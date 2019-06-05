<%@page import="com.cochau.model.Nhacungcap"%>
<%@page import="com.cochau.model.Sanpham"%>
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
<title>Quản Lý Sản Phẩm</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body class="nav-md">
	<%
		List<Sanpham> listSanPham = (List<Sanpham>) session.getAttribute("listSanPham");
	%>
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
									<h3>Quản lý sản phẩm</h3>
									<div style="padding-left: 84%">
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#themsanpham">
											<span class="glyphicon glyphicon-plus"></span>&nbsp;Thêm sản
											phẩm
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
												<h2>Danh sách sản phẩm</h2>
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
															<th>Mã sản phẩm</th>
															<th>Tên sản phẩm</th>
															<th>Giá bán</th>
															<th>Nhà cung cấp</th>
															<th>Thao tác</th>
														</tr>
													</thead>
													<tbody>

														<%
															for (Sanpham sanpham : listSanPham) {
														%>
														<tr>
															<td><%=sanpham.getMasanpham()%></td>
															<td><%=sanpham.getTensanpham()%></td>
															<td><%=sanpham.getGiaban()%></td>
															<td><%=sanpham.getNhacungcapByManhacungcap().getTennhacungcap()%></td>
															<td><a class="btn btn-success btn-xs"
																href="<%=application.getContextPath()%>/SanPham/ThongTinSanPham?MaSP=<%=sanpham.getMasanpham()%>">
																	<span class="glyphicon glyphicon-folder-open"></span>&nbsp;Xem
																	thông tin
															</a> <a class="btn btn-info btn-xs"
																href="<%=application.getContextPath()%>/SanPham/SuaSanPham?MaSP=<%=sanpham.getMasanpham()%>"><span
																	class="glyphicon glyphicon-edit"></span>&nbsp;Sửa</a> <a
																class="btn btn-danger btn-xs" data-toggle="modal"
																data-target="#xoasanpham<%=sanpham.getMasanpham()%>"><span
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

					<div class="modal fade" id="themsanpham" role="dialog">
						<div class="modal-dialog">
							<%
								List<Nhacungcap> danhSachNhaCungCap = (List<Nhacungcap>) session.getAttribute("listNhaCungCap");
							%>
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h3 class="modal-title">Thêm sản phẩm</h3>
								</div>
								<div class="modal-body">
									<form class="form-horizontal"
										action="<%=application.getContextPath()%>/SanPham/ThemSanPham">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="masanpham">Mã
												sản phẩm:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													value="SP<%=System.currentTimeMillis()%>" name="masanpham"
													id="masanpham" required="required" readonly>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="tensanpham">Tên
												sản phẩm:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="tensanpham"
													id="tensanpham" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="soluong">Số
												lượng:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="soluong"
													required="required" id="soluong">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="mausac">Màu
												sắc:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="mausac"
													required="required" id="mausac">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="cameratruoc">Camera
												trước:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="cameratruoc"
													id="cameratruoc" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="camerasau">Camera
												sau:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="camerasau"
													id="camerasau" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="bonho">Bộ
												nhớ:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="bonho"
													id="bonho" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="hedieuhanh">Hệ
												điều hành:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="hedieuhanh"
													id="hedieuhanh" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="pin">Pin:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="pin"
													id="pin" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="giaban">Giá
												bán:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="giaban"
													id="giaban" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="thoigianbaohanh">Thời
												gian bảo hành:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control"
													name="thoigianbaohanh" id="thoigianbaohanh"
													required="required">
											</div>
										</div>

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="nhacungcap">Nhà
												cung cấp:</label>
											<div class="col-sm-9">
												<select name="nhacungcap" id="nhacungcap"
													class="form-control">
													<%
														for (Nhacungcap nhacungcap : danhSachNhaCungCap) {
													%>
													<option value="<%=nhacungcap.getManhacungcap()%>"><%=nhacungcap.getTennhacungcap()%>
													</option>
													<%
														}
													%>
												</select>
											</div>
										</div>

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
						for (Sanpham sanpham : listSanPham) {
					%>
					<div class="modal fade" id="xoasanpham<%=sanpham.getMasanpham()%>"
						role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h3 class="modal-title">Xóa sản phẩm</h3>
								</div>
								<div class="modal-body">
									<h4>
										Bạn có chắc muốn xóa sản phẩm
										<%=sanpham.getMasanpham()%>
										này ?
									</h4>
								</div>
								<div class="modal-footer">
									<a
										href="<%=application.getContextPath()%>/SanPham/XoaSanPham?MaSP=<%=sanpham.getMasanpham()%>"><button
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