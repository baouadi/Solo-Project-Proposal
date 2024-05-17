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
            <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab"></div>
            <div class="tab-pane fade" id="pills-order" role="tabpanel" aria-labelledby="pills-order-tab"></div>
            <div class="tab-pane fade" id="pills-account" role="tabpanel" aria-labelledby="pills-account-tab"></div>
            <div class="tab-pane fade" id="pills-logout" role="tabpanel" aria-labelledby="pills-logout-tab"></div>
        </div>
        <ul class="nav nav-pills mb-3 justify-content-end" id="pills-tab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="/home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="/order" role="tab" aria-controls="pills-order" aria-selected="false">Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="/account" role="tab" aria-controls="pills-account" aria-selected="false">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="/logout" role="tab" aria-controls="pills-logout" aria-selected="false">LOG OUT</a>
            </li>
        </ul>
    </div>
<div class="quick">
<h3>Quick Options</h3></div>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Start Your Order</h5>
						<p class="card-text">Explore our diverse menu and customize
							your pizza to perfection. From classic favorites to bold new
							flavors, there's something for everyone at Pizza Pete's.</p>
						<a href="\order" class="btn btn-primary">New Order</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">You don't want to think!</h5>
						<p class="card-text">Never miss out on your go-to pizza again.
							With just a few clicks, easily reorder your favorite pizza for a
							hassle-free dining experience.</p>
						<a href="/reorder" class="btn btn-primary">Re-Order My Fav</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Special treatment</h5>
						<p class="card-text">Ready for a culinary adventure? Let Pizza
							Pete's surprise you with a unique and delightful pizza creation.
							Discover new flavors and indulge in the unexpected at every bite.</p>
						<a href="/reorder" class="btn btn-primary">SURPRISE ME</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>