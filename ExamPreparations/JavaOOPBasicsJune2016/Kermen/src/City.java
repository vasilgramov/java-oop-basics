import houses.Home;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Home> homes;

    public City() {
        this.homes = new ArrayList<>();
    }

    public void addHome(Home home) {
        this.homes.add(home);
    }

    public void paySalaries() {
        for (Home home : homes) {
            home.paySalaries();
        }
    }

    public double getTotalConsumption() {
        double total = 0;
        for (Home home : this.homes) {
            total += home.getHomeCost();
        }

        return total;
    }

    public void payBills() {
        List<Home> leftHome = new ArrayList<>();

        for (Home home : this.homes) {
            if (home.canPayBills()) {
                home.payBills();
                leftHome.add(home);
            }
        }

        this.homes = leftHome;
    }

    public int getPopulation() {
        int total = 0;
        for (Home home : this.homes) {
            total += home.getHomePopulation();
        }

        return total;
    }
}
