$(function(){
	//新增
	$('#btn0').click(function(){
		var user = {userName:"大黄峰",loginName:"p",
				password:"123456",age:"19",gender:1};
		console.info(user);
		
		$.ajax({
			type:"POST",
			url:"users/-1",
			data:user,
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	
	//修改
	$('#btn1').click(function(){
		var user = {userName:"小黄峰",loginName:"p",
				password:"123456",age:"19",gender:1};
		console.info(user);
		
		$.ajax({
			type:"PUT",
			url:"users/1",
			data:user,
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	//删除
	$('#btn2').click(function(){
		
		$.ajax({
			type:"DELETE",
			url:"users/3",
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	//查询
	$('#btn3').click(function(){
		
		$.ajax({
			type:"GET",
			url:"users/1",
			async:true,
			success:function(data){
				//不需要再写json.parse(data);
				console.info(data);
			}
		});
	});
	
	
});
	