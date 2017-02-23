package p02_creatingConstructors;

public class Person {
    private String name;
    private int age;

    public Person() {
        this("No name", 1);
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
