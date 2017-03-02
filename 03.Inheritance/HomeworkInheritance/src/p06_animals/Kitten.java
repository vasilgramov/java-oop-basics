package p06_animals;

public class Kitten extends Cat {

    protected Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void produceSound() {
        System.out.println("Miau");
    }
}
