<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.min.css">
</head>
<body>
<%@ include file="../common/navigation.jspf" %>
<div class="container">
    <h1>Enter the details:</h1>
    <form:form method="post" modelAttribute="todo">
        <br>
        <fieldset class="mb-3">
            <form:label path="description">Description: </form:label>
            <form:input type="text" path="description"
                        required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="completedBy">Completed by: </form:label>
            <form:input type="text" path="completedBy"
                        required="required"/>
            <form:errors path="completedBy" cssClass="text-warning"/>
        </fieldset>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <input class="btn btn-success" type="submit"/>
    </form:form>
    <%@ include file="../common/footer.jspf" %>
    <script type="text/javascript">
        $('#completedBy').datepicker({format: 'yyyy-mm-dd'});
    </script>
</div>
</body>
</html>