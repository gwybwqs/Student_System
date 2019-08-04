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
	$('#student').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			data : {
				id : '#username'
			},
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = 'studentManager.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#teacher').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			data : {
				id : '#username'
			},
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = 'teacherManager.html';
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#lesson-table')
			.bootstrapTable(
					{
						url : '/lesson/listLesson',
						method : 'GET',
						pagination : true,
						sidePagination : 'server',
						queryParams : function(params) {
							return params;
						},
						pageSize : 6,
						dataType : 'json',
						search : true,
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
									field : 'sid',
									title : 'ID',
									checkbox : true
								},
								{
									field : 'lid',
									title : 'ID',
									sortable : true,
								},
								{
									field : 'lname',
									title : '名称'
								},
								{
									field : 'tid',
									title : '授课老师号'
								},
								{
									field : 'tname',
									title : '授课老师名称'
								},
								{
									field : 'ltime',
									title : '学时'
								},
								{
									field : 'lscore',
									title : '学分'
								},
								{
									field : 'opt',
									title : '操作',
									width : '140px',
									align : 'center',
									formatter : function(value, row) {
										var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="update('
												+ row.lid + ')">修改</a>';
										res += '<a class="btn btn-danger" onclick="del('
												+ row.lid + ')">删除</a>';
										return res;
									}
								} ]
					});
	$('#btn-update').on('click', function() {
		$.ajax({
			url : '/lesson/updateLesson',
			method : 'POST',
			data : $('#form-update').serialize(),
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					$('#lesson-table').bootstrapTable('refresh');
					$('#myModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#btn-add').on('click', function() {
		$.ajax({
			url : '/lesson/addLesson',
			method : 'POST',
			data : $('#form-add').serialize(),
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					$('#lesson-table').bootstrapTable('refresh');
					$('#addModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#mdel').on(
			'click',
			function() {
				var sel = $('#lesson-table').bootstrapTable('getSelections');
				var selid = "";

				sel.forEach(function(v) {
					selid += v.lid + ",";
				});
				if (sel.length > 0) {
					$.confirm({
						title : '确认删除?',
						content : '确认删除',
						type : 'green',
						buttons : {
							ok : {
								text : "确认",
								btnClass : 'btn-primary',
								keys : [ 'enter' ],
								action : function() {
									$.ajax({
										url : '/lesson/mdeleteLesson/' + selid,
										method : 'POST',
										dataType : 'json',
										success : function(res) {
											if (res.success) {
												$('#lesson-table')
														.bootstrapTable(
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

var update = function(sid) {
	$.ajax({
		url : '/lesson/findLesson/' + sid,
		method : 'GET',
		data : {
			id : sid
		},
		dataType : 'json',
		success : function(res) {
			if (res.success) {
				$('#lid').val(res.data.lid);
				$('#lname').val(res.data.lname);
				$('#tid').val(res.data.tid);
				$('#tname').val(res.data.tname);
				$('#ltime').val(res.data.ltime);
				$('#lscore').val(res.data.lscore);
			} else {
				alert(res.msg);
			}
		}
	});
};

var del = function(sid) {
	$.confirm({
		title : '确认删除?',
		content : '确认删除',
		type : 'green',
		buttons : {
			ok : {
				text : "确认",
				btnClass : 'btn-primary',
				keys : [ 'enter' ],
				action : function() {
					$.ajax({
						url : '/lesson/deleteLesson/' + sid,
						method : 'GET',
						dataType : 'json',
						success : function(res) {
							if (res.success) {
								$('#lesson-table').bootstrapTable('refresh');
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