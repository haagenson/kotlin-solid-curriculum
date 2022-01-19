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

$OLID is all about money (Dollar sign brought you by Mike Gehard 😀). It's all about money. Companies want to us to reduce the amount of duplicated, unnecessary costs.

Sandi Metz puts it really well [in this blog post](https://sandimetz.com/blog/2017/9/13/breaking-up-the-behemoth):

![](https://www.sandimetz.com/s/012-designStaminaGraph.gif)

If you design your software poorly, the cost of adding a feature over time will get worse and worse.

If you design your software well, you'll theoretically be able to respond to change as quickly after 2 years as you did in the first 2 months.

## What about YAGNI?

YAGNI stands for "Ya Ain't Gonna Need It" and it's a g

Some people confuse "good design" with "anticipating every possible case upfront."

SOLID attempts to solve 

## Resources

- https://stackify.com/solid-design-principles/
- https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
- https://www.baeldung.com/solid-principles

## Open Closed Principle (OCP)


