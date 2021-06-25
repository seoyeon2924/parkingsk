 $(document).ready(function(e) {
	//var data = {}
	//data["loginId"] = ${session.loginId};
	console.log("시작하기");
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/mypage" ,
//	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (result) {
		console.log("SUCCESS");
		console.log(result);
		var innerHtml ='';

		for(i in result){

		    console.log(result[i].bookerName);

		    innerHtml +='<tr><td>' + result[i].bokkingParkingLotName + '</td>' +
		                    '<td>' + result[i].id + '</td>' +
		                    '<td>' + result[i].bookDate + '</td>' +
		                    '<td>' + result[i].bookStatus + '</td>' +
		                    '<td>' + result[i].bookCarNo + '</td>' +
		                    // 클릭한 데이터로 인자값 주고 싶으나 시간이 없으니 하드코딩으로 해결해본다....
		                    '<td><a href="/reviews" class="btn btn-outline-primary"> 리뷰작성 </a></td>' +'</tr>'
		}
		console.log(innerHtml);
		$("#tableBody").html(innerHtml);
	} , error: function( e) {
		console.log("error");
		console.log(e);
	}
})
});