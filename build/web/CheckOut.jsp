
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Fashi Template">
        <meta name="keywords" content="Fashi, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Fashi | Template</title>

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
        <!--<script defer src="js/CheckOutValidate.js"></script>-->
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <jsp:include page="top.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <div class="breacrumb-section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb-text product-more">
                                <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                                <a href="./shop.html">Shop</a>
                                <span>Check Out</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb Section Begin -->

            <!-- Shopping Cart Section Begin -->
            <section class="checkout-section spad">
                <div class="container">
                    <form id="checkoutform" action="checkout" method="post" class="checkout-form">
                        <div class="row">
                            <div class="col-lg-6">
                                <h4>Biiling Details</h4>
                                <div class="row">
                                    <div class="col-lg-12 input-control">
                                        <label for="name">Full Name<span>*</span></label>
                                        <input type="text" id="name" name="name" >
                                        <div class="error"></div>
                                    </div>                                    
                                    <div class="col-lg-12 input-control">
                                        <label for="country">Country<span>*</span></label>
                                        <input type="text" id="country" name="country" >
                                        <div class="error"></div>
                                    </div>
                                    <div class="col-lg-12 input-control">
                                        <label for="street">Street Address<span>*</span></label>
                                        <input type="text" id="street" class="street-first" name="address" >
                                        <div class="error"></div>
                                    </div>
                                    <div class="col-lg-12 input-control">
                                        <label for="city">Town / City<span>*</span></label>
                                        <input type="text" id="city" name="city" >
                                        <div class="error"></div>
                                    </div>
                                    <div class="col-lg-12 input-control">
                                        <label for="phone">Phone<span>*</span></label>
                                        <input type="text" id="phone" name="phone" >
                                        <div class="error"></div>
                                    </div>
                                    <div class="col-lg-12 input-control">
                                        <label for="messege">Messege</label>
                                        <input type="text" id="messege" placeholder="Please leave a message" name="mess">
                                        <div class="error"></div>
                                    </div>
                                    <div class="col-lg-12 input-control">   
                                        <label for="phone">Coupon Code</label>
                                        <input type="text" id="code" placeholder="Enter Your Coupon Code Here" name="code">
                                        <div class="error"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="place-order">
                                    <h4>Your Order</h4>
                                    <div class="order-total">
                                        <ul class="order-table">
                                            <li>Product <span>Total</span></li>
                                            <c:forEach items="${listC}" var="o">
                                                <c:forEach items="${listP}" var="p">
                                                    <c:if test="${o.product_id == p.product_id}">
                                                    <li class="fw-normal">${p.product_name}<span>$${p.product_price *o.quantity}</span></li>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                        <li class="total-price">Total <span>$${totalMoney}</span></li>
                                    </ul>
                                    <div class="payment-check">
                                        <div class="pc-item">
                                            <label for="pc-check">
                                                Cheque Payment
                                                <input type="checkbox" id="pc-check">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <div class="pc-item">
                                            <label for="pc-paypal">
                                                Paypal
                                                <input type="checkbox" id="pc-paypal">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="order-btn">
                                        <button type="submit" class="site-btn place-btn">Place Order</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Shopping Cart Section End -->

        <jsp:include page="bottom.jsp"></jsp:include>
        
        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/jquery.dd.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>