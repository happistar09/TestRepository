<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		<script>
			//전역 변수
			var v1 = "A";
			
			//함수단위의 변수 (Javascript는 함수단위)
			function fun1(){
				var v2 = "B";				
				if(true){
					var v3 = "C";
					//v4는 전역변수
					v4 = "D";
				}
				console.log(v1);
				console.log(v2);
				console.log(v3);
				console.log(v4);
			}
			fun1();
			console.log(v1);
			//console.log(v2);
			//console.log(v3);
			console.log(v4);
		</script>
	</head>
	<body>

	</body>
</html>
