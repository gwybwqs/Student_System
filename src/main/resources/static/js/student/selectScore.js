$(function() {

	$.ajax({
		url : '/user/username',
		method : 'GET',
		dataType : 'json',
		success : function(res) {
			if (res.success) {
				$('#username').text(res.data.username);
			} else {
				location.href = res.data.url;
			}
		}
	});

	$('#selectLesson').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = "selectLesson.html";
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#selectedLesson').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			data : {
				id : '#username'
			},
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = 'selectedLesson.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#Score-table').bootstrapTable({
		url : '/selected/selectScore',
		method : 'GET',
		pagination : false,
		sidePagination : 'server',
		queryParams : function(params) {
			return params;
		},
		pageSize : 6,
		showRefresh : true, // 显示刷新按钮
		dataType : 'json',
		search : true,
		// silent : true, // 必须设置刷新事件
		toolbar : '#toolbar',
		responseHandler : function(res) {
			if (!res.success) {
				location.href = res.data.url;
			} else {
				return res;
			}
		},
		columns : [ {
			field : 'lid',
			title : '课程编码',
			sortable : true
		}, {
			field : 'lname',
			title : '名称'
		}, {
			field : 'lscore',
			title : '成绩',			
			formatter : function(value) {
				return value + '分';
			}
		} ]
	});

});
