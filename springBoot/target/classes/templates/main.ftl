<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${request.contextPath}/">
<title>Insert title here</title>
<script type="text/javascript"
	src="static/bootstrap/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="static/js/view.main.js" charset="utf-8"></script>
</head>
<body>
	这是首页！欢迎你，${author.name},你的密码是:${author.age}
	
	<p/>
	<button id="btn0">新增</button>
	<button id="btn1">修改</button>
	<button id="btn2">删除</button>
	<button id="btn3">查询</button>
	<p/>
	
	<a href="sysmag/hello?name=asdf">点击进入，Freemaker页面</a>
</body>
</html>