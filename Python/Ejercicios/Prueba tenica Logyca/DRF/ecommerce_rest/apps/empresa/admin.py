from django.contrib import admin
from apps.empresa.models import *

class CodeInline(admin.TabularInline):
    model = Code
    extra = 3

class EnterpriseAdmin(admin.ModelAdmin):
    inlines = [CodeInline, ]

admin.site.register(Enterprise, EnterpriseAdmin)
