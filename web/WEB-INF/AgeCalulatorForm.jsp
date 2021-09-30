<%-- 
    Document   : AgeCalulatorForm
    Created on : 30-Sep-2021, 12:05:26 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="POST" action="Age">
            <label>Enter your age:</label>
            <input type="text" name="ageinput" value="${age_input}">
            <br>
            <input type="submit" value="Age next birthday">
        </form>
        
        <!-- 3 Separate results can be shown based on the results of the boolean passed from the testing in the servlet-->
        <c:if test="${nullEntry}">
            <p>You must enter your current age.</p>
        </c:if>
                
        <c:if test="${nonNumeric}">
            <p>You must enter a number.</p>
        </c:if>
            
        <c:if test="${allGood}">
            <p>Your age next birthday will be ${newAge}</p>
        </c:if>

        <a href="http://localhost:8084/Lab3Calculators1.1/Arithmetic">Arithmetic Calculator</a>
    </body>
</html>
