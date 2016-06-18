<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>

</script>
<script type="text/javascript">
	function ajaxTest() {
		$.ajax({
			type : "GET",
			url : "admin/welcome/abc",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				alert("success:" + data);
				<!--
				alert("success:" + data.msg);
				-->
				$("#result").html(data);
			}
		});
	}
	function ajaxJsonTest() {
		$.ajax({
			type : "GET",
			url : "admin/say/hello",
			datatype : "json",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				<!--alert("success:" + data);
				-->

				<!--alert("success:" + data.msg);
				-->
				$("#result").html(data.msg);
			}
		});

	}

	function ajJsonTest() {
		$.ajax({
			type : "post",
			url : "admin/person/",
			datatype : "json",
			error : function(data) {
				alert("出错了！！:" + data);
			},
			success : function(data) {
				alert("success:" + data[0].userName + data[1].userName
						+ data[2].userName);
				<!---->

				<!--alert("success:" + data.msg);
				-->
				$("#result").html(data);
			}
		});

	}
	
	function aJsonTest() {
		$.ajax({
			type : "get",
			url : "/user/addUser.do",
			data : $("#registerForm").serialize(),
			//datatype : "json",
			error : function(data) {
				alert("出错了！！:" + data);
			},
			success : function(data) {
				alert("success:" + data);
				<!---->

				<!--alert("success:" + data.msg);
				-->
				$("#result").html(data);
			}
		});

	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>


<form id="registerForm" action="${pageContext.request.contextPath}/user/addUser.do">
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
				<input type="submit" value="保存" onclick="aJsonTest();">
			</table>

		</div>
	</form>
	<br>
	<br>
	<br>
	<br>


	<p id="result"></p>
	<input type="text" name="name" id="name" />
	<input type="submit" value="登录" onclick="ajaxTest();" />
	<input type="submit" value="测试ajaxjson" onclick="ajJsonTest();" />
	<div id="result"></div>
</body>
</html>