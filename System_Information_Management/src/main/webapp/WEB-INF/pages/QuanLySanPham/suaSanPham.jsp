<%@page import="java.util.StringTokenizer"%>
<%@page import="com.cochau.model.Nhacungcap"%>
<%@page import="com.cochau.model.Sanpham"%>
<%@page import="com.cochau.model.Chucvu"%>
<%@page import="java.util.List"%>
<%@page import="com.cochau.model.Nhanvien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
<link
	href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
<!-- NProgress -->
<link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>"
	rel="stylesheet">
<!-- iCheck -->
<link
	href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css"/>"
	rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link
	href="<c:url value="/resources/vendors/google-code-prettify/bin/prettify.min.css"/>"
	rel="stylesheet">
<!-- Select2 -->
<link
	href="<c:url value="/resources/vendors/select2/dist/css/select2.min.css"/>"
	rel="stylesheet">
<!-- Switchery -->
<link
	href="<c:url value="/resources/vendors/switchery/dist/switchery.min.css"/>"
	rel="stylesheet">
<!-- starrr -->
<link href="<c:url value="/resources/vendors/starrr/dist/starrr.css"/>"
	rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link
	href="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.css"/>"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<c:url value="/resources/build/css/custom.min.css"/>"
	rel="stylesheet">
<title>Sửa Sản Phẩm</title>
</head>

<body class="nav-md">
	<%!public int toKenNiZer(String a) {
		StringTokenizer stringTokenizer = new StringTokenizer(a, " ");
		return Integer.parseInt(stringTokenizer.nextToken());

	}%>
	<div class="container body">
		<div class="main_container">

			<c:import url="../menu.jsp" />
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								<a
									href="<%=application.getContextPath()%>/SanPham/QuanLySanPham">Quản
									lý sản phẩm</a>
							</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
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
									<h2>Sửa thông tin sản phẩm</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>

								<%
									Sanpham sanpham = (Sanpham) session.getAttribute("suasanpham");
								%>
								<%
									List<Nhacungcap> danhSachNhaCungCap = (List<Nhacungcap>) session.getAttribute("listNhaCungCap");
								%>

								<div class="x_content">
									<form class="form-horizontal"
										action="<%=application.getContextPath()%>/SanPham/XuLySuaSanPham">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="masanpham">Mã
												sản phẩm:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													value="<%=sanpham.getMasanpham()%>" name="masanpham"
													id="masanpham" required="required" readonly>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="tensanpham">Tên
												sản phẩm:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="tensanpham"
													id="tensanpham" value="<%=sanpham.getTensanpham()%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="soluong">Số
												lượng:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="soluong"
													required="required" value="<%=sanpham.getSoluong()%>"
													id="soluong">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="mausac">Màu
												sắc:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="mausac"
													required="required" value="<%=sanpham.getMausac()%>"
													id="mausac">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="cameratruoc">Camera
												trước:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="cameratruoc"
													id="cameratruoc" value="<%=toKenNiZer(sanpham.getCamaratruoc())%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="camerasau">Camera
												sau:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="camerasau"
													id="camerasau" value="<%=toKenNiZer(sanpham.getCamarasau())%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="bonho">Bộ
												nhớ:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="bonho"
													id="bonho" value="<%=toKenNiZer(sanpham.getBonho())%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="hedieuhanh">Hệ
												điều hành:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="hedieuhanh"
													id="hedieuhanh" value="<%=sanpham.getHedieuhanh()%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="pin">Pin:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="pin"
													id="pin" value="<%=toKenNiZer(sanpham.getPin())%>" required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="giaban">Giá
												bán:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="giaban"
													id="giaban" value="<%=sanpham.getGiaban()%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="thoigianbaohanh">Thời
												gian bảo hành:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control"
													name="thoigianbaohanh" id="thoigianbaohanh"
													value="<%=toKenNiZer(sanpham.getThoigianbaohanh())%>"
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
											<button type="submit" class="btn btn-success btn-block">
												<span class="glyphicon glyphicon-edit"></span> Sửa
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
	<!-- Bootstrap -->
	<script
		src="<c:url value="/resources/bootstrap/dist/js/bootstrap.min.js"/>"></script>
	<!-- FastClick -->
	<script
		src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js"/>"></script>
	<!-- NProgress -->
	<script
		src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="<c:url value="/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"/>"></script>
	<!-- iCheck -->
	<script src="<c:url value="/resources/vendors/iCheck/icheck.min.js"/>"></script>
	<!-- bootstrap-daterangepicker -->
	<script
		src="<c:url value="/resources/vendors/moment/min/moment.min.js"/>"></script>
	<script
		src="<c:url value="/resources/vendors/bootstrap-daterangepicker/daterangepicker.js"/>"></script>
	<!-- bootstrap-wysiwyg -->
	<script
		src="<c:url value="/resources/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"/>"></script>
	<script
		src="<c:url value="/resources/vendors/jquery.hotkeys/jquery.hotkeys.js"/>"></script>
	<script
		src="<c:url value="/resources/vendors/google-code-prettify/src/prettify.js"/>"></script>
	<!-- jQuery Tags Input -->
	<script
		src="<c:url value="/resources/vendors/jquery.tagsinput/src/jquery.tagsinput.js"/>"></script>
	<!-- Switchery -->
	<script
		src="<c:url value="/resources/vendors/switchery/dist/switchery.min.js"/>"></script>
	<!-- Select2 -->
	<script
		src="<c:url value="/resources/vendors/select2/dist/js/select2.full.min.js"/>"></script>
	<!-- Parsley -->
	<script
		src="<c:url value="/resources/vendors/parsleyjs/dist/parsley.min.js"/>"></script>
	<!-- Autosize -->
	<script
		src="<c:url value="/resources/vendors/autosize/dist/autosize.min.js"/>"></script>
	<!-- jQuery autocomplete -->
	<script
		src="<c:url value="/resources/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"/>"></script>
	<!-- starrr -->
	<script src="<c:url value="/resources/vendors/starrr/dist/starrr.js"/>"></script>
	<!-- Custom Theme Scripts -->
	<script src="<c:url value="/resources/build/js/custom.min.js"/>"></script>

</body>
</html>