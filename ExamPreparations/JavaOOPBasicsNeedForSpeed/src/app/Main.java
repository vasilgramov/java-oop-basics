package app;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladix on 4/25/17.
 */
public class Main {

    public static void main(String[] args) {

        Map<Integer, String> asd = new HashMap<>();
        asd.put(1, "asd");
        asd.put(2, "sdasd");
        asd.put(3, "dsa");


        asd.remove(2);

        System.out.println();
    }
}
