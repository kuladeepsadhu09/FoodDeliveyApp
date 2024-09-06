<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    HttpSession session2 = request.getSession(false);
    if (session2 != null) {
        session.invalidate();
    }
    response.sendRedirect("index.jsp");
%>

</body>
</html>