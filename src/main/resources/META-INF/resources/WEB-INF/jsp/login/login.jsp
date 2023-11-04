<html>
<head>
    <title>Login Page!!</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <style>
        .welcome-page {
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="welcome-page"><h2>Welcome to the login page:</h2>
</div>
<pre style="color: orangered">${errorMessage}</pre>
<div class="container">
    <form method="post">
        <label>Username:
            <input type="text" name="name">
        </label>
        <label>
            Password:
            <input type="password" name="password">
        </label>
        <input type="submit">
    </form>
</div>
<script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.7.1/jquery.js"></script>
</body>
</html>