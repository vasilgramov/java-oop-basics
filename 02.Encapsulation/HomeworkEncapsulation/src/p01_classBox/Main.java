package p01_classBox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double length = Double.parseDouble(in.nextLine());
        double width = Double.parseDouble(in.nextLine());
        double height = Double.parseDouble(in.nextLine());

        Box box = null;
        try {
            box = new Box(length, width, height);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        double surfaceArea = box.getSurfaceArea();
        System.out.printf("Surface Area - %.2f%n", surfaceArea);

        double lateralSurfaceArea = box.getLateralSurfaceArea();
        System.out.printf("Lateral Surface Area - %.2f%n", lateralSurfaceArea);

        double volume = box.getVolume();
        System.out.printf("Volume - %.2f%n", volume);
    }
}
