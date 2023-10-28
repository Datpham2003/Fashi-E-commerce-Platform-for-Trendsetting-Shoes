<%-- 
    Document   : Tracking.jsp
    Created on : Oct 19, 2023, 10:43:07 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card border-top border-bottom border-3" style="border-color: #f37a27 !important;">
                            <div class="card-body p-5">

                                <p class="lead fw-bold mb-5" style="color: #f37a27;">Purchase Reciept</p>
                                
                                <div class="row">
                                    <div class="col mb-3">
                                        <p class="small text-muted mb-1">Date</p>
                                        <p>10 April 2021</p>
                                    </div>
                                    <div class="col mb-3">
                                        <p class="small text-muted mb-1">Order No.</p>
                                        <p>012j1gvs356c</p>
                                    </div>
                                </div>

                                <div class="mx-n5 px-5 py-4" style="background-color: #f2f2f2;">
                                    <c:forEach items="${listO}" var="o">
                                        <c:forEach items="${listP}" var="p">
                                            <c:if test="${o.product_id == p.product_id}">
                                                <div class="row">
                                                    <div class="col-md-6 col-lg-6">
                                                        <p>${p.product_name}</p>
                                                    </div>
                                                    <div class="col-md-2 col-lg-2">
                                                        <p>${o.size}</p>
                                                    </div>
                                                    <div class="col-md-4 col-lg-4">
                                                        <p>$${p.product_price *o.product_quantity}</p>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    <div class="row">
                                        <div class="col-md-8 col-lg-8">
                                            <p class="mb-0">Shipping</p>
                                        </div>
                                        <div class="col-md-4 col-lg-4">
                                            <p class="mb-0">$33.00</p>
                                        </div>
                                    </div>
                                </div>

                                <div class="row my-4">
                                    <div class="col-md-4 offset-md-8 col-lg-3 offset-lg-9">
                                        <p class="lead fw-bold mb-0" style="color: #f37a27;">$${totalMoney}</p>
                                    </div>
                                </div>

                                <p class="lead fw-bold mb-4 pb-2" style="color: #f37a27;">Tracking Order</p>

                                <div class="row">
                                    <div class="col-lg-12">

                                        <div class="horizontal-timeline">

                                            <ul class="list-inline items d-flex justify-content-between">
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">Ordered</p
                                                    class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">Shipped</p
                                                    class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">On the way
                                                    </p>
                                                </li>
                                                <li class="list-inline-item items-list text-end" style="margin-right: 8px;">
                                                    <p style="margin-right: -8px;">Delivered</p>
                                                </li>
                                            </ul>

                                        </div>

                                    </div>
                                </div>

                                <p class="mt-4 pt-2 mb-0">Want any help? <a href="#!" style="color: #f37a27;">Please contact
                                        us</a></p>
                                <p class="mt-4 pt-2 mb-0"><a href="home" style="color: #f37a27;"> Back To Home Page</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
