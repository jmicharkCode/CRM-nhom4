<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.javabackend.java16.crmapp.utils.UrlConst" %>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.HOME %>" />">Home</a></li>
	                        <li class="breadcrumb-item"><a href="#">User</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            User Dashboard
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">User Dashboard</h1>
	            </div>
	            <div class="ml-auto">
	                <a href="<c:url value="http://localhost:8080/java16-crm-nhom-4/user-add" />" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">add</i>
	    				Add New User
	    			</a>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- End Breadcrumb -->
	
	<!-- START BODY -->
	<div class="container">
		<div class="card card-form">
            <table class="table mb-0 thead-border-top-0">
                <thead>
                    <tr>
                        <th>ID</th>
						<th>Name</th>
	                     <th>Email</th>
	                     <th>Address</th>
	                     <th>Phone</th>
	                     
                    </tr>
                </thead>
                <tbody class="list" id="staff02">
                 	<c:choose> 
                 		<c:when test="${users == null}">
                 			<tr class="row">
                 				<td class="col-12 text-center">There is no data.</td>
                 			</tr>
                 		</c:when>
                 		<c:otherwise>
                 			<c:forEach var="user" items="${users}"  >
	                 			<tr>
		                           <td>
		                               ${user.id}
		                           </td>
		                           <td>${user.fullname }</td>
		                           <td>${user.email }</td>
		                           <td>${user.address }</td>
		                           <td>${user.phone }</td>
		                           <td>
		                           	<form
									action='<c:url value="<%=UrlConst.USER_UPDATE%>"></c:url>'
									method="get">
									<input type="hidden" name="id" value="${user.id}"></input>
									<button type="submit"  class="text-muted"><i class="material-icons">edit</i></button>
						 </form>
									</td>
									<td>
		                           	<form
									action='<c:url value="<%=UrlConst.USER_DELETE%>"></c:url>'
									method="get">
									<input type="hidden" name="id" value="${user.id}"></input>
									<button type="submit" class="text-muted"><i class="material-icons">delete</i></button>
								</form>
		                           	
		                           </td>
	                    		</tr>
                 			</c:forEach>
                 		</c:otherwise>
                 	</c:choose>
               	</tbody>
            </table>
		</div>
	</div>
	<!-- END BODY -->
</body>
