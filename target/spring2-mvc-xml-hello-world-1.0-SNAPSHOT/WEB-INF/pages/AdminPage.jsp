<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <ul class="list-group">
        <li class="list-group-item" style="background:dimgray;height:45px">
            <div class="top">
                <h4 style="margin:0%;padding:0%">Top Posts</h4>
                <div class="form-group">
                    <select class="form-control" id="sel1" style="width:105px;margin-top: -22px;margin-left:400px;">
                        <option>All Users</option>
                        <option>Active</option>
                        <option>Inactive</option>
                    </select>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Active</th>
                    <th>Manage</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Sahil</td>
                    <td>sahil@example.com</td>
                    <td>Sahil</td>
                    <td>Verma</td>
                    <td>Yes</td>
                    <td>Activate</td>
                </tr>
                </tbody>
            </table>
        </li>
    </ul>
    </ul>
</div>
</div>
</body>
</html>