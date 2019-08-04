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
	$('#student').on('click',function(){
		$.ajax({
			url:'/user/username',
			method:'GET',
			dataType:'json',
			success: function(res){
				if(res.success) {
					location.href = 'studentManager.html';
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
	

	
	$('#tea-table').bootstrapTable({
		url: '/Teacher/listTeacher',
		method: 'GET',
		pagination: true,
		sidePagination:'server',
		queryParams: function(params){
			return params;
		},
		pageSize: 6,
		dataType: 'json',
  		search: true,
  		toolbar: '#toolbar',
  		responseHandler: function(res){
  			if(!res.success){
  				location.href = res.data.url;
  			} else {
  				return res;
  			}
  		},
		columns: [{
			field: 'sid',
			title: 'ID',
			checkbox: true
			}, {
			field: 'tid',
			title: 'ID',
			sortable: true,
			}, {
			field: 'tname',
			title: '姓名'
			}, {
			field: 'gender',
			title: '性别'
			}, {
			field: 'lesson',
			title: '主职',
			}, {
			field: 'phone',
			title: '联系方式'
			}, {
			field: 'opt',
			title: '操作',
			width: '140px',
			align: 'center',
			formatter: function(value,row){
				var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="update(' + row.tid + ')">修改</a>';
					res += '<a class="btn btn-danger" onclick="del(' + row.tid + ')">删除</a>';
				return res;
			}
		}]
	});
	$('#btn-update').on('click', function(){
		$.ajax({
			url:'/Teacher/updateTeacher',
			method:'POST',
			data: $('#form-update').serialize(),
			dataType:'json',
			success: function(res){
				if(res.success) {
					$('#tea-table').bootstrapTable('refresh');
					$('#myModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	$('#btn-add').on('click', function(){
		$.ajax({
			url:'/Teacher/addTeacher',
			method:'POST',
			data: $('#form-add').serialize(),
			dataType:'json',
			success: function(res){
				if(res.success) {
					$('#tea-table').bootstrapTable('refresh');
					$('#addModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	$('#mdel').on('click', function(){
		var sel = $('#tea-table').bootstrapTable('getSelections');
		var selid = "";
		
		sel.forEach(function(v){
			selid += v.tid + ",";
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
			        			url:'/Teacher/mdeleteTeacher/'+selid,
			        			method:'POST',
			        			dataType:'json',
			        			success: function(res){
			        				if(res.success) {
			        					$('#tea-table').bootstrapTable('refresh');
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
		url:'/Teacher/findTeacher/'+sid,
		method:'GET',
		dataType:'json',
		success: function(res){
			if(res.success) {
				$('#tid').val(res.data.tid);
				$('#password').val(res.data.password);
				$('#tname').val(res.data.tname);
				$('#gender').val(res.data.gender);
				$('#lesson').val(res.data.lesson);
				$('#phone').val(res.data.phone);
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
	    				url:'/Teacher/deleteTeacher/'+sid,
	    				method:'GET',
	    				dataType:'json',
	    				success: function(res){
	    					if(res.success) {
	    						$('#tea-table').bootstrapTable('refresh');
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