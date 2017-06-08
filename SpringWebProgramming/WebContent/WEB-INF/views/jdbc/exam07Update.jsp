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
			function fileChange() {
				if($("#attach")[0].files.length != 0){
					var filename = $("#attach")[0].files[0].name;
					$("#spanFileName").text(filename);
				}
			}
		</script>
	</head>
	<body>
		<h4>글 수정</h4>
		<hr/>
		<form method="post" style="padding: 0px 20px" enctype="multipart/form-data">
			<input type="hidden" name="no" value="${image.no}"/>
			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-bullhorn">Title</span>
					</span>
					<input type="text" class="form-control" placeholder="제목" name="title" value="${image.title}"/>
				</div>
			</div>			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user">Name</span>
					</span>
					<input type="text" class="form-control" placeholder="글쓴이" name="writer" value="${image.writer}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-list-alt">Content</span>
					</span>
					<input type="text" class="form-control" placeholder="내용" name="content" value="${image.content}"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock">Password</span>
					</span>
					<input type="password" class="form-control" placeholder="비밀번호" name="password" value="${image.password}"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group" style="height: 47px;">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<div class="form-control" style="height: 47px;">
						<span id="spanFileName">${image.filename}</span>
						<label for="attach" class="btn btn-default">변경</label>
						<input id="attach" style="visibility:hidden;" type="file" name="attach" onchange="fileChange()">
					</div>										
				</div>
			</div>				
						
			<input type="submit" class="btn btn-info" value="수정하기"/>
		</form>
	</body>
</html>