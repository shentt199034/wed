package model;

import java.sql.Date;
//所有的类默认继承Object
public class Product extends Object{
	private int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
private String name;
private double  price;
private String remark;
private Date date;
private Category category;
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
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
			+ ", category=" + category + "]";
}

}
