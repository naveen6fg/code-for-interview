package designpattern;

interface Animal {

    void eat();

    void sleep();

    void run();

}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog Eat");
    }

    @Override
    public void sleep() {
        System.out.println("Dog Sleep");
    }

    @Override
    public void run() {
        System.out.println("Dog run");
    }
}

class Rabbit implements Animal {
    @Override
    public void eat() {
        System.out.println("Rabbit Eat");
    }

    @Override
    public void sleep() {
        System.out.println("Rabbit Sleep");
    }

    @Override
    public void run() {
        System.out.println("Rabbit run");
    }
}

class Bear implements Animal {
    @Override
    public void eat() {
        System.out.println("Bear Eat");
    }

    @Override
    public void sleep() {
        System.out.println("Bear Sleep");
    }

    @Override
    public void run() {
        System.out.println("Bear run");
    }
}


class FactoryHelper {

    public Animal factorHelperMethod(String animalType) {

        if (animalType == null) {
            return null;
        }
        if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("rabbit")) {
            return new Rabbit();
        } else if (animalType.equalsIgnoreCase("Bear")) {
            return new Bear();
        }
    return null;
    }
}

class FactoryDesignPattern {
    public static void main(String[] args) {
        FactoryHelper helper = new FactoryHelper();

        Animal dog = helper.factorHelperMethod("dog");
        dog.eat();
        dog.sleep();
        dog.run();
        System.out.println();

        Animal rabbit = helper.factorHelperMethod("rabbit");
        rabbit.eat();
        rabbit.sleep();
        rabbit.run();

        System.out.println();
        Animal bear = helper.factorHelperMethod("bear");
        bear.eat();
        bear.sleep();
        bear.run();
    }
}
//Factory Method: Defines a method for creating an object, but the actual object creation is done in subclasses or through specific conditions.
//Interface or Superclass: Objects created by the factory method usually share a common interface or superclass, ensuring they are used in a polymorphic way.
//Client: The client doesn’t need to know the exact class being instantiated. It just uses the factory to get the required object.