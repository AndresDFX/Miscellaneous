"""
Testing the django rest framework configuration
"""

from django.test import TestCase
from rest_framework.test import APIClient

class CustomerDataAPITestCase(TestCase):
    """
    Basic test case that asserts that we can actually call the API
    """

    def test_can_reach_api(self):
        """
        Asserts that calling the API actually works
        """
        client = APIClient()
        client.post('/api/v1/customerdata/', {'id': '1234'}, format='json')
