package cn.hw.oa.service;

import model.Order;
import model.OrderItem;

// 用来实现购物车的业务逻辑
public class OrderService {

	// 创建一个方法,用来计算当前购物车的总价格,返回新的总价格
	public double cluTotal(Order order) {
		// 总价格就是每个购物项的单价之和
		double sum = 0.0;
		for (OrderItem item : order.getItemList()) {
			// 总价 = 单价 * 数量
			sum += item.getPrice() * item.getNum();
		}
		return sum;
	}

}
