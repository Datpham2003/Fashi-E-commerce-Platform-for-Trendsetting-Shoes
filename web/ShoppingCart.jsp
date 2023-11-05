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
                                <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                                <a href="./shop.html">Shop</a>
                                <span>Shopping Cart</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb Section Begin -->

            <!-- Shopping Cart Section Begin -->
            <section class="shopping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="cart-table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Image</th>
                                            <th class="p-name">Product Name</th>
                                            <th>Price</th>
                                            <th>Size</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listC}" var="o">
                                        <c:forEach items="${listP}" var="p">
                                            <c:if test="${o.product_id == p.product_id}">
                                                <tr>
                                                    <td class="cart-pic first-row"><img src="${p.product_image}" alt=""></td>
                                                    <td class="cart-title first-row">
                                                        <h5>${p.product_name}</h5>
                                                    </td>
                                                    <td class="p-price first-row">$${p.product_price}</td>
                                                    <td class="p-price first-row">${o.product_size}</td>
                                                    <td class="qua-col first-row">
                                                        <div class="quantity">
                                                            <div class="pro-qty">
                                                                <input type="text" value="${o.quantity}">
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="total-price first-row">$${p.product_price*o.quantity}</td>
                                                    <td class="close-td first-row" >
                                                        <a href="deletecart?pid=${o.product_id}&size=${o.product_size}">
                                                            <i class="ti-close"></i> 
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="cart-buttons">
                                    <a href="shop" class="primary-btn continue-shop">Continue shopping</a>
                                </div>
                            </div>
                            <div class="col-lg-4 offset-lg-4">
                                <div class="proceed-checkout">
                                    <ul>
                                        <li class="subtotal">Subtotal <span>$${totalMoney}</span></li>
                                        <li class="cart-total">Total <span>$${totalMoney}</span></li>
                                    </ul>
                                        <c:if test="${totalMoney == '0'}">
                                            <a style="opacity:0.6;pointer-events: none " href="" class="proceed-btn">PROCEED TO CHECK OUT</a>
                                        </c:if>
                                    <!--                                    <a href="loadCheckOut" class="proceed-btn">PROCEED TO CHECK OUT</a>-->
                                          <c:if test="${totalMoney != '0'}">
                                    <a href="loadCheckOut" class="proceed-btn">PROCEED TO CHECK OUT</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
