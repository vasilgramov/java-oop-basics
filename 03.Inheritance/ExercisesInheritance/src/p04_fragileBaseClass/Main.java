package p04_fragileBaseClass;

public class Main {

    public static void main(String[] args) {
        Predator predator = new Predator();

        predator.feed(new Food());
    }
}
