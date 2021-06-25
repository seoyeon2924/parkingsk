/*
회원 가입 등록 폼에 사용
*/
  $("#custom-register-btn").click(function(e) {
  console.log("회원가입 버튼 눌림 ");
	var data = {};

	data["loginId"] = $("#memberLoginId").val();
	data["loginPassword"] = $("#exampleInputPassword").val();
	data["name"] = $("#memberName").val();
	data["company"] = $("#memberCompany").val();
	data["employeeNumber"] = $("#memberEmployNumber").val();
	data["roleType"] = $("#memberRoleType").val();
	console.log(data);
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/register" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
		console.log("SUCCESS");
		alert("회원가입이 완료되었습니다.");
		location.href="/";
	} , error: function(e) {
		console.log("ERROR",e);
		alert("회원가입 불가");
		console.log(data);
		location.href="/register";
	}
})
});