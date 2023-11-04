<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../common/navigation.jspf" %>
<div class="container">
    <h1>Welcome to todo app.</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Complete by</th>
            <th>is done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.completedBy}</td>
                <td>${todo.done}</td>
                <td>
                    <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>
                </td>
                <td>
                    <a href="update-todo?id=${todo.id}" class="btn btn-primary">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="../common/footer.jspf" %>
</body>
</html>