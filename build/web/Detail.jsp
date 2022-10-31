
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Book detail</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link rel="icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>
        <!-- Page Loader -->
        <div id="loader-wrapper">
            <div id="loader"></div>

            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="home">

                    <img src="img/logo.png" alt="" class="fas fa-film mr-2" style="height:50px; ">
                </a>
                   
                <button
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

        <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="img/Cover_page.jpg">

        </div>

        <div class="container-fluid tm-container-content tm-mt-60">
            <div class="row mb-4">
                <h2 class="col-12 tm-text-primary">${detail.name}</h2>
            </div>
            <div class="row tm-mb-90" style="" >            
                <div class="col-xl-8 col-lg-7 col-md-6 col-sm-12" style="display:flex;align-items:center;justify-content: center;">
                    <img src="${detail.image}" alt="Image" class="img-fluid" style="width:50%;">
                </div>
                <div class="col-xl-4 col-lg-5 col-md-6 col-sm-12">
                    <div class="tm-bg-gray tm-video-details">

                        <div class="text-center mb-5">
                            <a href="cart?id=${detail.id}" class="btn btn-primary tm-btn-big">Borrow</a>
                        </div>                    
                        <div class="mb-4 d-flex flex-wrap">
                            <div class="mr-4 mb-2">
                                <span class="tm-text-gray-dark">Author: </span><span class="tm-text-primary">${detail.author}</span>
                            </div>
                            <div class="mr-4 mb-2">
                                <span class="tm-text-gray-dark">Language: </span><span class="tm-text-primary">${detail.language}</span>
                            </div>
                            <div class="mr-4 mb-2">
                                <span class="tm-text-gray-dark">Type: </span><span class="tm-text-primary">${detail.type}</span>
                            </div>
                            <div class="mr-4 mb-2">
                                <span class="tm-text-gray-dark">Publisher: </span><span class="tm-text-primary">${detail.publisher}</span>
                            </div>
                            <div class="mr-4 mb-2">
                                <span class="tm-text-gray-dark">Amount: </span><span class="tm-text-primary">${detail.amount}</span>
                            </div>
                        </div>
                        <div class="mb-4">
                            <h3 class="tm-text-gray-dark mb-3">License</h3>
                            <p>Free for both personal and commercial use. No need to pay anything. No need to make any attribution.</p>
                        </div>
                        <div>
                            <h3 class="tm-text-gray-dark mb-3">Tags</h3>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Cloud</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Bluesky</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Nature</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Background</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Timelapse</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Night</a>
                            <a href="#" class="tm-text-primary mr-4 mb-2 d-inline-block">Real Estate</a>
                        </div>
                    </div>
                </div>
            </div>

        </div> <!-- container-fluid, tm-container-content -->

        <footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
            <div class="container-fluid tm-container-small">
                <div class="row">
                    <div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title">About Catalog-Z</h3>
                        <p>Integer ipsum odio, pharetra ac massa ac, pretium facilisis nibh. Donec lobortis consectetur molestie. Nullam nec diam dolor. Fusce quis viverra nunc, sit amet varius sapien.</p>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                        <h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
                        <ul class="tm-footer-links pl-0">
                            <li><a href="#">Advertise</a></li>
                            <li><a href="#">Support</a></li>
                            <li><a href="#">Our Company</a></li>
                            <li><a href="#">Contact</a></li>
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
                        Copyright 2020 Catalog-Z Company. All rights reserved.
                    </div>
                    <div class="col-lg-4 col-md-5 col-12 px-5 text-right">
                        Designed by <a href="https://templatemo.com" class="tm-text-gray" rel="sponsored" target="_parent">TemplateMo</a>
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