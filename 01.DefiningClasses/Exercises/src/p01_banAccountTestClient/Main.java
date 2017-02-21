package p01_banAccountTestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccountById = new HashMap<>();

        String command = in.nextLine();
        while (!"End".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Create":
                    executeCreateCommand(commandArgs, bankAccountById);
                    break;
                case "Deposit":
                    executeDepositCommand(commandArgs, bankAccountById);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(commandArgs, bankAccountById);
                    break;
                case "Print":
                    executePrintCommand(commandArgs, bankAccountById);
                    break;
            }

            command = in.nextLine();
        }
    }

    private static void executePrintCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);

        if (!bankAccountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        BankAccount bankAccount = bankAccountById.get(id);
        System.out.println(bankAccount);
    }

    private static void executeWithdrawCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!bankAccountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        BankAccount bankAccount = bankAccountById.get(id);

        try {
            bankAccount.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeDepositCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!bankAccountById.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        BankAccount bankAccount = bankAccountById.get(id);

        try {
            bankAccount.deposit(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeCreateCommand(String[] commandArgs, Map<Integer, BankAccount> bankAccountById) {
        int id = Integer.parseInt(commandArgs[1]);

        if (bankAccountById.containsKey(id)) {
            System.out.println("Account already exists");
            return;
        }

        BankAccount bankAccount = new BankAccount(id);
        bankAccountById.put(id, bankAccount);
    }
}
