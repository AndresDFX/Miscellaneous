from rest_framework import serializers
from apps.empresa.models import *


class CodeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Code
        fields = '__all__'

class EnterpriseSerializer(serializers.ModelSerializer):
    codes = CodeSerializer(many=True, read_only=True, source='code_set')
    
    class Meta:
        model = Enterprise
        fields = ('id', 'name', 'nit', 'gln', 'codes')