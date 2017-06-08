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
	</head>
	<body>
		<h4>사진 게시판</h4>
		<hr/>		
		<table class="table table-bordered" style="margin-top: 20px; width:1000px">
			<tr class="success">
				<td>글번호</td>
				<td>사진</td>
				<td>제목</td>				
				<td>내용</td>
				<td>글쓴이</td>
				<td>조회수</td>
				<td>파일이름</td>				
				<td>날짜</td>
				
				
				
				
			</tr>
			<c:forEach var="b" items="${list}">
				<tr>
					<td>${b.no}</td>
					<td><a href="exam07Detail?no=${b.no}"><img src="../file/exam05?no=${b.no}" width="100px" height="100px"/></a></td>
					<td><a href="exam07Detail?no=${b.no}">${b.title}</a></td>
					<td>${b.content}</td>
					<td>${b.writer}</td>
					<td>${b.hitcount}</td>					
					<td>${b.filename}</td>				
					<td>${b.day}</td>							
															
				</tr>
			</c:forEach>
		</table>
		<div style="margin-top: 20px; width:700px; text-align:center;">
			<a href="exam07?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="exam07?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp;
				<a href="exam07?pageNo=${i}" <c:if test="${pageNo==i}">style="font-weight:bold; color:red;"</c:if>>${i}</a>
				&nbsp;
			</c:forEach>
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="exam07?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>			
			<a href="exam07?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
	</body>
</html>