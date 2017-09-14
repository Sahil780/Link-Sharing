<div class="row">
    <div class="col-sm-12" style="border: 2px solid black; border-radius: 4px;margin-top: 25px;">
        <div id="rshare" style="background-color: whitesmoke; margin-left: -15px;margin-right: -15px; border-bottom: 2px solid black;margin-top: 2px;padding-left: 3px;">
            <b>Trending Topics</b>
            <a href=""><span style="float: right;margin-right: 20px;text-decoration: underline">${linktoallviewofsubscription}</span></a>
        </div>
        <div class="col-sm-3" style="margin-top: 10px;">

            <!-- topic creator pic will shown here -->

            <span class="glyphicon glyphicon-user" style="font-size: 50px;border: 1px solid black;"></span>
        </div>
        <!-- end of pic -->
        <div class="col-sm-9">

            <!-- topic name will fetch here -->

            <a href=""><span style="text-decoration: underline;font-size: 15px">Grails</span></a>
            <br>

            <!-- fetch firts name of owner of topic -->
            <div class="row">
                <div class="col-sm-4">
            <span style="font-size: 10px;color: grey;">
              <!-- resource creator firstname will fetch here with date created -->
               @uday</span>
                    <!-- link to unsubscribe -->
                    <br>
                    <a href=""><span style="text-decoration: underline;font-size: 15px">unsubscribe</span></a>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <span style="font-size: 12px;color: grey;">Subscriptions</span>
                    <br>
                    <span>12</span>
                </div>
                <div class="col-sm-4">
                    <span style="font-size: 12px;color: grey;">Post</span>
                    <br>
                    <!-- number of post in topic -->
                    <span>21</span>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6">
                    <select name="catagory" id="catagory">
                        <option value="Serious">Serious</option>
                        <option value="Very Serious">Very Serious</option>
                        <option value="Casual">Casual</option>
                    </select>
                </div>
                <div class="col-sm-6">
                    <select name="Visibility">
                        <option value="Private">Private</option>
                        <option value="Public">Public</option>
                    </select>
                </div>
            </div>
            <!-- link to send delete post -->
            <div class="row">
                <div class="col-sm-6">
                    <a href="#">
                        <span class="glyphicon glyphicon-trash"></span>
                    </a>

                    <!-- link to edit topic info -->

                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    <!-- link to send invitation -->

                    <a href="#">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </a>
                </div>
            </div>
            <hr>
        </div>


        <%-- division for those user who are not the owner or admin of the topic --%>



        <div class="col-sm-3" style="margin-top: 10px;">

            <!-- topic creator pic will shown here -->

            <span class="glyphicon glyphicon-user" style="font-size: 50px;border: 1px solid black;"></span>
        </div>
        <!-- end of pic -->
        <div class="col-sm-9">

            <!-- topic name will fetch here -->

            <a href=""><span style="text-decoration: underline;font-size: 15px">Grails</span></a>
            <br>

            <!-- fetch firts name of owner of topic -->
            <div class="row">
                <div class="col-sm-4">
            <span style="font-size: 10px;color: grey;">
              <!-- resource creator firstname will fetch here with date created -->
               @uday</span>
                    <!-- link to unsubscribe -->
                    <br>
                    <a href=""><span style="text-decoration: underline;font-size: 15px">unsubscribe</span></a>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <span style="font-size: 12px;color: grey;">Subscriptions</span>
                    <br>
                    <span>12</span>
                </div>
                <div class="col-sm-4">
                    <span style="font-size: 12px;color: grey;">Post</span>
                    <br>
                    <!-- number of post in topic -->
                    <span>21</span>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6">
                    <select name="catagory" id="catagory">
                        <option value="Serious">Serious</option>
                        <option value="Very Serious">Very Serious</option>
                        <option value="Casual">Casual</option>
                    </select>
                </div>
            </div>
            <!-- link to send delete post -->
            <%--<div class="row">--%>
                <%--<div class="col-sm-6">--%>


                    <%--<!-- link to edit topic info -->--%>

                    <%--<!-- link to send invitation -->--%>

                    <%--<a href="#">--%>
                    <%--<span class="glyphicon glyphicon-envelope"></span>--%>
                <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <hr>
        </div>
    </div>
</div>
<%--<div class="col-sm-3" style="margin-top: 10px;">--%>

<%--<!-- topic creator pic will shown here -->--%>

<%--<span class="glyphicon glyphicon-user" style="font-size: 50px;border: 1px solid black;"></span>--%>
<%--</div>--%>
<%--<!-- end of pic -->--%>
<%--<div class="col-sm-9">--%>

<%--<!-- topic name will fetch here -->--%>

<%--<a href=""><span style="text-decoration: underline;font-size: 15px">Grails</span></a>--%>
<%--<br>--%>

<%--<!-- fetch firts name of owner of topic -->--%>

<%--<span style="font-size: 10px;color: grey;">--%>
<%--<!-- resource creator firstname will fetch here with date created -->--%>
<%--@uday</span>--%>
<%--<span style="font-size: 12px;color: grey;padding-left: 75px;">Subscriptions</span>--%>
<%--<span style="font-size: 12px;color: grey;padding-left: 10px;">Post</span>--%>
<%--<br>--%>

<%--<!-- link to unsubscribe -->--%>

<%--<a href=""><span style="text-decoration: underline;font-size: 15px">unsubscribe</span></a>--%>

<%--<!-- number of subscription to topic  -->--%>
<%--<span style="padding-left: 25px;">12</span>--%>

<%--<!-- number of post in topic -->--%>
<%--<span style="padding-left: 68px;">21</span>--%>
<%--<br>--%>
<%--<span style="padding-left: 110px">--%>
<%--<select name="catagory" id="catagory">--%>
<%--<option value="Serious">Serious</option>--%>
<%--<option value="Very Serious">Very Serious</option>--%>
<%--<option value="Casual">Casual</option>--%>
<%--</select>--%>
<%--</span>--%>
<%--<!-- link to send invitation -->--%>

<%--<a href="#">--%>
<%--<span class="glyphicon glyphicon-envelope"></span>--%>
<%--</a>--%>
<%--<hr >--%>
<%--</div>--%>


<%--</div>--%>
<%--</div>--%>