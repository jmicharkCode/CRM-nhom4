<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.javabackend.java16.crmapp.utils.UrlConst" %>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<c:url value="http://localhost:8080/java16-crm-nhom-4/home" />">Home</a></li>
	                        <li class="breadcrumb-item"><a href="<c:url value="http://localhost:8080/java16-crm-nhom-4/user" />">User</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                           Edit User
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Edit User</h1>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- End Breadcrumb -->
	<div class="container page__container">
		<div class="card card-form">
            <div class="row no-gutters">
                <div class="col-lg-4 card-body">
                    <p><strong class="headings-color">Rules</strong></p>
                    <p class="text-muted">There is no rule!</p>
                </div>
                <div class="col-lg-8 card-form__body card-body">
                    <form action="<c:url value="http://localhost:8080/java16-crm-nhom-4/user-update" />" method="post">
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" name="email" id="email">
                        </div>
                       
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="text" class="form-control" name="phone" id="phone">
                        </div>
                         <div class="form-group">
                            <label for="address">Address:</label>
                            <textarea type="text" class="form-control" name="address" id="address" aria-label="With textarea"></textarea>
                        </div>
                       
                        <input type="hidden" name="id" value="${id}"></input>
                        <button class="btn btn-primary w-25 justify-content-center" type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
        </div>
     </div>
</body>
