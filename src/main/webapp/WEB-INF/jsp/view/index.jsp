
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>food list</h1>
        <c:forEach var="entry" items="${entries}">
            <a href="<c:url value="/item/?id=${entry.itemid}"/>">${entry.itemname}</a>
        </c:forEach>
    </body>
</html>
