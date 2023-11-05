
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

        <!--new login-->
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2login.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="../css/main.css" type="text/css"/>
        <link rel="stylesheet" href="../css/main.css" type="text/css">
        <link rel="stylesheet" href="../lib/owlcarousel/assets/owl.theme.default.min.css" type="text/css"/>
        <link rel="stylesheet" href="../css/main.css" type="text/css">
        <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.css" type="text/css"/>
        <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.css" type="text/css">
        <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/util.css" type="text/css"/>
        <link rel="stylesheet" href="../css/util.css" type="text/css">
        <!--end-->
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <jsp:include page="top.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
        <div class="breacrumb-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb-text">
                            <a href="#"><i class="fa fa-home"></i> Home</a>
                            <span>Login</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb Form Section Begin -->

        <!-- Register Section Begin -->

        <div class="register-login-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3">
                        <div class="login-form">
                            <h2>Login</h2>
                            <form action="LoginControl" method="post" id="form">
                                <div class="group-input" >
                                    <label for="username" >Username *</label>
                                    <input type="text" name="username" id="username" placeholder="Username"><br/>                
                                    <small>Error message</small><br/>
                                </div>
                                <div class="group-input">
                                    <label for="pass" >Password *</label>
                                    <input type="password" name="pass" id="pass" placeholder="Password" ><br/>
                                    <small>Error message</small><br/>
                                </div>
                                <c:if test="${mess == 'Wrong username or pass'}">
                                    <div class="alert">
                                        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                        <strong>!</strong> 
                                        ${mess}
                                    </div>
                                </c:if>

                                <div class="group-input gi-check">
                                    <div class="gi-more">
                                        <label for="save-pass">
                                            Save Password
                                            <input type="checkbox" id="save-pass">
                                            <span class="checkmark"></span>
                                        </label>
                                        <a href="#" class="forget-pass">Forget your Password</a>
                                    </div>
                                </div>
                                <button type="submit" class="site-btn login-btn">Sign In</button>
                            </form>
                            <div class="switch-login">
                                <a href="Register.jsp" class="or-login">Or Create An Account</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Register Form Section End -->

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
            <style>

                .login-form form .group-input small{
                    visibility: hidden;
                }

                .login-form form .group-input.success input {
                    border-color: green;
                }
                .login-form form .group-input.error input {
                    border-color: red;
                }
                .login-form form .group-input.success small {
                    visibility: hidden;
                }
                .login-form form .group-input.error small {
                    color: red;
                    visibility: visible;
                    position: absolute;
                }

                .alert {
                    padding: 20px;
                    background-color: #f44336;
                    color: white;
                }
                .closebtn {
                    margin-left: 15px;
                    color: white;
                    font-weight: bold;
                    float: right;
                    font-size: 22px;
                    line-height: 20px;
                    cursor: pointer;
                    transition: 0.3s;
                }

                .closebtn:hover {
                    color: black;
                }

            </style>


            <script>
                //        const form = document.getElementById('form');
                //        const username = document.getElementById('username');
                //        const password = document.getElementById('pass');
                //
                //        form.addEventListener('submit', (e) => {
                //            e.preventDefault(); 
                //            checkInputs();
                //            
                //        });
                //        
                //        function checkInputs(){
                //            const usernameValue = username.value.trim();
                //            const passwordValue = password.value.trim();
                //    
                //            if(usernameValue === ''){        
                //                setErrorFor(username, "Username cannot be blank"); 
                //            }else{
                //                setSuccessFor(username);
                //            }
                //            
                //            if(passwordValue === ''){        
                //                setErrorFor(password, "Password cannot be blank");
                //            }else{
                //            setSuccessFor(password);
                //            }
                //        }
                //
                //        function setErrorFor(input, message){
                //            const groupInput = input.parentElement;
                //            const small = groupInput.querySelector('small');
                //    
                //            small.innerText = message;
                //    
                //            groupInput.className = 'group-input error';
                //        }
                //        function setSuccessFor(input) {
                //            const groupInput = input.parentElement;
                //            groupInput.className = 'group-input success';
                //        }

                const usernameEl = document.querySelector('#username');
                const passwordEl = document.querySelector('#pass');
                const form = document.querySelector('#form');


                const checkUsername = () => {

                    let valid = false;

                    const min = 3,
                            max = 25;

                    const username = usernameEl.value.trim();

                    if (!isRequired(username)) {
                        showError(usernameEl, 'Username cannot be blank.');
                    } else if (!isBetween(username.length, min, max)) {
                        showError(usernameEl, `Username must be between ${min} and ${max} characters.`);
                    } else {
                        showSuccess(usernameEl);
                        valid = true;
                    }
                    return valid;
                };


                const checkPassword = () => {
                    let valid = false;
                    const password = passwordEl.value.trim();

                    if (!isRequired(password)) {
                        showError(passwordEl, 'Password cannot be blank.');
                    } else {
                        showSuccess(passwordEl);
                        valid = true;
                    }

                    return valid;
                };

                const isPasswordSecure = (password) => {
                    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
                    return re.test(password);
                };

                const isRequired = value => value === '' ? false : true;
                const isBetween = (length, min, max) => length < min || length > max ? false : true;


                const showError = (input, message) => {
                    // get the form-field element
                    const groupInput = input.parentElement;
                    // add the error class
                    groupInput.classList.remove('success');
                    groupInput.classList.add('error');

                    // show the error message
                    const error = groupInput.querySelector('small');
                    error.textContent = message;
                };

                const showSuccess = (input) => {
                    // get the form-field element
                    const groupInput = input.parentElement;

                    // remove the error class
                    groupInput.classList.remove('error');
                    groupInput.classList.add('success');

                    // hide the error message
                    const error = groupInput.querySelector('small');
                    error.textContent = '';
                };


                form.addEventListener('submit', function (e) {
                    // prevent the form from submitting
                    e.preventDefault();

                    // validate fields
                    let isUsernameValid = checkUsername(),
                            isPasswordValid = checkPassword();

                    let isFormValid = isUsernameValid &&
                            isPasswordValid;

                    // submit to the server if the form is valid
                    if (isFormValid) {
                        form.submit();
                    }
                });


                const debounce = (fn, delay = 500) => {
                    let timeoutId;
                    return (...args) => {
                        // cancel the previous timer
                        if (timeoutId) {
                            clearTimeout(timeoutId);
                        }
                        // setup a new timer
                        timeoutId = setTimeout(() => {
                            fn.apply(null, args);
                        }, delay);
                    };
                };

                form.addEventListener('input', debounce(function (e) {
                    switch (e.target.id) {
                        case 'username':
                            checkUsername();
                            break;
                        case 'pass':
                            checkPassword();
                            break;
                    }
                }));
        </script>
    </body>

</html>