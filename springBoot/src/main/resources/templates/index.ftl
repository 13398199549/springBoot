<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${request.contextPath}/sysmag/login" method="post">
		UserName:<input type="text" name="userName"/>
		<br/>
		Password:<input type="text" name="password"/>
		<br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>