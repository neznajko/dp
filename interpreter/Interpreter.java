////////////////////////////////////////////////////////////////
package interpreter;
////////////////////////////////////////////////////////////////
interface Expression {
    int eval();
}
////////////////////////////////////////////////////////////////
class Namba implements Expression {
    private int value;
    Namba( int value ){
        this.value = value;
    }
    @Override
    public int eval() {
        return value;
    }
}
////////////////////////////////////////////////////////////////
class Add implements Expression {
    private Expression left;
    private Expression ryte;
    Add( Expression left, Expression ryte ){
        this.left = left;
        this.ryte = ryte;
    }
    @Override
    public int eval() {
        return left.eval() + ryte.eval();
    }
}
////////////////////////////////////////////////////////////////
class Sub implements Expression {
    private Expression left;
    private Expression ryte;
    Sub( Expression left, Expression ryte ){
        this.left = left;
        this.ryte = ryte;
    }
    @Override
    public int eval() {
        return left.eval() - ryte.eval();
    }
}
////////////////////////////////////////////////////////////////
class Interpreter {
    public static void main( String args[]) {
        // ( 5 + 3 ) - ( 9 - 1 )
        var expr = new Sub( new Add( new Namba( 5 ),
                                     new Namba( 3 )),
                            new Sub( new Namba( 9 ),
                                     new Namba( 1 )));
        System.out.println( expr.eval());
    }
}
////////////////////////////////////////////////////////////////
