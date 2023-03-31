# eduNEXT Coding Challenge

In this repository you will find the description and files of your personal coding challenge.
The developer challenge is designed to give us an overview on your dexterity when developing web applications based on python.

The main objective is to determine not only whether you have the technical knowledge, but also how you communicate the decisions you make along the way and how you work with existing code. We hope that you find this challenge motivating.


# What are we assessing?

We are looking for someone who is a good fit for our team, and this requires that candidates alongside their code and technical skill are also motivated to work and to lead projects and features into completion, and that they are capable of communicating effectively with other members of the team and customers about the requirements, the specifications or the status of the work.

We will look at the results of this challenge through the lens of:

- Communication
    + Clear
    + Complete
- Independence of work
- Tech skills & best practices
    + Correctness of the solution
    + Architecture of the solution
    + QA
        * Code quality
        * Unit testing


# The task at hand

We want to evaluate you in a setting that is similar to our day to day work. For this, we ask you to download the code in this repository and make the `customerdataapi` micro-service work. You will find more information about this service and how to run it in `01_our_microservice/README.md`.

The second task is to create a python based library that interacts with the `customerdataapi` micro-service. This library will make upgrades or downgrades of the services for a given customer.

The business rules for upgrading or downgrading are available in `02_your_code/RULES.md`.

To make this challenge more robust, we have provided a few unit tests for your logic. They will run automatically in github actions when you push. To make the connections of your code to the tests easier we have created a command line interface (cli). More about how to use the cli in `02_your_code/CLI.md`.

You are free to use any libraries that you need as long as your code still conforms to the cli.


# Delivering

To deliver your code, please make a Pull Request (PR) to the `main` branch of the repository with your changes. The PR should include an explanation of the decisions you made. 

We will look at the way you deliver the code, the quality of the code we give you in the microservice is the quality we expect. We encourage you to use the same (or better) tools to maintain it. We also look at the technical decisions and the explanation of your PR. The story this all tells us, lets us understand how you write software and how you work as part of a team.


# Kudos

As we said before, at eduNEXT we look at the code from many different angles. For this, we want to let you know of all the things that value and that we will look for when assessing your response.

* Organization of your code
* Clarity of your PR explanations or the questions in Campfire
* Code comments
* Iterative approach to development
* Using linting or other quality tools

You will receive extra points for special achievements in the resolution of the challenge.

* Adding unit tests to your code
* Using coverage measurements for your unit testing
* Using CI to run your quality processes

Finally if you are having fun or simply like this kind of things, there is a side challenge.

* In the `customerdataapi` test suite, the `test_can_reach_api` is not really useful. Can you tell us why and propose a change in a different PR to make it better?


# Rules

Please keep this challenge to yourself, we expect you to be the only author of the code that is published here.


# Nice readings and links


* Using conventional commits. https://www.conventionalcommits.org/en/v1.0.0/

* Use comments in your code when you need to explain the intent of you code.
https://blog.codinghorror.com/code-tells-you-how-comments-tell-you-why/

* You can find a useful guide to make better commit messages here: https://chris.beams.io/posts/git-commit/.

* Structuring your code like a champion: https://docs.python-guide.org/writing/structure/#structure-of-code-is-key

* How to make a good Pull Request cover letter. https://blog.alphasmanifesto.com/2016/07/11/how-to-create-a-good-pull-request/

* Make bash work in windows: https://itsfoss.com/install-bash-on-windows/
