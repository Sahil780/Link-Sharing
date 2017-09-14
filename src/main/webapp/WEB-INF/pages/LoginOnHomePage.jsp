<ul class="list-group">
    <li class="list-group-item" style="background:dimgray">Login</li>
    <li class="list-group-item">
        <form action="/loginProcess" method="post">
            <div class="form-group">
                <label for="useremail">Username*</label>
                <input type="text" required="required" name="username" class="form-control" id="useremail"  placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="pwd">Password*</label>
                <input type="password" required="required" name="password" class="form-control" id="pwd" placeholder="Enter password">
            </div>
            <div class="checkbox">

                <button type="submit" class="btn btn-primary" style="float:right">Submit</button>
            </div>
        </form>
        <a class="btn" role="button" data-toggle="modal"
           data-target="#SendOtpModel">Forgot password</a>
    </li>
</ul>
<div class="modal fade" id="SendOtpModel" tabindex="-1" role="dialog"
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
                <h4 class="modal-title" id="Sendotp">
                    OTP REQUEST
                </h4>
            </div>

            <!-- Modal Body -->
            <div class="modal-body">
                <form action="/sendverificationcode" id="SendOTPForm" method="post">
                    <div class="form-group">
                        <label for="EmailOfUser">Email *</label>
                        <input class="form-control" placeholder="Enter Your Email To Reset Your Password "  id="EmailOfUser" name="useremailid"  required/>
                    </div>
                    <button type="submit" class="btn btn-default" id="sendverificationcode" style="border:1px solid black;">Submit</button>
                </form>
                <form action="/updatepassword" id="updatePasswordForm" method="post">
                    <div class="form-group">
                        <label for="EmailToReset">Email *</label>
                        <input class="form-control" placeholder="Enter Your Email To Reset Your Password"  id="EmailToReset" name="email"  required/>
                    </div>
                    <div class="form-group">
                    <label for="pass">New Password *</label>
                    <input class="form-control" placeholder="Enter New Password"  id="pass" name="password"  required/>
                </div>
                    <div class="form-group">
                        <label for="confirmpass">Confirm Password *</label>
                        <input class="form-control" placeholder="Enter Confirm Password"  id="confirmpass" name="confirmpassword"  required/>
                    </div>
                    <div class="form-group">
                        <label for="verificationcode">Confirm Password *</label>
                        <input class="form-control" type="text" placeholder="Enter Verification Code"  id="verificationcode" name="verificationcode"  required/>
                    </div>
                    <button type="submit" class="btn btn-default" id="updatePassword" style="border:1px solid black;">Submit</button>

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