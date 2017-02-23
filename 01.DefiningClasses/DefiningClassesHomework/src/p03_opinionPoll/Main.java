package p03_opinionPoll;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Person> people = new TreeSet<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String name = commandArgs[0];
            int age = Integer.parseInt(commandArgs[1]);

            Person person = new Person(name, age);
            if (person.getAge() > 30) {
                people.add(person);
            }
        }

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
