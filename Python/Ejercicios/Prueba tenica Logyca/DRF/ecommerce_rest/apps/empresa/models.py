from django.db import models

class Enterprise(models.Model):
    creado = models.DateTimeField(auto_now_add=True)
    modificado = models.DateTimeField(auto_now=True)
    name = models.CharField(max_length=200)
    nit = models.BigIntegerField(blank=True, unique=True)
    gln = models.BigIntegerField()


class Code(models.Model):
    creado = models.DateTimeField(auto_now_add=True)
    modificado = models.DateTimeField(auto_now=True)
    owner = models.ForeignKey(Enterprise, on_delete=models.CASCADE)
    name = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200, blank=True)
