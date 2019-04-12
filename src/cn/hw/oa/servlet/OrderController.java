package cn.hw.oa.servlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hw.oa.service.OrderItemService;
import cn.hw.oa.service.OrderService;
import cn.hw.oa.service.Productservice;
import model.Order;
import model.OrderItem;
import model.Product;

// 对购物项的操作
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource(name = "ps")
	private Productservice productService;
	@Resource(name = "ot") // 首先要配置在spring-bean.xml中
	private OrderItemService orderItemService;
	@Resource(name = "or")
	private OrderService orderService;

	@Resource // 每个用户都有自己的session
	private HttpServletRequest request;

	// 更新购物车中某个购物项的数量,返回新的总价格
	@RequestMapping("/updateItem")
	@ResponseBody // 返回json格式
	public Object updateItem(int pid, int num) {
		Order order = (Order) request.getSession().getAttribute("order");
		order = orderItemService.updateItem(order, pid, num);
		// 更新数量后要重新计算总价格
		order.setTotal(orderService.cluTotal(order));
		// 把新总价的购物车重新放到session中
		request.getSession().setAttribute("order", order);
		return order.getTotal();
	}
	// 添加到购物车,添加完毕之后跳转到购物车页面
	@RequestMapping("/addItem")
	public String addItem(int id) {
		// 当前购买商品
		Product product = productService.getById(id);
		// 创建一个购物项,把商品的信息赋值购物项
		OrderItem item = new OrderItem();
		item.setName(product.getName());
		item.setNum(1);
		item.setPrice(product.getPrice());
		item.setProduct(product);
		// 如果当前用户没有购物车,则首先创建一个新的购物车
		HttpSession session = request.getSession();
		if (session.getAttribute("order") == null) {
			session.setAttribute("order", new Order());
		}
		// 把购物项添加到购物车中(每个人都有自己的购物车,因此购物车应该session中)
		Order order = (Order) session.getAttribute("order");
		// 把购物项添加到购物车中
		order = orderItemService.addItem(order, item);
		// 需要计算购物车总价格
		double total = orderService.cluTotal(order);
		order.setTotal(total);
		// 把新的购物车添加到sessio中
		session.setAttribute("order", order);
		// 重定向session的数据是不会丢失
		return "redirect:/shopCart.jsp";
	}
}
