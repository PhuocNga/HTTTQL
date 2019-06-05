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
<title>Sửa Nhân Viên</title>
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

<body class="nav-md">
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
									href="<%=application.getContextPath()%>/NhanVien/QuanLyNhanVien">Quản
									lý nhân viên</a>
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
									<h2>Sửa thông tin nhân viên</h2>
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
									Nhanvien nhanvien = (Nhanvien) session.getAttribute("suanhanvien");
								%>
								<%
								List<Chucvu> danhSachTenChucVu = (List<Chucvu>) session.getAttribute("danhSachTenChucVu");
								%>

								<div class="x_content">
									<form class="form-horizontal"
										action="<%=application.getContextPath()%>/NhanVien/XuLySuaNhanVien">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="manhanvien">Mã
												nhân viên:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													value="<%=nhanvien.getManhanvien()%>" name="manhanvien"
													id="manhanvien" required="required" readonly>
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="tennhanvien">Tên
												nhân viên:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="tennhanvien"
													id="tennhanvien" value="<%=nhanvien.getTennhanvien()%>"
													required="required">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="ngaysinh">Ngày
												sinh:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="ngaysinh"
													value="<%=nhanvien.getNgaysinh()%>" required="required"
													id="datepicker">
											</div>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="gioitinh">Giới
												tính:</label>
											<% if(nhanvien.getGioitinh().equals("Nam")) {%>
											<div class="col-sm-9">
												<label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nam" id="gioitinh" checked>
													Nam
												</label> <label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nữ" id="gioitinh"> Nữ
												</label>
											</div>
											<% } else { %>
											<div class="col-sm-9">
												<label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nam" id="gioitinh" >
													Nam
												</label> <label class="radio-inline"> <input type="radio"
													name="gioitinh" value="Nữ" id="gioitinh" checked> Nữ
												</label>
											</div>
											<% } %>
										</div>
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="sodienthoai">Số
												điện thoại:</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="sodienthoai"
													value="<%=nhanvien.getSodienthoai()%>" id="sodienthoai"
													required="required">

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
												chỉ:</label>
											<div class="col-sm-9">
												<textarea rows="3" class="form-control" name="diachi"
													id="diachi" required="required"><%=nhanvien.getDiachi()%></textarea>
											</div>
										</div>

										<hr>
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
			<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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