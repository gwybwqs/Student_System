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
	$('#scoreManager').on('click',function(){
		$.ajax({
			url:'/user/username',
			method:'GET',
			dataType:'json',
			success: function(res){
				if(res.success) {
					location.href = 'scoreManager.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});
	
	
	$('#tea-table').bootstrapTable({
		url: '/update/listTeacher',
		method: 'GET',
		pagination: false,
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
				return res;
			}
		}]
	});
	$('#btn-update').on('click', function(){
		$.ajax({
			url:'/update/updateTeacher',
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
	

		
});

var update = function(sid){
	$.ajax({
		url:'/update/findTeacher/'+sid,
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

