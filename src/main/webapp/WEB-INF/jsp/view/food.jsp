
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food detail</title>
    </head>
    <body>
        <h1>${Items.itemname}</h1>
        <c:if  test="${Items.photo!=null}">
        </c:if>
        Name:${Items.itemname}<p>
        Price:${Items.price}<p>
        available:${Items.selling}<p>
    </body>
</html>
