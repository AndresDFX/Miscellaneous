import uuid
from uuid import UUID

import pytest
from customerdataapi.models import CustomerData
from django.core.management import CommandError, call_command
from mixer.backend.django import mixer

from app.constants import Action, SubscriptionType
from app.repository import DjangoCustomerDataRepository


def create_customer_data(subscription_type: str):
    data = {
        "banner_message": "<p><span>Welcome</span> to Mr X's website</p>",
        "LAST_PAYMENT_DATE": "2020-01-10T09:25:00Z",
        "theme_name": "Tropical Island",
        "user_profile_image": "https://i.imgur.com/LMhM8nn.jpg",
        "ENABLED_FEATURES": {
            "CERTIFICATES_INSTRUCTOR_GENERATION": True,
            "ENABLE_COURSEWARE_SEARCH": True,
            "ENABLE_COURSE_DISCOVERY": True,
            "ENABLE_DASHBOARD_SEARCH": True,
            "ENABLE_EDXNOTES": True,
            "INSTRUCTOR_BACKGROUND_TASKS": True,
        },
        "displayed_timezone": "America/Bogota",
        "language_code": "en",
        "CREATION_DATE": "2013-03-10T02:00:00Z",
        "user_email": "barack@aol.com",
        "SUBSCRIPTION": subscription_type,
    }
    return mixer.blend(CustomerData, id=uuid.uuid4(), data=data)


@pytest.mark.django_db(transaction=True)
class TestModifyCustomerData:
    COMMAND_NAME = "modify_customer_data"
    repository = DjangoCustomerDataRepository()

    @staticmethod
    def _call_command(
        command_name: str, action: str, customer_data_id: UUID, plan: str
    ):
        call_command(
            command_name,
            "--action",
            action,
            "--customer_data_id",
            customer_data_id,
            "--plan",
            plan,
        )

    def test_upgrade_subscription_basic_to_premium_successful(self):
        customer_data = create_customer_data(SubscriptionType.BASIC.value)
        new_subscription = SubscriptionType.PREMIUM.value
        self._call_command(
            command_name=self.COMMAND_NAME,
            action=Action.UPGRADE.value,
            customer_data_id=customer_data.id,
            plan=new_subscription,
        )
        customer_data_object = self.repository.get(id=customer_data.id)
        assert customer_data_object.subscription == new_subscription

    def test_downgrade_subscription_premium_to_free_successful(self):
        customer_data = create_customer_data(SubscriptionType.PREMIUM.value)
        new_subscription = SubscriptionType.FREE.value
        self._call_command(
            command_name=self.COMMAND_NAME,
            action=Action.DOWNGRADE.value,
            customer_data_id=customer_data.id,
            plan=new_subscription,
        )
        customer_data_object = self.repository.get(id=customer_data.id)
        assert customer_data_object.subscription == new_subscription
        assert all(customer_data_object.features.__dict__.values()) == False

    def test_failed_for_subscription_type_not_exists(self):
        customer_data = create_customer_data(SubscriptionType.BASIC.value)
        new_subscription = "not valid"
        with pytest.raises(CommandError) as e:
            self._call_command(
                command_name=self.COMMAND_NAME,
                action=Action.UPGRADE.value,
                customer_data_id=customer_data.id,
                plan=new_subscription,
            )
        error = f"{self.COMMAND_NAME} :: error :: The subscription type {new_subscription} not exists"
        assert e.value.args[0] == error

    def test_failed_for_customer_data_not_exists(self):
        customer_data_id = uuid.uuid4()
        new_subscription = SubscriptionType.PREMIUM.value
        with pytest.raises(CommandError) as e:
            self._call_command(
                command_name=self.COMMAND_NAME,
                action=Action.UPGRADE.value,
                customer_data_id=customer_data_id,
                plan=new_subscription,
            )
        error = f"{self.COMMAND_NAME} :: error :: The customer with id {customer_data_id} is not exists"
        assert e.value.args[0] == error

    def test_failed_for_subscription_same_before(self):
        customer_data = create_customer_data(SubscriptionType.BASIC.value)
        new_subscription = SubscriptionType.BASIC.value
        with pytest.raises(CommandError) as e:
            self._call_command(
                command_name=self.COMMAND_NAME,
                action=Action.UPGRADE.value,
                customer_data_id=customer_data.id,
                plan=new_subscription,
            )
        error = f"{self.COMMAND_NAME} :: error :: The customer already has the same subscription"
        assert e.value.args[0] == error

    def test_failed_for_new_subscription_is_not_support_in_hierarchy(self):
        customer_data = create_customer_data(SubscriptionType.BASIC.value)
        new_subscription = SubscriptionType.PREMIUM.value
        action = Action.DOWNGRADE.value
        with pytest.raises(CommandError) as e:
            self._call_command(
                command_name=self.COMMAND_NAME,
                action=action,
                customer_data_id=customer_data.id,
                plan=new_subscription,
            )
        error = f"{self.COMMAND_NAME} :: error :: The {action} subscription from {SubscriptionType.BASIC.value} to {new_subscription} is not allowed"
        assert e.value.args[0] == error

    def test_failed_for_action_subscription_not_valid(self):
        customer_data = create_customer_data(SubscriptionType.BASIC.value)
        new_subscription = SubscriptionType.PREMIUM.value
        with pytest.raises(CommandError) as e:
            self._call_command(
                command_name=self.COMMAND_NAME,
                action="not valid",
                customer_data_id=customer_data.id,
                plan=new_subscription,
            )
        error = f"{self.COMMAND_NAME} :: error :: Unknown change subscription action"
        assert e.value.args[0] == error
