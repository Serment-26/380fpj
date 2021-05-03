
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>food list</h1>
        <c:if test="${fn:length(entries) == 0}">
        <p>There is no food yet.</p>
        </c:if>
        <c:if test="${fn:length(entries) > 0}">
            <ul>
        <c:forEach var="entry" items="${entries}">
            <li><a href="<c:url value="/item/?id=${entry.itemid}"/>">${entry.itemname}</a></li>
        </c:forEach>
            </ul>>
      </c:if>
    </body>
</html>
