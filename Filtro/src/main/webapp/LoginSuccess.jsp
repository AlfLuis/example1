<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Login Success</title>
</head>
<body>
	<%
		String user = (String) session.getAttribute("usuario");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("usuario"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>
	<h3>
		Hola
		<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>
	<br> User=<%=user%>
	<br>
	<a href="CheckoutPage.jsp">Checkout Page</a>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
	<form id="formKill" onsubmit="return false;">
		<input type="submit" value="Kill Session" id="kill">
	</form>
</body>
<script type="text/javascript">
	$('#kill').click(function() {
		$.ajax({
			url : "KillSessionServlet",
			type : "post",
			success : function(result, status, jqXHR) {
			$(location).attr('href', 'index.html');
			},
			error : function(data, errorThrown) {
				alert("Error...");
			}
		});
	});
</script>
</html>