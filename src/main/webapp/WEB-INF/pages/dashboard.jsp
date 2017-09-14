<%

    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/dashboardStyle.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css">
    <title></title>
    <script src="/resources/jquery.twbsPagination.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
    <script src="/resources/Dashboard.js"></script>
    <script src="/resources/bootstrap3-typeahead.js"></script>
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />

</head>
<body>
<%@page errorPage="errorpage.jsp"%>
<%
    String uname=(String)session.getAttribute("uname");
%>
<div class="container">
    <div class="row">
        <div class="col-sm-12" id="headerstyle" >
            <div class="col-sm-2">
<span id="link">
<a href="##">Link Sharing</a>
</span>
            </div>
<div class="col-sm-3" style="margin-right: -30px;">
    <span id="search">
    <span class="glyphicon glyphicon-search"></span>

    <span style="font-style: italic;">
        <span data-toggle="modal" data-target="#SearchTopicModel" style="border: none;">
            Search Topic here
        </span>
    </span>
    <!--  <span class="fa fa-times-circle"></span> -->
    <i class="fa fa-spinner fa-spin" style="font-size:15px"></i>
    </span>
</div>



            <div class="col-md-1" style="margin-left: 80px;">
                <a class="btn" role="button" data-toggle="modal"
                   data-target="#createTopicModel"> <span class="fa fa-comment"></span>
                </a>
            </div>

            <div class="col-md-1" style="margin-right: -30px;">
                <a class="btn" role="button" data-toggle="modal"
                   data-target="#SendInvitationModel"> <span
                        class="glyphicon glyphicon-envelope"></span>
                </a>
            </div>

            <div class="col-md-1" style="margin-right: -30px;">
                <a class="btn" role="button" data-toggle="modal"
                   data-target="#linkedresourcemodel"> <span
                        class="glyphicon glyphicon-link"></span>
                </a>
            </div>

            <div class="col-md-1" style="margin-right: -30px;">
                <a class="btn" role="button" data-toggle="modal"
                   data-target="#documentresourcemodel"> <span class="fa fa-file-o"></span>
                </a>
            </div>
        <div class="col-sm-1" >
        <a href="/userProfile" style="float: right;padding-right: 2px;"><img src="/UserProfilePic?uname=<%=uname%> " width="30px" height="30px;"></a>
        </div>
            <div class="col-sm-1">
            <span class="dropdown">


<!-- usr profile fetch here -->
<%=uname%>
<span class="dropdown-content">
  <a href="/userProfilePage?uname=${username}">profile</a><br>
  <a href="##">users</a><br>
  <a href="##">topics</a><br>
  <a href="##">posts</a><br>
  <a href="/logout">logout</a>
  </span>
</span>
            </div>
            <%--<!-- link to add documnt resource -->--%>
            <%--<a data-toggle="modal" data-target="#documentresourcemodel">--%>
                <%--<i style="font-size:24px;float: right;padding-right: 20px;" class="fa">&#xf15b;</i></a>--%>
            <%--<!-- link to add linked resource -->--%>
            <%--<a  data-toggle="modal" data-target="#linkedresourcemodel" style="font-size:24px;float: right;padding-right: 20px;" class="glyphicon glyphicon-link">&#xf0c1;</a>--%>
            <%--<!-- link to send subscription invitaion -->--%>
            <%--<a data-toggle="modal" data-target="#myModalNorm">--%>
                <%--<i style="font-size:24px;float: right;padding-right: 20px;" class="fa">&#xf003;</i></a>--%>
            <%--<!-- link to create topic -->--%>
            <%--<a role="button" class="btn" style="float: right;padding-right: 20px;" data-toggle="modal" data-target="#myModalNorm">--%>
                <%--<span class="fa fa-comment" ></span></a>--%>
            <%--<span id="search">--%>
        <%--<span class="glyphicon glyphicon-search"></span>--%>

                <%--<a data-toggle="modal" data-target="#myModalforsearchtopic">--%>
                   <%--<span style="font-style: italic;">Search Topic Here</span>--%>
                <%--</a>--%>
                <%--<!--  <span class="fa fa-times-circle"></span> -->--%>
        <%--&lt;%&ndash;<i class="fa fa-spinner fa-spin" style="font-size:15px"></i>&ndash;%&gt;--%>
         <%--</span>--%>

    </div>
    </div>




    <!-- header ends here  -->


    <!-- User profile division starts here -->

    <div class="row" style="margin-top: 20px;">
        <div class="col-sm-4" id="userinfo">
                    <jsp:include page="dashboarduserinfo.jsp"></jsp:include>
                    <jsp:include page="Subscriptions.jsp"></jsp:include>
            <jsp:include page="TrendingTopicsOnDashboard.jsp"></jsp:include>
        </div>

        <div class="col-sm-7" style="border: 2px solid black; border-radius: 4px;margin-left: 35px;float: right;">
            <div id="rshare" style="background-color: whitesmoke; margin-left: -15px;margin-right: -15px; border-bottom: 2px solid black;margin-top: 2px;padding-left: 3px;">
                <b>Inbox</b>
            </div>
            <div id="inbox">
            <jsp:include page="inbox.jsp" />
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="pagination"></ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="createTopicModel" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        Modal title
                    </h4>
                </div>

                <!-- Modal Body -->
                <div class="modal-body" id="modelbox">

                    <form role="form" action="/createtopic" id="createtopicform" method="post">
                        <div class="form-group">
                            <label for="TopicName" id="uniqueTopicname"></label>
                            <label for="TopicName">Topic Name</label>
                            <input type="text" class="form-control"
                                   id="TopicName" placeholder="Enter Topic Name" name="name" required/>
                        </div>
                        <div class="form-group">

                            <label for="vis">Visibility</label>
                           <select class="form-control" name="visibililty" id="vis" required>
                               <option value="Private">Private</option>
                               <option value="Public">Public</option>
                           </select>
                        </div>
                        <button type="submit" class="btn btn-default" id="createtopic" style="border:1px solid black;">Submit</button>
                    </form>
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        Close
                    </button>

</div>
            </div>
        </div>
    </div>




    <%-- model for creating documented resource --%>

    <div class="modal fade" id="documentresourcemodel" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModal">
                        Create Documented Resource
                    </h4>
                </div>

                <!-- Modal Body -->
                <div class="modal-body" >

                    <form role="form" action="/createDocumentResource" id="createdocumentedresourceform" method="post">
                            <div class="form-group">
                                <label for="desc">Description *</label>
                                <textarea class="form-control" rows="5" id="desc" name="description" placeholder="Enter Description" required></textarea>
                            </div>
                        <div class="form-group">
                            <label for="topicsearchfordocumentresource">Topic Name *</label>
                                    <input class="form-control" placeholder="Enter Topic Name" id="topicsearchfordocumentresource" name="topicnamefordocumentresource"/>
                        </div>
                        <label for="filepath">Browse attachments*</label>
                        <span class="btn btn-default btn-file">
                         <input type="file" name="file" id="filepath" required>
                        </span>
                        <button type="submit" class="btn btn-default" id="createdocumentresource" style="border:1px solid black;">Submit</button>
                    </form>
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        Close
                    </button>

                </div>
            </div>
        </div>
    </div>

    <%-- ends--%>

    <%-- model for linked resource --%>

    <div class="modal fade" id="linkedresourcemodel" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModaforlinkedresource">
                        Create Linked Resource
                    </h4>
                </div>

                <!-- Modal Body -->
                <div class="modal-body" >

                    <form role="form" action="/createLinkedResource" id="createlinkedresourceform" method="post">
                        <div class="form-group">
                            <label for="desc">Description *</label>
                            <textarea class="form-control" rows="5" id="desc1" name="description" placeholder="Enter Description" required></textarea>
                        </div>
                        <div class="form-group">
                            <label for="topicsearchforlinkedresource">Topic Name *</label>
                            <input class="form-control" placeholder="Enter Topic Name"  id="topicsearchforlinkedresource" name="topicnameforlinkedresource" required/>
                        </div>
                        <div class="form-group">
                            <label for="url">File Path / Link  *</label>
                            <input class="form-control" placeholder="Enter File Path" id="url" name="url" required/>
                        </div>
                        <button type="submit" class="btn btn-default" id="createlinkedresource" style="border:1px solid black;">Submit</button>
                    </form>
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        Close
                    </button>

                </div>
            </div>
        </div>
    </div>

<%--ends--%>


    <%-- model for search topic --%>


    <div class="modal fade" id="SearchTopicModel" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog ui-front">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalForSearchTopic">
                        Search Topic
                    </h4>
                </div>

                <!-- Modal Body -->
                <div class="modal-body">
                        <div class="form-group">
                            <label for="topicsearchforlinkedresource">Topic Name *</label>
                            <input class="form-control" placeholder="Enter Topic Name"  id="searchTopic"  required/>
                        </div>
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        Close
                    </button>

                </div>
            </div>
        </div>
    </div>

    <%-- ends --%>


    <%-- model for send invitation --%>


    <div class="modal fade" id="SendInvitationModel" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog ui-front">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalForSendInvitaion">
                        Send Invitation
                    </h4>
                </div>

                <!-- Modal Body -->
                <div class="modal-body" >
                    <form role="form" action="/sendSubscriptionInvitation" id="sendSubscriptionInvitaition" method="post">

                    <div class="form-group">
                        <label for="topicsearchforlinkedresource">Email *</label>
                        <input class="form-control" type="email" placeholder="Enter Email Id"  id="userEmail" name="emailofuser" required/>
                    </div>

                    <div class="form-group">
                        <label for="topicsearchforlinkedresource">Topic Name *</label>
                        <input class="form-control" type="text" placeholder="Enter Topic Name"  id="topicForSubscription" name="tname" required/>
                    </div>
                        <button type="submit" class="btn btn-default" id="invite" style="border:1px solid black;">Submit</button>

                    </form>
                </div>

                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">
                        Close
                    </button>

                </div>
            </div>
        </div>
    </div>


    <%--  ends --%>
    <script>
        $(document).ready(function () {
            $("#searchTopic").autocomplete({
                minLength: 1,
                type: "GET",
                //define callback to format results
                source: function (request, response) {
                    $.getJSON("/findpublictopic", request, function (result) {
                        response($.map(result, function (item) {
                            return {
                                // following property gets displayed in drop down
                                label:"Topic Name   : "+item[0]+ "      Created By  : "+item[1],
                                // following property gets entered in the textbox
                                value: "Topic Name "+item[0]+ "Created By"+item[1],
                                // following property is added for our own use
                                tag_url: "/showtopicpage?val=" + item[0] + "-" + item[1]
                            }
                        }));
                    });
                },

                //define select handler
                select: function (event, ui) {
                    if (ui.item) {
                        window.location.href = ui.item.tag_url;
//                event.preventDefault();
//                $("#selected_tags span").append('<a href=" + ui.item.tag_url + " target="_blank">'+ ui.item.label +'</a>');
//                //$("#tagQuery").value = $("#tagQuery").defaultValue
//                var defValue = $("#tagQuery").prop('defaultValue');
//                $("#tagQuery").val(defValue);
//                $("#tagQuery").blur();
                        return false;
                    }
                }
            });
        });
    </script>
</div>
</body>
</html>
