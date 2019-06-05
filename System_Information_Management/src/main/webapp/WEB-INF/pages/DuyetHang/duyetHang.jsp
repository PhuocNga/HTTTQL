<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/nprogress/nprogress.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/build/css/custom.min.css "/>" rel="stylesheet">
            <title>Duyệt đơn nhập hàng</title>
        </head>

        <body class="nav-md">
            <div class="container body">
                <div class="main_container">
					<c:import url="../menu.jsp"/>
				
                    <!-- page content -->
                    <div class="right_col" role="main">
                        <div class="">
                            <div class="clearfix"></div>

                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h3>Duyệt đơn nhập hàng</h3>
                                            </div>


                                            <ul class="nav navbar-right panel_toolbox">
                                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                </li>
                                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                </li>
                                            </ul>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">


                                            <div class="col-md-12 col-sm-12 col-xs-12">

                                                <div class="x_panel">

                                                    <div class="x_title">
                                                        <h2>Danh sách đơn đề nghị duyệt hàng</h2>
                                                      
                                                        <ul class="nav navbar-right panel_toolbox">
                                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                            </li>

                                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                            </li>
                                                        </ul>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                    <div class="x_content">
                                                    <p style="color: red"> ${thongBao}</p>
                                                        <table id="datatable-buttons" class="table table-striped table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Mã đơn đề nghị</th>
                                                                    <th>Ngày đề nghị</th>
                                                                    <th>Nhân viên</th>
                                                                    <th>Số lượng</th>
                                                                    <th>Tổng số tiền</th>
                                                                    <th>Xem chi tiết</th>
                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                                <c:if test="${!empty dh}">
                                                                    <c:forEach items="${dh}" var="dh">
                                                                        <tr>
                                                                            <td>${dh.madonduyethang}</td>
                                                                            <td>${dh.ngaylap}</td>
                                                                            <td>${dh.manhanvien}</td>
                                                                            <td>${dh.tongsoluong } cái</td>
                                                                            <td>${dh.tonggiatri }VNĐ</td>
                                                                            <td>
                                                                                <a href="chiTietDuyetDon/${dh.madonduyethang}" class="btn btn-danger btn-xs" ><span ></span> Chi tiết</a></td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                                <!-- /page content -->
                            </div>
                        </div>

                        <!--Modal them nha cc-->
                        <div class="container">

                            <!--Model thêm-->
                            
                          
                        </div>
                    </div>
                    <!-- page content -->
                    
        <footer>
          <div class="pull-right">
            Hệ thống thông tin quản lý - đề tài:quản lý cửa hàng điện thoại
          </div>
          <div class="clearfix"></div>
        </footer>
                </div>
            </div>
            <!-- jQuery -->
            <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js " />"></script>

            <!-- Bootstrap -->
            <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js " />"></script>
            <!-- FastClick -->
            <script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js " />"></script>">

            <!-- NProgress -->
            <script src="<c:url value="/resources/vendors/nprogress/nprogress.js " />"></script>
            <!-- iCheck -->
            <script src="<c:url value="/resources/vendors/iCheck/icheck.min.js " />"></script>
            <!-- Datatables -->
            <script src="<c:url value="/resources/vendors/datatables.net/js/jquery.dataTables.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js " />"></script>
            <script src=" <c:url value="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js " />"></script>
            <script src=" <c:url value="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/jszip/dist/jszip.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/pdfmake/build/pdfmake.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/pdfmake/build/vfs_fonts.js " />"></script>
            <!-- Custom Theme Scripts -->
            <script src="<c:url value="/resources/build/js/custom.min.js " />"></script>
        </body>

        </html>