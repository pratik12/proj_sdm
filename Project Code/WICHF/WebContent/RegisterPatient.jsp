<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Registration Form</title>
<SCRIPT LANGUAGE=javascript>

	

	function validateForm(formObj) {
		//TO DO Add Java Script Validation Code Here

		if (formObj.userid.value.length == 0) {
			alert("Please enter User Id!");
			formObj.userid.focus();
			return false;
		}

		if (formObj.password.value.length == 0) {
			alert("Please enter Password!");
			formObj.password.focus();
			return false;
		}
		
		if (formObj.password.value == formObj.Spassword.value) {
			alert("Password do not match!");
			formObj.password.focus();
			return false;
		}

		if (formObj.birthDate.value.length == 0) {
			alert("Please select valid Birth Date");
			formObj.birthDate.focus();
			return false;
		}
		if (formObj.name.value.length == 0) {
			alert("Please enter First Name!");
			formObj.name.focus();
			return false;
		}

	

		if (formObj.phone.value.length == 0) {
			alert("Please enter Phone!");
			formObj.phone.focus();
			return false;
		}

		if (!formObj.phone.value.match(/^\d+$/)) {
			alert("Please enter correct Phone No.!");
			formObj.phone.focus();
			return false;
		}

		if (formObj.healthCardNumber.value.length == 0) {
			alert("Please select valid Health Card Number");
			formObj.healthCardNumber.focus();
			return false;
		}
		
		if (formObj.birthDate.value.length == 0) {
			alert("Please select valid Birth Date");
			formObj.birthDate.focus();
			return false;
		}
		

		alert("Hello");
		return true;
	}

</SCRIPT>
</head>
<body>
	
	<table width="100%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="">
		<tr bgcolor="">
			<td align="center"><form action="registerPatient"
					method="post" onsubmit="return validateForm(this);">

					<!--  <font color="red"> <html:errors /></font>-->

					<table border="0" bgcolor="#6699CC" cellpadding="0" cellspacing="1">

						<tr bgcolor="#6699CC">
							<td align="center" colspan="2"><font style="color: white"
								size="4">Account Registration</font></td>
						</tr>

						<tr>
							<td align="center" colspan="2"><font style="color: white"
								size="2">Fields marked with * are mandate Fields</font></td>
						</tr>
						
						<tr bgcolor="#FFFFFF">
							<td align="right" width="200"><font size="3" face="Monotype Corsiva" style="color: #6699CC">Health Card Number:</font></td>
							<td align="left"><input type="text" name="healthCardNumber" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">Birth Date(dd-mm-yyyy):</font></td>
							<td align="left"><input type="text" name="birthDate" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">Gender(M/F):</font></td>
							<td align="left" colspan="2"><input type="text" name="gender" value="" /></td>
							
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">Name: </font></td>
							<td align="left"><input type="text" name="name" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">Annual CheckUp Done(Y/N): </font></td>
							<td align="left"><input type="text" name="isAnnualCheckUpDone" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">UserId: </font></td>
							<td align="left"><input type="text" name="userId" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC">Password: </font></td>
							<td align="left"><input type="text" name="password" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>
						
						<tr bgcolor="#FFFFFF">
							<td align="right"> <font size="3" face="Monotype Corsiva" style="color: #6699CC"> Re Enter Password: </font></td>
							<td align="left"><input type="text" name="Spassword" value="" /></td>
							<td><font style="color: red">*</font></td>
						</tr>

						
						<tr bgcolor="#FFFFFF">
							<td align="center" colspan="3"><input type="submit" value="Save">

							</td>
						</tr>
					</table>

				</form></td>
		</tr>
	</table>
	
</body>
</html>