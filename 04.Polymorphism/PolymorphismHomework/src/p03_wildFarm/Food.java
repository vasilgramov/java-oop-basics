package p03_wildFarm;

public abstract class Food {
    private int quantity;

    protected Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
