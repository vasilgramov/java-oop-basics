package p03_validationData;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private double salary;



    public Person(String name, String lastName, int age, double salary) {
        setName(name);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <=0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void increaseSalary(int bonus) {
        if (this.age > 30) {

            this.salary += (this.salary * bonus) / 100;
        } else {
            this.salary += (this.salary * bonus) / 200;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName() + " get " + this.salary + " leva";
    }
}