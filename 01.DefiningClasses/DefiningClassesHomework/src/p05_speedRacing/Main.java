package p05_speedRacing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Car> carByModel = new LinkedHashMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carArgs = in.nextLine().split("\\s+");

            String model = carArgs[0];
            int fuelAmount = Integer.parseInt(carArgs[1]);
            double fuelCostPer1KM = Double.parseDouble(carArgs[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1KM);
            carByModel.put(model, car);
        }

        String command = in.nextLine();
        while (!"End".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            String model = commandArgs[1];
            int distance = Integer.parseInt(commandArgs[2]);

            Car car = carByModel.get(model);
            car.move(distance);

            command = in.nextLine();
        }

        for (Map.Entry<String, Car> stringCarEntry : carByModel.entrySet()) {
            Car car = stringCarEntry.getValue();
            System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTravelled());
        }
    }
}
