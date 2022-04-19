<%--
  Created by IntelliJ IDEA.
  User: fred
  Date: 2022-04-18
  Time: 6:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customers</title>
<%--    Reference our style sheet--%>

    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

<%--        put new button: Add Customer--%>
    <input type="button" value="Add Customer"
            onclick="window.location.href='showFormForAdd'; return false"
           class="add-button"
    />

<%--        Add our html table here--%>
        <table>

            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

<%--            Loop over and print our customers--%>
            <c:forEach var="tempCustomer" items="${customers}">

<%--                Construct an "update" link with customer id--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

<%--                Construct an "delete" link with customer id--%>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>


                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                    <td>
<%--                        Display the update link--%>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                        onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>
</div>
</body>
</html>
