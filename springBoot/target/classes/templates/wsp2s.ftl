<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${request.contextPath}/">
<title>这是websocket发布订阅实现</title>
<script type="text/javascript"
	src="static/js/sockjs.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="static/js/stomp.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="static/bootstrap/js/jquery-3.2.0.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="static/js/view.wsp2s.js" charset="utf-8"></script>
</head>
<body>
	<noscript><h2 style="color:#ff0000">可能你的浏览器不支持websocket</h2></noscript>
<div>
	<div>
		<button id="connect">连接</button>
		<button id="disconnect">断开连接</button>
	</div>

	<div id="conversationDiv">
		<label>输入信息：</label>
		<input type="text" id="information"/>
		<button id="send">发送</button>
	</div>
	<div>
		<p id="response"></p>
	
	</div>



</div>





</body>
</html>