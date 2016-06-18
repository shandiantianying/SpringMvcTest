<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script  type="text/javascript" src="js/jquery-2.1.3.js"></script>
<script src="js/jquery-1.7.2.js">

</script>
<script type="text/javascript" >
	function ajaxTest() {
		alert("${pageContext.request.contextPath}/js/jquery-2.1.3.js")
		$.ajax({
			type : "GET",
			dataType : 'json',
			url : "admin/welcome/111",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				alert("success:" + data.msg);
				$("#result").html(data.msg);
			}
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="name" id="name" />
	<input type="submit" value="登录" onclick="ajaxTest();" />
	<div id="result"></div>
</body>
</html>