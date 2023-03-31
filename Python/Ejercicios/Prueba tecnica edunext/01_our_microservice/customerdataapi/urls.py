# -*- coding: utf-8 -*-
"""
URLs for customerdataapi.
"""
from django.urls import include, path
from django.contrib import admin
from django.views.generic import TemplateView
from rest_framework.routers import DefaultRouter

from customerdataapi.views import CustomerDataViewSet

ROUTER = DefaultRouter()
ROUTER.register(r'customerdata', CustomerDataViewSet)

urlpatterns = [
    path(r'admin/', admin.site.urls),
    path(r'api/v1/', include(ROUTER.urls)),
    path(r'', TemplateView.as_view(template_name="customerdataapi/base.html")),
]
