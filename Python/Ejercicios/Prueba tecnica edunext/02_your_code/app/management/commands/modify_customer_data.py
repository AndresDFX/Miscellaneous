# Standard Library
# Django
import logging
from uuid import UUID

from django.core.management.base import BaseCommand, CommandError

from ...exceptions import (CustomerDataNotExistsException, LimitSubscription,
                           SameSubscriptionChange, SubscriptionNotAutorized,
                           SubscriptionTypeNotExists, UnknownAction)
from ...handler import DjangoChangeSuscriptions

logger = logging.getLogger(__name__)


class Command(BaseCommand):
    help = """
        Change subscription a customer_data

        Example of use:

        python manage.py modify_customer_data --action=upgrade --customer_data_id=1b2f7b837b4d441da210afaa970e5b76 --plan=basic
    """

    def add_arguments(self, parser):
        parser.add_argument("--action", required=True, nargs="?", type=str)
        parser.add_argument(
            "--customer_data_id", required=True, nargs="?", type=UUID
        )
        parser.add_argument("--plan", required=True, nargs="?", type=str)

    def handle(self, *args, **options):
        logger.info(f"modify_customer_data :: called with {options} options")

        action = options.get("action", "")
        customer_data_id = options.get("customer_data_id", "")
        plan = options.get("plan", "")

        try:
            change_suscription = DjangoChangeSuscriptions()
            change_suscription.handle(
                id=customer_data_id, action=action, new_value=plan
            )
        except (
            LimitSubscription,
            SameSubscriptionChange,
            CustomerDataNotExistsException,
            SubscriptionTypeNotExists,
            UnknownAction,
            SubscriptionNotAutorized,
        ) as e:
            msg = f"modify_customer_data :: error :: {str(e)}"
            logger.error(msg)
            raise CommandError(msg)

        msg = (
            f"customer with id {customer_data_id} was {action} to plan {plan}."
        )
        self.stdout.write(self.style.SUCCESS(msg))
        logger.info(msg)
