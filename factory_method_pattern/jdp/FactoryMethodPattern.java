////////////////////////////////////////////////////////////////
package factory_method_pattern.jdp;
////////////////////////////////////////////////////////////////
interface AnimalFactory {
    Animal create();
}
////////////////////////////////////////////////////////////////
class DogFactory implements AnimalFactory {
    public Dog create() {
        System.out.println( "Creating a dog ..." );
        return new Dog();
    }
}
////////////////////////////////////////////////////////////////
class CatFactory implements AnimalFactory {
    public Cat create() {
        System.out.println( "Creating a cat ..." );
        return new Cat();
    }
}
////////////////////////////////////////////////////////////////
class Client {
    AnimalFactory factory;
    void setFactory( AnimalFactory factory ){
        this.factory = factory;
    }
    void checkThisOut() {
        Animal animal = factory.create();
        animal.speak();
        animal.action();
    }
    public static void main( String args[] ){
        Client cli = new Client();
        cli.setFactory( new DogFactory());
        cli.checkThisOut();
        cli.setFactory( new CatFactory());
        cli.checkThisOut();
        //
        // Creating a dog ...
        // Woof
        // Playing
        // Creating a cat ...
        // Meou
        // Eating
    }
}
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////

