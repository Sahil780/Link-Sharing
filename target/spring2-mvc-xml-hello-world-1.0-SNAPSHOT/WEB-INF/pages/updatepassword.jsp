<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
<script type="text/javascript">

    $("#submitdata").click(function () {
        var password=$("#userpassword").val();
        var confirmpassword=$("#confirm_password").val();
        if(password==confirmpassword)
        {
            $("#updatePasswordForm").ajaxForm({
                success:function (msg) {
                    alert(msg);

                },
                error:function (msg) {
                    alert(msg);

                }
            });
        }
        else
        {
            alert("confirm password did not matched");
        }
    });

</script>

<ul class="list-group">
    <li class="list-group-item" style="background:#000078">Login</li>
    <li class="list-group-item" style="background-color: #F5F5F5;">
        <form action="/updatePassword" id="updatePasswordForm" method="post">
            <div class="form-group">
                <label for="userpassword">Password</label>
                <input type="text" required="required" name="password" class="form-control" id="userpassword"  placeholder="Enter username " style="background-color: 	#FAF0E6">
                ${errormessage}
            </div>
            <div class="form-group">
                <label for="confirmpwd">Confirm Password*</label>
                <input type="password" required="required" name="confirmpassword" class="form-control" id="confirmpwd" placeholder="Enter password" style="background-color: 	#FAF0E6">
            </div>
            <div class="checkbox">

                <button type="submit" class="btn btn-primary" id="submitdata" style="float:right">Submit</button>
            </div>
        </form>
    </li>
</ul>