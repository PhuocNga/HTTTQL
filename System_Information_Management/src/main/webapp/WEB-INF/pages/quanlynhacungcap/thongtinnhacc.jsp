<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/build/css/custom.min.css"/>" rel="stylesheet">
<title>thông tin nhà cung cấp</title>
</head>
<body>
<body class="nav-md">
    <div class="container body">
      <div class="main_container">
      
       <!-- Menu -->
		<c:import url="../menu.jsp"/>
	  <!-- Menu -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Quản lý nhà cung cấp</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Thông tin nhà cung cấp</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <div class="col-md-8 col-lg-8 col-sm-7">
                       <div style="padding-left: 50%">
                       <c:choose>
                       <c:when test="${!empty infonhacc}">
                       
                        <table  cellpadding="4" cellspacing="0">
                            <tr>
                                <td><h4 style="font-weight: bold;font-style: italic">Mã nhà cung cấp:</h4></td>
                                <td><h4>${infonhacc.manhacungcap }</h4></td>
                            </tr>
                            <tr>
                                <td><h4 style="font-weight: bold;font-style: italic">Tên nhà cung cấp:</h4></td>
                                <td><h4>${infonhacc.tennhacungcap}</h4></td>
                            </tr>
                            <tr>
                                <td><h4 style="font-weight: bold;font-style: italic">Địa chỉ nhà cung cấp:</h4></td>
                                <td><h4>${infonhacc.diachi}</h4></td>
                            </tr>
                            <tr>
                                <td><h4 style="font-weight: bold;font-style: italic">Số điện thoại nhà cung cấp: &nbsp;</h4></td>
                                <td><h4>${infonhacc.sodienthoai}</h4></td>
                            </tr>
                        </table>
                        </c:when>
                        <c:otherwise>
                        <h3>Không tìm thấy nhà cung cấp</h3>
                        </c:otherwise>
                        </c:choose>
                       	<div style="text-align: center;"><a href="<c:url value="/nhacungcap/quanlynhacungcap"/>" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> Quay lại</a></div>
                        </div>
                    </div>
                    
 
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        
        <!-- /footer content -->
      </div>
    </div>
 <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js"/>"></script>
<script src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
<script src="<c:url value="/resources/build/js/custom.min.js"/>"></script>
</body>
</html>