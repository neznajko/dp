# GoF Definition
Glows fade into sky,  
City lights undone in silence,  
Morning claims the streets.  
#
```c++
    "If they have told me there will be so many requests,
     I wouldn't take the job"   -- An anonymous receiver
```
Let's say we have developed, believe it or not, some very complex
application like *FishExchange* a Chess Engine, ***DeBugga***
a Java Debugger, **edjtor** a Text Editor based on C, etc., and we
want to make users interact with our application via GUI or terminal.
So the first most natural solution is to create a wrapper class
that owns the app like a *Command Center* with a *ComSat Station*,
that receives user's requests, and delegates( again ) the actual
job, to the app

Let's try to allow an *undo* operation at the *ComSat Station*.
Every time an user makes a request, we register it in a *history*
container, then the *undo* will pop up the most recent request, and
ask the app to take appropriate actions depending on its type:
```java
    void undo() {
        String command = history.pop();
        if( command == "insert" ){
            edjtor.remove();
        } else if ...
    }            
```
This might work well for small application, but if we have many
commands it might become quite cumbersome, not to mention that
*history* should keep command's parameters as well, and if we want
to add another command, we have to modify the *undo* code. Taking
application's snapshots, as alternative approach, in large apps is
usually a very costly operation, and not an effective solution.

In the ***Command Pattern***, our old fellow the *ComSat Station* 
is called the *Invoker*, the app is known as the *Receiver*, the
users are the *Clients* and there is one more actor called the
*Command*. So if clients make requests to the invoker with a
terminal like:

```c#
  > append "2:o"
  > delete 1 10 
```
then to every separate command we create a corresponding
*command object* by passing command's parameters as its attributes, 
together with a reference to the receiver. With all
that stuff the *command object* is able to execute and undo any
command.

```java
    interface Command {
        void execute();
        void undo();
    }
    class AppendCommand implements Command {
        App edjtor;
        String text;
        AppendCommand( App edjtor, String text ){
            this.edjtor = edjtor;
            this.text = text;
        }
        void execute() {
            edjtor.append( text );
        }
        void undo() {
            edjtor.pop( text );
        }
   }
        
```
Now the Invoker's *history* will register *command objects* and the
Invoker's *undo* will look something like thus:
```c++
    void undo() {
        var command = history.pop();
        command.undo();
    }
```
