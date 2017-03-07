package p03_wildFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String command = in.nextLine();
        while (!"End".equals(command)) {
            String[] animalArgs = command.split("\\s+");
            Animal animal = AnimalFactory.createAnimal(animalArgs); // might return null

            String[] foodArgs = in.nextLine().split("\\s+");
            Food food = FoodFactory.createFood(foodArgs); // might return null

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            System.out.println(animal);

            command = in.nextLine();
        }
    }
}
