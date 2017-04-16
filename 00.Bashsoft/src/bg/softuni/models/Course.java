package bg.softuni.models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vladix on 4/16/17.
 */
public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM = 100;


    private String name;
    private Map<String, Student> studentByName;

    public Course(String name) {
        this.name = name;
        this.studentByName = new LinkedHashMap<>();

    }

    public String getName() {
        return this.name;
    }

    public Map<String, Student> getStudentByName() {
        return this.studentByName;
    }

    public Student getStudentByName(String studentName) {
        return this.studentByName.get(studentName);
    }

    public boolean containsStudent(String studentName) {
        return this.studentByName.containsKey(studentName);
    }

    public void enrollStudent(Student student) {
        if (this.studentByName.containsKey(student.getUserName())) {
            OutputWriter.displayException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE, student.getUserName(), this.getName()
            ));

            return;
        }

        this.studentByName.put(student.getUserName(), student);
    }

}
