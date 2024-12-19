# GoF Definition
Complex paths converge,  
Harmony guides every step,  
A calm subsystem.

# DiDP Definition
Facade is a structural design pattern that provides a simplified
interface to a library, a framework, or any other complex set of
classes.

#
Let's take the *Photoshop* application as an example, it consist of
many subsystems, like *FileIO*, *ColorAdjustments*, *Transform*,
*Tools*, etc.
```java
 +-----------+ +------------------+ +-----------+ +-----------+
 |  FileIO   | | ColorAdjustments | | Transform | |   Tools   |
 +-----------+ +------------------+ +-----------+ +-----------+
 | +new()    | | +brightness()    | | +scale()  | | +brush()  |
 | +open()   | | +saturation()    | | +mirror() | | +fill()   |
 | +save()   | | +levels()        | | +rotate() | | +heal()   |
 | +saveAs() | | +curves()        | | +skew()   | | +pencil() |
 | +export() | | +invert()        | | ...       | | +text()   |
 | ...       | | ...              | +-----------+ | ...       |
 +-----------+ +------------------+               +-----------+
```

It seems the *Facade Pattern* has two main usages. One is to
present to the users a simplified version of the system, like in
business offices, the sys admins have installed a simplified version
of Windows with restricted functionality to make sure someone
doesn't mess anything, or people hanging all day in social medias.

The other usage is to automate certain tasks, like in the how to 
draw something with Photoshop online tutorials:
```c++
 1. Click thus!
 2. Make a triangle
 3. Pick green color
 4. Use fill bucket
 5. Select Text Tool
 6. Type "Merry Christmas"
 7. etc.
```

So one can create a method *makeChristmasPostCard* with parameters,
like how many trees, what text exactly and so on. 

Here is how our facade will look like:
```
 +---------------------+
 | Facadeshop          |
 +---------------------+
 | -fileIO             |
 | -colorAdjustments   |
 | -transform          |
 | -tools              |
 +---------------------+
 | +new()              |
 | +open()             |
 | +save()             |
 | +levels()           |
 | +scale()            |
 | +fill()             |
 +---------------------+
 | +enhance()          |
 | +reduce()           |
 | +makeFrenchCheese() |
 +---------------------+
```
