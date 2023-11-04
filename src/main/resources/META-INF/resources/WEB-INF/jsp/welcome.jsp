<head>
    <title>Welcome Page!!</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h2>Welcome to our site ${name}:</h2>
    <div>
        <h3>Manage your <a href="list-todos">todo list</a></h3>
    </div>
</div>
<%@ include file="common/footer.jspf" %>
</body>
