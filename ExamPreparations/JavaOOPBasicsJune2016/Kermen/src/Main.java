import houses.Home;
import houses.HomeFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        City city = new City();

        int lineCounter = 1;
        String command = in.nextLine();
        while (!"Democracy".equals(command)) {


            if ("EVN".equals(command)) {
                double totalConsumption = city.getTotalConsumption();
                System.out.println("Total consumption: " + totalConsumption);
            } else if ("EVN bill".equals(command)) {
                city.payBills();
            } else {
                String[] homeArgs = command.split("\\s+|\\(|\\)\\s*|,\\s+");
                Home home = HomeFactory.getHome(homeArgs);
                city.addHome(home);
            }

            if (lineCounter % 3 == 0) {
                city.paySalaries();
            }

            lineCounter++;

            command = in.nextLine();
        }

        int totalPopulation = city.getPopulation();
        System.out.println("Total population: " + totalPopulation);
    }
}
