<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>
<!-- Reference our Style Sheet -->
<link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM -Customer Relationship Manager</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
			
			<!-- Put the new button : Add customer -->
			
			<input type="button" value="Add customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
			<!-- Add out HTML table here -->

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- Loop over and print our customer details -->
				<c:forEach var="tempCustomer" items="${customerlist}">
					<!-- Construct an update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id }" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						
						<td>
							<!-- Display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							 onClick="if(!(confirm('Are you sure you want to delete the Customer?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>

</body>
</html>