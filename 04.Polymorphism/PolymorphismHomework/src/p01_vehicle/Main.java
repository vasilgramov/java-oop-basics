package p01_vehicle;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] carArgs = in.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]), Double.parseDouble(carArgs[3]));

        String[] truckArgs = in.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]), Double.parseDouble(truckArgs[3]));

        String[] busArgs = in.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busArgs[1]), Double.parseDouble(busArgs[2]), Double.parseDouble(busArgs[3]));

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
                    } else if (vehicleType.equals("Truck")) {
                        truck.drive(argument);
                    } else {
                        bus.driveWithPeople(argument);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } else if (commandType.equals("Refuel")) {
                try {
                    if (vehicleType.equals("Car")) {
                        car.refuel(argument);
                    } else if (vehicleType.equals("Truck")) {
                        truck.refuel(argument);
                    } else {
                        bus.refuel(argument);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            } else {
                try {
                    bus.drive(argument);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}
