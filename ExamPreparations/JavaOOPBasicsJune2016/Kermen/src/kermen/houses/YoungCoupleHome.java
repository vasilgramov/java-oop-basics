package kermen.houses;

import kermen.devices.Device;
import kermen.people.Person;

public class YoungCoupleHome extends Home {
    private static final int YOUNG_COUPLE_ROOMS_COUNT = 2;
    private static final int YOUNG_COUPLE_ROOM_ELECTRICITY = 20;

    public YoungCoupleHome(Person firstPerson, Person secondPerson, Device tv, Device fridge, Device laptop) {
        super.setRoom(YOUNG_COUPLE_ROOM_ELECTRICITY);
        super.setRoomsCount(YOUNG_COUPLE_ROOMS_COUNT);

        super.addPerson(firstPerson);
        super.addPerson(secondPerson);

        super.addDevice(tv);
        super.addDevice(fridge);
        super.addDevice(laptop);
        super.addDevice(laptop);
    }
}
