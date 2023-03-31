# Backend Developer Coding Challenge


## Situation description

As we saw on the challenge stack section, for each of our customers, we keep a
configuration object stored in the customer data micro-service.

An example of the object we store and access for each customer is:

```
{
    "SUBSCRIPTION": "basic",
    "CREATION_DATE": "2013-03-10T02:00:00Z",
    "LAST_PAYMENT_DATE": "2020-01-10T09:25:00Z",
    "theme_name": "Tropical Island",
    "ENABLED_FEATURES": {
        "CERTIFICATES_INSTRUCTOR_GENERATION": true,
        "INSTRUCTOR_BACKGROUND_TASKS": true,
        "ENABLE_COURSEWARE_SEARCH": true,
        "ENABLE_COURSE_DISCOVERY": true,
        "ENABLE_DASHBOARD_SEARCH": true,
        "ENABLE_EDXNOTES": true
    },
    "language_code": "en",
    "banner_message": "<p><span>Welcome</span> to Mr X's website</p>",
    "displayed_timezone": "America/Bogota",
    "user_profile_image": "https://i.imgur.com/LMhM8nn.jpg",
    "user_email": "barack@aol.com"
}
```

This object is very flexible and it can change by other services and tools. When
you modify this object, you should only change the fields you need.


## Challenge

For the challenge, please imagine your next tasks is to create an administrative
tool that updates the customer information after they modify their subscription.
Your code will receive the ID of the customer to modify and the target
subscription level.

You can use python and any framework or library for your solution.
We will test it using python 3.8 so please make it compatible.


## Subscription levels

For this challenge we have 3 levels: `free`, `basic` or `premium`.

Anytime that you do an upgrade you should add a key, with the name`UPGRADE_DATE`,
to the customer that contains the current datetime. The same for any downgrade,
but with the name `DOWNGRADE_DATE`.

Paid customers are able to modify their features and turn them on and off. So if
the target downgrade is `free` then the customer just reached the free tier and
we must turn all the `ENABLED_FEATURES` to `False`. Upgrading will not have the
opposite effect.


## Advanced

We can always make things better, if you want to demonstrate your mastery you
can use the exit code of your process and bash to mark errors with the given
input.

- Error code 1: the ID does not exist or is badly formated
- Error code 2: the target subscription level is not reachable
- Error code 3: other unknown error

This is not tested in the end to end tests, but you are welcome to change them
if you add support for this advanced feature.
