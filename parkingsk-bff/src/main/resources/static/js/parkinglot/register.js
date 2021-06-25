// parkinglot register사용
  $(".btn.btn-google.btn-user.btn-block").click(function(e) {
	var data = {}
	data["name"] = $("#lot_name").val();
	data["companyName"] = $("#company_name").val();
	data["capacity"] = $("#capacity").val();
	data["latitude"] = $("#latitude").val();
	data["longitude"] = $("#longitude").val();
	data["openTime"] = $("#openTime").val();
	data["endTime"] = $("#endTime").val();
	data["address"] = $("#address").val();
	data["area"] = $("#area").val();
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/parkinglotregister" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
		console.log("SUCCESS");
		location.href="parkinglot";
	} , error: function( e) {
		console.log("ERROR",e);
		location.href="parkinglot";
	}
})
});
