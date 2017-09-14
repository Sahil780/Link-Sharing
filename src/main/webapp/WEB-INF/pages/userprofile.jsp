<%-- 
    Document   : topicshow
    Created on : 21 Jul, 2017, 5:01:57 PM
    Author     : SAHIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height initial-scale=1">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="/resources/jquery.twbsPagination.js"></script>

        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
    <script src="/resources/userprofile.js"></script>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css">


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
        .fa {
  padding: 10px;
  font-size: 30px;
  width: 50px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}


    </style>
    <script>
        var pagenumberfortopic=0,pagenumberforpost=0;
        $(document).ready(function () {
            var obj = $('#pagination').twbsPagination({
                totalPages:10,
                visiblePages: 5,
                onPageClick: function (event, page) {
                    $("#topicsOnUserProfile").html('');
                    $.ajax({
                        type:"GET",
                        url:'topicsonuserprofilepage?index='+page+'&username=${username}',
                        success:function (response) {
                            $('#topicsOnUserProfile').append(response);
                            pagenumberfortopic=page;
                            console.log(response);
                        }
                    })
                }

            });

            var obj = $('#postPagination').twbsPagination({
                totalPages:10,
                visiblePages: 5,
                onPageClick: function (event, page) {
                    $("#postOnUserProfilePage").html('');
                    $.ajax({
                        type:"GET",
                        url:'postonuserprofilepage?index='+page+'&username=${username}',
                        success:function (response) {
                            $('#postOnUserProfilePage').append(response);
                            pagenumberforpost=page;
                            console.log(response);
                        }
                    })
                }

            });
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
                            $("#postOnUserProfilePage").html('');
                            $.ajax({
                                url: 'postonuserprofilepage?index=' + pagenumberforpost + '&username=${profileuser}',
                                method: "get",
                                success: function (response) {
                                    $('#postOnUserProfilePage').append(response);
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
<body>
  <%@include file="headeronuserprofile.jsp"%>

    <div class="container-fluid ">


        <div class="msec">
            <div class="col-md-12">
                <div class="col-md-6 ">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <div class="media">
                                <div class="media-left">
                                </div>
                                <div class="media-body">
                                   <h3 class="media-heading">&nbsp;<small><i></i></small><a href="" style="float:right; font-size:12px">Grails</a></h3>
                                    <div class="col-md-6">
                                        <h4>Subscriptions</h4><br/>
                                        <small><p>50</p></small>
                                    </div>
                                    <div class="col-md-6">
                                        <h4>Topics</h4><br/>
                                        <small><p>20</p></small>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>

                    <ul class="list-group">
                        <li class="list-group-item" style="background:dimgray">Topics<a style="float: right"></a></li>
                        <li class="list-group-item" id="topicsOnUserProfile">
                <jsp:include page="topicsonuserprofile.jsp"></jsp:include>
                        </li>

                    </ul>
                    <div class="row">
                        <div class="col-sm-12">
                            <nav aria-label="Page navigation">
                                <ul class="pagination" id="pagination"></ul>
                            </nav>
                        </div>
                    </div>
                        
                        <%--<li class="list-group-item" style="background:dimgray">Subscription<a style="float: right"></a></li>--%>
                        <%--<ul class="list-group">--%>
                         <%--<%@include file="subscription.jsp"%>--%>
                        <%--</ul>--%>
                    

                  
                </div>
                <div class="col-md-6">
                    <ul class="list-group">
                        <li class="list-group-item" id="posts" style="background:dimgray">Posts</li>
                        <li class="list-group-item" id="postOnUserProfilePage">
                        <jsp:include page="postsonuserprofile.jsp"></jsp:include>
                    </li>
                    </ul>
                    <div class="row">
                        <div class="col-sm-12">
                            <nav aria-label="Page navigation">
                                <ul class="pagination" id="postPagination"></ul>
                            </nav>
                        </div>
                    </div>
                </div></div></div></div></html>
<script>

</script>
    </body>
</html>