<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No match</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h1 align="center">No match found</h1>
	<form action="UploadServlet">
			<table align="center" border="2" width="40%" cellpadding="2">
				<tbody>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Phone no.:</td>
						<td><input type="text" name="phone" /></td>
					</tr>

					<tr>
						<td>Email Id:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Disease:</td>
						<td><input type="text" name="disease" /></td>
					</tr>
					<tr>
						<td>Details:</td>
						<td><input type="text" name="details" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Upload" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
	</form>
	

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>