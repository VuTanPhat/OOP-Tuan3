package SP;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
	    // Tạo đối tượng Order
	    order order = new order(1, LocalDate.of(2023, 5, 9));

	    // Thêm các sản phẩm vào đơn hàng
	    order.addLineItem(new product("sp4", "Nước tương", 8000), 10);
	    order.addLineItem(new product("sp1", "Gạo", 18000), 5);
	    order.addLineItem(new product("sp4", "Đường", 10000), 1);
	    order.addLineItem(new product("sp1", "Gạo", 18000), 1);

	    // In kết quả ra màn hình
	    System.out.println(order.toString());
	}
}