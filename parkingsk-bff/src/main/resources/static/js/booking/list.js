$(".btn.btn-primary").click(function(e) {
	var data = {}
	//data["name"] = $("#lot_name").val();
	//data["name"] = "SK";
	
	//alert(longi);
	
	
	if(lati == "" ){
		alert("목적지를 선택해주세요.")
	}
	
	data["lati"] = lati;
	data["longi"] = longi;
				
    $.ajax({
	type: "POST",
	contentType: "application/json",
	url: "/closeparkinglot" ,
	data : JSON.stringify(data) ,
	dataType: 'json' ,
	success: function (data) {
		console.log("SUCCESS",data);
		console.log(data);
		var innerHtml = '';
		
		for(i in data) {
			innerHtml += '<div class="col-xl-4 col-md-6 mb-4">' + 
                        '<div class="card border-left-info shadow h-80 py-3" style="cursor:pointer">' +
                            '<div class="card-body">' +
                                '<div class="row no-gutters align-items-center">' +
                                    '<div class="col mr-2" onClick="parking_onClick(\''+ data[i].id + '\', \'' + data[i].name +'\', \'' + data[i].capacity +'\', \'' +data[i].openTime +'\', \'' + data[i].endTime +'\', \'' + data[i].address + '\');">' +
                                        '<div class="text-xs font-weight-bold text-info text-uppercase mb-1">'+data[i].companyName+' '+ data[i].area +'</div>' +
                                        '<div class="row no-gutters align-items-center">' +
                                            '<div class="col-auto">' +
                                                '<div class="h6 mb-0 mr-3 font-weight-bold text-gray-800">'+data[i].name+'</div>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>'  +
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

function parking_onClick(id, name, capacity, openTime, endTime, address){	

	document.getElementById("parkingLotId").value = id;
	document.getElementById("parkingLotName").value = name;
	document.getElementById("address").value = address;
	document.getElementById("capacity").value = capacity;
	document.getElementById("openTime").value = openTime;
	document.getElementById("endTime").value = endTime;
	
	
}