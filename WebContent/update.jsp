<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
      <form action="${pageContext.request.contextPath}/Productservlet" method="post">
                              商品名称：<input type="text" name="name"  value="${requestScope.product.name}"/><br />
                              商品价格：<input type="password" name="price"  value="${requestScope.product.price}" /><br />
                              详细介绍：<textarea name="remark" rows="3" cols="50">${requestScope.product.remark}</textarea><br />
         <button type="submit" >提交 </button>
         <input type="hidden" name="type" value ="update"/>
         <input type="hidden" name="id" value ="${requestScope.product.id}"/>
       
    </form>  
</body>
</html>