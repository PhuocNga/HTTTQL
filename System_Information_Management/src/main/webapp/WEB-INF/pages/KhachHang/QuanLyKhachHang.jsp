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
            <title>Quản lý Khách Hàng</title>
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
                                            <h3>Quản lý khách hàng</h3>
                                            <center> <h2  class="btn-success">${createSuccess}</h2></center>
                                           
                                           
                                            <div style="padding-left: 870px"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#themncc"><span class="glyphicon glyphicon-plus"></span>Thêm Khách Hàng</button>
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
                                                        <h2>Danh sách khách hàng</h2>
                                                        
                                                        <ul class="nav navbar-right panel_toolbox">
                                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                            </li>

                                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                            </li>
                                                        </ul>
                                                        <div class="clearfix"></div>
                                                    </div>
                                                    <div class="x_content">
                                                        <table id="datatable-buttons" class="table table-striped table-bordered">
                                                            <thead>
                                                                <tr>
                                                                    <th>Mã Khách Hàng</th>
                                                                    <th>Tên Khách Hàng</th>
                                                                    <th>Địa chỉ</th>
                                                                    <th>Số điện thoại</th>
                                                                    <th>Thao tác</th>
                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                                <c:if test="${!empty kh}">
                                                                    <c:forEach items="${kh}" var="kh">
                                                                        <tr>
                                                                            <td>${kh.makhachhang}</td>
                                                                            <td>${kh.tenkhachhang}</td>
                                                                            <td>${kh.diachi}</td>
                                                                            <td>${kh.sodienthoai }</td>
                                                                            <td><a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#chitietkh${kh.makhachhang}" ><span class="glyphicon glyphicon-folder-open"></span> Xem thông tin</a>
                                                                                <a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#suakh${kh.makhachhang}" ><span class="glyphicon glyphicon-edit" ></span> Sửa</a>
                                                                                <a class="btn btn-danger btn-xs" data-toggle="modal" data-target="#xoakh${kh.makhachhang}"><span class="glyphicon glyphicon-trash"></span> Xóa</a></td>
                                                                        </tr>
                                                                        <!--Model thêm-->
                            <div class="modal fade" id="chitietkh${kh.makhachhang}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h3 class="modal-title">Chi tiết khách hàng</h3>
                                        </div>
                                        <div class="modal-body" style="text-align: center;">
                                       		
                                            
                                               <h2> <label for="mancc">Mã khách hàng *</label> ${kh.makhachhang}</h2>
                                                <br>
                                                
                                               <h2> <label for="tenncc">Tên khách hàng *</label>${kh.tenkhachhang}</h2>
                                               <br>
                                               <h2> <label for="mancc">Số điện thoại khách hàng *</label>${kh.sodienthoai }</h2>
                                                <br>
                                                
                                                <h2><label for="mancc">CMND khách hàng *</label>${kh.sochungminh}</h2>
                                                <br>
                                               <h2> <label for="mancc">Ngày sinh *</label>${kh.ngaysinh}</h2>
                                                <br>
                                              <h2>  <label for="mancc">Địa chỉ khách hàng *</label></h2>
                                                
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>
                             <!--Model xóa-->
							
                            <div class="modal fade" id="xoakh${kh.makhachhang}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h3 class="modal-title">Xóa khách hàng</h3>
                                        </div>
                                        <div class="modal-body">
                                            <h4>Bạn có chắt muốn xóa có id :${kh.makhachhang}</h4>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="<c:url value="/xoaKhachHang/${kh.makhachhang}"/>"><button class="btn btn-danger"><span class="glyphicon glyphicon-ok"></span> Có</button></a>
                                            <a><button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Không</button></a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            
                            <!--Model sữa-->
                            <div class="modal fade" id="suakh${kh.makhachhang}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h3 class="modal-title">Sửa khách hàng</h3>
                                        </div>
                                        <div class="modal-body">
                                            <form action="suaKhachHang/${kh.makhachhang }" >
                                                <label for="mancc">Mã khách hàng *</label>
                                                <input readonly value="${kh.makhachhang}" type="text" class="form-control" name="id${kh.makhachhang }" required="required">
                                                <label for="tenncc">Tên khách hàng *</label>
                                                <input value="${kh.tenkhachhang}" type="text" class="form-control" name="name${kh.makhachhang }" required="required">
                                                <label for="mancc">Số điện thoại khách hàng *</label>
                                                <input value="${kh.sodienthoai}" type="number" class="form-control" name="sdt${kh.makhachhang }" required="required">
                                                <label  for="mancc">CMND khách hàng *</label>
                                                <input value="${kh.sochungminh}" type="number" class="form-control" name="cmnd${kh.makhachhang }" required="required">
                                                <label for="mancc">Ngày sinh *</label>
                                                <input value="${kh.ngaysinh}" type="date" class="form-control" name="ngaysinh${kh.makhachhang }" required="required">
                                                <label for="mancc">Địa chỉ khách hàng *</label>
                                                <br>
                                                <textarea   rows="5" class="form-control" name="diachi${kh.makhachhang}" required="required">${kh.diachi}</textarea>
                                                <br>
                                                <div style="text-align: center"><button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Sửa</button></div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>
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
                            <div class="modal fade" id="themncc" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h3 class="modal-title">Thêm Khách Hàng</h3>
                                        </div>
                                        <div class="modal-body">
                                            <form action="themKhachHang" >
                                                <label for="mancc">Mã Khách Hàng *</label>
                                                <input readonly type="text" class="form-control" name="id" value="<%out.print("KH"+System.currentTimeMillis()); %>" required="required">
                                                <label for="tenncc">Tên Khách Hàng *</label>
                                                <input type="text" class="form-control" name="name" required="required">
                                                <label for="mancc">Số điện thoại Khách Hàng *</label>
                                                <input type="number" class="form-control" name="sdt" required="required">
                                                <label for="mancc">Địa chỉ Khách Hàng *</label>
                                                <input type="number" class="form-control" name="cmnd" required="required">
                                                <label for="mancc">CMND Khách Hàng *</label>
                                                <input type="number" class="form-control" name="sdt" required="required">
                                                <label for="mancc">Ngày sinh *</label>
                                                <input type="date" class="form-control" name="ngaysinh" required="required">
                                                <label for="mancc">Địa chỉ Khách Hàng *</label>
                                                <br>
                                                <textarea rows="5" class="form-control" name="diachi" required="required"></textarea>
                                                <br>
                                                <div style="text-align: center"><button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Thêm</button></div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>

                           
                           
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