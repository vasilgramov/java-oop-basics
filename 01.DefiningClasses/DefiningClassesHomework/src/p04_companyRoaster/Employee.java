package p04_companyRoaster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);

        this.setEmail(null);
        this.setAge(-1);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String emailToPrint = this.getEmail() == null ? "n/a" : this.getEmail();
        int ageToPrint = this.getAge() == -1 ? -1 : this.getAge();

        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), emailToPrint, ageToPrint);
    }
}
