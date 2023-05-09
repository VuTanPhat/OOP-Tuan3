package SP;

public class orderdetail {
    private int quantity;
    private product product;

    public orderdetail(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calcTotalPrice() {
        return this.quantity * this.product.getPrice();
    }

    public product getProduct() {
        return this.product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

