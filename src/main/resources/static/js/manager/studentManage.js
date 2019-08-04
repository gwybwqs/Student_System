$(function(){
	
	$.ajax({
		url:'/user/username',
		method:'GET',
		dataType:'json',
		success: function(res){
			if(res.success) {
				$('#username').text(res.data.username);
			} else {
				location.href = res.data.url;
			}
		}
	});

	
	$('#teacher').on('click',function(){
		$.ajax({
			url:'/user/username',
			method:'GET',
			dataType:'json',
			success: function(res){
				if(res.success) {
					location.href = "teacherManager.html";
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	$('#lesson1').on('click',function(){
		$.ajax({
			url:'/user/username',
			method:'GET',
			data: {id:'#username'},
			dataType:'json',
			success: function(res){
				if(res.success) {
					location.href = 'lessonManager.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	
	$('#stu-table').bootstrapTable({
		url: '/stu/listStu',
		method: 'GET',
		pagination: true,
		sidePagination:'server',
		queryParams: function(params){
			return params;
		},
		pageSize: 6,
		showRefresh : true, // 显示刷新按钮
		dataType: 'json',
  		search: true,
  		 //silent : true, // 必须设置刷新事件
  		toolbar: '#toolbar',
  		responseHandler: function(res){
  			if(!res.success){
  				location.href = res.data.url;
  			} else {
  				return res;
  			}
  		},
		columns: [{
			field: 'id',
			title: 'ID',
			checkbox: true
			}, {
			field: 'sid',
			title: '学号'
			}, {
			field: 'sname',
			title: '姓名'
			}, {
			field: 'gender',
			title: '性别'
			}, {
			field: 'age',
			title: '年龄',
			sortable: true,
			formatter: function(value){
				return value + '岁';
			}
			}, {
			field: 'grade',
			title: '班级'
			}, {
			field: 'opt',
			title: '操作',
			width: '140px',
			align: 'center',
			formatter: function(value,row){
				var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="update(' + row.sid + ')">修改</a>';
					res += '<a class="btn btn-danger" onclick="del(' + row.sid + ')">删除</a>';
				return res;
			}
		}]
	});
	$('#btn-update').on('click', function(){
		$.ajax({
			url:'/stu/updateStu',
			method:'POST',
			data: $('#form-update').serialize(),
			dataType:'json',
			success: function(res){
				if(res.success) {
					$('#stu-table').bootstrapTable('refresh');
					$('#myModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	$('#btn-add').on('click', function(){
		$.ajax({
			url:'/stu/addStu',
			method:'POST',
			data: $('#form-add').serialize(),
			dataType:'json',
			success: function(res){
				if(res.success) {
					$('#stu-table').bootstrapTable('refresh');
					$('#addModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	$('#mdel').on('click', function(){
		var sel = $('#stu-table').bootstrapTable('getSelections');
		var selid = "";
		
		sel.forEach(function(v){
			selid += v.sid + ",";
		});
		if(sel.length > 0){
			$.confirm({
			    title: '确认删除?',
			    content: '确认删除',
			    type: 'green',
			    buttons: {
			        ok: {
			            text: "确认",
			            btnClass: 'btn-primary',
			            keys: ['enter'],
			            action: function(){
			            	$.ajax({
			        			url:'/stu/mdeleteStu/',
			        			method:'POST',
			        			data: {ids:selid},
			        			dataType:'json',
			        			success: function(res){
			        				if(res.success) {
			        					$('#stu-table').bootstrapTable('refresh');
			        				} else {
			        					alert(res.msg);
			        				}
			        			}
			        		});
			            }
			        },
					cancel: {
						text: '取消',
						action: function(){
						}
					}
			    }
			});
			
		}else{
			alert("您未选择数据！")
		}
	
	});
});

var update = function(sid){
	$.ajax({
		url:'/stu/findStu/'+sid,
		method:'GET',
		dataType:'json',
		success: function(res){
			if(res.success) {
				$('#sid').val(res.data.sid);
				$('#password').val(res.data.password);
				$('#sname').val(res.data.sname);
				$('#gender').val(res.data.gender);
				$('#age').val(res.data.age);
				$('#grade').val(res.data.grade);
			} else {
				alert(res.msg);
			}
		}
	});
};


var del = function(sid){	
	$.confirm({
	    title: '确认删除?',
	    content: '确认删除',
	    type: 'green',
	    buttons: {
	        ok: {
	            text: "确认",
	            btnClass: 'btn-primary',
	            keys: ['enter'],
	            action: function(){
	            	$.ajax({
	    				url:'/stu/deleteStu/'+sid,
	    				method:'GET',
	    				dataType:'json',
	    				success: function(res){
	    					if(res.success) {
	    						$('#stu-table').bootstrapTable('refresh');
	    					} else {
	    						alert(res.msg);
	    					}
	    				}
	    			});
	            }
	        },
			cancel: {
				text: '取消',
				action: function(){
				}
			}
	    }
	});
	return false;
};