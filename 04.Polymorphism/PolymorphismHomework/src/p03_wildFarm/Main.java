package p03_wildFarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String command = in.nextLine();
        while (!"End".equals(command)) {
            String[] animalArgs = command.split("\\s+");
            String animalType = animalArgs[0];
            String animalName = animalArgs[1];
            double animalWeight = Double.parseDouble(animalArgs[2]);
            String animalLivingRegion = animalArgs[3];

            Animal animal = null;
            if ("Cat".equals(animalType)) {
                String catBreed = animalArgs[4];
                animal = new Cat(animalName, animalType, animalWeight, 0, animalLivingRegion, catBreed);
            } else if ("Mouse".equals(animalType)) {
                animal = new Mouse(animalName, animalType, animalWeight, 0, animalLivingRegion);
            } else if ("Tiger".equals(animalType)) {
                animal = new Tiger(animalName, animalType, animalWeight, 0, animalLivingRegion);
            } else if ("Zebra".equals(animalType)) {
                animal = new Zebra(animalName, animalType, animalWeight, 0, animalLivingRegion);
            }

            // check if null

            String[] foodArgs = in.nextLine().split("\\s+");
            String foodType = foodArgs[0];
            int foodAmount = Integer.parseInt(foodArgs[1]);

            Food food = null;
            if ("Vegetable".equals(foodType)) {
                food = new Vegetable(foodAmount);
            } else if ("Meat".equals(foodType)) {
                food = new Meat(foodAmount);
            }

            // check if null

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
