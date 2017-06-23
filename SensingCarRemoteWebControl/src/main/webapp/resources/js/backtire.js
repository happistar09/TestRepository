function backtire(command, speed, direction) {

	var json = {"command" : command, "speed" : speed, "direction" : direction};

	$.ajax({
		url : "http://" + location.host + "/SensingCarRemoteWebControl/backtire",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#backtireStatus").html("speed=" + data.speed +"<br/>direction=" + data.direction);
				$("#btnSpeed0").attr("onclick", "backtire('change','0','" + data.direction +"')");
				$("#btnSpeed1").attr("onclick", "backtire('change','1000','" + data.direction +"')");
				$("#btnSpeed2").attr("onclick", "backtire('change','1300','" + data.direction +"')");
				$("#btnSpeed3").attr("onclick", "backtire('change','1700','" + data.direction +"')");
				$("#btnSpeed4").attr("onclick", "backtire('change','2000','" + data.direction +"')");
				$("#btnSpeed5").attr("onclick", "backtire('change','2400','" + data.direction +"')");
				$("#btnSpeed6").attr("onclick", "backtire('change','2700','" + data.direction +"')");
				$("#btnSpeed7").attr("onclick", "backtire('change','3100','" + data.direction +"')");
				$("#btnSpeed8").attr("onclick", "backtire('change','3400','" + data.direction +"')");
				$("#btnSpeed9").attr("onclick", "backtire('change','3800','" + data.direction +"')");
				$("#btnSpeed10").attr("onclick", "backtire('change','4095','" + data.direction +"')");
				$("#btnDirectionForward").attr("onclick", "backtire('change','" + data.speed +"', 'forward')");
				$("#btnDirectionBackward").attr("onclick", "backtire('change','" + data.speed +"', 'backward')");
				
			}
		}
	});
}