<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Link-Share</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script href="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
t    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>

    <style>
        body {
            background: linear-gradient(132deg, #ec5218, #1665c1);
            background-size: 400% 400%;
            animation: BackgroundGradient 30s ease infinite;
        }

        @keyframes BackgroundGradient {
            0% {background-position: 0% 50%;}
            50% {background-position: 100% 50%;}
            100% {background-position: 0% 50%;}
        }


    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#validateform").validate({
                rules: {
                    email: {
                        required: true,
                        email: true,
                        remote:""
                    },
                    userName: {
                        required: true,
                        minlenght: 3,
                        maxlength: 15
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirmpassword: {
                        required: true,
                        equalTo: "#password"
                    }
                },
                messages: {
                    userName: {
                        require: "Dont Forget your Username",
                        minlength: "You minlength is not right",
// maxlength:$.validator.format("You have exceeded the maxlength {0}")
                    },
                    confirmpassword: {
                        require: "You Forgot to confirm your password",
                        equalTo: "Password Not match"
                    }
                }
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(function() {
                $("#tagsName,#tagsName1,#tagsName2").autocomplete({
                    source: function(request, response) {
                        $.ajax({
                            url: "/get_topic_list",
                            type: "POST",
                            data: { term: request.term },

                            dataType: "json",

                            success: function(data) {
                                console.log(data);
                                response($.map(data, function(v){
                                    return {
                                        label: v,
                                        value: v
                                    };
                                }));
                            }
                        });
                    },
//                        select:function () {
//                            window.location.href="http://www.google.com";
//                        }

                });
            });
        });
    </script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="disablesubmit()">
<div class="container-fluid">
    <jsp:include page="headerindexhomepage.jsp"></jsp:include>
    <div class="msec">
        <div class="col-md-12">
            <div class="col-md-7">
                <ul class="list-group">
                    <li class="list-group-item" style="background:dimgray">Recent shares</li>
                    <c:forEach  var="resource" items="${recentresources}">
                    <li class="list-group-item">
                        <div class="media">
                            <div class="media-left">
                                <img src="/UserProfilePic?uname=${resource.createdBy.username}" width="120" height="120"/>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">${resource.createdBy.firstname} ${resource.createdBy.lastname}<small><i>@${resource.createdBy.username} ${resource.lastUpdated}</i></small><a href="" style="float:right; font-size:12px">
                                        ${resource.topic.name}
                     </a></h4>
                                <p>${resource.description}</p>
                                <div class="pgd">
                                    <div class="soc">
                                        <a href="#" class="fa fa-facebook"></a>
                                        <a href="#" class="fa fa-twitter"></a>
                                        <a href="#" class="fa fa-google"></a>
                                    </div>
                                    <a href="##" style="float:right">View post</a>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </li></ul>

                <ul class="list-group">
                    <li class="list-group-item" style="background:dimgray;height:45px">
                        <div class="top">
                            <h4 style="margin:0%;padding:0%">Top Posts</h4>
                            <div class="dropdown float-lg-right" style="float:right;;padding:0%;margin-top:-4% ;margin-right:4%">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Today
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" >
                                    <li><a href="#">Today</a></li>
                                    <li><a href="#">1 week</a></li>
                                    <li><a href="#">1 month</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="media" style="padding-top :10px">
                            <div class="media-left">
                                <img src="${pageContext.request.contextPath}/resources/assets/images/3.png" width="120" height="120">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Yashi Gupta  <small><i>@yashi 10min</i></small><a href="" style="float:right;font-size:12px">Grails</a></h4>
                                <p>Welcome to Link Sharing</p>
                                <div class="pgd">
                                    <div class="soc">
                                        <a href="#" class="fa fa-facebook"></a>
                                        <a href="#" class="fa fa-twitter"></a>
                                        <a href="#" class="fa fa-google"></a>
                                    </div>
                                    <a href="" style="float:right">View post</a>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="col-md-5">
                <jsp:include page="LoginOnHomePage.jsp"></jsp:include>
                <jsp:include page="RegistrationOnHomePage.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
<script>
    var emailflag=0,userflag=0,passwordflag=0;
    function disablesubmit() {

        document.getElementById("register").disabled=true;
    }
    var request;
    function checkusername()
    {
        var v=document.getElementById("username").value;

        var url="uniqueusername?val="+v;

        if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
        }
        else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
        }

        try{
            request.onreadystatechange=getInf;
            request.open("POST",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }

    function getInf(){
        if(request.readyState==4){
            var val=request.responseText;
            document.getElementById("status").innerHTML=val;
            if(val=="user name not available")
            {
                userflag=1;
                document.getElementById("register").disabled=true;
            }
            else
            {
                userflag=0;
            }
            if(userflag==0&&emailflag==0&&passwordflag==0)
            {

                document.getElementById("register").disabled=false;
            }


        }
    }


    /////////////////   check for email  //////////////

    var request;
    function checkemail()
    {

        var v=document.getElementById('mail').value;

        var url="uniqueemail?val="+v;

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
            document.getElementById("status").innerHTML=val;
            if(val==="email id not available")
            {
                emailflag=1;
                document.getElementById("register").disabled=true;
            }
            else {
                emailflag = 0;
                document.getElementById("register").disabled=false;
            }


        }
    }

    function confirmpassword() {
        var password=document.getElementById('password').value;
        var confirmpassword=document.getElementById('passwordconfirm').value;

        if(password===confirmpassword)
        {
            passwordflag=0;

        }
        else {
            passwordflag = 1;
            document.getElementById('status').value="password not matched";
            document.getElementById('register').disabled=true;
        }
        if(userflag==0&&emailflag==0&&passwordflag==0) {
            document.getElementById('register').disabled = false;
        }

    }
    $(document).ready(function () {
        $('#SendOTPForm').ajaxForm({

            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
        $('#updatePasswordForm').ajaxForm({

            success: function (msg) {
                alert(msg);
            },
            error: function (msg) {
                alert(msg);
            }
        });
    });
    $("#sendverificationcode").click(function () {
        $("#SendOtpModel").model('hide');
    });

</script>



</body>
</html>