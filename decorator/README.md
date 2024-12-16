# GoF Definition
The echo of the winds calls,  
Through the quiet breath of the forest,  
Time dissolves like mist.  
#
CGPT was insisting that Proxy and Decorator are different, but I
still can get what exactly is the difference, anyway let's pretend
that they are different because Proxy is implementing an interface
to agree with the Service API while Decorator is extending a Class
to add functionality, whatever

```c++
   +----------+<-------+--------+
   | Beverage |        | Coffee |
   +----------+        +--------+
   | +drink() |        +----------+
   +----------+<-------| Espresso |
   ^                   +----------+
   |
   +-----------+       +---------------+
   | Decorator |<------| MilkDecorator |
   +-----------+       +---------------++
   | -beverage |<------| SugarDecorator |
   +-----------+       +----------------+
```
