<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/assets/css/st.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>
    <script src="/resources/jquery.twbsPagination.js" type="text/javascript"></script>



    <style>
        body {
            background: linear-gradient(132deg, #ec5218, #1665c1);
            background-size: 400% 400%;
            animation: BackgroundGradient 30s ease infinite;
        }

        @keyframes BackgroundGradient {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }
    </style>
    <script>
        var pagenumber=0;
        $(document).ready(function () {

            var obj = $('#pagination').twbsPagination({
                totalPages: 10,
                visiblePages: 5,
                onPageClick: function (event, page) {
                    $("#inboxContent").html('');
                    $.ajax({
                        url: 'fetchinbox?index=' + page,
                        method: "get",
                        success: function (response) {
                            $('#inboxContent').append(response);
                            pagenumber = page;
                        }
                    })
                    console.info(page);
                }


            })
        });

            function markedasread(id) {
                alert(id);
                var ref = this;
                $.ajax({
                    url: "readstatus?rid=" + id,
                    method: "get",
                    success: function (response) {
                        alert(response);
                        if (response == "marked as read") {
                            $(ref).remove();
                            $(function () {
                                $("#inboxContent").html('');
                                $.ajax({
                                    url: 'fetchinbox?index=' + pagenumber,
                                    method: "get",
                                    success: function (response) {
                                        $('#inboxContent').append(response);
                                        $('#inboxContent').append(response);
                                    }
                                })

                            })

                        }
                    }
                    ,
                    failure: function (response) {
                        alert(response);

                    }
                })
            }

    </script>
</head>
    <%@include file="headerindexhomepage.jsp" %>
    <div class="container-fluid ">


        <div class="msec">
            <div class="col-md-12">
                <div class="col-md-6 ">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-left">
                                    <img src="/UserProfilePic?uname=${username}"

                                         width="120" height="120"/>
                                </div>
                                <div class="media-body">
                                    <%--<h3 class="media-heading"><%=((User)request.getSession().getAttribute("Userdetails")).getFirstname()%>&nbsp;<%=((User)request.getSession().getAttribute("Userdetails")).getLastname()%><small><i>@<%=request.getParameter("username")%></i></small><a href="" style="float:right; font-size:12px">Grails</a></h3>--%>
                                    <div class="row">
                                        <div class="col-md-3">
                                        <h4>${username}</h4>
                                        <small><p>${firstname}</p></small>
                                    </div>
                                    </div>
                                        <div class="row">
                                    <div class="col-md-3">
                                        <h4>Subscription</h4><br/>
                                        <small><p>${userinfo[1]}</p></small>
                                    </div>
                                        <div class="col-md-3">
                                            <h4>Topics</h4><br/>
                                            <small><p>${userinfo[0]}</p></small>
                                        </div>
                                        </div>
                                </div>
                            </div>
                        </li>
                    </ul>

                    <ul class="list-group">
                        <li class="list-group-item" style="background:dimgray">Subscriptions<a style="float: right">View
                            All</a></li>
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-left">
                                    <img src="/UserProfilePic?uname=${username}"
                                         width="120" height="120"/>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        <small><i>@uday 5min</i></small>
                                        <a href="" style="float:right; font-size:12px">Grails</a></h4>

                                    <div class="pgd">
                                        <a href="" style="float:right">View post</a>
                                    </div>
                                </div>
                            </div>
                            <div class="media" style="padding-top :10px">
                                <div class="media-left">
                                    <img src="${pageContext.request.contextPath}/resources/assets/images/2.jpg"
                                         width="120" height="120">
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">Uday Pratap singh
                                        <small><i>@uday 10min</i></small>
                                        <a href="" style="float:right;font-size:12px">Grails</a></h4>
                                    <div class="pgd">
                                        <a href="" style="float:right">View post</a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>

                </div>
                <div class="col-md-6">
                    <ul class="list-group">
                        <li class="list-group-item" style="background:dimgray">Inbox</li>
                        <li class="list-group-item" id="inboxContent">
                        </li>
                        <div class="row">
                            <div class="col-sm-12">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination" id="pagination"></ul>
                                </nav>
                            </div>
                        </div>

                        <%----%>
                        <li class="list-group-item">

                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>