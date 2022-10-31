

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add a new book</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script
        type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link rel="icon" href="image/logo.png">
        <link href="css/style_signupUser.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- //web font -->
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="javascript.js"></script>    </head>
    <body>
        <!-- n -->
        <div class="main-w3layouts wrapper">
            <a href="DetailBook"><img src="image/back_..png" alt="button back" style="position: relative; width: 50px; left: 1%;"></a>
            <h1><u>Add a new book</u></h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form action="InsertBook" method="post">
                        <input class="text email" type="text" name="img" placeholder="img" required="">
                        <input class="text email" type="text" name="book_name" placeholder="book_name" required="">
                        <input class="text email" type="text" name="author" placeholder="author" required="">
                        <input class="text email" type="text" name="language" placeholder="language" required="">
                        <input class="text email" type="text" name="type" placeholder="type" required="">
                        <input class="text email" type="text" name="publisher" placeholder="publisher" required="">
                        <input class="text email" type="text" name="publishing_year" placeholder="publishing_year" required="">
                        <input class="text email" type="text" name="amount" placeholder="amount" required="">

                        <input type="submit" value="ADD BOOK">
                    </form>
                    <p>View all available books!!!<a href="DetailBook"> View</a></p>
                </div>
                <!-- //copyright -->
                <ul class="colorlib-bubbles">
                    <li></li>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <p>© 2018 Libary Signup Form. </p>
            </div>
            <!-- //copyright -->
            <ul class="colorlib-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <!-- //main -->    </body>
</html>
