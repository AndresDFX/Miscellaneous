class SubscriptionException(Exception):
    pass


class CustomerDataNotExistsException(SubscriptionException):
    pass


class SameSubscriptionChange(SubscriptionException):
    pass


class LimitSubscription(SubscriptionException):
    pass


class SubscriptionTypeNotExists(SubscriptionException):
    pass


class UnknownAction(SubscriptionException):
    pass


class SubscriptionNotAutorized(SubscriptionException):
    pass
