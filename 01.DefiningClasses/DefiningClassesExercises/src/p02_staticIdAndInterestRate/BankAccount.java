package p02_staticIdAndInterestRate;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int idsCount = 1;

    private static double rate = DEFAULT_INTEREST_RATE;

    private int id;
    private double balance;

    public BankAccount() {
        this.setId(idsCount++);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        System.out.printf("Deposited %.0f to %s%n", amount, this);

        this.setBalance(this.getBalance() + amount);
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    @Override
    public String toString() {
        return String.format("ID" + this.getId());
    }
}
