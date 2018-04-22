<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File AWS</title>
</head>
<body>
	<form action="uploadFile" method="post" enctype="multipart/form-data">
		<h3>Upload File to AWS</h3>
		<br /> <input type="file" name="file"> <br /><br />
		<button type="submit">Up</button>
		<br />
		<p>
			Open here: <a href="${linkFileUpSuccess}">${linkFileUpSuccess}</a>
		</p>
	</form>

</body>
</html>