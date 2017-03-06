package p01_vehicle;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] carArgs = in.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));

        String[] truckArgs = in.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]));

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            String commandType = commandArgs[0];
            String vehicleType = commandArgs[1];
            double argument = Double.parseDouble(commandArgs[2]);

            if (commandType.equals("Drive")) {
                try {
                    if (vehicleType.equals("Car")) {
                        car.drive(argument);
                    } else {
                        truck.drive(argument);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } else {
                if (vehicleType.equals("Car")) {
                    car.refuel(argument);
                } else {
                    truck.refuel(argument);
                }
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
    }
}
