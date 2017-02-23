package p03_opinionPoll;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return this.getName() + " - " + this.getAge();
    }

    @Override
    public int compareTo(Person other) {
        return this.getName().compareTo(other.getName());
    }
}
