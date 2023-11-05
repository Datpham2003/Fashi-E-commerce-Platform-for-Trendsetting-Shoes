<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords"
              content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, materialpro admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, materialpro admin lite design, materialpro admin lite dashboard bootstrap 5 dashboard template">
        <meta name="description"
              content="Material Pro Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
        <meta name="robots" content="noindex,nofollow">
        <title>Material Pro Lite Template by WrapPixel</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/materialpro-lite/" />
        <link rel="icon" type="image/png" sizes="16x16" href="../assets/images/favicon.png">
        <link href="css/styleship.min.css" rel="stylesheet">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet" href="css/profile.css" type="text/css">

    </head>

    <body>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <!--    <div class="preloader">
                <div class="lds-ripple">
                    <div class="lds-pos"></div>
                    <div class="lds-pos"></div>
                </div>
            </div>-->

        <jsp:include page="toprole.jsp"></jsp:include>
            <!-- ============================================================== -->
            <!-- Main wrapper - style you can find in pages.scss -->
            <!-- ============================================================== -->
            <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
                 data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
                <!-- ============================================================== -->
                <!-- Topbar header - style you can find in pages.scss -->
                <!-- ============================================================== -->

                <!-- ============================================================== -->
                <!-- End Topbar header -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Left Sidebar - style you can find in sidebar.scss  -->
                <!-- ============================================================== -->      
                <aside class="left-sidebar" data-sidebarbg="skin6">

                    <a href="home" style="margin-left:75px">
                        <img src="img/logo.png" alt="">
                    </a>

                    <!-- Sidebar scroll-->
                    <div class="scroll-sidebar">
                        <!-- Sidebar navigation-->
                        <nav class="sidebar-nav">
                            <ul id="sidebarnav">
                                <!-- User Profile-->
                                <li class="sidebar-item"> <span
                                        class="hide-menu"></span></a></li>                        
                                <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                                             href="ship" aria-expanded="false"><i class="mdi me-2 mdi-table"></i><span
                                            class="hide-menu">Order</span></a></li>
                                <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                                             href="shiphistory" aria-expanded="false"><i class="mdi me-2 mdi-table"></i><span
                                            class="hide-menu">History</span></a></li>                                    
                            </ul>

                        </nav>
                        <!-- End Sidebar navigation -->
                    </div>
                    <!-- End Sidebar scroll-->
                    <div class="sidebar-footer">
                        <div class="row">
                            <div class="col-4 link-wrap">
                                <!-- item-->
                                <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i
                                        class="ti-settings"></i></a>
                            </div>
                            <div class="col-4 link-wrap">
                                <!-- item-->
                                <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i
                                        class="mdi mdi-gmail"></i></a>
                            </div>
                            <div class="col-4 link-wrap">
                                <!-- item-->
                                <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i
                                        class="mdi mdi-power"></i></a>
                            </div>
                        </div>
                    </div>
                </aside>
                <!-- ============================================================== -->
                <!-- End Left Sidebar - style you can find in sidebar.scss  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Page wrapper  -->
                <!-- ============================================================== -->
                <div class="page-wrapper">
                    <!-- ============================================================== -->
                    <!-- Bread crumb and right sidebar toggle -->
                    <!-- ============================================================== -->
                    <div class="page-breadcrumb">
                        <div class="row align-items-center">
                            <div class="col-md-6 col-8 align-self-center">
                                <h3 class="page-title mb-0 p-0">Order</h3>
                                <div class="d-flex align-items-center">
                                </div>
                            </div>
                            <div class="col-md-6 col-4 align-self-center">
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End Bread crumb and right sidebar toggle -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Container fluid  -->
                    <!-- ============================================================== -->
                    <div class="container-fluid">
                        <!-- ============================================================== -->
                        <!-- Start Page Content -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <!-- column -->
                            <div class="col-sm-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Order</h4>
                                        <div class="table-responsive">
                                            <table class="table user-table">
                                                <thead>
                                                    <tr>
                                                        <th class="border-top-0">#</th>
                                                        <th class="border-top-0">Name Customer</th>
                                                        <th class="border-top-0">Address</th>
                                                        <th class="border-top-0">Phone</th>
                                                        <th class="border-top-0">Total Price</th>
                                                        <th class="border-top-0">Deposit</th>
                                                        <th class="border-top-0">Status</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${order}" var="o">
                                                    <c:if test="${o.order_status == null}">                                                    
                                                        <tr>
                                                            <td>${o.order_id}</td>
                                                            <td>${o.customer_name}</td>
                                                            <td>${o.address}</td>
                                                            <td>${o.phone}</td>S
                                                            <td>${o.price}</td>
                                                            <td>${o.price*0.5}</td>
                                                            <c:if test="${o.order_status == null}">
    <!--                                                            <td><button type="submit" class="btn btn-success d-none d-md-inline-block text-white" href="updateship?o=${o.order_id}&p=${o.price*0.5}">Accept</button></td>-->
                                                                <td>
                                                                    <a class="btn btn-success d-none d-md-inline-block text-white" href="updateship?o=${o.order_id}&p=${o.price*0.5}&a=accept">Accept</a>
                                                                </td>

                                                            </c:if>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>    `
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        
                     <div class="row">
                            <!-- column -->
                            <div class="col-sm-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Order is being delivered</h4>
                                        <div class="table-responsive">
                                            <table class="table user-table">
                                                <thead>
                                                    <tr>
                                                        <th class="border-top-0">#</th>
                                                        <th class="border-top-0">Name Customer</th>
                                                        <th class="border-top-0">Address</th>
                                                        <th class="border-top-0">Phone</th>
                                                        <th class="border-top-0">Total Price</th>
                                                        <th class="border-top-0">Deposit</th>
                                                        <th class="border-top-0">Status</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${process}" var="o">
                                                    <c:if test="${o.order_status == 'OnGoing'}">                                                    
                                                        <tr>
                                                            <td>${o.order_id}</td>
                                                            <td>${o.customer_name}</td>
                                                            <td>${o.address}</td>
                                                            <td>${o.phone}</td>S
                                                            <td>${o.price}</td>
                                                            <td>${o.price*0.5}</td>
                                                            <c:if test="${o.order_status == 'OnGoing'}">
                                                                <td><a class="btn btn-danger d-none d-md-inline-block text-white" href="updateship?o=${o.order_id}&p=${o.price*0.5}&a=delivered">Delivered</a></td>
                                                            </c:if>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>    `
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>    
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer">  <a href="https://www.wrappixel.com/"></a>
                </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>

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
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="../assets/plugins/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="../assets/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/app-style-switcher.js"></script>
        <!--Wave Effects -->
        <script src="js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="js/custom.js"></script>
    </body>

</html>