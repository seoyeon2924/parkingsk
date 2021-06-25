// Smooth scrolling using jQuery easing
$(".btn.btn-google.btn-user.btn-block").click(function(e) {
	
	/*
	private Long bookerId;
	private String bookerName;
	private Long availableParkingLotId;
	private String availableParkingLotName;
	private String bookdate;
	private String bookCarNo;
	private String bookStatus;
	*/
	
	var data = {}
	data["bookerId"] = $("#bookerId").val();  //새션에서
	data["bookerName"] = $("#bookerName").val(); //새션에서
	data["parkingLotId"] = $("#parkingLotId").val();
	data["parkingLotName"] = $("#parkingLotName").val();
	data["bookdate"] = $("#bookdate").val();
	data["bookCarNo"] = $("#bookCarNo").val();
	data["bookStatus"] = "BOOKED";
	data["result"] = "";
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/bookingregister" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
//			for (var key in data){ 
//				console.log("attr: " + key + ", value: " + data[key]); }

			console.log("예약결과 : " + data.result);
			if(data.result == "Success"){
				alert("주차장을 예약했습니다.");
				location.href="/mypage";
			}else{
				alert("주차장 예약에 실패했습니다" + data.result);
				location.href="booking";
			}
		},error: function( e) {
			//console.log("ERROR",e);
			console.log("예약결과 : " +data);
			alert("주차장을 예약했습니다..");
			location.href="booking";
		}
	})
});

