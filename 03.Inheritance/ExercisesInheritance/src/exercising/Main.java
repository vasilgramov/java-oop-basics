package exercising;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Person person = new Person("Pesho", 5);
        person.sleep();

        Person student = new Student("Pesho", 10, "OMG");
        student.sleep();
    }
}
