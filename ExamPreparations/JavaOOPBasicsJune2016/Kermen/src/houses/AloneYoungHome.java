package houses;

import devices.Device;
import people.Person;

public class AloneYoungHome extends Home {
    private static final int ALONE_YOUNG_HOME_ROOMS_COUNT = 1;
    private static final int ALONE_YOUNG_HOME_ROOM_ELECTRICITY_COST = 10;

    public AloneYoungHome(Person person, Device laptop) {
        super.setRoom(ALONE_YOUNG_HOME_ROOM_ELECTRICITY_COST);
        super.setRoomsCount(ALONE_YOUNG_HOME_ROOMS_COUNT);

        super.addPerson(person);
        super.addDevice(laptop);
    }
}
