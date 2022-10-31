
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
        <link rel="stylesheet" href="./css/stylemytable.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="icon" href="img/logo.png">

    </head>
    <body>
        <!--        Page Loader -->
        <div id="loader-wrapper">
            <div id="loader"></div>

            <div class="loader-section section-left"></div>
            <div class="loader-section section-right"></div>

        </div>
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="home">
                    <img src="img/logo.png" alt="" class="fas fa-film mr-2" style=" height:50px;">
                    FPT Library
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

        <hr>
        <div>
            <!--        code from here-->
            <c:if test="${list==null}">
                <div class="row mb-12">
                    <h2 class="col-12 tm-text-primary" style="text-align: center">
                        There Are No Book Available.
                    </h2>
                </div>
            </c:if >            
            <c:if test="${list!=null}">
                <main>
                    <div class="table" style="padding: 0px 30px 0px 30px;">
                        <div class="table_header">
                            Book Information
                            <a href="insertBook.jsp"><button type="submit" class="btn btn-outline-primary">Add new book</button></a>
                        </div>
                        <div class="header_fixed">
                            <table>
                                <thead>
                                    <tr>
                                        <th style="border: 1px solid black;text-align: center;">ID</th>
                                        <th style="border: 1px solid black;text-align: center;">IMAGE</th>
                                        <th style="border: 1px solid black;text-align: center;">NAME</th>
                                        <th style="border: 1px solid black;text-align: center;">AUTHOR</th>
                                        <th style="border: 1px solid black;text-align: center;">LANGUAGE</th>
                                        <th style="border: 1px solid black;text-align: center;">TYPE</th>

                                        <th style="border: 1px solid black;text-align: center;">PUBLISHER</th>
                                        <th style="border: 1px solid black;text-align: center;">AMOUNT</th> 

                                        <th style="border: 1px solid black;padding: 0 15px; text-align: center;">PUBLISHING YEAR</th>
                                        <th style="border: 1px solid black;padding: 0 15px; text-align: center;">MANAGE</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${listB}" var="o">
                                    <tr style="border: 1px solid black;" >
                                        <td style="text-align: center;">${o.id}</td>                                        
                                        <td style="text-align: center;"><img src="${o.image}" style="width: 100px;"></td>
                                        <td style="text-align: center;">${o.name}</td>
                                        <td style="text-align: center;">${o.author}</td>
                                        <td style="text-align: center;">${o.language}</td>
                                        <td style="text-align: center;">${o.type}</td>
                                        <td style="text-align: center;">${o.publisher}</td>
                                        <td style="text-align: center;">${o.publishing_year}</td>
                                        <td style="text-align: center;">${o.amount}</td>
                                        <td>
                                            <a href="update?bid=${o.id}"><button type="submit" class="btn btn-outline-primary" >Update</button></a> <br>
                                            <a href="#"><button class="btn btn-outline-primary" onclick="JSDelete(${o.id})" style="width: 100%;">Delete</button></a>
                                            <!--<li><a class="dropdown-item" onclick="return JSDelete()">Delete</a></li>-->
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </main>
            </c:if >
            <!--        code sau dòng này tao quánh bỏ bữa ah-->        
        </div>
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

        <script type="text/javascript">
                                                function JSalert() {
                                                    swal({
                                                        title: "Are you sure?",
                                                        text: "Do you really want to log out this book? Click OK to log out.",
                                                        buttons: true,
                                                    })
                                                            .then((willDelete) => {
                                                                if (willDelete) {
                                                                    window.location.href = "firstpage.jsp";
                                                                } else {
                                                                    swal("You still stay in the PR library!");
                                                                }
                                                            });
                                                }

                                                function JSDelete(id) {
                                                    swal({
                                                        title: "Are you sure?",
                                                        text: "Once deleted, you will not be able to recover this imaginary file!",
                                                        icon: "warning",
                                                        buttons: true,
                                                        dangerMode: true,
                                                    })
                                                            .then((willDelete) => {
                                                                if (willDelete) {
                                                                    swal("Poof! Your imaginary file has been deleted!", {
                                                                        icon: "success",
                                                                    });
                                                                    var req = new XMLHttpRequest();
                                                                    req.open("GET", "delete?bid=" + id, true);
                                                                    req.send(null);
                                                                    window.location.href = "http://localhost:8080/Projectnew/DetailBook";
                                                                } else {
                                                                    swal("Your imaginary file is safe!");
                                                                }
                                                            });

                                                }

                                                $(window).on("load", function () {
                                                    $('body').addClass('loaded');
                                                });
        </script>
        <script>
            $(window).on("load", function () {
                $('body').addClass('loaded');
            });
        </script>
    </body>
</html>
