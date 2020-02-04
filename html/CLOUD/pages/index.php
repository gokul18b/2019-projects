<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <?php
    session_start();
    if (!isset($_SESSION['userId']) && !isset($_SESSION['sessionID'])) {
        echo '<script type="text/javascript">location.href = "index.html";</script>';
    }
    ?>

    <title>My School</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <?php
            echo '<a class="navbar-brand" href="index.php">Welcome to MySchool, ' . $_SESSION['userName'] . '</a>';
            ?>
        </div>
    </nav>
    <!-- /.navbar-header -->
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                New Post.
            </div>
        </div>
    </div>
</div>
<div class="panel-body">
    <div class="col-lg-6">
        <form role="form" action="send_message.php" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input class="form-control" placeholder="Name" name="name" type="text" autofocus>
            </div>
            <div class="form-group">
                <input class="form-control" placeholder="Title" name="title" type="text" autofocus>
            </div>
            <div class="form-group">
                <input class="form-control" placeholder="Message" name="message" type="text" autofocus>
            </div>
            <div class="form-group">
                <input name="image" type="file" size="50">
            </div>
            <button type="submit" class="btn btn-outline btn-primary">Send Message</button>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                New Image.
            </div>
        </div>
    </div>
</div>
<div class="panel-body">
    <div class="col-lg-6">
        <form role="form" action="send_image.php" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input class="form-control" placeholder="Name" name="name" type="text" autofocus>
            </div>
            <div class="form-group">
                <input class="form-control" placeholder="Image Title" name="title" type="text" autofocus>
            </div>
            <div class="form-group">
                <input type="file" name="image" size="50">
            </div>
            <button type="submit" class="btn btn-outline btn-primary">Send Message</button>
        </form>
    </div>
</div>
</body>


</html>