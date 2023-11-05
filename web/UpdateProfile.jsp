<%-- 
    Document   : Profile
    Created on : Sep 28, 2023, 10:45:29 AM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <div class="container-xl px-4 mt-4">
            <!-- Account page navigation-->

            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <div>
                                <c:if test="${listProfile.image == null}">
                                    <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="image">
                                </c:if>    
                                <img class="img-account-profile rounded-circle mb-2" src="${listProfile.image}" alt="image">
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
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <!-- Profile picture upload button-->
                            <!--                            <button class="btn btn-primary" type="button">Upload new image</button>-->
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="updateProfile" method="post">
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">ID</label>
                                    <input class="form-control" name="profile_id" id="inputUsername" type="text"  value="${listProfile.profile_id}" readonly>
                                </div>

                                <!-- Form Group (username)-->                  
                                <!--                                <div class="mb-3">
                                                                    <label class="small mb-1" for="inputUsername">Username</label>
                                                                    <input class="form-control" value="${listAc.username}" id="inputUsername" type="text" name="username" readonly>
                                                                </div>-->

                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->

                                    <div class="col-md-6">                             
                                        <label class="small mb-1" for="inputFirstName">Full name</label>

                                        <input class="form-control" value="${listProfile.full_name}" id="inputFirstName" type="text" placeholder="Enter your first name" name="full_name">                                

                                    </div>

                                    <!-- Form Group (last name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Address</label>
                                        <input class="form-control" value="${listProfile.address}" id="inputLocation" type="text" placeholder="Enter your address" name="address">
                                    </div>
                                    <!--                            <div class="col-md-6">
                                                                    <label class="small mb-1" for="inputLastName">Last name</label>
                                                                    <input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" value="Luna">
                                                                </div>-->
                                </div>
                                <!--                         Form Row        
                                -->                        <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputEmailAddress">Email</label>
                                        <input class="form-control" value="${listProfile.email}" id="inputEmailAddress" type="email" placeholder="Enter your email address" name="email">
                                    </div>

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Gender</label><br>
                                        <select class="form-control" id="inputGender" name="gender">
                                            <option value="1" ${listProfile.gender == 1 ? "selected" : ""}>Male</option>
                                            <option value="0" ${listProfile.gender == 0 ? "selected" : ""}>FeMale</option>                                  
                                        </select>
                                    </div>
                                </div>
                                <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control" value="${listProfile.phone}" id="inputPhone" type="text" placeholder="Enter your phone number" name="phone">
                                    </div>

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Birthday</label>
                                        <input class="form-control" value="${listProfile.dob}" id="inputBirthday"  type="date" placeholder="Enter your birthday" name="dob" >
                                    </div>
                                </div>

                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="submit">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="bottom.jsp"></jsp:include>
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

                        removeOldImage(); // Gọi hàm xóa ảnh cũ
                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }

            // Hàm để xóa ảnh cũ
            function removeOldImage() {
                var elem = document.getElementById('currentImage');
                elem.parentNode.removeChild(elem);
            }
        </script>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
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

