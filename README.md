## SOLID Introduction

## Prerequisite(s)

* Comfort with creating and implementing Interfaces

## Objectives

* Given a piece of code, identify reasons it might change
* Perform "extract method" and "extract class" refactoring
* Identify code that requires modification to extend functionality
* Write code that removes business logic from factories
* (Spring) 

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

## Why do we care?

$OLID is partly about money (Dollar sign brought you by Mike Gehard 😀). Companies want to us to reduce the amount of duplicated, unnecessary costs.

It's also partly about joy, and a sense of satisfaction with your job. Research has shown that high deployment frequency reduces burnout. If you can't quickly change code, you can't deploy frequently.

Sandi Metz puts it really well [in this blog post](https://sandimetz.com/blog/2017/9/13/breaking-up-the-behemoth):

![](https://www.sandimetz.com/s/012-designStaminaGraph.gif)

If you design your software poorly, the cost of adding a feature over time will get worse and worse.

If you design your software well, you'll theoretically be able to respond to change as quickly after 2 years as you did in the first 2 months.

## Refactoring to SOLID

SOLID only matters when it's time to change something. For some things the cost of change now vs the cost of change later is the same.

For example, if you reflexively create an interface called `Parser`, and a class called `ParserImpl`, you're doing it wrong.

SOLID should never lead you to creating unnecessary abstractions or unnecessarily complex code.

If you practice lean product development, and build prototypes to get early customer feedback, SOLID might fit into your flow like this:

- Build a prototype, don't worry about SOLID or TDD at all
- Get customer feedback
- If the product isn't worth building, pivot - many times this means deleting all the code
- If the product is worth building, refactor to SOLID, add tests etc...

If you practice TDD, SOLID fits in like this:

- Red (write a failing test)
- Green (make it pass the simplest way)
- Refactor (make it SOLID)

## What about YAGNI?

YAGNI stands for "Ya Ain't Gonna Need It" and it's a great way to keep big-design-upfront tendencies in check.

Some people confuse "good design" with "building for every possible case upfront."

SOLID attempts to solve this tension by giving you simple techniques to make it easy to change your code later.

So you only ever build exactly what you need right now. But you build it in a way that tomorrow it will be easy to extend.

## Where to start?

The two most important principles to master are Single Responsibility (SRP) and Open/Closed (OCP) which is what this workshop will focus on.

## Single Responsibility (SRP)

> A class should have only one reason to change.

Note that this does _not_ say "a class should only do one thing".

Some things to watch out for:

**Mixing plumbing with business logic**

IO operations are one of the big things to watch out for.

Let's say you have code that:

- Reads configuration for a configuration file
- Uses those config values to make a calculation

There are lots of reasons the configuration code could change:
- Variables could be added/changed/removed from the config
- The location of the config file could change
- The format of the config file could change
- The way config is loaded could change (it could come from a database, or environment variables etc...)

Then there are reasons that the calculation code could change:
- PO changes business rules in a user stories

Decoupling IO is so common that there are dedicated techniques like [functional core, imperative shell](https://www.destroyallsoftware.com/screencasts/catalog/functional-core-imperative-shell).

Here are a few ways you can determine if a class violates SRP:

**Analyze code** - Look at a class (or method/function), and ask yourself "what are all the reasons this code could change?"

Then see if those reasons all highly-related.

For example if you have a class that parses emails using the SMTP protocol. The code:

- parses to/from information
- parses various email body types (multipart bodies, text, HTML etc...)
- parses DKIM information

What would make this code change:
- Change to the SMTP spec around to/from information
- Change to the SMTP spec around headers
- Change to the SMTP spec around encryption
- The HTML spec could change

This class could have 50 methods and be 400 lines long and might not violate SRP. Probably the HTML parsing stuff goes into a separate class(es).

**Git History** - Look at your git history for a class. Are all the commit messages related to the same thing?

If you have multiple commits related to different types of changes, maybe this class violates SRP.

**Reasonable people can disagree**

As the complexity of the system grows, the scope of what a single reason is to change grows smaller and smaller.

This requires judgement, and tradeoff decisions.

### How to fix SRP

- Extract method (names become more specific)
- Extract class

May involve creating new packages, organizing code differently. Basically copy/paste.

## Open Closed Principle (OCP)


## Resources

- https://stackify.com/solid-design-principles/
- https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
- https://www.baeldung.com/solid-principles
