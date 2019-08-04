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

	$('#selectedLesson').on('click', function() {
		$.ajax({
			url : '/user/username',
			method : 'GET',
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					location.href = "selectedLesson.html";
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

	$('#selectlesson-table')
			.bootstrapTable(
					{
						url : '/select/listLesson',
						method : 'GET',
						pagination : true,
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
									sortable : true
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
									field : 'opt',
									title : '操作',
									width : '140px',
									align : 'center',
									formatter : function(value, row) {
										var res = '<a class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="update('
												+ row.lid + ')">详细信息</a>';
										return res;
									}
								} ]
					});
	

	$('#btn-add').on('click', function() {
		$.ajax({
			url : '/stu/addStu',
			method : 'POST',
			data : $('#form-add').serialize(),
			dataType : 'json',
			success : function(res) {
				if (res.success) {
					$('#selectlesson-table').bootstrapTable('refresh');
					$('#addModal').modal('hide');
				} else {
					alert(res.msg);
				}
			}
		});
	});

	$('#mselect').on(
			'click',
			function() {
				var sel = $('#selectlesson-table').bootstrapTable('getSelections');
				var selid = "";

				sel.forEach(function(v) {
					selid += v.lid + ",";
				});
				if (sel.length > 0) {
					$.confirm({
						title : '确认选课?',
						content : '确认选课',
						type : 'green',
						buttons : {
							ok : {
								text : "确认",
								btnClass : 'btn-primary',
								keys : [ 'enter' ],
								action : function() {
									$.ajax({
										url : '/select/addStulesson/',
										method : 'POST',
										data: {ids:selid},
										dataType : 'json',
										success : function(res) {
											if (res.success) {
												$('#selectlesson-table').bootstrapTable(
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
		url : '/select/findLesson/' + sid,
		method : 'GET',
		dataType : 'json',
		success : function(res) {
			if (res.success) {
				$('#lname').val(res.data.lname);
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
						url : '/stu/deleteStu/' + sid,
						method : 'GET',
						dataType : 'json',
						success : function(res) {
							if (res.success) {
								$('#selectlesson-table').bootstrapTable('refresh');
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