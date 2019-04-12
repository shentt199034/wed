package model;
//所有的类默认继承Object
public class Category {
	private int cid;

private String cname;
private boolean chot;
public void setChot(boolean chot) {
	this.chot = chot;
}
public boolean isChot() {
	return chot;
}
public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}


@Override
public String toString() {
	return "Category [cid=" + cid + ", cname=" + cname + ", chot=" + chot + "]";
}

}


