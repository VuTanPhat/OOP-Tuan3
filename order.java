package SP;

import java.time.LocalDate;

public class order {
    private int orderID;
    private LocalDate orderDate;
    private orderdetail[] lineItems;
    private int count;

    public order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        lineItems = new orderdetail[10];
        count = 0;
    }

    public void addLineItem(product p, int q) {
        lineItems[count] = new orderdetail(p, q);
        count++;
    }

    public double calcTotalCharge() {
        double totalCharge = 0;
        for (int i = 0; i < count; i++) {
            totalCharge += lineItems[i].calcTotalPrice();
        }
        return totalCharge;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Mã HD: %d%n", this.orderID));
        result.append(String.format("Ngày lập hoá đơn: %s%n", this.orderDate));
        result.append(String.format("%-5s | %-20s | %-20s | %15s | %10s | %15s%n", "STT", "Mã SP", "Mô tả", "Đơn giá", "Số lượng", "Thành tiền"));

        
        for (int i = 0; i < count; i++) {
            orderdetail item = lineItems[i];
            product product = item.getProduct();
            int quantity = item.getQuantity();
            double price = product.getPrice();
            double total = item.calcTotalPrice();
            result.append(String.format("%-5d | %-20s | %-20s | %,15.0f | %,10d | %,15.0f%n", i+1,product.getDescription(), product.getProductID(), price, quantity, total));
        }

        
        double totalCharge = calcTotalCharge();
        result.append(String.format("%-53s %,15.0f VND", "Tổng tiền thanh toán:", totalCharge));
        return result.toString();
    }

    public orderdetail[] getLineItems() {
        return lineItems;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
