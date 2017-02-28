package p05_randomArrayList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();

        ral.add(1);
        ral.add("pesho");
        ral.add(new ArrayList<>());
        ral.add(-1);

        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
    }
}
