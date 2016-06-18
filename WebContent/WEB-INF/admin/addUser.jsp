<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<script type="text/javascript">
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/addUser.do">
		<div align="center">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" /></td>
				</tr>

				<tr>
					<td>地址：</td>
					<td><input type="text" name="userAddress" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="userAge" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="text" name="userPassword" /></td>
				</tr>
				<div id="errorMessage">${errorMessage }</div>
				<input type="submit" value="保存">
			</table>

		</div>
	</form>

</body>
</html>