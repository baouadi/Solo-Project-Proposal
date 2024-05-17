<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pizza Time</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<header>
		<h1>Pizza Pete's</h1>
		<a href="/">Don't have an account? Register</a>
	</header>
	<div class="container">
    <div class="form-group">
        <h2 class="text-center">Welcome Back!</h2>
        <form:form action="/login" modelAttribute="newLogin" class="form">
            <div class="form-row">
                <form:errors path="email" cssClass="error-message" />
                <form:label for="email" path="email">Email:</form:label><span>
                <form:input type="text" path="email" class="form-control" /></span>
                
            </div>

            <div class="form-row">
                <form:errors path="password" cssClass="error-message" />
                <form:label for="password" path="password">Password:</form:label>
                <form:input type="password" path="password" class="form-control" />
            </div>

          <div class="text-center">
                        <button type="submit" class="btn btn-primary btn-lg btn-block">Log In</button>
                    </div>
        </form:form>
    </div>
    </div>
</body>

</html>