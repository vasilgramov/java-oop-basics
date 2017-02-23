package p03_validationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLines = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] input = br.readLine().split("\\s+");
            try{
                people.add(new Person(input[0],input[1],Integer.parseInt(input[2]),Double.parseDouble(input[3])));
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        int bonus = Integer.parseInt(br.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }

    }
}