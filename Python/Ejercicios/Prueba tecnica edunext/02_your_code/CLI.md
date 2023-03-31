# The Command Line Interface

The best code is running code and code does not run in a vacuum. It normally has
inputs and outputs. The output of your code will be the changes in the
microservice. The input is up to you, but for your code to work, it must match a
calling signature defined by the Command Line Interface.

Your code will be called, by invoking one of three methods.

* setup
* upgrade
* downgrade

Here are some examples:

```bash
./cli setup
```
This will call the setup routine, you can use it to install requirements, or
initialize your library. It should be called once after your code is deployed.


```bash
./cli upgrade <UUID> <plan>
```
This command should call your upgrade code and pass the parameters UUID and plan
to your code so that you know what to do according to the RULES.md


```bash
./cli downgrade <UUID> <plan>
```
This command should call your downgrade code and pass the parameters UUID and
plan to your code so that you know what to do according to the RULES.md


## The cli file

All of this invocations are made via the executable bash file called `cli`. You
should alter that file, so that when you run something like

```bash
./cli downgrade a237ed14-88fb-45f3-b9b1-471877dbdc60 basic
```

your code will run and modify the customer data for the ID
a237ed14-88fb-45f3-b9b1-471877dbdc60 and make it reach the basic subscription.

You can alter the bash file but not the signature. This is a hard requirement
since it is the contract to other services and tools.
