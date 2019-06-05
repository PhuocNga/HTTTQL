<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- Bootstrap -->
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="<c:url value="/resources/vendors/google-code-prettify/bin/prettify.min.css"/>" rel="stylesheet">
    <!-- Select2 -->
    <link href="<c:url value="/resources/vendors/select2/dist/css/select2.min.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">
    <!-- starrr -->
    <link href="<c:url value="/resources/vendors/starrr/dist/starrr.css"/>" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.css"/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/build/css/custom.min.css"/>" rel="stylesheet">
<title>sửa nhà cung cấp</title>
</head>

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
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Sửa thông tin nhà cung cấp</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    
                                    <!-- Form -->
                                    <c:set var="sessionNhaCC" value="${sessionScope.suanhacc}"/>
                                    <c:if test="${!empty sessionNhaCC}">
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" method="post" action='<c:url value="/nhacungcap/ktra"/>'>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name" >Mã nhà cung cấp</label> <span class="required">*</span>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="manhacungcap" value="${sessionNhaCC.manhacungcap}" readonly/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Tên nhà cung cấp</label> <span class="required">*</span>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="last-name" name="tennhacungcap" required="required" class="form-control col-md-7 col-xs-12" value="${sessionNhaCC.tennhacungcap}"/>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12" >Số điện thoại nhà cung cấp</label><span class="required">*</span>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name" class="form-control col-md-7 col-xs-12" type="number" name="sodienthoainhacungcap" required="required" value="${sessionNhaCC.sodienthoai}"/>
                                                <c:if test="${!empty sessionScope.error_sdt}">
                                                <div style="color: red"><c:out value="${error_sdt}"/> </div>
                                                </c:if>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ nhà cung cấp</label><span class="required">*</span>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <textarea  class="form-control col-md-7 col-xs-12" name="diachinhacungcap" rows="5" required="required">${sessionNhaCC.diachi}</textarea>
                                            </div>
                                        </div>

                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                              <a href="<c:url value="/nhacungcap/quanlynhacungcap"/>"><button class="btn btn-primary" type="button">Hủy</button></a>
                                               <a> <button class="btn btn-primary" type="reset">Xóa form</button></a>
                                                <button type="submit" class="btn btn-success">Sửa</button>
                                            </div>
                                        </div>

                                    </form>
                                    </c:if>
                                    
                                    <!-- Form -->
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <!-- /page content -->


        </div>
    </div>

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
    <!-- bootstrap-progressbar -->
    <script src="<c:url value="/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"/>"></script>
    <!-- iCheck -->
    <script src="<c:url value="/resources/vendors/iCheck/icheck.min.js"/>"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="<c:url value="/resources/vendors/moment/min/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.js"/>"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="<c:url value="/resources/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/jquery.hotkeys/jquery.hotkeys.js"/>"></script>
    <script src="<c:url value="/resources/vendors/google-code-prettify/src/prettify.js"/>"></script>
    <!-- jQuery Tags Input -->
    <script src="<c:url value="/resources/vendors/jquery.tagsinput/src/jquery.tagsinput.js"/>"></script>
    <!-- Switchery -->
    <script src="<c:url value="/resources/vendors/switchery/dist/switchery.min.js"/>"></script>
    <!-- Select2 -->
    <script src="<c:url value="/resources/vendors/select2/dist/js/select2.full.min.js"/>"></script>
    <!-- Parsley -->
    <script src="<c:url value="/resources/vendors/parsleyjs/dist/parsley.min.js"/>"></script>
    <!-- Autosize -->
    <script src="<c:url value="/resources/vendors/autosize/dist/autosize.min.js"/>"></script>
    <!-- jQuery autocomplete -->
    <script src="<c:url value="/resources/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"/>"></script>
    <!-- starrr -->
    <script src="<c:url value="/resources/vendors/starrr/dist/starrr.js"/>"></script>
    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/build/js/custom.min.js"/>"></script>

</body>
</html>