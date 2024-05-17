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
            <div class="tab-pane fade show active" id="pills-order" role="tabpanel" aria-labelledby="pills-order-tab"></div>
            <div class="tab-pane fade" id="pills-account" role="tabpanel" aria-labelledby="pills-account-tab"></div>
            <div class="tab-pane fade" id="pills-logout" role="tabpanel" aria-labelledby="pills-logout-tab"></div>
        </div>
        <ul class="nav nav-pills mb-3 justify-content-end" id="pills-tab" role="tablist">
            <li class="nav-item">
                <a class="nav-link " id="pills-home-tab" data-toggle="pill" href="/home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" id="pills-profile-tab" data-toggle="pill" href="/order" role="tab" aria-controls="pills-order" aria-selected="false">Order (0)</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="/account" role="tab" aria-controls="pills-account" aria-selected="false">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="/logout" role="tab" aria-controls="pills-logout" aria-selected="false">LOG OUT</a>
            </li>
        </ul>
    </div>
	<div class="container text-center">
		<form:form action="/order" modelAttribute="newPizza" class="form"
			method="post">
			 <input type="hidden" name="pizzaOrderId" value="${pizzaOrder.id}">

			<div class="form-group">
				<label for="method">Method:</label> <select class="form-control"
					id="method" name="method">
					<option value="CarryOut">Carry Out</option>
					<option value="EatHere">Eat Here</option>
				</select>
			</div>


			<div class="form-group row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="size">Size:</label> <select class="form-control"
							id="size" name="size">
							<option value="Large">Large</option>
							<option value="Medium">Medium</option>
							<option value="Small">Small</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="crust">Crust:</label> <select class="form-control"
							id="crust" name="crust">
							<option value="Thin Crust">Thin Crust</option>
							<option value="Thick Crust">Thick Crust</option>
						</select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="quantity">Quantity:</label> <select
							class="form-control" id="quantity" name="quantity">
							<c:forEach var="i" begin="1" end="10" step="1">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>


			<div class="form-group">
				<label>Toppings:</label><br>
				<div class="row">
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="pepperoni"
								name="pepperoni" value="1"> <label
								class="form-check-label" for="pepperoni"><div
									class="square"></div> Pepperoni</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="mushrooms"
								name="mushrooms" value="1"> <label
								class="form-check-label" for="mushrooms"><div
									class="square"></div> Mushrooms</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="onions"
								name="onions" value="1"> <label class="form-check-label"
								for="onions"><div class="square"></div> Onions</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="peppers"
								name="peppers" value="1"> <label
								class="form-check-label" for="peppers"><div
									class="square"></div> Peppers</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="sausage"
								name="sausage" value="1"> <label
								class="form-check-label" for="sausage"><div
									class="square"></div> Sausage</label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="checkbox" id="olives"
								name="olives" value="1"> <label class="form-check-label"
								for="olives"><div class="square"></div> Olives</label>
						</div>
					</div>
				</div>
			</div>


			<button type="submit" class="btn btn-primary">Add to Order</button>
		</form:form>
	</div>

</body>
</html>