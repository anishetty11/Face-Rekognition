<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>match</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<% File file=new File("/home/gulshir/Desktop/face_matched.txt");
	BufferedReader bf=new BufferedReader(new FileReader(file));
	String st=bf.readLine();
	out.println("<b>Name:</b> "+bf.readLine()+"\n");
	out.println("<br><b>Phone:</b> "+bf.readLine()+"\n");
	out.println("<br><b>Email:</b> "+bf.readLine()+"\n");
	out.println("<br><b>Disease:</b> "+bf.readLine()+"\n");
	out.println("<br><b>Details:</b> "+bf.readLine()+"\n");
	while(((st=bf.readLine())!=null))
	{
		out.println(st);	
	}
	
	bf.close();
%>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>