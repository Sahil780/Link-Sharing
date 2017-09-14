<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String uname=(String)session.getAttribute("uname");
%>

<div class="col-sm-3">
    <!-- user profile pic will be fetch here -->
    <a href="##" style="margin-left: -20px;padding-top: 5px;"><img src="/UserProfilePic?uname=<%=uname%> " width="80px" height="80px;"></a>
</div>
<div class="col-sm-9">
    <!--  user name will fecth here  -->
    <span id="username" style="font-size: 20px;"><b>${uname}</b></span>
    <!-- end of user name -->
    <br>
    <!-- first name of user will fetch here -->
    <span style="font-size: 10px;color: grey;">@${firstname}</span>
    <!-- end of first name -->
    <br>
    <div class="row">
        <div class="col-sm-6">
            <span style="font-size: 15px;color: grey;">Subscriptions</span>
            <br>
            <!-- subscription will show here -->
            <span>
                ${userinfo[1]}
            </span>
        </div>
   <div class="col-sm-6">
    <span style="font-size: 15px;color: grey;">Topics</span>
       <br>
    <!-- end of subscriptions -->
    <!-- number of topics will be show here -->
    <span>
        ${userinfo[0]}
    </span>
   </div>
    <!-- end of no. of topics -->
    </div>
</div>
