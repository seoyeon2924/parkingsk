  $("#review-register-btn").click(function(e)  {
	console.log("리뷰저장 버튼 누름");
	var data = {};
	data["contents"] = $("#contents").val();
	data["starPoint"] = $("#starPoint").val();
	console.log(data);
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/reviews" ,
	data : JSON.stringify(data) ,
	//dataType: 'json' ,
	success: function (data) {
		console.log("SUCCESS");
        Swal.fire({
          title: '리뷰를 등록하시겠습니까?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes'
        }).then((result) => {
          if (result.isConfirmed) {
            Swal.fire(
               'Success!',
               '리뷰가 정상적으로 등록되었습니다.',
               'success'
            ).then((result) => {
               location.href="/mypage";
            })
          }
        })
	} , error: function( e) {
		console.log("[ERROR] : ", e);
	    }
    })
});

