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
        <link rel="stylesheet" href="css/profile.css" type="text/css">
    </head>
    <body>
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <jsp:include page="top.jsp"></jsp:include>

            <div class="container-xl px-4 mt-4">
                <!-- Account page navigation-->

                <hr class="mt-0 mb-4">
                <div class="row">
                    <div class="col-xl-4">
                        <!-- Profile picture card-->
                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Profile Picture</div>
                            <div class="card-body text-center">
                                <!-- Profile picture image-->
                            <c:if test="${profile.image == null}">
                                <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                            </c:if> 
                            <c:if test="${profile.image != null}">    
                                <img class="img-account-profile rounded-circle mb-2" src="${profile.image}" alt="">
                            </c:if>     
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <!-- Profile picture upload button-->
                            <button class="btn btn-primary" onclick="openImagePopup()">Upload new image</button>
                        </div>
                    </div><br>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="UpdateProfileController" method="post" id="form">

                                <!-- Form Group (username)-->                  
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Username (how your name will appear to other users on the site)</label>
                                    <input class="form-control" value="${sessionScope.acc.username}" id="inputUsername" type="text" placeholder="Enter your username" value="username" readonly>
                                </div>

                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->

                                    <div class="col-md-6">                             
                                        <label class="small mb-1" for="inputFirstName">Full name</label>
                                        <input class="form-control"  name="inputFullName" value="${profile.full_name}" id="inputFullName" type="text" placeholder="Enter your Full name" value="Valerie" >                                
                                        <small class="smallerror">Error message</small>
                                    </div>

                                    <!-- Form Group (last name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Address</label>
                                        <input class="form-control"  name="inputAddress" value="${profile.address}" id="inputAddress" type="text" placeholder="Enter your Address" value="San Francisco, CA" >
                                        <small class="smallerror">Error message</small>
                                    </div>
                                    <!--                            <div class="col-md-6">
                                                                    <label class="small mb-1" for="inputLastName">Last name</label>
                                                                    <input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" value="Luna">
                                                                </div>-->
                                </div>
                                <!--                         Form Row          -->                       
                                <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                        <c:if test="${profile.email == null}">
                                            <input class="form-control"  name="inputEmailAddress" value="${profile.email}" id="inputEmailAddress" type="email" placeholder="Enter your email address" value="name@example.com" >
                                        </c:if> 
                                        <c:if test="${profile.email != null}">    
                                            <input class="form-control"  name="inputEmailAddress" value="${profile.email}" id="inputEmailAddress" type="email" placeholder="Enter your email address" value="name@example.com" readonly>
                                        </c:if>

                                    </div>

                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLocation">Gender</label><br>
                                        <select class="form-control" id="inputGender" name="gender" >
                                            <c:choose>
                                                <c:when test="${profile.gender eq '1'}">
                                                    <option value="male" selected>Male</option>
                                                    <option value="female">Female</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="male">Male</option>
                                                    <option value="female" selected>Female</option>
                                                </c:otherwise>
                                            </c:choose>                                    
                                        </select>
                                    </div>
                                </div>
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control"  name="inputPhone" value="${profile.phone}" id="inputPhone" type="text" placeholder="Enter your phone number" value="555-123-4567" >
                                        <small class="smallerror">Error message</small><br>
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Birthday</label>
                                        <input class="form-control"  name="inputBirthday" value="${profile.dob}" id="inputBirthday"  type="date" name="birthday" placeholder="Enter your birthday" value="06/10/1988" >
                                    </div>
                                </div>

                                <!-- Save changes button-->
                                <!--                                <a href="EditProfile.jsp" class="btn btn-primary">Edit Profile</a>-->
                                <div>
                                <button class="btn btn-primary" type="submit">Save changes</button>


                                </div>
                                <!--                                <button class="btn btn-primary" type="submit">Save</button>-->
                            </form>

                                   <button class="btn btn-primary" onclick="openChangePopup()">Change Password</button> 
                            <!--                                    <button class="btn btn-primary" type="submit">Edit Profile</button>-->

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div id="passwordChangePopup" class="popup">
            <div class="popup-content">
                <h2>Change Password</h2>
                <form action="changepass" method="post">
                    <span class="close" onclick="closeChangePopup()">&times;</span>
                    <label for="currentPassword">Current Password:</label>
                    <input type="password" name="currentPassword" id="currentPassword" required><br>
                    
                    <label for="newPassword">New Password:</label>
                    <input type="password" name="newPassword" id="newPassword" required><br>

                    <label for="confirmPassword">Confirm Password:</label>
                    <input type="password" name="confirmPassword" id="confirmPassword" required><br>

                    <button type="submit" id="submitPasswordChange">Submit</button>
                </form>
            </div>
        </div>

        <div id="popup" class="popup">
            <div class="popup-content">
                <form action="UpdateImage" method="post">
                    <span class="close" onclick="closeImagePopup()">&times;</span>
                    <p>Please enter the image link:</p>
                    <input type="text" name="imageLink" id="imageLink">
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>                              

        <jsp:include page="bottom.jsp"></jsp:include>

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
        <script defer src="js/ProfileValidate.js"></script>
        <script>
                        function openChangePopup() {
                            var popup = document.getElementById("passwordChangePopup");
                            popup.style.display = "flex";
                        }

                        function closeChangePopup() {
                            var popup = document.getElementById("passwordChangePopup");
                            popup.style.display = "none";
                        }
        </script>
    </body>
</html>
