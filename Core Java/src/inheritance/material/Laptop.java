package inheritance.material;
import inheritance.stock.Inventory;

public class Laptop extends Inventory{
    private int uniqueId;
    private String brand;
    private String colour;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Laptop(int quantity, int uniqueId, String brand, String colour) {
        super(quantity, 3);
        this.uniqueId = uniqueId;
        this.brand = brand;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "uniqueId=" + uniqueId +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
