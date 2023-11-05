<%-- 
    Document   : AddImport
    Created on : Oct 27, 2023, 10:17:21 AM
    Author     : DanPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Danh sách đơn hàng | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="logout"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
                     alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>Võ Trường</b></p>
                    <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS Bán Hàng</span></a></li>
                <li><a class="app-menu__item" href="http://localhost:9999/onlineshopping/manageProduct"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item active" href="http://localhost:9999/onlineshopping/managerImportProduct"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý hàng nha cung cap</span></a></li>
                <li><a class="app-menu__item" href="http://localhost:9999/onlineshopping/managerStoreProduct"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Quản lý hàng trong kho
                        </span></a></li><
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách đơn hàng</li>
                    <li class="breadcrumb-item"><a href="#">Thêm đơn hàng</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Lay hang</h3>
                        <div class="tile-body">
                            <div class="row element-button">
                                 <div class="col-sm-2">
                                    <a href="AddProvider.jsp" class="btn btn-add btn-sm"><i
                                            class="fas fa-folder-plus"></i> Add Provider</a>
                                </div>
                                <div class="col-sm-2">
                                    <a href="/onlineshopping/addProduct" class="btn btn-add btn-sm"><i
                                            class="fas fa-folder-plus"></i> Add Product</a>
                                </div>
                            </div>



                            <form action="addImport" method="POST">
                                <div class="row">
                                    <div class="form-group col-md-4">
                                        <label for="exampleSelect1" class="control-label">Provider name</label>
                                        <select class="form-control" id="exampleSelect1" name="provider_id">
                                            <option>-- Choose Provider --</option>
                                            <c:forEach items="${listProvider}" var="o">                   
                                                <option value="${o.provider_id}">${o.provider_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group  col-md-4">
                                        <label class="control-label">Date of receipt</label>
                                        <input class="form-control" type="date" name="import_date">
                                    </div>

<!--                                    <div class="form-group  col-md-4">
                                        <label class="control-label">Total price</label>
                                        <input class="form-control" type="number" name="total_price">
                                    </div>-->
                                    <div class="form-group  col-md-4">
                                        <label class="control-label">Note</label>
                                        <textarea class="form-control" rows="4" name="note" ></textarea>
                                    </div>  

                                    <div style="display: flex; text-align: center" id="product-fields" class="product-row">
                                        <div class="form-group  col-md-3">
                                            <label for="exampleSelect1" class="control-label">Product name</label>
                                            <select class="form-control" id="exampleSelect1" name="product_id-0">
                                                <option>-- Choose Product Name --</option>
                                                <c:forEach items="${listP}" var="o">                   
                                                    <option value="${o.product_id}">${o.product_name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group  col-md-3">
                                            <label class="control-label">Quantity</label>
                                            <input class="form-control" type="text" name="product_import_quantity-0">
                                        </div>
                                        
                                        <div class="form-group  col-md-3">
                                            <label class="control-label">Size</label>
                                            <input class="form-control" type="text" name="product_import_size-0">
                                        </div>
                                        <div style="display: flex;">
                                            <button id="add-new-button" class="btn btn-save" type="button" style="height: 40px; width: 80px; margin-top: 30px; margin-right: 20px">Add new</button>
                                            <button class="btn btn-cancel" type="button" style="height: 40px; width: 80px; margin-top: 30px">Delete</button>
                                        </div>
                                    </div>

                                    <br>

                                </div>

                                <input type="hidden" name="count" id="count" value="0">

                                <div>
                                    <button class="btn btn_1" type="submit">Lưu lại</button>
                                    <a class="btn btn-cancel" href="/doc/table-data-oder.html">Hủy bỏ</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
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
                    </form>>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!--                <script>
                $(document).ready(function () {
                    var count = 0;
        
                    // Khi click vào nút "Add new"
                    $(document).on("click", ".btn-save", function () {
                        count++;
                        var newProductFields = $("#product-fields").clone();
                        var newId = "product-fields-" + count;
                        newProductFields.attr("id", newId);
                        newProductFields.find('select').attr("id", "exampleSelect1-" + count);
                        newProductFields.find('select').attr("name", "product_id-" + count);
                        newProductFields.find('input[type="text"]').each(function () {
                            var oldId = $(this).attr("name");
                            $(this).attr("name", oldId + "-" + count);
                        });
                        newProductFields.find('input[type="text"]').val('');
                        newProductFields.find('select').val('-- Choose Product Name --');
                        newProductFields.addClass('product-row');
                        $("#product-fields").after(newProductFields);
                    });
        
                    // Khi click vào nút "Delete"
                    $(document).on("click", ".btn-cancel", function () {
                        var productRows = $('.product-row');
                        if (productRows.length > 1) {
                            if ($(this).closest('.product-row').index() !== 0) {
                                $(this).closest('.product-row').remove();
                            } else {
                                alert("Không thể xóa hàng đầu tiên.");
                            }
                        } else {
                            alert("Không thể xóa hàng cuối cùng.");
                        }
                    });
                });
                </script>-->
                <script>
                $(document).ready(function () {
                    var count = 0;
                    var saved = false; // Thêm biến lưu trạng thái
        
                    $(document).on("click", ".btn-save", function () {
                        if (!saved) { // Kiểm tra xem đã lưu hay chưa
                            count++;
                            $("#count").val(count);
                            var newProductFields = $("#product-fields").clone();
                            var newId = "product-fields-" + count;
                            newProductFields.attr("id", newId);
                            newProductFields.find('select').attr("id", "exampleSelect1-" + count);
                            newProductFields.find('select').attr("name", "product_id-" + count);
                            newProductFields.find('input[type="text"]').each(function () {
                                var oldId = $(this).attr("name");
                                $(this).attr("name", oldId + "-" + count);
                            });
                            newProductFields.find('input[type="text"]').val('');
                            newProductFields.find('select').val('-- Choose Product Name --');
                            newProductFields.addClass('product-row');
                            $("#product-fields").after(newProductFields);
                        }
                    });
        
                    $(document).on("click", ".btn-cancel", function () {
                        var productRows = $('.product-row');
                        if (productRows.length > 1) {
                            if ($(this).closest('.product-row').index() !== 0) {
                                $(this).closest('.product-row').remove();
                            } else {
                                alert("Không thể xóa hàng đầu tiên.");
                            }
                        } else {
                            alert("Không thể xóa hàng cuối cùng.");
                        }
                    });
        
                    // Khi click vào nút "Lưu lại"
                    $(document).on("click", ".btn-save[type=submit]", function () {
                        saved = true; // Đặt saved thành true để ngăn chặn việc thêm hàng mới
                    });
                });
                </script>



<!--        <script>
        $(document).ready(function () {
            var count = 1;
            var saved = false; // Variable to store the current state
            var maxProductId = 0; // Variable to keep track of the maximum product_id

            $(document).on("click", ".btn-save", function () {
                if (!saved) { // Check if it has been saved or not
                    count++;
                    $("#count").val(count);
                    maxProductId++; // Increment the maximum product_id
                    var newProductFields = $("#product-fields").clone();
                    var newId = "product-fields-" + count;
                    newProductFields.attr("id", newId);
                    newProductFields.find('select').attr("id", "exampleSelect1-" + maxProductId);
                    newProductFields.find('select').attr("name", "product_id_" + maxProductId); // Change "-" to "_" to maintain consistency
                    newProductFields.find('input[type="text"]').each(function () {
                        var oldId = $(this).attr("name");
                        $(this).attr("name", oldId.replace(/-\d+$/, "-" + count));
                    });
                    newProductFields.find('input[type="text"]').val('');
                    newProductFields.find('select').val('-- Choose Product Name --');
                    newProductFields.addClass('product-row');
                    $("#product-fields").after(newProductFields);
                }
            });
            $(document).on("click", ".btn-cancel", function () {
                var productRows = $('.product-row');
                if (productRows.length > 1) {
                    if ($(this).closest('.product-row').index() !== 0) {
                        $(this).closest('.product-row').remove();
                    } else {
                        alert("Cannot delete the first row.");
                    }
                } else {
                    alert("Cannot delete the last row.");
                }
            });
            // When clicking the "Save" button
            $(document).on("click", ".btn-save[type=submit]", function () {
                saved = true; // Set saved to true to prevent adding new rows
            });
        });
        </script>-->
    </body>
</html>
