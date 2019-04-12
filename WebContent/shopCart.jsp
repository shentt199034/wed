<!-- jsp指令 -->
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="/wed/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	// 注册丢失焦点事件
	$(".num").blur(function(){
		// 判断当前的值是否正确,如果错误则还原之前的值
		var num = this.value
		if(!isNaN(num) && num > 0 && num%1==0){
			// 数字合法,则更新lang的值,且发送ajax请求
			$(this).attr('lang',num)
			$.post('${pageContext.request.contextPath}/order/updateItem.mvc',{pid:$(this).attr('id'),num:num},function(total){
				// 获取总价格的标签,更新总价格
				$("#total").html(total)			    
			},"json")
		}else{
			// 数字无效,还原之前值
			this.value = $(this).attr('lang')
		}
	})
	$('.btnDel').click(function(){
		  var pid=$(this).attr('lang')
		  $.get('${pageContext.request.contextPath}/order/updateItem.mvc',{pid:$(this).attr('id')})
		  $(this).parents("tr:first").remove()
})
})

</script>
</head>
<body>

	<h1>显示购物车页面, 返回<a href="${pageContext.request.contextPath}/index.jsp">首页</a></h1>
	<table border="1" width="800px">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>数量</th>
			<th>价格</th>
			<th>操作</th>
		<tr>
		<!-- 第二行,用来循环显示购物项 -->
		<c:forEach items="${sessionScope.order.itemList}" var="item" varStatus="num">
		<tr>
			<td>${num.count}</td>
			<td>${item.name}</td>
			<td><input type="text" class="num" id="${item.product.id}" lang="${item.num}" value="${item.num}" size="2" /></td>
			<td>${item.price}</td>
			<td><button type="button" class="btnDel" lang="${p.id}">ajax删除</button></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align: right;">总价格:<span id="total">${sessionScope.order.total}</span></td>
		</tr>
	</table>
	
</body>
</html>