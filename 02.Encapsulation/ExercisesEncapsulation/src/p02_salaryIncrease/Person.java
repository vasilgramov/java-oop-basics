package p02_salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(int bonus) {
        if (this.getAge() > 30) {
            this.setSalary(this.getSalary() + this.getSalary() * (bonus / 100.0));
        } else {
            this.setSalary(this.getSalary() + this.getSalary() * (bonus / 200.0));
        }
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " get " + this.getSalary() + " leva";
    }
}
