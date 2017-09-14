<%@ page import="com.ttn.beans.User" %>
<html>
<head>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dashboardStyle.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Commons.css"/>
    <script>
        $('#updateUserPasswordForm').ajaxForm({

            success: function (msg) {
                alert("Your Password is changed");
            },
            error: function (msg) {
                console.log(msg);
                alert(msg);
            }
        });
    </script>
    <style>

    </style>
</head>
<%! static int flag;%>
<%
    User user = (User) session.getAttribute("User");
%>
<div class="container" style="width: 70%">

<jsp:include page="userProfileHeader.jsp"></jsp:include>
    <div id="division1" class="col-md-5 col-sm-5">
        <div style="padding-left: 0;">
            <jsp:include page="userData.jsp"></jsp:include>
        </div>

        <div style="padding-left: 0;">
            <div class="dynamicDiv" style="margin-bottom:15px;">
                <div class="dynamicDivHead">
                    <span class="phead">Subscription</span>
                    <a style="color: #55ACEE" class="pull-right">View All</a>
                </div>
                <% //while (blogIterator.hasNext()){ Blog userblog = blogIterator.next();%>
                <div style="margin-top:10px;margin-left:10px;margin-right:5px;margin-bottom:10px;">
                    <div class="media">
                        <div class="media-left">
                            <img class="media-object" src="getphoto" style="background-size: 100% 100%;  width:70px; height: 70px">
                        </div>
                        <div class="media-body" >
                            <small style="margin-top:0px ">topic name</small>
                            <div>
                                <div class="col-md-4 col-sm-10" style="float: left;margin-bottom: 0px;margin-left: 0">
                                    <p style="margin-bottom: 0">@uday</p>
                                    <p><a>Unsubscribe</a></p>
                                </div>
                                <div class="col-md-4 col-sm-10" style="float: left;margin-bottom: 0px;margin-left: 0">
                                    <p style="margin-bottom: 0">Subscriptions</p>
                                    <p>50</p>
                                </div>
                                <div class="col-md-4 col-sm-10" style="float: left;margin-bottom: 0px;margin-left: 0">
                                    <p style="margin-bottom: 0">Post</p>
                                    <p>30</p>
                                </div>
                            </div>
                            <div style="margin-left: 10px">
                                <select class="col-md-4 selectpicker">
                                    <option>Mustard</option>
                                    <option>Ketchup</option>
                                    <option>Relish</option>
                                </select>
                                <select class="col-md-4 selectpicker">
                                    <option>Mustard</option>
                                    <option>Ketchup</option>
                                    <option>Relish</option>
                                </select>
                                <div class="col-md-4">
                                    <a href="#"><span class="popupBox glyphicon glyphicon-envelope"></span></a>
                                    <a href="#"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a href="#"><span class="glyphicon glyphicon-trash"></span></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="division2" class="col-md-7 col-sm-7">
        <div style="padding-right: 0;margin-bottom: 20px">
            <div class="dynamicDiv">
                <div class="dynamicDivHead">
                    <p class="phead">Profile</p>
                </div>
                <form class="form-horizontal" id="updateProfileDataForm" style="padding:10px;margin-bottom: 0" enctype="multipart/form-data" action="/updateUserProfile" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="firstname">First Name:</label>
                        <div class="col-sm-8">
                            <input type="text" id="firstname" class="form-control" minlength="5" name="firstname" value="<%=user.getFirstname()%>"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="lastname">Last Name:</label>
                        <div class="col-sm-8">
                            <input id="lastname" type="text" class="form-control" minlength="5" value="<%=user.getLastname()%>" name="lastname"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="username">Username:</label>
                        <div class="col-sm-8">
                            <input type="text" onkeyup="checkusername()" id="username" class="form-control" minlength="5" value="<%=user.getUsername()%>" name="username"></input>
                            <span id="usernameAvailability"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">Photo:</label>
                        <div class="col-sm-9">
                            <input type="file" class="form-control" id="foto" name="foto"/>
                        </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 5px">
                        <div class="col-sm-5 pull-right">
                            <button type="submit" id="updateProfileData" class="btn btn-default">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div style="padding-right: 0;">
            <div class="dynamicDiv">
                <div class="dynamicDivHead">
                    <p class="phead">Change Password</p>
                </div>
                <form id="updateUserPasswordForm" class="form-horizontal" style="padding:10px;margin-bottom: 0" action="/updatePasswordForm" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="password">Password:</label>
                        <div class="col-sm-9">
                            <input type="password" id="password" class="form-control" minlength="5" placeholder="Enter password" name="password" required></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="confirm_password">Confirm Password:</label>
                        <div class="col-sm-9">
                            <input type="password" id="confirm_password" onkeyup="confirmpassword()" class="form-control" minlength="5" placeholder="Enter password" required/>
                            <span id="myspan" style="color: red;">Please enter same password</span>
                        </div>
                    </div>
                    <div class="form-group" style="margin-bottom: 5px">
                        <div class="col-sm-5 pull-right">
                            <button type="submit" id="updateUserPassword" class="btn btn-default">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </div>
</div>
<script>

    var request;
    function checkusername()
    {
        var v=document.getElementById('username').value;

        var url="uniqueusername?val="+v;

        if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
        }
        else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }

        try{
            request.onreadystatechange=getInfo;
            request.open("POST",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }

    function getInfo(){
        if(request.readyState==4){
            var val=request.responseText;
            document.getElementById("usernameAvailability").innerHTML=val;
            if(val==="user name not available")
            {
                document.getElementById("updateProfileData").disabled=true;
            }
          else {

                document.getElementById("updateProfileData").disabled=false;
            }


        }
    }
    function confirmpassword() {
        var password=document.getElementById('password').value;
        var confirmpassword=document.getElementById('confirm_password').value;

        if(password===confirmpassword) {
            document.getElementById("updateProfileData").disabled=false;

        }
        else
        {
            document.getElementById("updateProfileData").disabled=true;

        }

    }

</script>
<%--<form action="/getTags" method="post"></form>Search:<input type="text" id="tagName"></input>--%>
</body>
</html>