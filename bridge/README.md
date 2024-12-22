# GoF Definition
Abstraction fall, drifting slow,  
A breeze whispers through the trees,  
The interface waits.  

Let's consider Desktop Environments for Linux Distributions like
Debian or Fedora. So we have basically: GNOME(X11), GNOME(Wayland),
KDE(Qt), KDE(OpenGL), etc. So if we want to build an architecture
for this scenario, we might end up with something like thus:
#
```c++
////////////////////////////////////////////////////////////////
                  +---------------------+
                  |    <<interface>>    |
                  | Desktop Environment |
                  +---------------------<<---+------------+
                  | +launchStartMenu()  |    | GNOME(X11) |
                  | +openFileBrowser()  |    +------------+
                  | +changeBackground() |
                  | +openTermianl()     |
                  | +closeWindow()      |    
                  | +drawIcons()        |       +---------+
                  | ...                 |       | KDE(Qt) |
                  +---------------------<<------+---------+
////////////////////////////////////////////////////////////////
```

Now every environment has it's own look and feel stuff, but
relies on *Graphics API* that provides the lower level functions
for drawing pixels, filling rectangles etc., like X11, Qt, ..
If we want to build an architecture that uses the **Bridge Pattern**
we have to detach GNOME from X11 and KDE from Qt, and put the
lower level graphics into separate interface say *Platform*. Then
we can use composition to encapsulate a platform into the Desktop
Environment, now abstract class:

```c#
################################################################
 +---------------------+
 |    <<abstract>>     |            +------------------+
 | Desktop Environment |            |   <<interface>>  |
 +---------------------<>-----------|     Platform     |
 | -platform           |            +------------------+
 +---------------------+            | +drawPixel()     |
 | +launchStartMenu()  |            | +fillRect()      |
 | ...                 |            | +renderText()    |
 ^---------------------^            | +makeArc()       |
 |                     |            | ...              |
 +-------+       +-----+            ^------------------^
 | GNOME |       | KDE |            ^                  ^
 +-------+       +-----+            +-----+       +----+
                                    | X11 |       | Qt |
                                    +-----+       +----+
################################################################
```

This creates a bridge between, the concrete environments
like GNOME, KDE, YOUNAMEIT and the concrete platforms X11, Qt,
WHATEVER .. so we can make different combinations like GNOME(X11),
GNOME(Qt), YOUNAMEIT(WHATEVER), and so forth
