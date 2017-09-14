<ul class="list-group">
    <li class="list-group-item" style="background:dimgray">Register</li>
    <li class="list-group-item">
        <span id="status"></span>
        <form action="/registrationprocess" id="validateform" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="firstname">First name*</label>
                <input type="text" required="required" class="form-control" id="firstname" name="firstname"  placeholder="FIRST NAME">
            </div>
            <div class="form-group">
                <label for="lastname">Last name*</label>
                <input type="text" required="required" class="form-control" id="lastname" name="lastname" placeholder="LAST NAME">
            </div>
            <div class="form-group">
                <label for="mail">Email*</label>
                <input type="email" required="required" class="form-control" id="mail" name="email" onkeyup="checkemail()" placeholder="Enter email" data-error="Please give valid email">
            </div>
            <div class="form-group">
                <label for="username">User name</label>
                <input type="text" required="required" class="form-control" id="username" name="username" onkeyup="checkusername()" placeholder="USER NAME">
            </div>
            <div class="form-group">
                <label for="password">Password*</label>
                <input type="password" required="required" class="form-control" id="password" name="password" onkeyup="confirmpassword()" placeholder="Enter password">
            </div>
            <div class="form-group">
                <label for="passwordconfirm">Confirm password*</label>
                <input type="password" name="passwordconfirm" class="form-control" id="passwordconfirm" onkeyup="confirmpassword()" placeholder="Enter password">
            </div>
            <div>
                <label>Photo*</label><input name="fileupload" type="file"><i></i>
            </div>
            <div class="checkbox">
                <button type="submit" class="btn btn-primary" id="register" style="float:right;margin-top: -35px;">Submit</button>
            </div>
        </form>
    </li>
</ul>