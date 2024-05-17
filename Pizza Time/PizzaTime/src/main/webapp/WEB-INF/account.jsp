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
<div class="cnt">
        <h1>PIZZA PETE'S</h1>
        <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade " id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab"></div>
            <div class="tab-pane fade" id="pills-order" role="tabpanel" aria-labelledby="pills-order-tab"></div>
            <div class="tab-pane fade show active" id="pills-account" role="tabpanel" aria-labelledby="pills-account-tab"></div>
            <div class="tab-pane fade" id="pills-logout" role="tabpanel" aria-labelledby="pills-logout-tab"></div>
        </div>
        <ul class="nav nav-pills mb-3 justify-content-end" id="pills-tab" role="tablist">
            <li class="nav-item">
                <a class="nav-link" id="pills-home-tab" data-toggle="pill" href="/home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="/order" role="tab" aria-controls="pills-order" aria-selected="false">Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" id="pills-contact-tab" data-toggle="pill" href="/account" role="tab" aria-controls="pills-account" aria-selected="false">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="/logout" role="tab" aria-controls="pills-logout" aria-selected="false">LOG OUT</a>
            </li>
        </ul>
    </div>
<body>
<<div class="bigctn">
    <div class="container">
        <h2>Account Info</h2>
        <form:form action="/account" method="post" modelAttribute="userUpdate">
            <input type="hidden" name="id" value="${user.id}">
            <div class="form-group row">
                <div class="col-md-6">
                    <label for="firstName">First Name</label>
                    <form:input path="firstName" class="form-control" id="firstName"/>
                    <form:errors path="firstName" cssClass="error-message"/>
                </div>
                <div class="col-md-6">
                    <label for="lastName">Last Name</label>
                    <form:input path="lastName" class="form-control" id="lastName"/>
                    <form:errors path="lastName" cssClass="error-message"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" class="form-control" id="email"/>
                <form:errors path="email" cssClass="error-message"/>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <form:input path="address" class="form-control" id="address"/>
                <form:errors path="address" cssClass="error-message"/>
            </div>
            <div class="form-group row">
                <div class="col-md-6">
                    <label for="city">City</label>
                    <form:input path="city" class="form-control" id="city"/>
                    <form:errors path="city" cssClass="error-message"/>
                </div>
                <div class="col-md-6">
                    <label for="state">State</label>
                    <form:select path="state" class="form-control" id="state">
                        <form:option value="tunis" label="Tunis"/>
                        <form:option value="nabeul" label="Nabeul"/>
                        <form:option value="benArous" label="Ben Arous"/>
                        <form:option value="ariana" label="Ariana"/>
                        <form:option value="zaghouane" label="Zaghouane"/>
                    </form:select>
                    <form:errors path="state" cssClass="error-message"/>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form:form>
    </div>
    <div class="container">
        <h2>Past Orders</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Size</th>
                    <th>Toppings</th>
                    <th>Price</th>
                    <th>Favorite</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pizzaOrder" items="${pizzaOrders}">
                    <tr>
                        <td><c:out value="${pizzaOrder.pizza.size}"/></td>
                        <td>
                            <c:if test="${pizzaOrder.pizza.pepperoni}">Pepperoni - </c:if>
                            <c:if test="${pizzaOrder.pizza.mushrooms}">Mushrooms - </c:if>
                            <c:if test="${pizzaOrder.pizza.onions}">Onions - </c:if>
                            <c:if test="${pizzaOrder.pizza.peppers}">Peppers - </c:if>
                            <c:if test="${pizzaOrder.pizza.sausage}">Sausage - </c:if>
                            <c:if test="${pizzaOrder.pizza.olives}">Olives - </c:if>
                        </td>
                        <td><c:out value="${pizzaOrder.price}"/></td>
                        <td>
                            <form action="/updateFavorite/${pizzaOrder.id}" method="post">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="checkbox"
                                           name="favorite" value="${pizzaOrder.id}"
                                           ${pizzaOrder.favorite ? 'checked' : ''}
                                           onchange="this.form.submit()">
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>