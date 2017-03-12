package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        CarManager carManager = new CarManager();

        String command = in.nextLine();
        while (!"Cops Are Here".equals(command)) {
            String[] commandArgs = command.split(" ");
            String comandType = commandArgs[0];
            if (comandType.equals("register")) {
                int id = Integer.parseInt(commandArgs[1]);
                String type = commandArgs[2];
                String brand = commandArgs[3];
                String model = commandArgs[4];
                int year = Integer.parseInt(commandArgs[5]);
                int horsePower = Integer.parseInt(commandArgs[6]);
                int acceleration = Integer.parseInt(commandArgs[7]);
                int suspension = Integer.parseInt(commandArgs[8]);
                int durability = Integer.parseInt(commandArgs[9]);

                carManager.register(id, type, brand, model, year, horsePower, acceleration, suspension, durability);
            } else if (comandType.equals("check")) {
                int id = Integer.parseInt(commandArgs[1]);
                System.out.print(carManager.check(id));
            } else if (comandType.equals("open")) {
                int id = Integer.parseInt(commandArgs[1]);
                String type = commandArgs[2];
                int length = Integer.parseInt(commandArgs[3]);
                String route = commandArgs[4];
                int pricePool = Integer.parseInt(commandArgs[5]);

                carManager.open(id, type, length, route, pricePool);
            } else if (comandType.equals("participate")) {
                int carId = Integer.parseInt(commandArgs[1]);
                int raceId = Integer.parseInt(commandArgs[2]);

                carManager.participate(carId, raceId);
            } else if (comandType.equals("start")) {
                int raceId = Integer.parseInt(commandArgs[1]);

                System.out.print(carManager.start(raceId));
            } else if (comandType.equals("park")) {
                int carId = Integer.parseInt(commandArgs[1]);

                carManager.park(carId);
            } else if (comandType.equals("unpark")) {
                int carId = Integer.parseInt(commandArgs[1]);

                carManager.unpark(carId);
            } else if (comandType.equals("tune")) {
                int tuneIndex = Integer.parseInt(commandArgs[1]);
                String addon = commandArgs[2];

                carManager.tune(tuneIndex, addon);
            }

            command = in.nextLine();
        }



    }
}
