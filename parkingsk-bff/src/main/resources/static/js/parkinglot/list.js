  $(".btn.btn-primary").click(function(e) {
	var data = {}
	data["name"] = $("#lot_name").val();
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/parkinglot" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
		console.log("SUCCESS",data);
		console.log(data);
		var innerHtml = '';
		
		for(i in data) {
			innerHtml += '<div class="col-xl-3 col-md-6 mb-4">' + 
                        '<div class="card border-left-info shadow h-100 py-2">' +
                            '<div class="card-body">' +
                                '<div class="row no-gutters align-items-center">' +
                                    '<div class="col mr-2">' +
                                        '<div class="text-xs font-weight-bold text-info text-uppercase mb-1">'+data[i].companyName+' '+ data[i].area +'</div>' +
                                        '<div class="row no-gutters align-items-center">' +
                                            '<div class="col-auto">' +
                                                '<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">'+data[i].name+'</div>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                    '<div class="col-auto">' +
                                    '<a href="/detailParkingLot/'+data[i].id+'">' +
                                        '<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>' +
                                    '</a>' +
                                    '</div>' +
                               '</div>' +
                            '</div>' +
                        '</div>' +
                    '</div>';
		}
		
        $("#testkey").html(innerHtml);
        console.log("#testkey");
	} , error: function( e) {
		console.log("error");
		console.log(e);
	}
})
});
