package designpattern;

public class SingletonDesignPattern {

    private static volatile SingletonDesignPattern singleton;

    // private constructor
    private SingletonDesignPattern() {
    }

    public static SingletonDesignPattern getInstance() {

        if (singleton == null) { // 1st check (no locking)

            synchronized (SingletonDesignPattern.class) { // lock

                if (singleton == null) { // 2nd check
                    singleton = new SingletonDesignPattern();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args) {

        SingletonDesignPattern obj1 = SingletonDesignPattern.getInstance();
        SingletonDesignPattern obj2 = SingletonDesignPattern.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);

        // Verify both references are same
        System.out.println(obj1 == obj2); // true
    }
}