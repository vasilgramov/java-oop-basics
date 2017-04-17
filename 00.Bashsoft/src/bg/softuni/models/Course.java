package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Collections;
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

    public Course(String courseName) {
        this.setName(courseName);
        this.studentByName = new LinkedHashMap<>();

    }

    public String getName() {
        return this.name;
    }

    private void setName(String courseName) {
        if (courseName == null || courseName.trim().equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_OR_EMPTY_VALUE);
        }

        this.name = courseName;
    }

    public Map<String, Student> getStudentByName() {
        return Collections.unmodifiableMap(this.studentByName);
    }

    public Student getStudentByName(String studentName) {
        return this.studentByName.get(studentName);
    }

    public boolean containsStudent(String studentName) {
        return this.studentByName.containsKey(studentName);
    }

    public void enrollStudent(Student student) {
        if (this.studentByName.containsKey(student.getUserName())) {
            throw new DuplicateEntryInStructureException(student.getUserName(), this.getName());
        }

        this.studentByName.put(student.getUserName(), student);
    }

}
