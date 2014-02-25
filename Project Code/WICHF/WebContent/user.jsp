<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<!-- 	 <s:form action="user"> -->
<!-- 	   <s:textfield name="userId" label="User Id"/> -->
<!-- 	   <s:textfield name="password" label="Password"/> -->
<!--    		<s:submit/> -->
   		
   		 <form action="user">
     	      <input type="text" name="userId" value="User Id"/>
		      <input type="password" name="password" value="Password"/>
		      <input type="submit" value="Say Hello"/>
		   </form>
   		
   		<hr/>
<!--      </s:form> -->
<%@ include file="footer.jsp" %>