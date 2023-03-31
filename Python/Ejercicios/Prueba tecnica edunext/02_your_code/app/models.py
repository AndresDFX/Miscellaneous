import json
from dataclasses import asdict, dataclass
from uuid import UUID

from app.constants import SubscriptionType


@dataclass
class Features:
    CERTIFICATES_INSTRUCTOR_GENERATION: bool = False
    INSTRUCTOR_BACKGROUND_TASKS: bool = False
    ENABLE_COURSEWARE_SEARCH: bool = False
    ENABLE_COURSE_DISCOVERY: bool = False
    ENABLE_DASHBOARD_SEARCH: bool = False
    ENABLE_EDXNOTES: bool = False

    def dict(self):
        return {k: v for k, v in asdict(self).items()}


@dataclass
class CustomerData:
    id: UUID
    data: dict
    features: Features
    subscription: str = SubscriptionType.FREE.value
