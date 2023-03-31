from django.urls import path
from apps.empresa.api.api import *


urlpatterns = [
    path('empresa/', empresa_api_view, name='empresa'),
    path('empresa/<int:id>/', empresa_detail_view, name='empresa_detail'),
    path('empresa/codes/<int:id>/', empresa_get_codes_view, name='empresa_get_codes'),
    path('empresa/nit/<int:nit>/', empresa_get_nit_view, name='empresa_get_nit'),
    path('empresa/code/<int:id>/', empresa_get_code_view, name='empresa_get_code'),
     
]