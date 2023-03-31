from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.decorators import api_view

from apps.empresa.models import *
from apps.empresa.api.serializers import *

@api_view(['GET','PUT','DELETE'])
def empresa_detail_view(request, id=None):
    empresa = Enterprise.objects.filter(id=id).first()

    if empresa:
        if request.method == 'GET':    
            empresa_serializer = EnterpriseSerializer(empresa)
            return Response(empresa_serializer.data, status=status.HTTP_200_OK)

        elif request.method == 'PUT':
            empresa_serializer = EnterpriseSerializer(empresa, data=request.data)
            if empresa_serializer.is_valid():
                empresa_serializer.save()
                return Response(empresa_serializer.data, status=status.HTTP_200_OK)
            return Response(empresa_serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        elif request.method == 'DELETE':
            empresa.delete()
            return Response({'message':'Empresa eliminada correctamente! '}, status=status.HTTP_200_OK)
    else:
        return Response({'message':'No se ha encontrado una empresa con estos datos'}, status=status.HTTP_400_BAD_REQUEST)

@api_view(['GET', 'POST'])
def empresa_api_view(request):

    if request.method == 'GET':
        empresas = Enterprise.objects.all()
        empresas_serializer = EnterpriseSerializer(empresas, many=True)
        return Response(empresas_serializer.data, status= status.HTTP_200_OK)
    
    elif request.method == 'POST':
        empresas_serializer = EnterpriseSerializer(data = request.data)
        if empresas_serializer.is_valid():
            empresas_serializer.save()
            return Response({'message':'Empresa creada correctamente! '}, status= status.HTTP_201_CREATED)
        else:
            return Response(empresas_serializer.errors, status= status.HTTP_400_BAD_REQUEST)


@api_view(['GET'])
def empresa_get_codes_view(request, id=None):
    code = Code.objects.filter(owner=id)

    if code:
        if request.method == 'GET':    
            code_serializer = CodeSerializer(code, many=True)
            return Response(code_serializer.data, status=status.HTTP_200_OK)
    return Response({'message':'No se ha encontrado una empresa con estos datos'}, status=status.HTTP_400_BAD_REQUEST)

@api_view(['GET'])
def empresa_get_code_view(request, id=None):
    
    empresa = Enterprise.objects.filter(code__id=id).values('id','name','gln','nit').first()

    if empresa:
        if request.method == 'GET':    
            empresa_serializer = EnterpriseSerializer(empresa)
            return Response(empresa_serializer.data, status=status.HTTP_200_OK)
    return Response({'message':'No se ha encontrado una empresa con estos datos'}, status=status.HTTP_400_BAD_REQUEST)

@api_view(['GET'])
def empresa_get_nit_view(request, nit=None):
    empresa = Enterprise.objects.filter(nit=nit).first()

    if empresa:
        if request.method == 'GET':    
            empresa_serializer = EnterpriseSerializer(empresa)
            return Response(empresa_serializer.data, status=status.HTTP_200_OK)
    return Response({'message':'No se ha encontrado una empresa con estos datos'}, status=status.HTTP_400_BAD_REQUEST)