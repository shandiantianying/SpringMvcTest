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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<style type="text/css">
.style4 {
	color: #000033
}
</style>
<title>Insert title here</title>
</head>
<body>
	欢迎您：${userName }
	<a href="${pageContext.request.contextPath}/admin/loginOut.do">注销</a>
	<a href="${pageContext.request.contextPath}/user/queryUser.do">查询</a>
	<form action="${pageContext.request.contextPath}/user/queryUser.do"
		class="style4">
		<div align="center">
			输入用户名: <input type="text" name="userName"> <input
				type="submit" value="查询">
		</div>
		<table width="800" border="1" align="center" cellpadding="0"
			cellspacing="0">
			<div align="center">
				<tr>
					<td><div align="center">用户名</div></td>
					<td><div align="center">地址</div></td>
					<td><div align="center">年龄</div></td>
					<td><div align="center">密码</div></td>
					<td><div align="center">用户操作</div></td>
				</tr>
				<c:forEach var="stuinf" items="${data }">
					<tr>
					  <td  style = "display:none;" height="28" align="center" class="style4">
							<div align="center">
								<c:out value="${stuinf.id}" />
							</div>
						</td>
						<td height="28" align="center" class="style4">
							<div align="center">
								<c:out value="${stuinf.userName}" />
							</div>
						</td>
						<td height="28" align="center" class="style4">
							<div align="center">
								<c:out value="${stuinf.userAddress}" />
							</div>
						</td>
						<td height="28" align="center" class="style4">
							<div align="center">
								<c:out value="${stuinf.userAge}" />
							</div>
						</td>
						<td height="28" align="center" class="style4">
							<div align="center">
								<c:out value="${stuinf.userPassword}" />
							</div>
						</td>
						<td>
							<div align="center">
								<a href="${pageContext.request.contextPath}/user/aUser.do">添加</a>--
								<a href="${pageContext.request.contextPath}/user/updateUser.do?userName=${stuinf.userName}">修改</a>--
								<a href="${pageContext.request.contextPath}/user/delUser.do?id=${stuinf.id}">删除</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</div>
		</table>
	</form>
</body>
</html>