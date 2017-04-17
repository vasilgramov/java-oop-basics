package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.*;

/**
 * Created by vladix on 4/16/17.
 */
public class Student {

    private String userName;
    private Map<String, Course> enrolledCourses;
    private Map<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);

        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return this.userName;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.NULL_OR_EMPTY_VALUE);
        }

        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    public Double getMarkByCourse(String couseName) {
        return this.marksByCourseName.get(couseName);
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarksInCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = this.calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM);


        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
