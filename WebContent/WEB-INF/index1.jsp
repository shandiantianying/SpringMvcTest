<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}\js\bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
<title>Insert title here</title>
</head>
<body>
	用户：
	<input type="text" name="userName" id="userName" />
	<Br> 地址：
	<input type="text" name="userAddress" id="userAddress" />
	<Br> 年龄：
	<input type="text" name="userAge" id="userAge" />
	<Br>

	<input type="submit" value="测试" id="test1" />
	<div id="result"></div>

	<tr>

		<td>用户名称</td>

		<td><input type="text" name="name" value="${item.userName}" /></td>

	</tr>

	<tr>

		<td>用户地址</td>

		<td><input type="text" name="price" value="${item.userAddress}" /></td>

	</tr>



	Welcome JSP!
	<center>
		<form action="${pageContext.request.contextPath }/admin/login.do"
			method="post">
			用户名：<input type="text" name="userName"> <br> 密码：<input
				type="passWord" name="userPassword"> <br>
			<div id="errorMessage">${ errorMessage }</div>
			<input type="submit" value="提交">
		</form>
	</center>
</body>
</html>