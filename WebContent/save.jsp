<!-- jsp指令 -->
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
   <script type="text/javascript">
   		// 页面加载完毕则发送ajax请求获取类别数据
   		$(function(){
   			// 发送请求去访问CategoryController
   			$.post("${pageContext.request.contextPath}/category/queryAll.mvc",null,function(data){
   				    // 把返回的json对象转化jquery对象(才可以使用jquery提供的属性和方法)
   				    $(data).each(function(i){
   				    	// 通过id选择器获取唯一select
   				    	$("#cid").append("<option value=" + this.cid +">" + this.cname + "</option>")
   				    })
   			},"json")
   		})
   </script>
</head>
<body>
	<!-- 创建一个form表单 
	    标签格式: <标签名  属性="属性值" 属性="属性值" />
	         <标签名>文本</标签名>
	 input: 文本框    textarea:文本域   button: 按钮   form: 表单域
	 
	 form action: 设置提交地址,method: 提交的方式(post/get)
	   
	   提交表单时 button的按钮属性值为: type="submit"        
	-->
	<form action="${pageContext.request.contextPath}/product/save.mvc" method="POST">
		商品名称:<input type="text" name="name" /><br />
		商品价格:<input type="text" name="price" /><br />
		详细介绍:<textarea name="remark" rows="3" cols="50"></textarea><br />
		所属类别:<select name="category.cid" id="cid">
			   </select>
		<button type="submit">提交</button>
		<!-- 多个jsp页面提交到了一个Servlet,因此需要通过隐藏域来区分 -->
		<input type="hidden" name="type" value="save" />
	</form>
</body>
</html>