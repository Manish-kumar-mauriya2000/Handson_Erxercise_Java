package inheritance.stock;

public class Inventory {
    private int quantity;
    private int   lowOrderLevelQuantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLowOrderLevelQuantity() {
        return lowOrderLevelQuantity;
    }

    public void setLowOrderLevelQuantity(int lowOrderLevelQuantity) {
        this.lowOrderLevelQuantity = lowOrderLevelQuantity;
    }

    public Inventory(int quantity, int lowOrderLevelQuantity) {
        this.quantity = quantity;
        this.lowOrderLevelQuantity = lowOrderLevelQuantity;
    }
}
