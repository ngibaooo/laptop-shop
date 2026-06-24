<!-- Tag thư viện JSTL - Có thể tìm hiểu sau. Project này chỉ sử dụng JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Tạo form với JSTL -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
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
            <div class="col-md-6 col-12"></div>
                <h2>Delete user ${id}</h2>
                <hr>
                <div class="alert alert-danger" role="alert">
                    Are you sure to delete user id ${id}?
                </div>
                <form:form method="post" action="/admin/user/delete" modelAttribute="currentUser">
                    <div class="mb-3" style="display: none"> //ẩn đi cột id không cho người dùng thấy. Dev có thể f12 để thấy
                        <label class="form-label">Id</label>
                        <form:input type="text" class="form-control" path="id"/>
                    </div>
                    <button class="btn btn-danger">Confirm</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>