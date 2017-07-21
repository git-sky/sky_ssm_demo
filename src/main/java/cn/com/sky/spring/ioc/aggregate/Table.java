package cn.com.sky.spring.ioc.aggregate;

public class Table {

	private String name;
	private double price;

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", price=" + price + "]";
	}
}