package houses;

import devices.Device;
import people.Child;
import people.Person;

import java.util.ArrayList;
import java.util.List;

public abstract class Home {
    private Room room;
    private int roomsCount;

    private List<Person> people;
    private List<Device> devices;
    private List<Child> children;

    private double budget;

    protected Home() {
        this.people = new ArrayList<>();
        this.devices = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    private Room getRoom() {
        return this.room;
    }

    protected void setRoom(int roomElectricityCost) {
        this.room = new Room(roomElectricityCost);
    }

    private int getRoomsCount() {
        return this.roomsCount;
    }

    protected void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getHomePopulation() {
        return this.people.size() + this.children.size();
    }

    private List<Person> getPeople() {
        return this.people;
    }

    private List<Device> getDevices() {
        return this.devices;
    }

    private List<Child> getChildren() {
        return this.children;
    }

    private double getBudget() {
        return this.budget;
    }

    //----------------------

    protected void addPerson(Person person) {
        this.people.add(person);
    }

    protected void addDevice(Device device) {
        this.devices.add(device);
    }

    protected void addChild(Child child) {
        this.children.add(child);
    }

    public double getHomeCost() {
        double total = 0;

        for (Child child : this.getChildren()) {
            total += child.getFoodCost();
            total += child.getAllToysCost();
        }

        for (Device device : this.getDevices()) {
            total += device.getElectricityCost();
        }

        total += this.getRoomsCount() * this.room.getElectricity();

        return total;
    }

    private double getHomeIncome() {
        double total = 0;

        for (Person person : this.getPeople()) {
            total += person.getIncome();
        }

        return total;
    }

    public void paySalaries() {
        this.budget += this.getHomeIncome();
    }

    public boolean canPayBills() {
        return this.getBudget() >= this.getHomeCost();
    }

    public void payBills() {
        this.budget -= this.getHomeCost();
    }
}
