<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="/wed/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$('.btnDel').click(function(){
		  var pid=$(this).attr('lang')
		  $.get('${pageContext.request.contextPath}/product/delete.mvc',{pid:pid})
		  $(this).parents("tr:first").remove()
})
  })
</script>
</head>
<body>
          <form action="${pageContext.request.contextPath}/product/query.mvc" method="get"> 
          给我搜：<input type="text" name="keyword" /> <button type="submit" >提交 </button>    
          </form>  
        <c:if test="${not empty requestScope.proList}">
          <h3>下面是查询结果</h3>
          <table border="1" width="600px">
          <tr>
            <th>编号</th>
            <th>商品名</th>
            <th>价格</th>
            <th>备注</th>
            <th>操作</th>
            </tr> 
            <c:forEach items="${requestScope.proList}" var="p" varStatus="num">
            <tr>
            <td>${num.count}</td>
            <td>${p.name }</td>
            <td>${p.price }</td>
            <td>${p.remark }</td>
            <td>${p.category.cname }</td>
            <td><button type="button" class="btnDel" lang="${p.id}">ajax删除</button>|
                <a href="${pageContext.request.contextPath}//product/getById.mvc?id=${p.id}">先查询在更新</a>
            </td>
            </tr> 
            </c:forEach>
         </table>
     </c:if>     
</body>
</html>