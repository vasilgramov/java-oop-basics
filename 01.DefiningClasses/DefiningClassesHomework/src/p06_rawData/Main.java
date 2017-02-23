package p06_rawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carArgs = in.nextLine().split("\\s+");
            String model = carArgs[0];
            int engineSpeed = Integer.parseInt(carArgs[1]);
            int enginePower = Integer.parseInt(carArgs[2]);
            int cargoWeight = Integer.parseInt(carArgs[3]);
            String cargoType = carArgs[4];
            double tire1Pressure = Double.parseDouble(carArgs[5]);
            int tire1Age = Integer.parseInt(carArgs[6]);
            double tire2Pressure = Double.parseDouble(carArgs[7]);
            int tire2Age = Integer.parseInt(carArgs[8]);
            double tire3Pressure = Double.parseDouble(carArgs[9]);
            int tire3Age = Integer.parseInt(carArgs[10]);
            double tire4Pressure = Double.parseDouble(carArgs[11]);
            int tire4Age = Integer.parseInt(carArgs[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[4];
            tires[0] = new Tire(tire1Pressure, tire1Age);
            tires[1] = new Tire(tire2Pressure, tire2Age);
            tires[2] = new Tire(tire3Pressure, tire3Age);
            tires[3] = new Tire(tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }


        String filter = in.nextLine();

        if (filter.equals("fragile")) {
            cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals(filter))
                    .filter(c -> Arrays.stream(c.getTires()).anyMatch(t -> t.getPressure() < 1))
                    .forEach(System.out::println);
        } else {
            cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals(filter))
                    .filter(c -> c.getEngine().getEnginePower() > 250)
                    .forEach(System.out::println);
        }

    }
}
