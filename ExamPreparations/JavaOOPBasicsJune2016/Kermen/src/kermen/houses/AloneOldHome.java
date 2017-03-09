package kermen.houses;

import kermen.people.Person;

public class AloneOldHome extends Home {
    private static final int ALONE_OLD_HOME_ROOMS_COUNT = 1;
    private static final int ALONE_OLD_HOME_ROOM_ELECTRICITY = 15;

    public AloneOldHome(Person person) {
        super.setRoom(ALONE_OLD_HOME_ROOM_ELECTRICITY);
        super.setRoomsCount(ALONE_OLD_HOME_ROOMS_COUNT);

        super.addPerson(person);
    }
}
