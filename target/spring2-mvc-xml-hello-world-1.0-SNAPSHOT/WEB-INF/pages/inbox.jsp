
<div class="col-sm-2" style="margin-top: 10px;">
    <img src="/UserProfilePic?uname="+ width="70px" height="70px">
</div>
<div class="col-sm-10">
    <div class="description" style="font-size: 15px;margin-left: 25px;">
        <!-- resource creator name will fetch here -->
        udaypratap singh <span style="font-size: 10px;color: grey;">
              <!-- resource creator firstname will fetch here with date created -->
               @uday 5min</span>
        <a href="###" style="float: right;">Grails</a>
        <br>
        <!-- description of resource will fetch from the -->
        asdh asd asd asd asd assd asd asd aasd asd asd asd asd asd asd  as asd asd asd asd asd asd asd
        assdasd assd assd asd asd asd asd
        asd assd asd asd asd
        <br>
        <span class="fa fa-facebook-official"></span>
        <span class="fa">&#xf173;</span>
        <span class="fa fa-google-plus"></span>

        <!-- link for view post -->

        <a href=""><span style="float: right;text-decoration: underline;font-size: 15px">view full post</span></a>

        <!-- link for mark as read -->

        <a href="/readstatus?rid="+><span style="float: right;text-decoration: underline;padding-right: 10px;font-size: 15px">mark as read</span></a>

        <!-- link for view full site -->

        <a href=""><span style="float: right;text-decoration: underline;padding-right: 10px;font-size: 15px">view full site</span></a>

        <!--  link for download option -->

        <a href="/download?file="+><span style="float: right;text-decoration: underline;padding-right: 10px;font-size: 15px">download</span></a>

    </div>

</div>


"\n" +
"<div class=\"col-sm-2\" style=\"margin-top:10px;">\n" +
"    <span class=\"glyphicon\glyphicon-user\" style=\"font-size:80px;border:1px solid black;margin-left: 2px;></span>\n" +
"</div>\n" +
"<div class=\"col-sm-10\">\n" +
"    <div class=\"description\" style=\"font-size:15px;margin-left:25px;">\n" +
"        <!-- resource creator name will fetch here -->\n" +r.getResources().getCreatedBy().getUsername()+
"         <span style=\"font-size:10px;color:grey;>\n" +
"              <!-- resource creator firstname will fetch here with date created -->\n" +"<br>@"+r.getResources().getCreatedBy().getFirstname()+
" "+r.getResources().getDateCreated()+
"              </span>\n" +
"        <a href=\"###\" style=\"float:right;">Grails</a>\n" +
"        <br>\n" +
"        <!-- description of resource will fetch from the -->\n" +r.getResources().getDescription()+
"        <br>\n" +
"        <span class=\"fa fa-facebook-official></span>\n" +
"        <span class=\"fa\">&#xf173;</span>\n" +
"        <span class=\"fa fa-google-plus></span>\n" +
"\n" +
"        <!-- link for view post -->\n" +
"\n" +
"        <a href=\"\"><span style=\"float:right;text-decoration: underline;font-size: 15px>view full post</span></a>\n" +
"\n" +
"        <!-- link for mark as read -->\n" +
"\n" +
"        <a href=\"\"><span style=\"float: right;text-decoration: underline;padding-right: 10px;font-size: 15px>mark as read</span></a>\n" +
"\n" +
"        <!-- link for view full site -->\n" +
"\n" +
"        <!--  link for download option -->\n" +
"\n" +
"       <a href='/download?fileName="+r.getResources().getResourcePath()+"' download ><span style=\"float:right;text-decoration:underline;padding-right:10px;font-size:15px>download</span></a>\n" +
"\n" +
"    </div>\n" +
"\n" +
"</div>\n"
