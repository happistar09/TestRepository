<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
		function handleBtnUpdate(){
			var password = $("#password").val();
			if(password == ""){
				$("#password").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
				$("#password").css("border-color", "red");
				return;
			}
			$.ajax({
				url: "exam07CheckPassword",
				method: "post",			
				data: {"no":"${image.no}","password":password},
				success: function(data){
					if(data.result == "success"){
						location.href = "exam07Update?mid=${image.no}"
					} else{
						$("#password").val("");
						$("#password").attr("placeholder", "비밀번호를 정확히 입력해주세요 !");
						$("#password").css("border-color", "red");
					}
				}
			});
		}
		
		function handleBtnDelete(){			
			var password = $("#password").val();
			if(password == ""){
				$("#password").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
				$("#password").css("border-color", "red");
				return;
			}
			$.ajax({
				url: "exam07CheckPassword",
				method: "post",			
				data: {"no":"${service.no}","password":password},
				success: function(data){
					if(data.result == "success"){
						location.href = "exam07Delete?no=${image.no}"
					} else{
						$("#password").val("");
						$("#password").attr("placeholder", "비밀번호를 정확히 입력해주세요 !");
						$("#password").css("border-color", "red");
					}
				}
			});
		}
		</script>		
	</head>
	<body>
		<h4>멤버 상세 보기</h4>
		<hr/>
		<form method="post" style="padding: 0px 20px" enctype="multipart/form-data">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="글번호" name="no" value="${image.no}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="제목" name="title" value="${image.title}" disabled/>
				</div>
			</div>			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input type="date" class="form-control" placeholder="내용" name="content" value="${image.content}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-leaf"></span>
					</span>
					<input type="text" class="form-control" placeholder="글쓴이" name="writer" value="${image.writer}" disabled/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<a class="form-control" href="#">${image.filename}</a>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input id="password" type="password" class="form-control" placeholder="비밀번호" name="password"/>
				</div>
			</div>
						
						
			<a href="exam07" class="btn btn-success">목록</a>
			<input onclick="handleBtnUpdate()" type="button" class="btn btn-warning" value="수정"/>
			<input onclick="handleBtnDelete()" type="button" class="btn btn-danger" value="삭제"/>
			
			<!--  
			<button>버튼</button>			//submit 기능
			<input type="button" value="버튼"/>	
			<input type="submit" value="버튼"/>	//submit 기능
			<input type="cancel" value="버튼"/>
			
			<input type="image" src="버튼.png"/>	//submit 기능
			<img src="버튼.png"/>			//submit 기능 없이 이미지만 넣고 싶을 때
			-->
		</form>
	</body>
</html>