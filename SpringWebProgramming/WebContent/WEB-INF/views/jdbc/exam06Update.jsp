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
				if($("#mattach")[0].files.length != 0){
					var originalfilename = $("#mattach")[0].files[0].name;
					$("#spanFileName").text(originalfilename);
				}
			}
		</script>
	</head>
	<body>
		<h4>정보 수정</h4>
		<hr/>
		<form method="post" style="padding: 0px 20px" enctype="multipart/form-data">
			<input type="hidden" name="mid" value="${member.mid}"/>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="id" name="mid" value="${member.mid}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="이름" name="mname" value="${member.mname}" disabled/>
				</div>
			</div>			
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input type="date" class="form-control" placeholder="등록날짜" name="mdate" value="${member.mdate}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-leaf"></span>
					</span>
					<input type="text" class="form-control" placeholder="전화번호" name="mtel" value="${member.mtel}"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-leaf"></span>
					</span>
					<input type="text" class="form-control" placeholder="이메일" name="memail" value="${member.memail}"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-leaf"></span>
					</span>
					<input type="text" class="form-control" placeholder="나이" name="mage" value="${member.mage}" disabled/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-leaf"></span>
					</span>
					<input type="text" class="form-control" placeholder="주소" name="maddress" value="${member.maddress}"/>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<input type="password" class="form-control" placeholder="비밀번호" name="mpassword" value="${member.mpassword}"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group" style="height: 47px;">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<div class="form-control" style="height: 47px;">
						<span id="spanFileName">${member.moriginalfilename}</span>
						<label for="mattach" class="btn btn-default">변경</label>
						<input id="mattach" style="visibility:hidden;" type="file" name="mattach" onchange="fileChange()">
					</div>										
				</div>
			</div>				
						
			<input type="submit" class="btn btn-info" value="수정하기"/>
		</form>
	</body>
</html>