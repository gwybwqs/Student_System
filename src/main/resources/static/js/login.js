$(function(){
	$('#login-submit').on('click', function(){
		if("管理者"==($('#selectstatus input:radio:checked').val())){
			$.ajax({
				url:'/Login/Managercheck',
				method:'post',
				data: $('#login-form').serialize(),
				dataType:'json',
				success: function(res){
					if(res.success) {
						location.href="manager/studentManager.html"
					} else {
						$('#msg').text(res.msg);
					}
				}
			});
			
		}
		else if("老师"==($('#selectstatus input:radio:checked').val())){
			$.ajax({
				url:'/Login/Teachercheck',
				method:'post',
				data: $('#login-form').serialize(),
				dataType:'json',
				success: function(res){
					if(res.success) {
						location.href="teacher/teacher.html"
					} else {
						$('#msg').text(res.msg);
					}
				}
			});
		}
		else if("学生"==($('#selectstatus input:radio:checked').val())){
			$.ajax({
				url:'/Login/Studentcheck',
				method:'post',
				data: $('#login-form').serialize(),
				dataType:'json',
				success: function(res){
					if(res.success) {
						location.href="student/selectLesson.html"
					} else {
						$('#msg').text(res.msg);
					}
				}
			});
		}
		else{alert("请选择您的身份！");}
		return false;
	});	
		
});