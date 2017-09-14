<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/13/2017
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<div id="data">
<c:forEach items="${resources}" var="res">
<br>
    <c:if test="${res.resourceType=='DocumentResource'}">
         <a href='/download?fileName="+${res.resourcePath}+"' download >${res.resourcePath}</a>

    </c:if>
    <c:if test="${!condition}">
        <a href="${res.resourcePath}" target="_blank">${res.resourcePath}</a>
    </c:if>
</c:forEach>
<hr>


</div>
<button id="forward">more-topics</button>
<script>
    var i=0;
    $(document).ready( function() {
        $("#forward").click(function () {
        i++;
            $("#data").html('');
            $.ajax({
                url: 'paginateddata?topicname=${topicname}"&index='+i,
                method: "GET",
                accept:"application/json",
                success: function (response) {
   console.log(response);
                    $.each(response,function (i,v) {
                        $("#data").append("topic name "+v.topic.name);
                        if(v.resourceType=="DocumentResource") {
                            $("#data").append(" <a href='/download?fileName="+v.resourcePath+"' download >"+v.resourcePath+"</a>");
                        }
                    })

                }
            });
//            if ($('#dlist option').filter(function () {
//                    return this.value === val;
//                }).length) {
//                //send ajax request
//                alert(this.value);
//            }
        });

    });
</script>
</body>
</html>
