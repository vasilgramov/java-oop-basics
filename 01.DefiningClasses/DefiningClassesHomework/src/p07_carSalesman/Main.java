package p07_carSalesman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Map<String, Engine> engineByModel = new HashMap<>();
        
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineArgs = in.nextLine().split("\\s+");
            String model = engineArgs[0];
            int power = Integer.parseInt(engineArgs[1]);

            Engine engine = getEngine(engineArgs, model, power);

            engineByModel.put(model, engine);
        }
        
        n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] carArgs = in.nextLine().split("\\s+");
            String carModel = carArgs[0];
            String engineModel = carArgs[1];
            Engine engine = engineByModel.get(engineModel);

            Car car = getCar(carArgs, carModel, engine);

            System.out.println(car);
        }
    }

    private static Car getCar(String[] carArgs, String carModel, Engine engine) {
        Car car = null;
        if (carArgs.length == 2) {
            car = new Car(carModel, engine);
        } else if (carArgs.length == 3) {
            try {
                int weight = Integer.parseInt(carArgs[2]);
                car = new Car(carModel, engine, weight);
            } catch (Exception e) {
                String color = carArgs[2];
                car = new Car(carModel, engine, color);
            }
        } else if (carArgs.length == 4) {
            int weight = Integer.parseInt(carArgs[2]);
            String color = carArgs[3];

            car = new Car(carModel, engine, weight, color);
        }
        return car;
    }

    private static Engine getEngine(String[] engineArgs, String model, int power) {
        Engine engine = null;
        switch (engineArgs.length) {
            case 2:
                engine = new Engine(model, power);

                break;
            case 3:
                try {
                    int displacements = Integer.parseInt(engineArgs[2]);

                    engine = new Engine(model, power, displacements);
                } catch (Exception e) {
                    String efficiency = engineArgs[2];

                    engine = new Engine(model, power, efficiency);
                }
                break;
            case 4:
                int displacements = Integer.parseInt(engineArgs[2]);
                String efficiency = engineArgs[3];

                engine = new Engine(model, power, displacements, efficiency);
                break;
        }
        
        return engine;
    }
}
