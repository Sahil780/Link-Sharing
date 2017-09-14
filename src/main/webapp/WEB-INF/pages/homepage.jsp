<%

    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

%>
<!DOCTYPE html>
<html>
<head>
	<title>home</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha256-U5ZEeKfGNOja007MMD3YBI0A3OSZOQbeG6z2f2Y0hu8=" crossorigin="anonymous"></script>
    <style type="text/css">
		.form-control
		{
			border: 2px solid black;
		}
	</style>
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />
</head>
<body onload="disablesubmit()">
<div class="container">
	<div class="row">
		<div class="col-md-12" style="border: 2px solid black; border-radius:5px; height: 50px;padding-top: 13px;">
         <span id="link" style="color: blue;text-decoration: underline;">
         <a href="##">Link Sharing</a>
         </span>
         <span id="search" style="float: right; border: 1px solid black;border-radius:8px;padding: auto;">
        <span class="glyphicon glyphicon-search"></span>
        <input type="text" placeholder="Search" style="border:none;font-style: italic;">
         <span class="fa fa-times-circle"></span>
         </span>
		</div>
</div>
		<!-- ///////////// header ends  ////////// -->
       
     <!--   /////// left side first div /////// -->
  
         <div class="row" style="margin-top: 20px;">
        <div class="col-md-8" style="border: 2px solid black; border-radius: 4px;">
           <div id="rshare" style="background-color: whitesmoke; margin-left: -15px;margin-right: -15px; border-bottom: 2px solid black;margin-top: 2px;padding-left: 3px;">
           	Recent Share
           </div>
            <!-- first col inside box for glyphicon-->
            <div class="row" style="margin-top: 10px;">
            <div class="col-md-2" style="">

             <span class="glyphicon glyphicon-user" style="font-size: 80px;border: 1px solid black;margin-left: 2px;"></span>
            </div>
             <!-- 2nd col inside box for description-->
             <div class="col-md-10">
             <div class="description" style="font-size: 15px;margin-left: 25px;">
               udaypratap singh <span style="font-size: 10px;color: grey;">@uday 5min</span>
                <a href="###" style="float: right;">Grails</a>
               <br>
               asdh asd asd asd asd assd asd asd aasd asd asd asd asd asd asd  as asd asd asd asd asd asd asd
               assdasd assd assd asd asd asd asd 
               asd assd asd asd asd 
               <br>
               <span class="fa fa-facebook-official"></span>
               <span class="fa">&#xf173;</span>
               <span class="fa fa-google-plus"></span>
               <span style="float: right;text-decoration: underline;"><a href="##">View Post</a></span>
               </div>
             </div>
             </div>
               <div class="row" style="margin-top: 10px;">
            <div class="col-md-2" style="">

             <span class="glyphicon glyphicon-user" style="font-size: 80px;border: 1px solid black;margin-left: 2px;"></span>
            </div>
             <!-- 2nd col inside box for description-->
             <div class="col-md-10">
             <div class="description" style="font-size: 15px;margin-left: 25px;">
               udaypratap singh <span style="font-size: 10px;color: grey;">@uday 5min</span>
                <a href="###" style="float: right;">Grails</a>
               <br>
               asdh asd asd asd asd assd asd asd aasd asd asd asd asd asd asd  as asd asd asd asd asd asd asd
               assdasd assd assd asd asd asd asd 
               asd assd asd asd asd 
               <br>
               <span class="fa fa-facebook-official"></span>
               <span class="fa">&#xf173;</span>
               <span class="fa fa-google-plus"></span>
               <span style="float: right;text-decoration: underline;"><a href="##">View Post</a></span>
               </div>
             </div>
             </div>
        </div>

         <!-- space for making form -->
         <div class="col-md-4">
         <div style="border: 2px solid black;border-radius: 5px;">
         <div style="background-color: whitesmoke; padding-left: 3px;border-bottom: 2px solid black;">
         Login
         </div>
             ${msg}${msgfromlogin}
      <form class="form-horizontal" action="/loginProcess" method="post" style="margin-top: 10px; margin-right: 5px;">
    <div class="form-group">
      <label class="control-label col-sm-4" for="email">Username:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control" id="email" placeholder="Enter email" name="username" style="border: 2px solid black;">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Password:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" style="border: 2px solid black;">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4">
      	<a href="##" style="font-size: 10px;text-decoration: underline;">Forgot Password</a>
      </label>
      <div class="col-sm-8">          
        <input type="submit" class="form-control" value="login" style="border: 2px solid black;">
      </div>
    </div>
    </form>
         </div>
	</div>
</div>
	<!-- 2nd row  -->


	 <div class="row" style="margin-top: 20px;">
        <div class="col-md-8" style="border: 2px solid black; border-radius: 4px;">
           <div id="rshare" style="background-color: whitesmoke; margin-left: -15px;margin-right: -15px; border-bottom: 2px solid black;margin-top: 2px;padding-left: 3px;">
           	Today's Post
           	<span style="float: right;margin-right: 15px;">
           	<select style="border: 1px solid black;">
           		<option value="##">today</option>
           		<option value="##">week</option>
           	</select>
           	</span>
           </div>
            <!-- first col inside box for glyphicon-->
            <div class="row" style="margin-top: 10px;">
            <div class="col-md-2" style="">

             <span class="glyphicon glyphicon-user" style="font-size: 80px;border: 1px solid black;margin-left: 2px;"></span>
            </div>
             <!-- 2nd col inside box for description-->
             <div class="col-md-10">
             <div class="description" style="font-size: 15px;margin-left: 25px;">
               udaypratap singh <span style="font-size: 10px;color: grey;">@uday 5min</span>
                <a href="###" style="float: right;">Grails</a>
               <br>
               asdh asd asd asd asd assd asd asd aasd asd asd asd asd asd asd  as asd asd asd asd asd asd asd
               assdasd assd assd asd asd asd asd 
               asd assd asd asd asd 
               <br>
               <span class="fa fa-facebook-official"></span>
               <span class="fa">&#xf173;</span>
               <span class="fa fa-google-plus"></span>
               <span style="float: right;text-decoration: underline;"><a href="##">View Post</a></span>

               </div>
             </div>
                <span id="status">s</span>
             </div>
             </div>


             <!-- 2nd form in 2nd row -->
             <div class="col-md-4">
             	
             	<!-- space for creating forms -->
             	<div style="border: 2px solid black;border-radius: 5px;">
         <div style="background-color: whitesmoke; padding-left: 3px;border-bottom: 2px solid black;">
            Register
         </div>
             	<form class="form-horizontal" action="registrationprocess" method="post" enctype="multipart/form-data" style="margin-top: 10px; margin-right: 5px;">
    <div class="form-group">
      <label class="control-label col-sm-4" for="email">first name:</label>
      <div class="col-sm-8">
        <input type="text" class="form-control"  placeholder="first name" name="fname" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" >Last name</label>
      <div class="col-sm-8">          
        <input type="text" class="form-control"  placeholder="last name" name="lname" required >
      </div>
    </div>
  <!--  -->
    <div class="form-group">
      <label class="control-label col-sm-4" >Email:</label>
      <div class="col-sm-8">          
        <input type="email" class="form-control" placeholder="Email" name="mailid" id="mail" required onkeyup="checkemail()">
      </div>
    </div>
    <!--  -->
    <div class="form-group">
      <label class="control-label col-sm-4">user name:</label>
      <div class="col-sm-8">          
        <input type="text" class="form-control" placeholder="User name" name="uname" id="name" required onkeyup="checkusername()">
      </div>
    </div>
    <!--  -->
    <div class="form-group">
      <label class="control-label col-sm-4">Password:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control"  placeholder="Enter password" name="pass" id="paswd" required>
      </div>
    </div>
   <!--  -->
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Confirm Password:</label>
      <div class="col-sm-8">          
        <input type="password" class="form-control" placeholder="Enter password again"

               name="cpass" id="confirmpwd" required onkeyup="confirmpassword()">
      </div>
    </div>
    <!--  -->
    <div class="form-group">
      <label class="control-label col-sm-4" >photo:</label>
      <div class="col-sm-8">          
        <input type="file" name="photu"  >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" ></label>
      <div class="col-sm-8">          
        <input type="submit" value="register" id="register" style="float: right;font-size: 15px;border: 2px solid black;border-radius: 8px;width: 100px;">
      </div>
    </div>
    <!--  -->
  
    <!--  -->
</form>
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
        var v=document.getElementById('name').value;

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
            document.getElementById("status").innerHTML=val;
            if(val==="user name not available")
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
            }
            if(userflag==0&&emailflag==0&&passwordflag==0)
            {
                document.getElementById("register").disabled=false;
            }


        }
    }

function confirmpassword() {
        var password=document.getElementById('paswd').value;
        var confirmpassword=document.getElementById('confirmpwd').value;

        if(password===confirmpassword)
        {
            passwordflag=0;

        }
        else {
            passwordflag = 1;
            document.getElementById('status').value="password not matched";
            document.getElementById('register').disabled=true;
        }
        if(userflag==0&&emailflag==0&&passwordflag==0)
        {

        }
    if(userflag==0&&emailflag==0&&passwordflag==0) {
        document.getElementById('register').disabled = false;
    }

}

    </script>
</body>
</html>