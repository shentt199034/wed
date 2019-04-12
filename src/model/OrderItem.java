package model;

// 购物项(被购买商品)
public class OrderItem {

	//
	private int iid;
	private String name;
	private int num;
	private double price;
	// 当前购物项所关联的真正商品(判断当前购物项是否重复)
	private Product product;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [iid=" + iid + ", name=" + name + ", num=" + num + ", price=" + price + ", product=" + product
				+ "]";
	}

}
