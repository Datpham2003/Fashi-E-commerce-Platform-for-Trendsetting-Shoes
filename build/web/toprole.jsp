<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Header Section Begin -->
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
                <div class="mail-service">
                    <i class=" fa fa-envelope"></i>
                    hello.colorlib@gmail.com
                </div>
                <div class="phone-service">
                    <i class=" fa fa-phone"></i>
                    +65 11.188.888
                </div>
            </div>
            <div class="ht-right">
                <c:if test="${sessionScope.acc != null}">
                        <div class="login-panel">
                            <div class="dropdownlog">
                            <a class="dropbtnlog"><i class="fa fa-user"></i>${sessionScope.acc.username}</a>
                            <div class="dropdownlog-content">
                                <a href="profile">Profile</a>
                            <a href="logout">Logout</a>
                            </div>
                            </div>
                        </div>
<!--                           <a class="login-panel"><i class="fa fa-user"></i>${sessionScope.acc.username}</a>-->
                
                    </c:if>
                    
                    <c:if test="${sessionScope.acc == null}">
                        <a href="Login.jsp" class="login-panel"><i class="fa fa-user"></i>Login</a>
                    </c:if>   

                <div class="lan-selector">
                    <select class="language_drop" name="countries" id="countries" style="width:300px;">
                        <option value='yt' data-image="img/flag-1.jpg" data-imagecss="flag yt"
                                data-title="English">English</option>
                        <option value='yu' data-image="img/flag-2.jpg" data-imagecss="flag yu"
                                data-title="Bangladesh">German</option>
                    </select>
                </div>
                <div class="top-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"><i class="ti-twitter-alt"></i></a>
                    <a href="#"><i class="ti-linkedin"></i></a>
                    <a href="#"><i class="ti-pinterest"></i></a>
                </div>
            </div>
        </div>
    </div>


        </div>
    </div>
   
    
            <style>
.dropdownlog-content {
  display: none;
  background: white;
  position: absolute;
  min-width: 160px;
  z-index: 1;
}

.dropdownlog-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}


.dropdownlog:hover .dropdownlog-content {
  display: block;
}

</style>
</header>
