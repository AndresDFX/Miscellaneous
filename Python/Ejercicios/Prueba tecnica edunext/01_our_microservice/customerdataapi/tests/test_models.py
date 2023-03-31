"""
Testing the basis of the django model we are defining
"""

from django.test import TestCase
from customerdataapi.models import CustomerData


class CustomerDataTestCase(TestCase):
    """
    A basic test case for the CustomerData model
    """

    def test_can_create_customer(self):
        """
        This method tests that we can create a simple object.
        If we can, then all the definitions are right and the application load.
        """
        CustomerData.objects.create(
            id="49a6307e-c261-414d-86f5-c6004bcec8ab",
            data={
                "test": "data"
            }
        )

    def test_can_repr(self):
        """
        This method tests the string representation of the model.
        """
        new_customer = CustomerData.objects.create(
            id="49a6307e-c261-414d-86f5-c6004bcec8ab",
            data={
                "test": "data"
            }
        )
        str(new_customer)
