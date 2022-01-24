## SOLID Introduction

## Setting Up

1. Ensure you have Java 11 or later installed locally
1. Ensure you have Kotlin installed locally
1. Fork this repository
1. Clone your fork
1. Open the project in an IDE
1. Run tests either in the IDE or with `./gradlew build`

All tests should pass.

## Workshop Prerequisite(s)

* Comfort with creating and implementing Interfaces, Classes and methods in Kotlin
* Comfort with creating Components in Spring

## Objectives

* Given a piece of code, identify reasons it might change
* Perform "extract method" and "extract class" refactoring to make code more compliant with SRP
* Identify code that requires modification to extend functionality
* Refactor code to be mostly compliant with OCP
* Use Spring to refactor code to be completely compliant with OCP

## Content

[SOLID](https://blog.cleancoder.com/uncle-bob/2020/10/18/Solid-Relevance.html) is a collection of design principles.

**S**ingle Responsibility Principle (SRP)

> Gather together the things that change for the same reasons. Separate things that change for different reasons.

**O**pen-Closed Principle (OCP)

> A Module should be open for extension but closed for modification.

**L**iskov Substitution Principle (LSP)

> A program that uses an interface must not be confused by an implementation of that interface.

**I**nterface Segregation Principle (ISP)

> Keep interfaces small so that users don’t end up depending on things they don’t need

**D**ependency Inversion Principle (DIP)

> Depend in the direction of abstraction. High level modules should not depend upon low level details.

This workshop will focus on SRP and OCP.

## Why do we care about SOLID?

SOLID is a set of guidelines that help you write code that's easy to change.

$OLID is partly about money (dollar sign brought you by [Mike Gehard](https://twitter.com/mikegehard) 😀). Companies want to us to reduce the amount of duplicated, unnecessary costs.

It's also partly about joy, and a sense of satisfaction with your job. Research has shown that high deployment frequency reduces burnout. Being able to change code quickly is one way to support higher deployment frequency.

## Single Responsibility (SRP)

> A class should have only one reason to change.

Note that this does _not_ say _"a class should only do one thing"_.

### How to find SRP violations

1. Make a list of all the reasons a class could change
1. Group those reasons into categories 
1. If there's more than one category, consider refactoring

For example if you have a class that parses emails using the SMTP protocol. Imagine the code does the following:
- parses to/from information
- parses various email body types (multipart bodies, text, HTML etc...)
- verifying DKIM information

What would make this code change (categorized):
- SMTP Spec Changes
    - Change to the SMTP spec around to/from information
    - Change to the SMTP spec around headers
    - Change to the SMTP spec around encryption
- HTML Spec Changes
    - Change to the HTML spec

Two very common examples of SRP violations are:
- [Coupling IO-related tasks with business logic](https://www.destroyallsoftware.com/screencasts/catalog/functional-core-imperative-shell)
- Coupling config reading/parsing code with business logic

### How to fix SRP violations

- (optionally) Extract methods
- Move methods to a different class

May involve creating new packages, organizing code differently. Basically copy/paste.

### SRP Lab

1. Open `src/main/kotlin/io/upslope/solid/srp/practice/WarningCounter.kt`
1. Run the `src/test/kotlin/io/upslope/solid/srp/practice/WarningCounterTest.kt` test
1. Refactor code in `WarningCounter.kt` to no longer violate SRP
1. Make sure tests still pass
1. Commit and push your code to your fork
1. Open a pull request against the main repository
1. Paste a link to your PR in Slack

## Open Closed Principle (OCP)

### How to find OCP violations

The easiest way to find OCP violations is to look for concrete dependencies in your methods.

For example, in the code below, `MyClass` has a concrete dependency on `MyParser`:

```kotlin
class MyClass {
    fun doSomething(data: String) {
        MyParser().parse(data);
        // do other important things here...
    }
}
```

### How to fix OCP violations

The easiest general way to think of fixing Open/Closed violations is to inject dependencies.

Most of the time you'll inject it in a constructor, like so:

```kotlin
class MyClass(private val parser: MyParser) {
    fun doSomething(data: String) {
        parser.parse(data);
        // do other important things here...
    }
}
```

You can also inject the dependency into the method like so:

```kotlin
class MyClass {
    fun doSomething(parser: MyParser, data: String) {
        parser.parse(data);
        // do other important things here...
    }
}
```

Method injection is less common, but is often used when declaring `@Bean` methods. 

### OCP Lab

1. Open `src/main/kotlin/io/upslope/solid/ocp/practice/FormatService.kt`
1. Run the `src/test/kotlin/io/upslope/solid/ocp/practice/FormatServiceTest.kt` test
1. Refactor code in `FormatService.kt` to no longer violate OCP
1. Make sure tests still pass
1. Commit and push your code to your fork (this will update your PR)
1. Paste a link to your PR in Slack

## Refactoring to SOLID

Although you may start out writing SOLID code from the start, in many cases you will think about SOLID when refactoring code.

Sandi Metz puts it really well [in this blog post](https://sandimetz.com/blog/2017/9/13/breaking-up-the-behemoth):

![](https://www.sandimetz.com/s/012-designStaminaGraph.gif)

If you design your software poorly, the cost of adding a feature over time will get worse and worse.

If you design your software well, you'll theoretically be able to respond to change as quickly after 2 years as you did in the first 2 months.

If you practice lean product development, and build prototypes to get early customer feedback, SOLID might fit into your flow like this:

- Build a prototype, don't worry about SOLID or TDD at all
- Get customer feedback
- If the product isn't worth building, pivot - many times this means deleting all the code
- If the product is worth building, refactor to SOLID, add tests etc...

If you practice TDD, SOLID fits in like this:

- Red (write a failing test)
- Green (make it pass the simplest way)
- Refactor (make it SOLID)

## Resources

- https://stackify.com/solid-design-principles/
- https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
- https://www.baeldung.com/solid-principles
