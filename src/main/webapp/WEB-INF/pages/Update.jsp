<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shubham
  Date: 7/19/17
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: tanuj
  Date: 7/8/17
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String username=(String)session.getAttribute("uname");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Link-Share</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/assets/css/st.css" >
    <script href="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <script href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">







        $().ready(function () {
            $("#validateform").validate({
                rules: {
                    email: {
                        required: true,
                        email: true
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
    <style>
        * {
            box-sizing: border-box;
        }

        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 2) {

        }

        /* Portrait */
        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 2)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 2)
        and (orientation: landscape) {

        }

        /* ----------- Galaxy S4 ----------- */

        /* Portrait and Landscape */
        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3) {

        }

        /* Portrait */
        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media screen
        and (device-width: 320px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: landscape) {

        }

        /* ----------- Galaxy S5 ----------- */

        /* Portrait and Landscape */
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3) {

        }

        /* Portrait */
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: landscape) {

        }




        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 480px)
        and (-webkit-min-device-pixel-ratio: 2) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 480px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: portrait) {
        }

        /* Landscape */
        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 480px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: landscape) {

        }

        /* ----------- iPhone 5 and 5S ----------- */

        /* Portrait and Landscape */
        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 568px)
        and (-webkit-min-device-pixel-ratio: 2) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 568px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: portrait) {
        }

        /* Landscape */
        @media only screen
        and (min-device-width: 320px)
        and (max-device-width: 568px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: landscape) {

        }

        /* ----------- iPhone 6 ----------- */

        /* Portrait and Landscape */
        @media only screen
        and (min-device-width: 375px)
        and (max-device-width: 667px)
        and (-webkit-min-device-pixel-ratio: 2) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 375px)
        and (max-device-width: 667px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media only screen
        and (min-device-width: 375px)
        and (max-device-width: 667px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (orientation: landscape) {

        }

        /* ----------- iPhone 6+ ----------- */

        /* Portrait and Landscape */
        @media only screen
        and (min-device-width: 414px)
        and (max-device-width: 736px)
        and (-webkit-min-device-pixel-ratio: 3) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 414px)
        and (max-device-width: 736px)
        and (-webkit-min-device-pixel-ratio: 3)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media only screen
        and (min-device-width: 414px)
        and (max-device-width: 736px)
        and (-webkit-min-device-pixel-ratio: 3)
        and (orientation: landscape) {

        }
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3) {

        }

        /* Portrait */
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media screen
        and (device-width: 360px)
        and (device-height: 640px)
        and (-webkit-device-pixel-ratio: 3)
        and (orientation: landscape) {

        }
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: portrait)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* Landscape */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: landscape)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* ----------- iPad 1 and 2 ----------- */
        /* Portrait and Landscape */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: portrait)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* Landscape */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: landscape)
        and (-webkit-min-device-pixel-ratio: 1) {

        }

        /* ----------- iPad 3 and 4 ----------- */
        /* Portrait and Landscape */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (-webkit-min-device-pixel-ratio: 2) {

        }

        /* Portrait */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: portrait)
        and (-webkit-min-device-pixel-ratio: 2) {

        }

        /* Landscape */
        @media only screen
        and (min-device-width: 768px)
        and (max-device-width: 1024px)
        and (orientation: landscape)
        and (-webkit-min-device-pixel-ratio: 2) {

        }
        @media
        (min-device-width: 800px)
        and (max-device-width: 1280px) {

        }

        /* Portrait */
        @media
        (max-device-width: 800px)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media
        (max-device-width: 1280px)
        and (orientation: landscape) {

        }


        @media screen
        and (device-width: 601px)
        and (device-height: 906px)
        and (-webkit-min-device-pixel-ratio: 1.331)
        and (-webkit-max-device-pixel-ratio: 1.332) {

        }

        /* Portrait */
        @media screen
        and (device-width: 601px)
        and (device-height: 906px)
        and (-webkit-min-device-pixel-ratio: 1.331)
        and (-webkit-max-device-pixel-ratio: 1.332)
        and (orientation: portrait) {

        }

        /* Landscape */
        @media screen
        and (device-width: 601px)
        and (device-height: 906px)
        and (-webkit-min-device-pixel-ratio: 1.331)
        and (-webkit-max-device-pixel-ratio: 1.332)
        and (orientation: landscape) {

        }


        @media screen
        and (min-device-width: 1200px)
        and (max-device-width: 1600px)
        and (-webkit-min-device-pixel-ratio: 1) {
        }

        /* ----------- Retina Screens ----------- */
        @media screen
        and (min-device-width: 1200px)
        and (max-device-width: 1600px)
        and (-webkit-min-device-pixel-ratio: 2)
        and (min-resolution: 192dpi) {
        }
        @media
        (max-device-width: 218px)
        and (max-device-height: 281px) {
            @media
            (max-device-width: 42mm)
            and (min-device-width: 38mm) {

            }
        }







    </style>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body style="background-image: url('${pageContext.request.contextPath}/resources/assets/images/bg5.png') ;background-repeat:no-repeat top;background-size: 100% ">





<div class="container-fluid">
    <%@include file="headeronuserprofile.jsp"%>

    <div class="msec">
        <div class="col-md-12">
            <div class="col-md-7 ">
                <ul class="list-group">
                    <li class="list-group-item" style="background-color:	#F5F5F5">




                        <div class="media" style="padding-top :10">
                        <div class="media-left">
                            <a href="/userProfilePage?uname=<%=username%>"> <img src="/UserProfilePic?uname=<%=username%>" width="120" height="120"></a>
                        </div>

                        <div class="media-body">
                            <h4 class="media-heading" id="fullNameOfUser" style="margin-right: 15px;">${uname}</h4>
                            <small id="timeStampOfBlog" style="margin-top:15px ">@${firstname}</small>
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
                        <%--</div>--%>
                    </li>
                </ul>
                <ul class="list-group">
                    <li class="list-group-item" style="background:#000078;height:45px ">
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
                    <li class="list-group-item" style="background-color: 	#F5F5F5">
                        <div class="media" style="padding-top :10">
                            <div class="media-left">
                                <img src="${pageContext.request.contextPath}/resources/assets/images/dp.jpg" width="120" height="120">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Uday Pratap singh  <small><i>@uday 10min</i></small><a href="" style="float:right;font-size:12px">Grails</a></h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
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
                <%@include file="updateprofilesave.jsp"%>
                <%@include file="updatepassword.jsp"%>

            </div>
        </div>
    </div>
</div>
</body>
</html>