<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>

</head>
<body>
<form id="idUploadLogoForm" enctype="multipart/form-data">
 
    <div>
 <label>Logo:</label>                
 <div id="idImagePlaceHolder"></div>
    </div>
 
    <div>
 <label for="idLogoFile">Choose your logo:</label>
 <input id="idLogoFile" type="file" name="logo"/>
    </div>   

</form>

<button id="idUploadLogoButton">Upload Logo</button>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	$('#idUploadLogoButton').on('click', function () {
		 var form = new FormData(document.getElementById('idUploadLogoForm'));
		 $.ajax({
		  url: "user/upload-logo",
		  data: form,
		  dataType: 'text',
		  processData: false,
		  contentType: false,
		  type: 'POST',
		  success: function (response) {
		      var data = jQuery.parseJSON(response);   
		      $('#idImagePlaceHolder').html('<img src="data:image/png;base64,' + data.JsonLogo.image + '"/>');   
		  },
		  error: function (jqXHR) {
		   //Error handling
		  }
		 });
		});
});
</script>
</body>
</html>