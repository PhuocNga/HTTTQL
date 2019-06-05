<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css "/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css "/> "
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/nprogress/nprogress.css "/> "
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css "/> "
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css "/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css "/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css "/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css "/>"
	rel="stylesheet">
<link
	href="<c:url value="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css "/>"
	rel="stylesheet">
<link href="<c:url value="/resources/build/css/custom.min.css "/>"
	rel="stylesheet">
<title>Quản Lý Nhân Viên</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <title>quản lý nhà cung cấp</title>
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
                                            <h3>Quản lý nhà cung cấp</h3>
                                            <div style="padding-left: 870px"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#themncc"><span class="glyphicon glyphicon-plus"></span>Thêm nhà cung cấp</button>
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
                                                        <h2>Danh sách nhà cung cấp</h2>
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
                                                                    <th>Mã nhà cung cấp</th>
                                                                    <th>Tên nhà cung cấp</th>
                                                                    <th>Địa chỉ</th>
                                                                    <th>Số điện thoại</th>
                                                                 
                                                                    <th>Thao tác</th>
                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                                <c:if test="${!empty list_nhacc}">
                                                                    <c:forEach items="${list_nhacc}" var="nhacc">
                                                                        <c:if test="${nhacc.getExit()}">
                                                                        <tr>
                                                                            <td>${nhacc.manhacungcap}</td>
                                                                            <td>${nhacc.tennhacungcap}</td>
                                                                            <td>${nhacc.diachi}</td>
                                                                            <td>${nhacc.sodienthoai}</td>
                                                                            <td><a class="btn btn-primary btn-xs" href="<c:url value='/nhacungcap/xemthongtinnhacc/${nhacc.manhacungcap}'/>"><span class="glyphicon glyphicon-folder-open"></span> Xem thông tin</a>
                                                                                <a class="btn btn-info btn-xs" href="<c:url value='/nhacungcap/suanhacungcap/${nhacc.manhacungcap}'/>"><span class="glyphicon glyphicon-edit" ></span> Sửa</a>
                                                                                <a class="btn btn-danger btn-xs" data-toggle="modal" data-target="#xoanhacc${nhacc.manhacungcap}"><span class="glyphicon glyphicon-trash"></span> Xóa</a></td>
                                                                        </tr>
                                                                        </c:if>
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
                                            <h3 class="modal-title">Thêm nhà cung cấp</h3>
                                        </div>
                                        <div class="modal-body">
                                            <form action="<c:url value="/nhacungcap/themnhacungcap"/>" >
                                                <label for="mancc">Mã nhà cung cấp *</label>
                             					<%long id=System.currentTimeMillis();%>
                                                <input type="text" class="form-control" name="manhacungcap" value="<%="NCC"+id%>" readonly>
                                                <label for="tenncc">Tên nhà cung cấp *</label>
                                                <input type="text" class="form-control" name="tennhacungcap" required="required">
                                                <label for="mancc">Số điện thoại nhà cung cấp *</label>
                                                <input type="number" class="form-control" name="sdtnhacungcap" required="required">
                                                <label for="mancc">Địa chỉ nhà cung cấp *</label>
                                                <br>
                                                <textarea rows="5" class="form-control" name="diachinhacungcap" required="required"></textarea>
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

                            <!--Model xóa-->
							<c:if test="${!empty list_nhacc}">
							<c:forEach items="${list_nhacc}" var="nhacc">
                            <div class="modal fade" id="xoanhacc${nhacc.manhacungcap}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h3 class="modal-title">Xóa nhà cung cấp</h3>
                                        </div>
                                        <div class="modal-body">
                                            <h4>Bạn có chắt muốn xóa nhà cung cấp >> <c:out value="${nhacc.tennhacungcap}"/></h4>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="<c:url value="/nhacungcap/xoanhacungcap/${nhacc.manhacungcap}"/>"><button class="btn btn-danger"><span class="glyphicon glyphicon-ok"></span> Có</button></a>
                                            <a><button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Không</button></a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            </c:forEach>
							</c:if>
                        </div>
                    </div>
                    <!-- page content -->
       <footer>
				<div class="pull-right">Hệ thống thông tin quản lý - đề
					tài:quản lý cửa hàng điện thoại</div>
				<div class="clearfix"></div>
			</footer>
		</div>
	</div>
	<!-- jQuery -->
	<script
		src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js " />"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Bootstrap -->
	<script
		src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js " />"></script>
	<!-- FastClick -->
	<script
		src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js " />"></script>
	<!-- NProgress -->
	<script
		src="<c:url value="/resources/vendors/nprogress/nprogress.js " />"></script>
	<!-- iCheck -->
	<script
		src="<c:url value="/resources/vendors/iCheck/icheck.min.js " />"></script>
	<!-- Datatables -->
	<script
		src="<c:url value="/resources/vendors/datatables.net/js/jquery.dataTables.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js " />"></script>
	<script
		src=" <c:url value="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js " />"></script>
	<script
		src=" <c:url value="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/jszip/dist/jszip.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/pdfmake/build/pdfmake.min.js " />"></script>
	<script
		src="<c:url value="/resources/vendors/pdfmake/build/vfs_fonts.js " />"></script>
	<!-- Custom Theme Scripts -->
	<script src="<c:url value="/resources/build/js/custom.min.js " />"></script>
</body>

</html>