package app.animals;

public class Cat extends Animal {
    private int iq;

    public Cat(String name, int age, int iq, String center) {
        super(name, age, center);
        this.setIq(iq);
    }

    public int getIq() {
        return this.iq;
    }

    private void setIq(int iq) {
        this.iq = iq;
    }
}
