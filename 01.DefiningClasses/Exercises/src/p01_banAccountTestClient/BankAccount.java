package p01_banAccountTestClient;

public class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.balance = 0.0;

        this.setId(id);
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

    private void setBalance(double balance) throws Exception {
        if (balance < 0) {
            throw new Exception("Insufficient balance");
        }

        this.balance = balance;
    }

    public void deposit(double amount) throws Exception {
        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(double amount) throws Exception {
        this.setBalance(this.getBalance() - amount);
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.getId(), this.getBalance());
    }
}
