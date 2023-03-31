from datetime import datetime

from customerdataapi.models import CustomerData

from app import models


class DjangoCustomerDataRepository:
    model = CustomerData

    def get(self, *args, **kwargs):
        customer_data = self.model.objects.filter(**kwargs).first()
        return self.to_domain(customer_data) if customer_data else None

    def update(self, model: models.CustomerData, action: str) -> None:
        customer_data = self.from_domain(model, action=action)
        customer_data._state.adding = False
        customer_data.save()

    def add(self, customer_data: models.CustomerData) -> models.CustomerData:
        # No needed
        ...

    def from_domain(
        self, domain_object: models.CustomerData, action: str = ""
    ) -> CustomerData:
        data = domain_object.data
        data["SUBSCRIPTION"] = domain_object.subscription
        data["ENABLED_FEATURES"] = domain_object.features.dict()
        if action:
            data[f"{action.upper()}_DATE"] = datetime.now()
        return self.model(
            id=domain_object.id,
            data=data,
        )

    @staticmethod
    def to_domain(orm: CustomerData) -> models.CustomerData:
        features = orm.data.get("ENABLED_FEATURES", "")
        return models.CustomerData(
            id=orm.id,
            data=orm.data,
            features=models.Features(**features),
            subscription=orm.data.get("SUBSCRIPTION"),
        )
