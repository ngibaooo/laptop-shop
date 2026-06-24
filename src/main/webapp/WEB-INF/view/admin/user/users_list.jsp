<!-- Tag thư viện JSTL - Có thể tìm hiểu sau. Project này chỉ sử dụng JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Tạo form với JSTL -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="/css/test.css"> -->

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12 mx-auto">
                <div class="d-flex justify-content-between">
                    <h2>Table Users</h2>
                    <a href="/admin/user/create" class="btn btn-primary">Create new user</a>
                </div>
                <div><hr></div>
                <div>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                            <th >ID</th>
                            <th >Email</th>
                            <th >Full Name</th>
                            <th >Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Biến items users_list này được truyền từ controller sang. Có các dữ liệu của các users đã truy vấn ra  -->
                            <!-- Biến var user là biến duyệt từng element trong vòng lặp for each -->
                            <c:forEach var="user" items="${users_list}">
                                <tr>
                                    <th>${user.id}</th>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>
                                        <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                                        <a href="/admin/user/update/${user.id}" class="btn btn-warning">Update</a>
                                        <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                                        <!-- <button class="btn btn-success">View</button> -->
                                        <!-- <button class="btn btn-warning mx-2">Update</button>
                                        <button class="btn btn-danger">Delete</button> -->
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