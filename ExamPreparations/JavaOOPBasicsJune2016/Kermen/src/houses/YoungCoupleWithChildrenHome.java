package houses;

import devices.Device;
import people.Child;
import people.Person;

import java.util.List;

public class YoungCoupleWithChildrenHome extends Home {
    private static final int YOUNG_COUPLE_WITH_CHILDREN_ROOMS_COUNT = 2;
    private static final int YOUNG_COUPLE_WITH_CHILDREN_ROOM_ELECTRICITY_COST = 30;

    public YoungCoupleWithChildrenHome(Person firstPerson, Person secondPerson, List<Child> children, Device tv, Device fridge, Device laptop) {
        super.setRoom(YOUNG_COUPLE_WITH_CHILDREN_ROOM_ELECTRICITY_COST);
        super.setRoomsCount(YOUNG_COUPLE_WITH_CHILDREN_ROOMS_COUNT);

        super.addPerson(firstPerson);
        super.addPerson(secondPerson);

        for (Child child : children) {
            super.addChild(child);
        }

        super.addDevice(tv);
        super.addDevice(fridge);
        super.addDevice(laptop);
        super.addDevice(laptop);
    }
}
