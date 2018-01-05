//获得项目的绝对路径，如：http://localhost:8083/uimcardprj
function getRootPath(){  
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath=window.document.location.href;  
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp  
    var pathName=window.document.location.pathname;  
    var pos=curWwwPath.indexOf(pathName);  
    //获取主机地址，如： http://localhost:8083  
    var localhostPaht=curWwwPath.substring(0,pos);  
    //获取带"/"的项目名，如：/uimcardprj  
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return(localhostPaht+projectName);  
} 

$(function() {
	var stompClient = null;
	disconnect();
	// 添加点击事件
	$('#connect').click(function() {
		connect();
	});

	// 添加点击事件
	$('#disconnect').click(function() {
		disconnect();
	});

	// 添加点击事件
	$('#send').click(function() {
		send();
	});

	function send() {
		var information = $('#information').val();
		console.info(getRootPath());
		stompClient.send("/accept", {}, JSON.stringify({
			'information' : information
		}));
		$('#information').prop('value','');
	}

	function disconnect() {

		if (stompClient != null) {
			stompClient.disconnect();
		}
		setConnected(false);
		console.info("Disconnected");
	}

	function connect() {
		var socket = new SockJS(getRootPath() + '/endpointWisely');// 相当于使用IP和端口，来创建一个连接
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {// 连接WebSocket服务端
			setConnected(true);
			console.info('Connected: ' + frame);
			stompClient.subscribe('/topic/getResponse', function(response) {
				showResponse(JSON.parse(response.body).responseMessage);
			});
		});
	}

	function setConnected(state) {
		$('#connect').attr('disabled', state);
		$('#disconnect').attr('disabled', !state);
		var visibility = state ? 'visible' : 'hidden';
		$('#conversationDiv').css('visibility', visibility);
		$('#conversationDiv').html();
	}

	function showResponse(message) {
		$('#response').html(message);
	}

});
