<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String uname=(String)session.getAttribute("uname");
%>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class="row well" >
    <div>
        <div class="col-md-6 col-sm-6">
            <a class="a1 rowheader" style="text-decoration: none">Link Sharing</a>
        </div>
        <div class="col-md-6 col-sm-6">
            <div class="col-md-4 col-sm-4 searchbox">
                <div class="input-group ">
                    <span class="input-group-addon glyphicon glyphicon-search"></span>
                    <span data-toggle="modal" data-target="#SearchTopicModel" style="border: none;">
            Search Topic here
        </span>
                    <span class="input-group-addon glyphicon glyphicon-remove-sign"></span>
                </div>
            </div>
            <div class="col-md-5 col-sm-4" style="margin-left: 25px;padding-right: 20px;">
                <a href="#" class="pull-right"><img class="media-object" src="/UserProfilePic?uname=<%=uname%> " style="background-size: 100% 100%;  width:37px; height: 37px"></a>
            </div>
            <div class="col-md-2 col-sm-4 pull-right" style="padding: 0;margin-right: 0">
                    <span class="dropdown" style="float: right">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${uname}
                        <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="/updateUserProfile?uname" </li>
                                <li><a href="logOut">Logout</a></li>
                            </ul>
                    </span>
            </div>
        </div>
    </div>
</div>
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
                    <label for="searchTopic">Topic Name *</label>
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
</body>
</html>