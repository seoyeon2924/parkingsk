/*
로그인 폼에 사용
*/
  $("#custom-login-btn").click(function(e) {
	var data = {};
	data["loginId"] = $("#inputLoginId").val();
	data["password"] = $("#inputPassword").val();
	console.log(data);
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/login" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
	console.log(data.roleType);
		console.log("SUCCESS");
		//alert(data.name + "님 안녕하세요~");
        Swal.fire({
            title: '로그인 성공',
            icon: 'success'
        }).then((result) => {
            // 로그인 한 사용자의 roleType에 따라 화면 분기 처리
            if ( data.roleType == "USER" ) {
                  location.href="/booking"
            } else {
                  location.href="/parkinglot"
            }
        })
	} , error: function(e) {
		    console.log("ERROR",e);
            Swal.fire({
              title: '로그인 실패',
              text: 'ID/PW를 확인해주세요!',
              icon: 'error'
            }).then((result) => {
              location.href="/login";
            })
	    }
    })
});
