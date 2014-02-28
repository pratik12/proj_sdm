<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Doctor</title>
</head>
<body>
	<h1> Add Doctor</h1>
	<s:actionerror/>
	
	<s:form action="add" method="post">
	    <s:textfield name="contact.firstName" label="Firstname"/>
	    <s:textfield name="contact.lastName" label="Lastname"/>
	    <s:textfield name="contact.emailId" label="Email"/>
	    <s:textfield name="contact.cellNo" label="Cell No."/>
	    <s:textfield name="contact.website" label="Homepage"/>
	    <s:textfield name="contact.birthDate" label="Birthdate"/>
	    <s:submit value="Add Contact" align="center"/>
	</s:form>
		
</body>
</html>