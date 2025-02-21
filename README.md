## What is Functional Programming
Functional programming in Java is a style of programming where you focus on using functions to perform tasks. Instead of writing code with lots of steps and changing variables, you create functions that take inputs and produce outputs without modifying anything outside their scope. It's like assembling building blocks to solve problems, where each block (function) does one specific job.

### Intermediate Operation
The operation in functional programming which returns streams of objects, are called intermediate operation.

### Terminal Operation
The operation in functional programming which doesn't return stream of objects , are called terminal operation.

## Functional Interface
Any interface with a SAM(Single Abstract Method) is a functional interface, and its implementation may be treated as lambda expressions.
Note that Java 8’s default methods are not abstract and do not count; a functional interface may still have multiple default methods.

## Higer Order Function
A higher order function is a function which returns a function or accepts a function as a parameter.

### Imp points
Java Streams are lazy. It means unless the terminal functions are executed, the functions won't be executed.
Parallel Streams are used to execute streams parallely so as to utilize full capacity of the CPU.
