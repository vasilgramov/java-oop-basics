package app;

import app.Car;

import java.util.*;

public abstract class Race {
    private int length;
    private String route;
    private int pricePool;
    private String type;
    private Map<Integer, Car> participants;

    protected Race(int length, String route, int pricePool) {
        this.participants = new LinkedHashMap<>();

        this.setLength(length);
        this.setRoute(route);
        this.setPricePool(pricePool);
    }

    private void setLength(int length) {
        this.length = length;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPricePool(int pricePool) {
        this.pricePool = pricePool;
    }

    public int getPricePool() {
        return this.pricePool;
    }

    public int getLength() {
        return this.length;
    }

    public String getRoute() {
        return this.route;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void addCar(int id, Car car) {
        this.participants.put(id, car);
    }

    public boolean containsCar(int id) {
        return this.participants.containsKey(id);
    }

    public int getParticipantsCount() {
        return this.participants.size();
    }

    public Map<Integer, Car> getParticipants() {
        return this.participants;
    }

    public abstract String start();


}
