/**
 * 
 */
$( document ).ready(function() {
       

	
	$("#subscribeButton").click(function() {
		  console.log("Button CLick!");
		  $("#paymentForm").show();
		  $("#subscribeButton").hide();
	});
	
	$("#subscribeToEvent").on('click', function(){
		var a = $("#eventID").text();
		var b =  $("#paymentTrue").val();
		formData = {eventId:a, ifPaid:b };
		$.ajax({
		    url : "/EventZone/main/event/subscribe/",
		    type: "POST",
		    data : formData,
		    success: function(data, textStatus, jqXHR)
		    {
		        console.log(data);
		        $("#sucDiv").show();
		        $("#paymentForm").hide();
				$("#subscribeButton").hide();
				
		    },
		    error: function (jqXHR, textStatus, errorThrown)
		    {
		    	$("#errorMSG").show();
		    	console.log(jqXHR, textStatus, errorThrown);
		    }
		});
});
	
	
 });

	