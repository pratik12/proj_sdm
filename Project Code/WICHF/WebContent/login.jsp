<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>

<html>
<head>
<title>Login</title>
</head>
<body>

<br><center><h3>Login</h3></center>
<FORM>
<TABLE align="center" >
  <TR>
    <TD>User Name</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="username" SIZE="20">
    </TD>
  </TR>
  <TR>
    <TD>Password</TD>
    <TD><INPUT TYPE="TEXT" NAME="password" SIZE="20"></TD>
  </TR>
  <tr>
  <td>
  <INPUT TYPE="SUBMIT" VALUE="Submit" NAME="B1">
  </td>
  </tr>
</TABLE>

</FORM>
</body>
</html>

        
<%@ include file="footer.jsp" %>