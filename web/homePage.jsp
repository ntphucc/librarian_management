
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
    <head>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page FPT Library</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./fontawesome/css/all.min.css">
        <link rel="stylesheet" href="./css/stylehome.css">
        <link rel="icon" href="./img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <!--Page Loader--> 
        <div id="loader-wrapper">
            <div id="loader"></div>

            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="home">
                    <img src="img/logo.png" alt="" class="fas fa-film mr-2" style=" height:50px;">

                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto mb-2 mb-lg-0">

                        <li class="nav-item">
                            <a class="nav-link nav-link-1 active" aria-current="page" href="home">Home</a>
                        </li>
                        <c:if test="${sessionScope.name.role !=1}">
                            <li class="nav-item">
                                <a class="nav-link nav-link-2" href="print">Cart</a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <a class="nav-link nav-link-3" href="about.jsp">About</a>
                        </li>
                        <c:if test="${sessionScope.name.role ==1}">
                            <li class="nav-item">
                                <a class="nav-link nav-link-4" href="MO_ShowBorrow_C">Manage Order</a>
                            </li>
                        </c:if >
                        <c:if test="${sessionScope.name.role ==1 }">
                            <li class="nav-item">
                                <a class="nav-link nav-link-5" href="DetailBook">Manage Book</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.name==null}">
                            <li class="nav-item">                            
                                <a class="nav-link nav-link-6" href="login_signUp.jsp">Login</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.name !=null}">
                            <li class="nav-item">
                                <a class="nav-link nav-link-7" href="updateProfile?id=${sessionScope.name.id}"><i class="fa-regular fa-user"></i></a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.name!=null}">
                            <li class="nav-item mx-2">
                                <a href="LogoutControl" class="nav-link ps-2 cursor-pointer">Logout</a>
                            </li>
                        </c:if >
                    </ul>
                </div>
            </div>
        </nav>
        <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="img/background.jpg">
            <form class="d-flex tm-search-form" action="SearchControl" method="get">
                <input class="form-control tm-search-input" id="lookingfor" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-success tm-search-btn" type="submit">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>

        <div class="container-fluid tm-container-content tm-mt-60">

            <!-- Button Float Right Side -->


            <a href="#contact"> <img class="contact" src="img/call.png" alt=""></a>
            <a href="#lookingfor" > <img class="lookingfor" src="img/lookingfor.png" alt=""></a>

            <!-- Button Float Right Bottom Side -->

            <a href="cart"><img class="register" src="img/edit.png" alt=""><p class="register-1">  Register to borrow books</p> </a>
                <c:if test="${list==null}">
                <div class="row mb-12">
                    <h2 class="col-12 tm-text-primary" style="text-align: center">
                        There Are No Book Available.
                    </h2>
                </div>
            </c:if >            
            <c:if test="${list!=null}">
                <div class="row mb-4">
                    <h2 class="col-6 tm-text-primary">
                        Book Available
                    </h2>

                </div>

                <div class="row">
                    <c:forEach items="${list}" var="o">
                        <div class="col-12 col-md-6 col-lg-4 ">
                            <div class="card" >
                                <img class="card-img-top" src="${o.image}" alt="Card image cap" style="width: 100%; height: 700px;">
                                <div class="card-body">
                                    <h4 class="card-title show_txt"><a href="detail?bid=${o.id}" title="View Product">${o.name}</a></h4>
                                    <p class="card-text show_txt">${o.author}</p>
                                    <div class="row">

                                        <div class="col">
                                            <a href="detail?bid=${o.id}" class="btn btn-success btn-block">View Book</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row tm-mb-90">

                </div>
            </c:if>
        </div> <!-- container-fluid, tm-container-content -->

        <footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
            <div class="container-fluid tm-container-small">
                <div class="row">
                    <div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title">About FPT Library</h3>
                        <p><a rel="sponsored" href="https://v5.getbootstrap.com/">FPT</a> Officially established on September 8, 2006 under the Prime Minister's Decision, FPT University became the first university in Vietnam established by an enterprise with 100% investment capital from the Corporation.</p>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title" id="contact">Contact</h3>
                        <ul class="tm-footer-links pl-0">
                            <li><a href="cart">Cart</a></li>
                            <li><a href="#">Support</a></li>
                            <li><a href="about.jsp">About Us</a></li>
                            <li><a href="#contact">Contact</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                        <ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
                            <li class="mb-2"><a href="https://facebook.com"><i class="fab fa-facebook"></i></a></li>
                            <li class="mb-2"><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
                            <li class="mb-2"><a href="https://instagram.com"><i class="fab fa-instagram"></i></a></li>
                            <li class="mb-2"><a href="https://pinterest.com"><i class="fab fa-pinterest"></i></a></li>
                        </ul>
                        <a href="#" class="tm-text-gray text-right d-block mb-2">Terms of Use</a>
                        <a href="#" class="tm-text-gray text-right d-block">Privacy Policy</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 col-md-7 col-12 px-5 mb-3">
                        Copyright 2022 FPT Company. All rights reserved .
                    </div>
                    <div class="col-lg-4 col-md-5 col-12 px-5 text-right">
                        Designed by <a href="https://templatemo.com" class="tm-text-gray" rel="sponsored" target="_parent">Taind and Group2</a>
                    </div>
                </div>
            </div>
        </footer>

        <script src="js/plugins.js"></script>
        <script>
            $(window).on("load", function () {
                $('body').addClass('loaded');
            });
        </script>
    </body>
</html>
