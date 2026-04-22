package thread;

public class SequentialExecationFlow {

    public static void main(String[] args) {
        makeHotWater();
        brewCoffee();//wait to complete above one
        makeCoffee();//wait to complete above one

    }

    public static void makeHotWater() {
        System.err.println("Boiling Water..!!");
    }
    public static void brewCoffee() {
        System.err.println("Crushing/Brewing. coffee.!!");
    }
    public static void makeCoffee() {
        System.err.println("Mixing both and make coffee..");
    }

}
