
public class Transaction {
    private int id;
    private String product;
    private String type;
    private double amount;

    public Transaction(int id, String product, String type, double amount) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
