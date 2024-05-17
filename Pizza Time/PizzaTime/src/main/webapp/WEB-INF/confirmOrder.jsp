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
			<div class="tab-pane fade " id="pills-home" role="tabpanel"
				aria-labelledby="pills-home-tab"></div>
			<div class="tab-pane fade show active" id="pills-order"
				role="tabpanel" aria-labelledby="pills-order-tab"></div>
			<div class="tab-pane fade" id="pills-account" role="tabpanel"
				aria-labelledby="pills-account-tab"></div>
			<div class="tab-pane fade" id="pills-logout" role="tabpanel"
				aria-labelledby="pills-logout-tab"></div>
		</div>
		<ul class="nav nav-pills mb-3 justify-content-end" id="pills-tab"
			role="tablist">
			<li class="nav-item"><a class="nav-link" id="pills-home-tab"
				data-toggle="pill" href="/home" role="tab"
				aria-controls="pills-home" aria-selected="true">Home</a></li>
			<li class="nav-item"><a class="nav-link active"
				id="pills-profile-tab" data-toggle="pill" href="/order" role="tab"
				aria-controls="pills-order" aria-selected="false">Order (1)</a></li>
			<li class="nav-item"><a class="nav-link" id="pills-contact-tab"
				data-toggle="pill" href="/account" role="tab"
				aria-controls="pills-account" aria-selected="false">Account</a></li>
			<li class="nav-item"><a class="nav-link" id="pills-contact-tab"
				data-toggle="pill" href="/logout" role="tab"
				aria-controls="pills-logout" aria-selected="false">LOG OUT</a></li>
		</ul>
	</div>
	<div class="container mt-5">

		<div class="container mt-5">
			<h2>Your Order</h2>
			<div class="card">
				<div class="card-body">
					<p>
						<strong>Method:</strong> <span th:text="${pizza.method}">${pizza.method}</span>
					</p>
					<p>
						<strong>Qty:</strong> <span th:text="${pizzaOrder.quantity}">${pizzaOrder.quantity}</span>
					</p>
					<p>
						<strong>Price:</strong> <span th:text="${pizzaOrder.price}">${pizzaOrder.price}</span>
					</p>
					<p>
						<strong>Crust:</strong> <span th:text="${pizza.crust}">${pizza.crust}</span>
					</p>
					<p>
						<strong>Toppings:</strong>
						<c:if test="${pizza.pepperoni}">Pepperoni - </c:if>
						<c:if test="${pizza.mushrooms}">Mushrooms - </c:if>
						<c:if test="${pizza.onions}">Onions - </c:if>
						<c:if test="${pizza.peppers}">Peppers - </c:if>
						<c:if test="${pizza.sausage}">Sausage - </c:if>
						<c:if test="${pizza.olives}">Olives - </c:if>						
					</p>
				</div>
			</div>
			<form action="/confirmOrder" method="post">
				<button type="submit" class="btn btn-danger mt-3" value="startOver" name="submit">Start
					Over</button>
			</form>

			<form action="/confirmOrder" method="post">
				<button type="submit" value="purchase" class="btn btn-success mt-3" name="submit">Purchase</button>
			</form>
		</div>
</body>
</html>