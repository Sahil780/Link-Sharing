<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="dynamicDiv" style="margin-bottom:15px;">
    <% //while (blogIterator.hasNext()){ Blog userblog = blogIterator.next();%>
    <div style="margin-top:10px;margin-left:10px;margin-right:10px;margin-bottom:2px;">
        <div class="media">
            <div class="media-left">
                <img class="media-object" src="/UserProfilePic?uname=${uname}" style="background-size: 100% 100%;  width:90px; height: 90px">
            </div>
            <div class="media-body" >
                <h4 class="media-heading" id="fullNameOfUser" style="margin-right: 5px;margin-bottom: 0px">${uname}</h4>
                <small id="timeStampOfBlog" style="margin-top:0px ">@${firstname}</small>
                <p id="userblogData" style="font-size: 15px"><%//=userblog.getBlogdata()%></p>
                <div id="profileDivision">
                    <div id="subprofileDivision1" class="col-md-6 col-sm-10" style="float: left;margin-bottom: 0px;margin-left: 0">
                        <a href="#" style="margin-bottom: 0">Subscriptions</a>
                        <p>${userinfo[1]}</p>
                    </div>
                    <div id="subprofileDivision2" class="col-md-6 col-sm-10" style="float: left;margin-bottom: 0px;margin-left: 0">
                        <a href="#" style="margin-bottom: 0">Topics</a>
                        <p>${userinfo[0]}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>