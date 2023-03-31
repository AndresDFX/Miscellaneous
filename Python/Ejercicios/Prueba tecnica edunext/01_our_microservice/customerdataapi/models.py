# -*- coding: utf-8 -*-
"""
Database models for customerdataapi.
"""

from __future__ import absolute_import, unicode_literals

import collections
import uuid
import jsonfield

from django.db import models


class CustomerData(models.Model):
    """
    A simple model to store our customer data
    """
    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)  # pylint: disable=invalid-name
    data = jsonfield.JSONField(blank=True, null=True, load_kwargs={'object_pairs_hook': collections.OrderedDict})

    def __str__(self):
        return "CustomerData with id <{}>".format(self.id)
