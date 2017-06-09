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
   		 <meta name="description" content="">
    	<meta name="author" content="">

    	

	    <!-- Bootstrap Core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom CSS -->
	    <link href="css/thumbnail-gallery.css" rel="stylesheet">
		<style>
		body {
			background-color: ivory;
			
		}
		</style>
	</head>
	<body>
	<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="exam07">[사진 게시판]</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="exam07Write">글 쓰기</a>
                    </li>
                   
                </ul>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

          <hr><hr><hr>
            
            <c:forEach var="b" items="${list}">
	            <div class="col-lg-4 thumb">
	                <a class="thumbnail" href="exam07Detail?no=${b.no}">
	                    <img class="img-responsive" src="../file/exam05?no=${b.no}" height="300px" width="300px"  alt="">
	                </a>
	            </div>
            </c:forEach>

        </div>

        <hr>        
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
       

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>	
		
	</body>
</html>