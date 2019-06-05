<%@page import="com.cochau.model.Sanpham"%>
<%@page import="com.cochau.model.KyluatNhanvien"%>
<%@page import="com.cochau.model.Kyluat"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@page import="com.cochau.model.KhenthuongNhanvien"%>
<%@page import="com.cochau.model.Khenthuong"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.cochau.model.Nhanvien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Thông Tin Sản Phẩm</title>
</head>
<body class="nav-md">
	<%!public String formatNumberLuong(double luong) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(luong);
	}%>

	<%
		Sanpham sanpham = (Sanpham) session.getAttribute("listThongTin");
	%>
	<div class="container body">
		<div class="main_container">

			<c:import url="../menu.jsp" />

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
						<div class="col-md-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Thông tin nhân viên</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a></li>
												<li><a href="#">Settings 2</a></li>
											</ul></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div class="col-md-12 col-lg-12 col-sm-12">
										<div style="padding: 3%">
											<table cellpadding="4" cellspacing="0"
												class="table table-striped table-bordered"
												style="text-align: center;">
												<tr>
													<td>Mã sản phẩm</td>
													<td><%=sanpham.getMasanpham()%></td>
												</tr>
												<tr>
													<td>Tên sản phẩm</td>
													<td><%=sanpham.getTensanpham()%></td>
												</tr>
												<tr>
													<td>Số lượng</td>
													<td><%=sanpham.getSoluong()%></td>
												</tr>
												<tr>
													<td>Màu sắc</td>
													<td><%=sanpham.getMausac()%></td>
												</tr>
												<tr>
													<td>Camera trước</td>
													<td><%=sanpham.getCamaratruoc()%></td>
												</tr>
												<tr>
													<td>Camera sau</td>
													<td><%=sanpham.getCamarasau()%></td>
												</tr>
												<tr>
													<td>Bộ nhớ</td>
													<td><%=sanpham.getBonho()%></td>
												</tr>
												<tr>
													<td>Hệ điều hành</td>
													<td><%=sanpham.getHedieuhanh()%></td>
												</tr>
												<tr>
													<td>Pin</td>
													<td><%=sanpham.getPin()%>
													</td>
												</tr>
												<tr>
													<td>Giá bán</td>
													<td><%=formatNumberLuong(sanpham.getGiaban())%>
														</td>
												</tr>
													<tr>
													<td>Thời gian bảo hành</td>
													<td><%=sanpham.getThoigianbaohanh()%></td>
												</tr>
												<tr>
													<td>Nhà cung cấp</td>
													<td><%=sanpham.getNhacungcapByManhacungcap().getTennhacungcap()%>
													</td>
												</tr>
											</table>
										</div>
									</div>
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