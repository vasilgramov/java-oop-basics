package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        AnimalCenterManager animalCenterManager = new AnimalCenterManager();

        String command = in.nextLine();
        while (!"Paw Paw Pawah".equals(command)) {
            String[] commandArgs = command.split(" \\| ");
            String commandType = commandArgs[0];
            if (commandType.equals("RegisterCleansingCenter")) {
                animalCenterManager.registerCleansingCenter(commandArgs[1]);
            } else if (commandType.equals("RegisterAdoptionCenter")) {
                animalCenterManager.registerAdoptionCenter(commandArgs[1]);
            } else if (commandType.equals("RegisterDog")) {
                animalCenterManager.registerDog(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]), commandArgs[4]);
            } else if (commandType.equals("RegisterCat")) {
                animalCenterManager.registerCat(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]), commandArgs[4]);
            } else if (commandType.equals("SendForCleansing")) {
                animalCenterManager.sendForCleansing(commandArgs[1], commandArgs[2]);
            } else if (commandType.equals("Cleanse")) {
                animalCenterManager.cleanse(commandArgs[1]);
            } else if (commandType.equals("Adopt")) {
                animalCenterManager.adopt(commandArgs[1]);
            } else if (commandType.equals("RegisterCastrationCenter")) {
                animalCenterManager.registerCastrationCenter(commandArgs[1]);
            } else if (commandType.equals("SendForCastration")) {
                animalCenterManager.sendForCastration(commandArgs[1], commandArgs[2]);
            } else if (commandType.equals("Castrate")) {
                animalCenterManager.castrate(commandArgs[1]);
            } else if (commandType.equals("CastrationStatistics")) {
                animalCenterManager.castrationStatistics();
            } else {
                throw new IllegalArgumentException("Invalid command!");
            }

            command = in.nextLine();
        }

        animalCenterManager.printStatistics();
    }
}
