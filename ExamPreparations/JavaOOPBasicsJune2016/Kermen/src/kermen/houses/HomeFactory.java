package kermen.houses;

import kermen.devices.*;
import kermen.people.Child;
import kermen.people.OldPerson;
import kermen.people.Person;
import kermen.people.YoungPerson;

import java.util.ArrayList;
import java.util.List;

public class HomeFactory {
    public static Home getHome(String[] homeArgs) {
        Home home = null;
        String homeType = homeArgs[0];
        if (homeType.equals("AloneOld")) {
            Person person = new OldPerson(Double.parseDouble(homeArgs[1]));

            home = new AloneOldHome(person);
        } else if (homeType.equals("AloneYoung")) {
            Person person = new YoungPerson(Double.parseDouble(homeArgs[1]));
            Device laptop = new Laptop(Double.parseDouble(homeArgs[3]));

            home = new AloneYoungHome(person, laptop);
        } else if (homeType.equals("OldCouple")) {
            Person firstPerson = new OldPerson(Double.parseDouble(homeArgs[1]));
            Person secondPerson = new OldPerson(Double.parseDouble(homeArgs[2]));
            Device tv = new TV(Double.parseDouble(homeArgs[4]));
            Device fridge = new Fridge(Double.parseDouble(homeArgs[6]));
            Device stove = new Stove(Double.parseDouble(homeArgs[8]));

            home = new OldCoupleHome(firstPerson, secondPerson, tv, fridge, stove);
        } else if (homeType.equals("YoungCouple")) {
            Person firstPerson = new YoungPerson(Double.parseDouble(homeArgs[1]));
            Person secondPerson = new YoungPerson(Double.parseDouble(homeArgs[2]));
            Device tv = new TV(Double.parseDouble(homeArgs[4]));
            Device fridge = new Fridge(Double.parseDouble(homeArgs[6]));
            Device laptop = new Laptop(Double.parseDouble(homeArgs[8]));

            home = new YoungCoupleHome(firstPerson, secondPerson, tv, fridge, laptop);

        } else if (homeType.equals("YoungCoupleWithChildren")) {
            Person firstPerson = new YoungPerson(Double.parseDouble(homeArgs[1]));
            Person secondPerson = new YoungPerson(Double.parseDouble(homeArgs[2]));
            Device tv = new TV(Double.parseDouble(homeArgs[4]));
            Device fridge = new Fridge(Double.parseDouble(homeArgs[6]));
            Device laptop = new Laptop(Double.parseDouble(homeArgs[8]));

            List<Child> children = new ArrayList<>();
            for (int i = 9; i < homeArgs.length; i++) {
                if (homeArgs[i].equals("Child")) {
                    Child child = new Child(Double.parseDouble(homeArgs[i + 1]));
                    for (int j = i + 2; j < homeArgs.length; j++) {
                        if (homeArgs[j].equals("Child")) {
                            i = j - 1;
                            break;
                        } else {
                            child.addToy(new Toy(Double.parseDouble(homeArgs[j])));
                        }
                    }

                    children.add(child);
                }
            }

            home = new YoungCoupleWithChildrenHome(firstPerson, secondPerson, children, tv, fridge, laptop);
        }

        return home;
    }
}
