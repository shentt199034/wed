<!-- jsp指令 -->
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品详细页面</title>
</head>
<body>
	<h1>此页面显示商品的详细信息</h1>
	商品图片:<img src="${pageContext.request.contextPath}/img/index_img.jpg" />
	商品名称:${requestScope.product.name}<br />
	商品价格:${requestScope.product.price}<br />
	商品详细:${requestScope.product.remark}<br />
	商品日期:${requestScope.product.date}<br />
	<a href="${pageContext.request.contextPath}/order/addItem.mvc?id=${requestScope.product.id}">购物项添加到购物车</a>
</body>
</html>