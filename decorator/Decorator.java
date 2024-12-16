////////////////////////////////////////////////////////////////
package decorator;
////////////////////////////////////////////////////////////////
class Decorator extends Beverage {
    Beverage beverage;
    Decorator( Beverage beverage ){
        this.beverage = beverage;
    }
    @Override
    public void drink() {
        beverage.drink();
    }
    static public void main( String args[] ){
        Beverage coffee = new Coffee();
        coffee = new MilkDecorator( coffee );
        coffee.drink();
        Beverage espresso = new Espresso();
        espresso = new SugarDecorator( espresso );
        espresso = new MilkDecorator( espresso );
        espresso.drink();
        // Drinking coffee plus milk!
        // Drinking espresso and sugar, plus milk!
    }
}    
////////////////////////////////////////////////////////////////
class MilkDecorator extends Decorator {
    MilkDecorator( Beverage beverage ){
        super( beverage );
    }
    @Override
    public void drink() {
        super.drink();
        System.out.println( " plus milk!" );
    }
}
////////////////////////////////////////////////////////////////
class SugarDecorator extends Decorator {
    SugarDecorator( Beverage beverage ){
        super( beverage );
    }
    @Override
    public void drink() {
        super.drink();
        System.out.print( " and sugar," );
    }
}
////////////////////////////////////////////////////////////////
