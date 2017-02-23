package p02_staticIdAndInterestRate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountById = new HashMap<>();

        String command = in.nextLine();
        while (!"End".equals(command)) {
            String[] commandArgs = command.trim().split("\\s+");

            String commandType = commandArgs[0];
            switch (commandType) {
                case "Create":
                    executeCreateCommand(bankAccountById);
                    break;
                case "Deposit":
                    executeDepositCommand(commandArgs, bankAccountById);
                    break;
                case "SetInterest":
                    executeSetInterestCommand(commandArgs, bankAccountById);
                    break;
                case "GetInterest":
                    executeGetInterestCommand(commandArgs, bankAccountById);
                    break;
            }


            command = in.nextLine();
        }
    }

    private static void executeGetInterestCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);
        if (!bankAccountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        int years = Integer.parseInt(commandArgs[2]);

        BankAccount bankAccount = bankAccountById.get(id);
        double interest = bankAccount.getInterest(years);
        System.out.printf("%.2f%n", interest);
    }

    private static void executeSetInterestCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        double interest = Double.parseDouble(commandArgs[1]);

        BankAccount.setInterest(interest);
    }

    private static void executeDepositCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!bankAccountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        double amount = Double.parseDouble(commandArgs[2]);
        BankAccount bankAccount = bankAccountById.get(id);
        bankAccount.deposit(amount);
    }

    private static void executeCreateCommand(Map<Integer, BankAccount> bankAccountById) {
        BankAccount bankAccount = new BankAccount();
        System.out.println("Account " + bankAccount + " created");

        int id = bankAccount.getId();
        bankAccountById.put(id, bankAccount);
    }
}
