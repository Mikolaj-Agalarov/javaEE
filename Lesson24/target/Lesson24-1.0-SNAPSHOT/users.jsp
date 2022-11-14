<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <div class="row">
        <div >
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto" style="margin: 25px 0px">
                    <div class="form-group">
                        <div class="card rounded shadow shadow-sm">
                            <div class="card-header">
                                <h3 class="mb-0">Register new user</h3>
                            </div>
                            <div class="card-body">
                                <form action="registration" method="post">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input name="username" class="form-control form-control-lg rounded-0">
                                        <small class="form-text text-muted">Username will be visible to other people </small>
                                    </div>
                                        <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input type="password" name="password" class="form-control form-control-lg rounded-0" id="exampleInputPassword1">
                                    </div>
                                    <button type="submit" class="btn btn-success btn-lg float-right" style="margin-top: 15px">Register</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="card">
            <div class="card-body">
                <div class="card-title">
                    <h3>All registered users</h3>
                </div>
                <div class="card-text">
                    <table class="table table-bordered table-striped mx-auto">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Name</th>
                            <th scope="col">Password</th>
                            <th scope="col">Created at</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.name}" />
                            </td>
                            <td>
                                <c:out value="${user.password}" />
                            </td>
                            <td>
                                <f:formatDate value="${user.createdAt}" pattern="YYYY-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
    </div>
</div>
</body>
</html>
