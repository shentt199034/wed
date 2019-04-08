<!-- jsp指令 -->
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<!-- 创建一个form表单 
	    标签格式: <标签名  属性="属性值" 属性="属性值" />
	         <标签名>文本</标签名>
	 input: 文本框    textarea:文本域   button: 按钮   form: 表单域
	 
	 form action: 设置提交地址,method: 提交的方式(post/get)
	   
	   提交表单时 button的按钮属性值为: type="submit"        
	-->
	<form action="${pageContext.request.contextPath}/ProductServlet" method="POST">
		商品名称:<input type="text" name="name" /><br />
		商品价格:<input type="text" name="price" /><br />
		详细介绍:<textarea name="remark" rows="3" cols="50"></textarea><br />
		<button type="submit">提交</button>
		<!-- 多个jsp页面提交到了一个Servlet,因此需要通过隐藏域来区分 -->
		<input type="hidden" name="type" value="save" />
	</form>
</body>
</html>