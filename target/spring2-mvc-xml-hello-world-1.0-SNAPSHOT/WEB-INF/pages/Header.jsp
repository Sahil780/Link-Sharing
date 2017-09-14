

<link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
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


<div class="col-md-12 well well-sm" style="background:			 #F5F5F5	">
    <div class="col-md-6 ">
        <span>   <a href=""><h3 class="linksh">Link Sharing</h3></a></span>
    </div>
    <div class="col-md-6 ">
        <div class="col-md-6 ">
        </div>
        <div class="col-md-6 ">
            <div class="input-group add-on"  >
                <input class="form-control" placeholder="Search" name="srch-term" id="searchTopic" type="text" style="margin-right: 60px">
                <div class="input-group-btn">
                    <button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                </div>
            </div>
        </div>
    </div>
</div>



<%--<nav class="navbar navbar-toggleable-md navbar-light bg-faded">--%>
    <%--<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>
    <%--<a class="navbar-brand" href="#">Navbar</a>--%>

    <%--<div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
        <%--<ul class="navbar-nav mr-auto">--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="#">Link</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link disabled" href="#">Disabled</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="text" placeholder="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</nav>--%>


