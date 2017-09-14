<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/13/2017
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${resources}" var="res">
    <br>
    <c:if test="${res.resourceType=='DocumentResource'}">
        <a href='/download?fileName="+${res.resourcePath}+"' download >${res.resourcePath}</a>
    </c:if>
    <c:if test="${!condition}">
        <a href="${res.resourcePath}" target="_blank">${res.resourcePath}</a>
    </c:if>

</c:forEach>
</body>
</html>
