package model;
//所有的类默认继承Object
public class Category {
	private int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

private String name;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Category [id=" + id + ", name=" + name + "]";
}

}


