

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/loginSignupStyle.css">
</head>
<body>
    <div class="hero">
        <div class="form-box">
            <div class="button-box">
                <div id="btn"></div>
                <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                <button type="button" class="toggle-btn" onclick="register()">Register</button>
            </div>
            <div class="social-icons">
                <img src="./image/book.png">                
            </div>
            <form id="login" action="login" class="input-group">
                <p class="text-danger">
                    ${mess}
                </p>
                <input name="username" type="text" class="input-field" placeholder="User Id" required>
                <input name ="password" type="password" class="input-field" placeholder="Enter Password" required>
                <div class="link link_1"><a href="#"><p>Forgot password</p></a></div>
                <button type="submit" class="submit-btn">Log in</button>
            </form>
            <form id="register" action="signUp" class="input-group" method="Post">
                <input name="username" type="text" class="input-field" placeholder="User Id" required>
                <input name="mail" type="text" class="input-field" placeholder="Email" required>
                <input name="password" type="password" class="input-field" placeholder="Enter Password" required>
                <input name="confrim" type="password" class="input-field" placeholder="Confirm Password" required>
                <input type="checkbox" class="chech-box"><span>I agree to the terms & consitions</span>
                <button type="submit" class="submit-btn">Sign up</button>
            </form>
        </div>
    </div>
    <script>
        var x =  document.getElementById("login");
        var y = document.getElementById("register");
        var z = document.getElementById("btn");
        function register(){
            x.style.left = "-400px";
            y.style.left= "50px";
            z.style.left = "110px";
        }
        function login(){
            x.style.left = "50px";
            y.style.left= "450px";
            z.style.left = "0px";
        }
    </script>
</body>
</html>

