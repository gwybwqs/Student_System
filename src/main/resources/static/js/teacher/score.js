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

	
	$('#info').on('click',function(){
		$.ajax({
			url:'/user/username',
			method:'GET',
			dataType:'json',
			success: function(res){
				if(res.success) {
					location.href = "teacher.html";
				} else {
					alert(res.msg);
				}
			}
		});
	});
	

	
	
	
	$('#score-table').bootstrapTable({
		url: '/update/listStuScore',
		method: 'GET',
		pagination: false,
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
			},  {
				field: 'lid',
				title: '课程编号'
				}, {
				field: 'lname',
				title: '课程名称'
				}, {
					field: 'lscore',
					title: '成绩'
					}
				,{
			field: 'opt',
			title: '操作',
			width: '140px',
			align: 'center',
			formatter: function(value,row){
				var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="update('+ row.sid +',' + row.lid + ')">打分</a>';
					res += '<a class="btn btn-danger" onclick="del('+ row.sid +',' + row.lid +')">删除</a>';
				return res;
			}
		}]
	});
	$('#btn-update').on('click', function(){
		$.ajax({
			url:'/update/updateScore',
			method:'POST',
			data: $('#form-update').serialize(),
			dataType:'json',
			success: function(res){
				if(res.success) {
					$('#score-table').bootstrapTable('refresh');
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
					$('#score-table').bootstrapTable('refresh');
					$('#addModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
});

var update = function(sid,lid){
	var selid = "";
		selid = sid + ","+lid	
	$.ajax({
		url:'/update/findScore',
		method:'GET',
		data: {ids:selid},
		dataType:'json',
		success: function(res){
			if(res.success) {
				$('#sname').val(res.data.sname);
				$('#sid').val(res.data.sid);
				$('#lid').val(res.data.lid);
				$('#lname').val(res.data.lname);	
				$('#lscore').val(res.data.lscore);
			} else {
				alert(res.msg);
			}
		}
	});
};

var del = function(sid,lid){
	var selid = "";
	selid = sid + ","+lid	
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
	    				url:'/update/deletelesson',
	    				method:'GET',
	    				data: {ids:selid},
	    				dataType:'json',
	    				success: function(res){
	    					if(res.success) {
	    						$('#score-table').bootstrapTable('refresh');
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