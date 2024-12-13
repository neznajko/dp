# GoF Definition  
Autumn leaves flutter,  
Whirling in the quiet breeze,  
Golden paths unwind.  

Basically this is a *Template Pattern*, where the algorithm is
the building process, say we have an algorithm method:

```java
void algorithm() {
    step1();
    step2();
    // ...
    stepN();
}
```
where step1, step2, ..., are abstract methods, receiving
realization in the concrete implementations.

There is also another understanding of the *Builder Pattern* for
example in the book *Effective Java*, which mainly concerns of
setting default attributes, without the need of making
*telescoping* constructors

