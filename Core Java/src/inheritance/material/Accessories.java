package inheritance.material;
import inheritance.stock.Inventory;

public class Accessories extends Inventory{
    private int uniqueId;
    private String name;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accessories(int quantity,int uniqueId, String name) {
        super(quantity,5);
        this.uniqueId = uniqueId;
        this.name = name;
    }
}
