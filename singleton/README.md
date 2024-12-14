# GoF Definition
Ensure a class only has one instance, and provide a global point of
access to it.

This might be the single GoF Definition that make any sense to me:)

```c++
    +---------------+
    |    Captain    |
    +---------------+
    | -captain      |
    | -Captain()    |
    | +getCaptain() |
    +---------------+
```

Strange as it might seems, but there are many nuances in this
simple pattern. One noticeable feature is how to initialize the
*singleton*, at the beginning of the program execution, or at a
request, which is known as *Lazy Initialization*
