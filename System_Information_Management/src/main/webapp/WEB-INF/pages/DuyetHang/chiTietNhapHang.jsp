<%@page import="org.springframework.ui.Model"%>
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
                <center><h3>Chi tiết đơn đề nghị nhập hàng</h3></center>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                   
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
               
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
                     
                       
                       
                           <table id="datatable-buttons" class="table table-striped table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Mã sản phẩm</th>
                                                                    <th>Số lượng </th>
                                                                   
                                                                   
                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                          
                                                                <c:if test="${!empty listChiTiet}">
                                                                    <c:forEach items="${listChiTiet}" var="kh">
                                                                        <tr>
                                                                        	
                                                                            <td>${kh[5]}</td>
                                                                            <td>${kh[6]}</td>
                                                                           
                                                                            
                                                                        </tr>
                                                                        
                            
                            
                            
                          
                                                                    </c:forEach>
                                                                  <center> <p style="  font-size: 25px">Mã đơn đề nghị : ${listChiTiet.get(0)[0]}</p></center>
                                                                   <p style=" font-size: 11px"> Ngày lập đơn : ${listChiTiet.get(0)[1]}</p>
                                                                    <p style=" font-size: 11px"> Nhân viên gửi đơn : ${listChiTiet.get(0)[2]}</p>
                                                                   
                                                                     
                                                              
                                                            </tbody>
                                                            
                                                            
                                                        </table>
                                                        
             <center>  <p style=" font-size: 12px"> Tổng số lượng : ${listChiTiet.get(0)[3]} cái</p></center>
                                                               <center>    <p style=" font-size: 12px"> Tổng giá trị : ${listChiTiet.get(0)[4]} VNĐ</p></center>
                                                                 
                                                          
                                                               
                       
                       	<div style="text-align: center;"><a href="<c:url value="/DuyetSanPham/${listChiTiet.get(0)[0]}"/>" class="btn btn-primary"> Duyệt</a></div>
                      </c:if>
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