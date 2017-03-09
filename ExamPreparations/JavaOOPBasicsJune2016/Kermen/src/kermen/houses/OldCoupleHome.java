package kermen.houses;

import kermen.devices.Device;
import kermen.people.Person;

public class OldCoupleHome extends Home {
    private static final int OLD_COUPLE_ROOMS_COUNT = 3;
    private static final int OLD_COUPLE_ROOM_ELECTRICITY_COST = 15;

    public OldCoupleHome(Person firstPerson, Person secondPerson, Device tv, Device fridge, Device stove) {
        super.setRoom(OLD_COUPLE_ROOM_ELECTRICITY_COST);
        super.setRoomsCount(OLD_COUPLE_ROOMS_COUNT);

        super.addPerson(firstPerson);
        super.addPerson(secondPerson);

        super.addDevice(tv);
        super.addDevice(fridge);
        super.addDevice(stove);
    }
}
