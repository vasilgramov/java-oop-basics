package p04_shippingSpree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Person> personByName = new LinkedHashMap<>();
        String[] peopleData = in.nextLine().split(";");
        for (String personData : peopleData) {
            String[] personArgs = personData.split("=");
            String name = personArgs[0];
            double money = Double.parseDouble(personArgs[1]);

            try {
                Person person = new Person(name, money);
                personByName.put(name, person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        Map<String, Product> productByName = new HashMap<>();
        String[] productsData = in.nextLine().split(";");
        for (String productData : productsData) {
            String[] productArgs = productData.split("=");
            String name = productArgs[0];
            double cost = Double.parseDouble(productArgs[1]);

            try {
                Product product = new Product(name, cost);
                productByName.put(name, product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = in.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            Person person = personByName.get(personName);
            Product product = productByName.get(productName);

            if (!person.canPurchase(product)) {
                System.out.printf("%s can't afford %s%n", person.getName(), product.getName());
            } else {
                try {
                    person.purchase(product);
                    System.out.printf("%s bought %s%n", person.getName(), product.getName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            command = in.nextLine();
        }

        for (Map.Entry<String, Person> stringPersonEntry : personByName.entrySet()) {
            Person person = stringPersonEntry.getValue();

            System.out.print(person.getName() + " - ");

            if (person.getProducts().size() == 0) {
                System.out.println("Nothing bought");
            } else {
                StringBuilder builder = new StringBuilder();

                boolean isFirst = true;
                for (Product product : person.getProducts()) {
                    if (isFirst) {
                        isFirst = false;

                        builder.append(product.getName());
                    } else {
                        builder.append(", " + product.getName());
                    }
                }

                System.out.println(builder.toString());
            }
        }
    }
}