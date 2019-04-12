package cn.hw.oa.service;

import java.util.List;

import model.Order;
import model.OrderItem;


// 购物项目的Service,主要完成购物的业务逻辑
public class OrderItemService {
	public Order updateItem(Order order, int pid, int num) {
		List<OrderItem> orderList = order.getItemList();
		for (OrderItem item : orderList) {
			if (item.getProduct().getId() == pid) {
				// 更新当前购物项的数量
				item.setNum(num);
			}
		}
		// 返回新的购物车
		return order;
	}

	// 把购物项添加到购物车中,返回新的购物车
	public Order addItem(Order order, OrderItem item) {
		// 当前购物项添加到购物车中(当前不判断重复)
		List<OrderItem> orderList = order.getItemList();
		// 往存储购物项的集合中添加新的购物项
		int i = 0;
		for (; i < orderList.size(); i++) {
			OrderItem currentItem = orderList.get(i);
			if (item.getProduct().getId() == currentItem.getProduct().getId()) {
				currentItem.setNum(currentItem.getNum() + 1);
				break;
			}
		}
		// 如果i等于size()则说明正常退出,则当前购物项在购物车中不存在
		if (i == orderList.size()) {
			// 往存储购物项的集合中添加新的购物项
			orderList.add(item);
		}
		return order;
	}
}
