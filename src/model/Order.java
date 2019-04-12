package model;

import java.util.ArrayList;
import java.util.List;

// 购物车,用户完成购物之后就是订单表
public class Order {

	private int oid;
	// 配送地址
	private String address;
	// 收件人的手机号码
	private String tel;
	// 收件人的名称
	private String name;
	// 订单的总金额
	private double total;
	// 一个购物车,可以包含多个购物项(List)
	private List<OrderItem> itemList = new ArrayList<OrderItem>();

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", address=" + address + ", tel=" + tel + ", name=" + name + ", total=" + total
				+ ", itemList=" + itemList + "]";
	}

}
