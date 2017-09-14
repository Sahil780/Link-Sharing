
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
<script type="text/javascript">

    $("#validateform").ajaxForm({
        success:function (msg) {
            alert(msg);

        },
        error:function (msg) {
            alert(msg);

        }
    });
</script>

<ul class="list-group" >
    <li class="list-group-item" style="background:#000078">Register</li>
    <li class="list-group-item" style="background-color:#F5F5F5;">
        <form action="/updateUserProfile" id="validateform" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="firstname">First name*</label>
                <input type="text" required="required" class="form-control" id="firstname" name="firstname" placeholder="FIRST NAME" style="background-color:	#FAF0E6;">
            </div>
            <div class="form-group">
                <label for="lastname">Last name*</label>
                <input type="text" required="required" class="form-control" id="lastname" name="lastname" placeholder="LAST NAME" style="background-color:	#FAF0E6;">
            </div>

            <div class="form-group">
                <label for="username">User name</label>
                <input type="text" required="required" class="form-control" id="username" name="username" placeholder="USER NAME "  style="background-color:	#FAF0E6;">
            </div>

            <div class="form-group">
                <label>Photo*</label><input  name="fileupload" type="file"><i>Browse</i>


            </div>


            <div class="checkbox">
                <button type="submit" class="btn btn-primary" style="float:right;margin-top:-35px; ">Update</button>
            </div>
        </form>
    </li>
</ul>