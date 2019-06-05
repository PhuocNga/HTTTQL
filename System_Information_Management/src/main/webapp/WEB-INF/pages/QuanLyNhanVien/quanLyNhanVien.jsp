<%@page import="com.cochau.model.Chucvu"%>
<%@page import="com.cochau.model.Nhanvien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
    $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat : 'yy-mm-dd',
            changeMonth : true,
            changeYear : true,
            yearRange: '-100y:c+nn',
            maxDate: '0d'
        });
    });
</script>
</head>
<%
	List<Nhanvien> listNhanVien = (List<Nhanvien>) session.getAttribute("quanLyNhanVien");
%>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<c:import url="../menu.jsp" />

			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h3>Quản lý nhân viên</h3>
									<div style="padding-left: 84%">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#themnhanvien">
											<span class="glyphicon glyphicon-plus"></span>&nbsp;Thêm nhân
											viên
										</button>
									</div>


									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">


									<div class="col-md-12 col-sm-12 col-xs-12">

										<div class="x_panel">

											<div class="x_title">
												<h2>Danh sách nhân viên</h2>
												<ul class="nav navbar-right panel_toolbox">
													<li><a class="collapse-link"><i
															class="fa fa-chevron-up"></i></a></li>

													<li><a class="close-link"><i class="fa fa-close"></i></a>
													</li>
												</ul>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<table id="datatable-buttons"
													class="table table-striped table-bordered"
													style="width: 100% !important">
													<thead>
														<tr>
															<th>Mã nhân viên</th>
															<th>Tên nhân viên</th>
															<th>Số điện thoại</th>
															<th>Chức vụ</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>

														<%
															for (Nhanvien nhanvien : listNhanVien) {
														%>
														<tr>
															<td><%=nhanvien.getManhanvien()%></td>
															<td><%=nhanvien.getTennhanvien()%></td>
															<td><%=nhanvien.getSodienthoai()%></td>
															<td><%=nhanvien.getChucvuByMachucvu().getTenchucvu()%>
															</td>
															<td><a class="btn btn-success btn-xs"
																href="<%=application.getContextPath()%>/NhanVien/ThongTinNhanVien?MaNV=<%=nhanvien.getManhanvien()%>">
																	<span class="glyphicon glyphicon-folder-open"></span>&nbsp;Xem
																	thông tin
															</a> <a class="btn btn-info btn-xs"
																href="<%=application.getContextPath()%>/NhanVien/SuaNhanVien?MaNV=<%=nhanvien.getManhanvien()%>"><span
																	class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</a> <a
																class="btn btn-danger btn-xs" data-toggle="modal"
																data-target="#xoanhanvien<%=nhanvien.getManhanvien()%>"><span
																	class="glyphicon glyphicon-trash"></span>&nbsp;Xóa</a></td>
														</tr>
														<%
															}
														%>
													</tbody>
												</table>
											</div>
										</div>
									</div>


								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="container">

					<div class="modal fade" id="themnhanvien" role="dialog">
						<div class="modal-dialog">
							<%
								List<Chucvu> danhSachTenChucVu = (List<Chucvu>) session.getAttribute("danhSachTenChucVu");
							%>
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h3 class="modal-title">Thêm nhân viên</h3>
								</div>
								<div class="modal-body">
									<form class="form-horizontal"
										action="<%=application.getContextPath()%>/NhanVien/ThemNhanVien">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="manhanvien">Mã
												nhân viên:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													value="NV<%=System.currentTimeMillis()%>" name="manhanvien"
													id="manhanvien" required="required" readonly>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="tennhanvien">Tên
												nhân viên:*</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="tennhanvien"
													id="tennhanvien" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="ngaysinh">Ngày
												sinh:*</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="ngaysinh"
													required="required" id="datepicker">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="gioitinh">Giới
												tính:</label>
											<div class="col-sm-9">
												<label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nam" id="gioitinh" checked>
													Nam
												</label> <label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nữ" id="gioitinh"> Nữ
												</label>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="sodienthoai">Số
												điện thoại:*</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="sodienthoai"
													id="sodienthoai" required="required">

											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="chucvu">Chức
												vụ:</label>
											<div class="col-sm-9">
												<select name="chucvu" id="chucvu" class="form-control">
													<%
														for (Chucvu chucvu : danhSachTenChucVu) {
													%>
													<option value="<%=chucvu.getMachucvu()%>"><%=chucvu.getTenchucvu()%>
													</option>
													<%
														}
													%>
												</select>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="diachi">Địa
												chỉ:*</label>
											<div class="col-sm-9">
												<textarea rows="3" class="form-control" name="diachi"
													id="diachi" required="required"></textarea>
											</div>
										</div>

										<hr>
										<p>* Trường bắt buộc phải nhập</p>
										<hr>
										<div style="text-align: center" class="col-sm-12">
											<button type="submit" class="btn btn-primary btn-block">
												<span class="glyphicon glyphicon-plus"></span> Thêm
											</button>
										</div>

									</form>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>
					<%
						for (Nhanvien nhanvien : listNhanVien) {
					%>
					<div class="modal fade"
						id="xoanhanvien<%=nhanvien.getManhanvien()%>" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h3 class="modal-title">Xóa nhân viên</h3>
								</div>
								<div class="modal-body">
									<h4>
										Bạn có chắc muốn xóa nhân viên
										<%=nhanvien.getManhanvien()%>
										này ?
									</h4>
								</div>
								<div class="modal-footer">
									<a
										href="<%=application.getContextPath()%>/NhanVien/XoaNhanVien?MaNV=<%=nhanvien.getManhanvien()%>"><button
											class="btn btn-danger">
											<span class="glyphicon glyphicon-ok"></span>&nbsp;Có
										</button></a> <a><button type="button" class="btn btn-default"
											data-dismiss="modal">
											<span class="glyphicon glyphicon-remove"></span>&nbsp;Không
										</button></a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>

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