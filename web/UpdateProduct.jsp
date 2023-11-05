<%-- 
    Document   : AddProduct
    Created on : Oct 27, 2023, 8:48:32 AM
    Author     : DanPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Thêm sản phẩm | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script>

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);

                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');

            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();

                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
        </script>
    </head>

    <body class="app sidebar-mini rtl">
        <style>
            .Choicefile {
                display: block;
                background: #14142B;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }

            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }

            #uploadfile,
            .removeimg {
                display: none;
            }

            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                /* border: 3px solid red; */
                border-radius: 50%;

            }

            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }

            .removeimg::after {
                /* color: #FFF; */
                /* background-color: #DC403B; */
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>${sessionScope.acc.username}</b></p>
                    <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS Bán Hàng</span></a></li>
                <!--                <li><a class="app-menu__item " href="index.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                                            class="app-menu__label">Bảng điều khiển</span></a></li>
                                <li><a class="app-menu__item " href="table-data-table.html"><i class='app-menu__icon bx bx-id-card'></i>
                                        <span class="app-menu__label">Quản lý nhân viên</span></a></li>
                                <li><a class="app-menu__item " href="#"><i class='app-menu__icon bx bx-user-voice'></i><span
                                            class="app-menu__label">Quản lý khách hàng</span></a></li>-->
                <li><a class="app-menu__item active" href="http://localhost:9999/onlineshopping/manageProduct"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item" href="http://localhost:9999/onlineshopping/managerImportProduct"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý hàng nha cung cap</span></a></li>
                <li><a class="app-menu__item" href="http://localhost:9999/onlineshopping/managerStoreProduct"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Quan ly hang trong kho
                        </span></a></li><!--
                <li><a class="app-menu__item" href="table-data-money.html"><i class='app-menu__icon bx bx-dollar'></i><span
                            class="app-menu__label">Bảng kê lương</span></a></li>
                <li><a class="app-menu__item" href="quan-ly-bao-cao.html"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>
                <li><a class="app-menu__item" href="page-calendar.html"><i class='app-menu__icon bx bx-calendar-check'></i><span
                            class="app-menu__label">Lịch công tác </span></a></li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài
                            đặt hệ thống</span></a></li>-->
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">List Product</li>
                    <li class="breadcrumb-item"><a href="#">Update product</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Update Product</h3>
                        <div class="tile-body">
<!--                            <div class="row element-button">
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#exampleModalCenter"><i
                                            class="fas fa-folder-plus"></i> Add Provider</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#adddanhmuc"><i
                                            class="fas fa-folder-plus"></i> Add Brand</a>
                                </div>
                                <div class="col-sm-2">
                                    <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#addtinhtrang"><i
                                            class="fas fa-folder-plus"></i> Add size</a>
                                </div>
                            </div>-->



                            <form class="row" action="updateProduct" method="POST" enctype="multipart/form-data">
                                <div class="form-group col-md-3">
                                    <label class="control-label">Product_ID</label>
                                    <input value="${listPro.product_id}" name="product_id" class="form-control" type="text" readonly>

                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Name product</label>
                                    <input value="${listPro.product_name}" name="product_name" class="form-control" type="text">
                                </div>

                                <!--                                <div class="form-group  col-md-3">
                                                                    <label class="control-label">Quantity</label>
                                                                     <input name="quantity" class="form-control" type="number">
                                                                </div>-->

                                <!--                                <div class="form-group col-md-3 ">
                                                                    <label for="exampleSelect1" class="control-label">Size</label>
                                                                    <select class="form-control" id="exampleSelect1" name="size">
                                                                        <option>-- Choose size --</option>
                                <c:forEach items="${listPs}" var="o">                   
                                    <option>${o}</option>
                                </c:forEach>
                            </select>
                        </div>-->

                                <div class="form-group col-md-3">
                                    <label for="exampleSelect1" class="control-label">Brand</label>
                                    <select class="form-control" id="exampleSelect1" name="brand_id">
                                        <c:set var="selectedBrandName" value="" scope="page" />
                                        <c:forEach items="${listBrand}" var="brand">
                                            <c:choose>
                                                <c:when test="${brand.brand_id == param.product}">
                                                    <c:set var="selectedBrandName" value="${brand.brand_name}" scope="page" />
                                                    <option value="${brand.brand_id}" selected>${brand.brand_name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${brand.brand_id}">${brand.brand_name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <c:if test="${not empty selectedBrandName}">
                                            <option value="${param.product}" selected>${selectedBrandName}</option>
                                        </c:if>
                                    </select>
                                </div>


                                <div class="form-group col-md-3">
                                    <label for="exampleSelect1" class="control-label">Category</label>
                                    <select class="form-control" id="exampleSelect1" name="category_id">

                                        <c:forEach items="${listCat}" var="o">                   
                                            <option value="${o.category_id}">${o.category_name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-3">
                                    <label class="control-label">Price</label>
                                    <input value="${listPro.product_price}" class="form-control" type="text" name="product_price">
                                </div>

                                <div class="form-group col-md-12">
                                    <label class="control-label">Image</label>
                                    <div id="currentImage">
                                        <img src="${listPro.product_image}" class="form-control" id="productImage" style="height: 150px; width: 170px"/>
                                    </div>
                                    <div>
                                        <div id="myfileupload">
                                            <input type="file" id="uploadfile" name="new_product_image" onchange="readURL(this);" />
                                        </div>
                                        <div id="thumbbox">
                                            <img height="450" width="400" alt="Thumb image" id="thumbimage" style="display: none" />
                                            <a class="removeimg" href="javascript:"></a>
                                        </div>
                                        <div id="boxchoice">
                                            <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Select Picture</a>
                                            <p style="clear:both"></p>
                                        </div>
                                    </div>
                                </div>




                                <div class="form-group col-md-12">
                                    <label class="control-label"> Description </label>
                                    <textarea class="form-control" name="mota" id="mota" name="product_description">${listPro.product_description}</textarea>
                                    <script>CKEDITOR.replace('mota');</script>
                                </div>

                                <br>

                                <button style="padding-right: 15px; margin-right: 15px" class="btn btn-save" type="submit">Save</button>
                                <a class="btn btn-cancel" href="table-data-product.html">Cancle</a>
                            </form>
                        </div>
                    </div><!-- comment -->
                </div>
            </div>
        </main>


        <!--
        MODAL CHỨC VỤ 
        -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <form class="modal-body" method="POST" action="addProduct">
                        <div class="row" >
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Add new provider</h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Input provider name</label>
                                <input class="form-control" type="text" name="provider_name" required>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="submit">Save</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Cancer</a>
                        <BR>
                    </form>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->



        <!--
        MODAL DANH MỤC
        -->
        <div class="modal fade" id="adddanhmuc" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <form class="modal-body" method="POST" action="addProduct">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Add new brand </h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Input name brand</label>
                                <input class="form-control" type="text" name="brand_name" required>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Brands have currently available</label>
                                <ul style="padding-left: 20px;">
                                    <c:forEach items="${listBrand}" var="o">                   
                                        <option>${o.brand_name}</option>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="submit">Save</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Cancer</a>
                        <BR>
                    </form>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->
        <!--
        MODAL TÌNH TRẠNG
        -->
        <div class="modal fade" id="addtinhtrang" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <form class="modal-body" action="addProduct" method="POST">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Add new Size</h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Input size</label>
                                <input class="form-control" name="size" type="text" required>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="submit">Save</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Cancer</a>
                        <BR>
                    </form>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->



        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script>
                                         function readURL(input) {
                                             if (input.files && input.files[0]) {
                                                 var reader = new FileReader();

                                                 reader.onload = function (e) {
                                                     document.getElementById('thumbimage').setAttribute('src', e.target.result);
                                                     document.getElementById('thumbimage').style.display = 'block';

                                                     // Thay đổi đường dẫn hình ảnh trực tiếp
                                                     var productImage = document.getElementById('productImage');
                                                     productImage.src = e.target.result;

                                                     removeOldImage(); 
                                                 };
                                                 reader.readAsDataURL(input.files[0]);
                                             }
                                         }
                                         function removeOldImage() {
                                             var elem = document.getElementById('currentImage');
                                             elem.parentNode.removeChild(elem);
                                         }
        </script>
    </body>

</html>