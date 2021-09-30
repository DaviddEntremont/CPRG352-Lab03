<%-- 
    Document   : ArithmeticCalculatorForm
    Created on : 30-Sep-2021, 12:07:52 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="Arithmetic">
            <form method="POST" action="CalculateAge">
            <label>First:</label>
            <input type="text" name="firstNumber" value="${first_number}">
            <br>
            <label>Second:</label>
            <input type="text" name="secondNumber" value="${second_number}">
            <br>
            <input type="submit" value="+" name="equation">
            <input type="submit" value="-" name="equation">
            <input type="submit" value="*" name="equation">
            <input type="submit" value="%" name="equation">
        </form>
            
        <br>
        <!-- Only one variable space that changes based on what's passed from the ifs in the servlet -->    
        Result: ${result}
        
        <br>
                    
        <a href="http://localhost:8084/Lab3Calculators1.1/Age">Age Calculator</a>
        
    </body>
</html>
