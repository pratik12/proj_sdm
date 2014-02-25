<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<h1>Login</h1>
         <FORM METHOD=POST ACTION="SaveName.jsp">
User Name<INPUT TYPE=TEXT NAME=uname SIZE=20><BR>
Password<INPUT TYPE=TEXT NAME=password SIZE=20><BR>

<P><INPUT TYPE=SUBMIT>
</FORM>
        
<%@ include file="footer.jsp" %>