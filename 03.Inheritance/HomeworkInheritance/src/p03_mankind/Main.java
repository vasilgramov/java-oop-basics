package p03_mankind;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] studentArgs = in.nextLine().split("\\s+");
        String studentFirstName = studentArgs[0];
        String studentLastName = studentArgs[1];
        String studentFacultyNumber = studentArgs[2];

        Student student = null;
        try {
            student = new Student(studentFirstName, studentLastName, studentFacultyNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(String.format("First Name: %s", student.getFirstName()));
        System.out.println(String.format("Last Name: %s", student.getLastName()));
        System.out.println(String.format("Faculty number: %s", student.getFacultyNumber()));

        System.out.println();

        String[] workerArgs = in.nextLine().split("\\s+");
        String workerFirstName = workerArgs[0];
        String workerLastName = workerArgs[1];
        double weekSalary = Double.parseDouble(workerArgs[2]);
        double hoursPerDay = Double.parseDouble(workerArgs[3]);

        Worker worker = null;
        try {
            worker = new Worker(workerFirstName, workerFirstName, weekSalary, hoursPerDay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(String.format("First Name: %s", worker.getFirstName()));
        System.out.println(String.format("Last Name: %s", worker.getLastName()));
        System.out.println(String.format("Week Salary: %.2f", worker.getWeekSalary()));
        System.out.println(String.format("Hours per day: %.2f", worker.getWorkHoursPerDay()));
        System.out.println(String.format("Salary per hour: %.2f", worker.getWorkHoursPerDay()));
    }
}
