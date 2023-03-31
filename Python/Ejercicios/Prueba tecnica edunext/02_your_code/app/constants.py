from enum import Enum


class SubscriptionType(Enum):
    BASIC = "basic"
    FREE = "free"
    PREMIUM = "premium"


class Action(Enum):
    UPGRADE = "upgrade"
    DOWNGRADE = "downgrade"


SubscriptionHierarchy = {
    SubscriptionType.FREE.value: 1,
    SubscriptionType.BASIC.value: 2,
    SubscriptionType.PREMIUM.value: 3,
}

operators = {
    Action.UPGRADE.value: lambda x, y: x > y,
    Action.DOWNGRADE.value: lambda x, y: x < y,
}
