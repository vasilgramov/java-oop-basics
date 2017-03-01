package p04_mordorsPlan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Gandalf gandalf = new Gandalf();
        String[] foods = in.nextLine().split("\\s+");

        for (String food : foods) {
            gandalf.eatFood(food.toLowerCase());
        }

        System.out.println(gandalf.getHappiness());
        gandalf.getMood();
    }
}
