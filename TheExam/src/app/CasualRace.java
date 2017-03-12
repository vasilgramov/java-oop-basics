package app;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CasualRace extends Race {
    private static final String CASUAL_RACE = "Casual";

    public CasualRace(int length, String route, int pricePool) {
        super(length, route, pricePool);
        super.setType(CASUAL_RACE);
    }

    @Override
    public String start() {
        StringBuilder builder = new StringBuilder();

        Map<Long, Car> players = new TreeMap<>();

        for (Car car : super.getParticipants().values()) {
            long overallPerformance = (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());

            players.put(overallPerformance, car);
        }

        LinkedHashMap<Long, Car> result = new LinkedHashMap<>();
        players.entrySet().stream()
                .sorted((p1, p2) -> Long.compare(p2.getKey(), p1.getKey()))
                .forEach(p -> result.put(p.getKey(), p.getValue()));

        int count = 1;
        for (Map.Entry<Long, Car> integerCarEntry : result.entrySet()) {
            if (count > 3) {
                break;
            }

            long money = 0;
            if (count == 1) {
                money = (super.getPricePool() * 50) / 100;
            } else if (count == 2) {
                money = (super.getPricePool() * 30) / 100;
            } else if (count == 3) {
                money = (super.getPricePool() * 20) / 100;
            }

            long points = integerCarEntry.getKey();
            Car car = integerCarEntry.getValue();

            builder.append(String.format("%d. %s %s %dPP - $%d\n", count, car.getBrand(), car.getModel(), points, money));

            count++;
        }

        return builder.toString();
    }

}
