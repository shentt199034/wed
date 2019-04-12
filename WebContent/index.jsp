<!-- jsp指令 -->
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品的首页</title>
</head>
<body>
	<table border="1" width="700px">
	    <!-- 大循环开始,每次循环的是一个productList -->
	    <c:forEach items="${applicationScope.bigList}" var="proList">
	    <tr>
	    	<td>${proList[0].category.cname}</td>
	    </tr>
		<tr>
			<td>
				<table>
					<tr>
					    <!-- 小循环开始 -->
					    <c:forEach items="${proList}" var="product">
						<td>
						        <!-- 显示商品信息 table表格 -->
						        <table>
						        	<tr>
						        		<td><img src="${pageContext.request.contextPath}/img/index_img.jpg" /></td>
						        	</tr>
						        	<tr>
						        		<td>${product.name}</td>
						        	</tr>
						        	<tr>
						        		<td>$ ${product.price},<a href="${pageContext.request.contextPath}/product/detail.mvc?id=${product.id}">详细</a></td>
						        	</tr>
						        </table>
						</td>
						</c:forEach>
						<!-- 小循环结束 -->
					</tr>
				</table>
			</td>
		</tr>
		</c:forEach>
		<!-- 大循环结束 -->
	</table>
</body>
</html>