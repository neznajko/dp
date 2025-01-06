# GoF Definition
**Given a language, define a representation for its grammar along
with an interpreter that uses the representation to interpret
sentences in the language.**

*GoF Definitions* are always source of inspiration, unfortunately
this is the last *GoF Pattern:)*. It is called *The Interpreter
Pattern* and is meant to be used when we deal with some grammar
rules, but it's more of a theoretical pattern and practically not
usable for very large languages

Say we have this grammar:
```java
   Expression := Namba |
                 Expression + Expression |
                 Expression - Expression
   Namba := integer
```

This is a recursive definition and is basically represented as a
tree with numbers as leaf nodes, like ( 2 + 5 ) - ( 8 + 1 ) is:
```c++
                -
               / \
              /   \
             +     +
            / \   / \
           2   5 8   1 
```
So we want to evaluate thus expression. Do to thus for every rule
we define an interface, and for every choice in the rule a
concrete implementation:

```c#
    +----------------<<---------( Namba )
    | <<Expression>> |
    +----------------<<---------( Add )
    | +eval()        |
    +----------------<<---------( Sub )
```
Now, to evaluate the expression we call *eval* on the root node.
In general the pattern has a *Context* object as well, which is the
*lookup table* in compilers and interpreters for holding variables'
values, but we don't need that stuff
