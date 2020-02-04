<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/17/15
 * Time: 12:24 AM
 */
session_start();
require_once 'commons.php';
if ( ! isset( $_SESSION['sessionID'] ) ) {
	header( "Location: logout.php" );
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>My Notifications</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="assets/css/facebook.css" rel="stylesheet">

    <!-- Java Script -->
    <script type="application/javascript">
        var form = document.getElementById("uploader_form"),
            button = document.getElementById("upload_button");

        function submitForm() {

            var form = document.getElementById("uploader_form"),
                button = document.getElementById("upload_button"),
                file = document.getElementById("file_chooser");
            if (file.value != "")
                form.submit();
            else
                window.alert("Please choose a file.");
        }

    </script>
    <!-- end java script -->
</head>

<body>

<div class="wrapper">
    <div class="box">
        <div class="row row-offcanvas row-offcanvas-left">

            <!-- sidebar -->
            <div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">


                <ul class="nav">
                    <li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i
                                    class="glyphicon glyphicon-chevron-right"></i></a></li>
                </ul>

                <ul class="nav hidden-xs" id="lg-menu">
                    <li><a href="categories.php"><i class="glyphicon glyphicon-list"></i> Categories</a></li>
                    <li><a href="topics.php"><i class="glyphicon glyphicon-list"></i> Topics</a></li>
                    <li><a href="notes.php"><i class="glyphicon glyphicon-list"></i> Notes</a></li>
                </ul>

                <!-- tiny only nav-->
                <ul class="nav visible-xs" id="xs-menu">
                    <li><a href="categories.php" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
                    <li><a href="topics.php" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
                    <li><a href="notes.php" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
                </ul>

            </div>
            <!-- /sidebar -->

            <!-- main right col -->
            <div class="column col-sm-10 col-xs-11" id="main">

                <!-- top nav -->
                <div class="navbar navbar-blue navbar-static-top">
                    <div class="navbar-header">
                        <button class="navbar-toggle" type="button" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="sr-only">Toggle</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="http://usebootstrap.com/theme/facebook" class="navbar-brand logo">b</a>
                    </div>
                    <nav class="collapse navbar-collapse" role="navigation">
                        <form class="navbar-form navbar-left">
                            <div class="input-group input-group-sm" style="max-width:500px;">
                                <input class="form-control" placeholder="Search" name="srch-term" id="srch-term"
                                       type="text">

                                <div class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><i
                                                class="glyphicon glyphicon-search"></i></button>
                                </div>
                            </div>
                        </form>
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="#postModal" role="button" data-toggle="modal"><i
                                            class="glyphicon glyphicon-plus"></i> Upload</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                            class="glyphicon glyphicon-user"></i></a>
                                <ul class="dropdown-menu">
                                    <li><a href="logout.php">logout</a></li>

                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <!-- /top nav -->

                <div class="padding">
                    <div class="full col-sm-9">

                        <!-- content -->
                        <div class="row">

                            <!-- main col left -->
                            <div class="col-sm-12">
								<?php
								/**
								 * Created by PhpStorm.
								 * User: root
								 * Date: 11/14/15
								 * Time: 6:23 PM
								 * Time: 6:23 PM
								 */

								require "databaseAndFunctions.php";

								if ( ! isset( $_GET['srch-term'] ) ) {
									if ( isset( $_POST['note_id'] ) || isset( $_SESSION['last_post']['note_id'] ) ) {
										if ( isset( $_POST['note_id'] ) ) {
											$_SESSION['last_post'] = $_POST;
											$id                    = $_SESSION['last_post']['note_id'];
										} else {
											$id = $_SESSION['last_post']['note_id'];
										}
										
										$sql    = "select * from `file_info` WHERE `note_id` = '$id' AND `user_id` = '$user_id' ORDER BY `time` ASC ";
										
										$result = mysqli_query( $DB, $sql );
										if ( $result ) {
											while ( $row = mysqli_fetch_array( $result ) ) {
												$name      = $id . "_" . $row['file_id'] . "_" . $row['name'];
												$file_name = $row['name'];
												$link      = $row['file_link'];

												echo <<< t
                                <div class="panel panel-default text-center" style="width: 100%">
                                    <h3 class="h3">$file_name</h3>
                                    <div class="panel-thumbnail" align="middle"><img src="$link"
                                                                                     class="img-responsive">
                                    </div>
                                    <div>
                                        <!-- Add any text details like uploader name later -->
                                        <a href="$link" download="$name">Click to download the file</a>
                                    </div>
                                </div>
t;
											}
										} else {
											echo <<< t
                                <div class="panel panel-default" style="width: 100%">
                                    <div class="panel-body">
                                        <!-- Add any text details like uploader name later -->
                                        <p>No files available do upload.</p>
                                    </div>
                                </div>
t;
										}
									}
								} else {
									$sql    = "select * from `file_info` WHERE `name` like  '%" . $_GET['srch-term'] . "%' AND `user_id` = '$user_id' ORDER BY `time` ASC ";
									echo $sql;
									$result = mysqli_query( $DB, $sql );
									if ( $result ) {
										while ( $row = mysqli_fetch_array( $result ) ) {
											$name      = $id . "_" . $row['file_id'] . "_" . $row['name'];
											$file_name = $row['name'];
											$link      = $row['file_link'];

											echo <<< t
                                <div class="panel panel-default text-center" style="width: 100%">
                                    <h3 class="h3">$file_name</h3>
                                    <div class="panel-thumbnail" align="middle"><img src="$link"
                                                                                     class="img-responsive">
                                    </div>
                                    <div>
                                        <!-- Add any text details like uploader name later -->
                                        <a href="$link" download="$name">Click to download the file</a>
                                    </div>
                                </div>
t;
										}
									} else {
										echo <<< t
                                <div class="panel panel-default" style="width: 100%">
                                    <div class="panel-body">
                                        <!-- Add any text details like uploader name later -->
                                        <p>No files available do upload.</p>
                                    </div>
                                </div>
t;
									}
								}

								?>


                            </div><!--/row-->

                            <hr>


                        </div><!-- /col-9 -->
                    </div><!-- /padding -->
                </div>
                <!-- /main -->

            </div>
        </div>
    </div>


    <!--post modal-->
    <div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                    Upload a file
                </div>
                <div class="modal-body">
                    <!-- Form for uploading file -->
                    <form id="uploader_form" class="form center-block" method="post" enctype="multipart/form-data"
                          action="upload.php">
                        <div class="form-group">
                            <input id="file_chooser" type="file" name="file" value="Select an image"
                                   accept="*/*"
                                   style="background: transparent; ">
                            <input type="hidden" name="note_id"
                                   value="<?php
							       if ( isset( $_POST['note_id'] ) ) {
								       echo $_POST['note_id'];
							       } else if ( isset( $_SESSION['last_post']['note_id'] ) ) {
								       echo $_SESSION['last_post']['note_id'];
							       } else {
								       echo 0;
							       } ?>">
                        </div>
                    </form>
                    <!-- END Form for uploading file -->
                </div>
                <div class="modal-footer">
                    <div>
                        <button id="upload_button" class="btn btn-primary btn-sm" data-dismiss="modal"
                                aria-hidden="true" onclick="submitForm();">
                            Upload
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('[data-toggle=offcanvas]').click(function () {
                $(this).toggleClass('visible-xs text-center');
                $(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
                $('.row-offcanvas').toggleClass('active');
                $('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
                $('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
                $('#btnShow').toggle();
            });
        });
    </script>
</body>
</html>