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
		<a href="/login">Already have an account? Login</a>
	</header>
 <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <form:form action="/" method="post" modelAttribute="newUser">
                <div class="form-group row">
                    <div class="col-md-6">
                        <form:errors path="firstName" cssClass="error-message" />
                        <label for="firstName">First Name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName">
                    </div>
                    <div class="col-md-6">
                        <form:errors path="lastName" cssClass="error-message" />
                        <label for="lastName">Last Name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <form:errors path="email" cssClass="error-message" />
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <form:errors path="address" cssClass="error-message" />
                    <label for="address">Address</label>
                    <input type="text" name="address" class="form-control" id="address">
                </div>
                <div class="form-group row">
                    <div class="col-md-6">
                        <form:errors path="city" cssClass="error-message" />
                        <label for="city">City</label>
                        <input type="text" name="city" class="form-control" id="city">
                    </div>
                    <div class="col-md-6">
                        <form:errors path="state" cssClass="error-message" />
                        <label for="state">State</label>
                        <select name="state" id="state" class="form-control">
                            <option value="tunis">Tunis</option>
                            <option value="nabeul">Nabeul</option>
                            <option value="benArous">Ben Arous</option>
                            <option value="ariana">Ariana</option>
                            <option value="zaghouane">Zaghouane</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <form:errors path="password" cssClass="error-message" />
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                <div class="form-group">
                    <form:errors path="confirm" cssClass="error-message" />
                    <label for="confirm">Confirm</label>
                    <input type="password" name="confirm" class="form-control" id="confirm">
                </div>
                <div class="text-center">
                        <button type="submit" class="btn btn-primary btn-lg btn-block">Sign up</button>
                    </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>




