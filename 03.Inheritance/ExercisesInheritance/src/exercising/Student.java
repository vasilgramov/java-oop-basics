package exercising;

public class Student extends Person{
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.setSchool(school);
    }

    public String getSchool() {
        return this.school;
    }

    private void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void sleep() {
        System.out.println("the student is sleeping...");
    }
}
