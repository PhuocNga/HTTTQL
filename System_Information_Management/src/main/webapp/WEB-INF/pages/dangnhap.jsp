<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
    <!-- Animate.css -->
    <link href="<c:url value="/resources/vendors/animate.css/animate.min.css"/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/build/css/custom.min.css"/>" rel="stylesheet">
</head>
<body>
<body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="<c:url value="/Home/ktradangnhap"/>" method="post">
              <h1>Đăng nhập</h1>
              <c:set var="user_error" value="${sessionScope.user_error }"/>
              <c:choose>
              <c:when test="${user_error!=null}">
              <div>
                <input type="email" class="form-control" placeholder="Tên tài khoản" required="" name="email" value="${user_error.tentaikhoan}" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Mật khẩu" required="" name="pass" value="${user_error.matkhau}"/>
              </div>
              </c:when>
              <c:otherwise>
                 <div>
                <input type="email" class="form-control" placeholder="Tên tài khoản" required="" name="email" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Mật khẩu" required="" name="pass"/>
              </div>
              </c:otherwise>
              
              </c:choose>
              
              <c:if test="${user_error!=null}">
              <div style="color: red">Tài khoản hoặc mật khẩu không đúng!</div>
              </c:if>
              <div>
                <button class="btn btn-default submit">Đăng nhập</button>
                <a href="#signup" class="to_register">Quên mật khẩu?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Hệ thống thông tin quản lý</h1>
                  <p>©2018 Hệ thống thông tin quản lý- cô Khương hải Châu</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
                <h1>Quên mật khẩu</h1>
              <div>
                <input type="email" class="form-control" placeholder="Nhập email của bạn" required="required" />
              </div>
              <div>
                  <button class="btn btn-default" type="submit">Gửi</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">
                  <a href="#signin" class="to_register">Đăng nhập</a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-paw"></i> Hệ thống thông tin quản lý</h1>
                  <p>©2018 Hệ thống thông tin quản lý- cô Khương hải Châu</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</body>
</html>