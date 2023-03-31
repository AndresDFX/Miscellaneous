# -*- coding: utf-8 -*-
"""
Views for customerdataapi.
"""
from __future__ import absolute_import, unicode_literals

from rest_framework import viewsets, permissions

from customerdataapi.models import CustomerData
from customerdataapi.serializers import CustomerDataSerializer


class CustomerDataViewSet(viewsets.ModelViewSet):
    """
    A simple ViewSet for listing or retrieving CustomerData.
    """

    queryset = CustomerData.objects.all()
    serializer_class = CustomerDataSerializer
    permission_classes = (permissions.AllowAny,)
