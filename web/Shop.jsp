

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
        <title>Fashi</title>

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
                            <div class="breadcrumb-text">
                                <a href="home"><i class="fa fa-home"></i> Home</a>
                                <span>Shop</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb Section Begin -->

            <!-- Product Shop Section Begin -->
            <section class="product-shop spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
                            <div class="filter-widget">
                                <h4 class="fw-title">Categories</h4>
                                <ul class="filter-catagories">
                                    <li><a href="#">Men</a></li>
                                    <li><a href="#">Women</a></li>
                                    <li><a href="#">Accessories</a></li>
                                </ul>
                            </div>
                            <div class="filter-widget">
                                <h4 class="fw-title">Brand</h4>
                                <div class="fw-brand-check">
                                <c:forEach items="${listB}" var="o">
                                    <div class="bc-item">
                                        <label for="bc-calvin">
                                            ${o.brand_name}
                                            <input type="checkbox" id="${o.brand_id}" name="brand_id">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </c:forEach>            
                            </div>
                        </div>
                        <div class="filter-widget">
                            <h4 class="fw-title">Price</h4>
                            <div class="filter-range-wrap">
                                <div class="range-slider">
                                    <div class="price-input">
                                        <input type="text" id="minamount">
                                        <input type="text" id="maxamount">
                                    </div>
                                </div>
                                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                     data-min="0" data-max="98">
                                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                </div>
                            </div>
                            <a href="#" class="filter-btn">Filter</a>
                        </div>

                        <div class="filter-widget">
                            <h4 class="fw-title">Size</h4>
                            <div class="fw-size-choose">
                                <c:forEach items="${listPS}" var="o">
                                    <div class="sc-item">
                                        <input type="radio" id="s-size">
                                        <label for="size">${o}</label>
                                    </div>
                                </c:forEach>    

                            </div>
                        </div>

                    </div>
                    <div class="col-lg-9 order-1 order-lg-2">
                        <div class="product-show-option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                                    <div class="select-option">
                                        <select class="sorting">
                                            <option value="">Default Sorting</option>
                                        </select>
                                        <select class="p-show">
                                            <option value="">Show:</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-5 col-md-5 text-right">
                                    <p>Show 01- 09 Of 36 Product</p>
                                </div>
                            </div>
                        </div>
                        <div class="product-list">
                            <div class="row">
                                <c:forEach items="${listP}" var="o">
                                    <div class="col-lg-4 col-sm-6">

                                        <div class="product-item">
                                            <div class="pi-pic">
                                                <img src="${o.product_image}" alt="" href="detail?id=${o.product_id}&bid=${o.brand_id}&cid=${o.cid}">
                                                <div class="icon">
                                                    <i class="icon_heart_alt"></i>
                                                </div>
                                                <ul>
                                                    <li class="w-icon active"><a href="detail?id=${o.product_id}&bid=${o.brand_id}&cid=${o.cid}"><i class="icon_bag_alt"></i></a></li>
                                                    <li class="quick-view"><a href="detail?id=${o.product_id}&bid=${o.brand_id}&cid=${o.cid}">+ Quick View</a></li>
                                                    <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="pi-text">
                                                <div class="catagory-name"></div>
                                                <a href="detail?id=${o.product_id}&bid=${o.brand_id}&cid=${o.cid}">
                                                    <h5>${o.product_name}</h5>
                                                </a>
                                                <div class="product-price">
                                                   $${o.product_price}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Shop Section End -->

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