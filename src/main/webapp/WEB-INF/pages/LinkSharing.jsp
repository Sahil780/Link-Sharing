<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring MVC Autocomplete with JQuery &amp; JSON example</title>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
    <script src="<c:url value="/resources/jquery.autocomplete.min.js" />"></script>
        <script type="text/javascript">// <![CDATA[
            function inputFocus(i){
                if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
            }
        function inputBlur(i){
            if(i.value==""){ i.value=i.defaultValue; i.style.color="#848484"; }
        }

            function onInput() {
                var val = document.getElementById("input").value;
                // An item was selected from the list!
                // yourCallbackHere()
                if (val == '') {

                }
                else {

                alert(val);
                window.location.href = "showtopicpage?val=" + val;
            }
                }

    </script>
    <style>
        #user
        {
            color: whitesmoke;
            font-size: 1px;
        }
        .autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
        .autocomplete-suggestion { padding: 5px 5px; white-space: nowrap; overflow: hidden; font-size:22px}
        .autocomplete-selected { background: #F0F0F0; }
        .autocomplete-suggestions strong { font-weight: bold; color: #3399FF; }
    </style>
</head>
<body>
<h2>create topic</h2>
<br>
<form action="createtopic" method="post">
    <input type="text" name="name">
      <select name="visibililty" >
        <option value="Private">private</option>
        <option value="Public">public</option>
    </select>
    <input type="submit" value="create">
</form>
<h2> search topic </h2>
<br>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<div id="find_keyword">

    <div class="ui-widget">
        <input id="tagQuery" type="text" name="tagQuery"  onFocus="inputFocus(this)" onBlur="inputBlur(this)">
    </div>
</div>
    <%--<div class="autocomplete-suggestion autocomplete-selected"></div>--%
    <%--<div class="autocomplete-suggestion"></div>--%>
<datalist id='dlist' style="font-size: 2px; ">

</datalist>
<hr>
<h3>create Linked resource</h3>
<br>
<form action="/createLinkedResource" method="post">
    link : <input type="text" name="url">
    <br><br>
    Description* <textarea name="description"></textarea>
   Topic : <input type="text"  id="linktopicinput" list="topiclistforlinkedresource" name="topicname">
   <datalist id="topiclistforlinkedresource"></datalist>
    <input type="submit" value="create">
</form>
<h3>create Document resource</h3>
<br>
<form action="/createDocumentResource" enctype="multipart/form-data" method="post">
    Document : <input type="file" name="file">
    <br><br>
    Description* <textarea name="description"></textarea>
    Topic : <input type="text" id="documenttopicinput"  list="topiclistfordocumentedresource" name="topicname">
    <datalist id="topiclistfordocumentedresource"></datalist>
    <input type="submit" value="create">
</form>
<hr>
<h3>send verification code and update password</h3>
<br><br>
<form action="/sendverificationcode" method="post" id="sendverificationcodeform">
    <input type="email" name="useremailid">
    <input type="submit" value="sendverificationcode">
</form>
<h3>update password </h3>
<br><br>
<form action="/updatepassword" method="post" id="updatepasswordform">
    <input type="email" name="email">
    <input type="password" name="password">
    <input type="password" name="confirmpassword">
    <input type="text" name="verificationcode">
    <input type="submit" value="upadate password">
</form>
</body>
<script>

////////////   search for topic  ///////////////

$(document).ready(function() {
    //attach autocomplete
    $("#tagQuery").autocomplete({
        minLength: 1,
        delay: 500,
        type:"GET",
        //define callback to format results
        source: function (request, response) {
            $.getJSON("/findpublictopic", request, function(result) {
                response($.map(result, function(item) {
                    return {
                        // following property gets displayed in drop down
                        label: item[0]+"^^"+item[1],
                        // following property gets entered in the textbox
                        value: item[0]+"^^" +
                        ""+item[1],
                        // following property is added for our own use
                        tag_url:"/showtopicpage?val=" +item[0]+"-"+item[1]
                    }
                }));
            });
        },

        //define select handler
        select : function(event, ui) {
            if (ui.item) {
                window.location.href=ui.item.tag_url;
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



//        $("#input").keyup(function () {
//            var val = this.value;
//            $("#dlist").html('');
//            $.ajax({
//                url: "findpublictopic",
//                method: "GET",
//                data: {term: val},
//                success: function (response) {
//                    $.each(response, function (i, v) {
//                        $("#dlist").append('<option>'+v[0]+"-"+v[1]+'</option>');
//                    });
//                }
//            });
////            if ($('#dlist option').filter(function () {
////                    return this.value === val;
////                }).length) {
////                //send ajax request
////                alert(this.value);
////            }
//        });

    /////////// for creating linkedresource for a particular topic /////////////

    $("#linktopicinput").keyup(function () {
        var val = this.value;
        $("#topiclistforlinkedresource").html('');
        $.ajax({
            url: "findpublictopic",
            method: "GET",
            data: {term: val},
            success: function (response) {
                $.each(response, function (i, v) {
                    $("#topiclistforlinkedresource").append('<option>'+v[0]+"-"+v[1]+'</option>');
                });
            }
        });
//            if ($('#dlist option').filter(function () {
//                    return this.value === val;
//                }).length) {
//                //send ajax request
//                alert(this.value);
//            }
    });

    /////////////   for creating documentedresource for a particular topic   ////////////

    $("#documenttopicinput").keyup(function () {
        var val = this.value;
        $("#topiclistfordocumentedresource").html('');
        $.ajax({
            url: "findpublictopic",
            method: "GET",
            data: {term: val},
            success: function (response) {
                $.each(response, function (i, v) {
                    $("#topiclistfordocumentedresource").append('<option>'+v[0]+"-"+v[1]+'</option>');
                });
            }
        });
//            if ($('#dlist option').filter(function () {
//                    return this.value === val;
//                }).length) {
//                //send ajax request
//                alert(this.value);
//            }
    });


    //////////   send verification code form through ajax ////////


    $('#sendverificationcodeform').ajaxForm({
        success: function(msg) {
            alert(msg);
        },
        error: function(msg) {
            alert(msg);
        }
    });



    /////////// send updatepassword form through ajax  ////////


    $('#updatepasswordform').ajaxForm({
        success: function(msg) {
            alert(msg);
        },
        error: function(msg) {
            alert(msg);
        }
    });

</script>

</html>