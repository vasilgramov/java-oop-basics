package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TheSystem theSystem = new TheSystem();

        String command = in.nextLine();
        while (!"System Split".equals(command)) {
            String[] commandArgs = command.split("\\(|\\)|,\\s+");

            String commandType = commandArgs[0];
            if (commandType.equals("RegisterPowerHardware")) {
                theSystem.registerPowerHardware(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
            } else if (commandType.equals("RegisterHeavyHardware")) {
                theSystem.registerHeavyHardware(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
            } else if (commandType.equals("RegisterLightSoftware")) {
                theSystem.registerLightSoftware(commandArgs[1], commandArgs[2], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
            } else if (commandType.equals("RegisterExpressSoftware")) {
                theSystem.registerExpressSoftware(commandArgs[1], commandArgs[2], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
            } else if (commandType.equals("ReleaseSoftwareComponent")) {
                theSystem.releaseSoftwareComponent(commandArgs[1], commandArgs[2]);
            } else if (commandType.equals("Dump")) {
                theSystem.dump(commandArgs[1]);
            } else if (commandType.equals("Restore")) {
                theSystem.restore(commandArgs[1]);
            } else if (commandType.equals("Destroy")) {
                theSystem.destroy(commandArgs[1]);
            } else if (commandType.equals("DumpAnalyze")) {
                theSystem.dumpAnalyze();
            } else if (commandType.equals("Analyze")) {
                System.out.println(theSystem.analyze());
            }

            command = in.nextLine();
        }

        System.out.print(theSystem.split());
    }
}
