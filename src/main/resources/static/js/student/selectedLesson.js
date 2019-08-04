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

	$('#selectScore').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			data : {
				id : '#username'
			},
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = 'selectScore.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#selectedlesson-table')
			.bootstrapTable(
					{
						url : '/selected/listLesson',
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
						columns : [
								{
									field : 'id',
									title : 'ID',
									checkbox : true
								},
								{
									field : 'lid',
									title : '课程编码',
									sortable : true,
								},
								{
									field : 'lname',
									title : '名称'
								},
								{
									field : 'tid',
									title : '授课老师编号'
								},
								{
									field : 'tname',
									title : '授课老师名称',
									
								},
								{
									field : 'ltime',
									title : '学时',
									sortable : true,
								},{
									field : 'lscore',
									title : '学分',
									sortable : true,
								},
								{
									field : 'opt',
									title : '操作',
									width : '140px',
									align : 'center',
									formatter : function(value, row) {
										var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="del('
												+ row.lid + ')">退选</a>';
										return res;
									}
								} ]
					});
	

	

	$('#mdel').on(
			'click',
			function() {
				var sel = $('#selectedlesson-table').bootstrapTable('getSelections');
				var selid = "";

				sel.forEach(function(v) {
					selid += v.lid + ",";
				});
				if (sel.length > 0) {
					$.confirm({
						title : '确认退课?',
						content : '确认退课',
						type : 'green',
						buttons : {
							ok : {
								text : "确认",
								btnClass : 'btn-primary',
								keys : [ 'enter' ],
								action : function() {
									$.ajax({
										url : '/selected/mdeletelesson/',
										method : 'POST',
										data: {ids:selid},
										dataType : 'json',
										success : function(res) {
											if (res.success) {
												$('#selectedlesson-table').bootstrapTable(
														'refresh');
											} else {
												alert(res.msg);
											}
										}
									});
								}
							},
							cancel : {
								text : '取消',
								action : function() {
								}
							}
						}
					});

				} else {
					alert("您未选择数据！")
				}

			});
});



var del = function(sid) {

	$.confirm({
		title : '确认退课?',
		content : '确认退课',
		type : 'green',
		buttons : {
			ok : {
				text : "确认",
				btnClass : 'btn-primary',
				keys : [ 'enter' ],
				action : function() {
					$.ajax({
						url : '/selected/deletelesson/' + sid,
						method : 'GET',
						dataType : 'json',
						success : function(res) {
							if (res.success) {
								$('#selectedlesson-table').bootstrapTable('refresh');
							} else {
								alert(res.msg);
							}
						}
					});
				}
			},
			cancel : {
				text : '取消',
				action : function() {
				}
			}
		}
	});
	return false;
};