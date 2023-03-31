from abc import ABC, abstractmethod
from uuid import UUID

from app.constants import (Action, SubscriptionHierarchy, SubscriptionType,
                           operators)
from app.exceptions import (CustomerDataNotExistsException, LimitSubscription,
                            SameSubscriptionChange, SubscriptionNotAutorized,
                            SubscriptionTypeNotExists, UnknownAction)
from app.models import CustomerData, Features
from app.repository import DjangoCustomerDataRepository


class ChangeSubscriptions(ABC):
    @abstractmethod
    def upgrade(self, *args, **kwargs) -> None:
        """Upgrade a subscription"""

    @abstractmethod
    def downgrade(self, *args, **kwargs) -> None:
        """Downgrade a subscription"""

    @abstractmethod
    def handle(self, *args, **kwargs) -> bool:
        """Handler according action (upgrade or downgrade)"""


class DjangoChangeSuscriptions(ChangeSubscriptions):
    repository = DjangoCustomerDataRepository()

    def validate_hierarchy(
        self, new_value: str, old_value: str, action: str
    ) -> bool:
        new_value_hierachy = SubscriptionHierarchy.get(new_value)
        old_value_hierachy = SubscriptionHierarchy.get(old_value)
        return operators[action](old_value_hierachy, new_value_hierachy)

    def _validate_customer_data(
        self,
        customer_data: CustomerData,
        id: UUID,
        new_value: str,
        action: str,
    ) -> None:
        if not new_value in SubscriptionType._value2member_map_:
            raise SubscriptionTypeNotExists(
                f"The subscription type {new_value} not exists"
            )
        if not customer_data:
            raise CustomerDataNotExistsException(
                f"The customer with id {id} is not exists"
            )
        if new_value == customer_data.subscription:
            raise SameSubscriptionChange(
                "The customer already has the same subscription"
            )
        if self.validate_hierarchy(
            new_value, customer_data.subscription, action
        ):
            raise SubscriptionNotAutorized(
                f"The {action} subscription from {customer_data.subscription} to {new_value} is not allowed"
            )

    def upgrade(self, id: UUID, action: str, new_value: str) -> None:
        customer_data = self.repository.get(id=id)
        self._validate_customer_data(customer_data, id, new_value, action)

        if customer_data.subscription == SubscriptionType.PREMIUM.value:
            raise LimitSubscription(
                "A premium subscription cannot be upgraded"
            )

        customer_data.subscription = new_value
        self.repository.update(customer_data, action=action)

    def downgrade(self, id: UUID, action: str, new_value: str) -> CustomerData:
        customer_data = self.repository.get(id=id)
        self._validate_customer_data(customer_data, id, new_value, action)

        if customer_data.subscription == SubscriptionType.FREE.value:
            raise LimitSubscription("A free subscription cannot be downgrade")

        if new_value == SubscriptionType.FREE.value:
            features = Features()
            customer_data.features = features

        customer_data.subscription = new_value
        self.repository.update(customer_data, action=action)

    def handle(self, id: UUID, action: str, new_value: str) -> None:
        if action == Action.UPGRADE.value:
            return self.upgrade(id=id, action=action, new_value=new_value)
        elif action == Action.DOWNGRADE.value:
            return self.downgrade(id=id, action=action, new_value=new_value)
        else:
            raise UnknownAction("Unknown change subscription action")
