<%@page import="java.text.DecimalFormat"%>
<%@page import="com.cochau.model.Sanpham"%>
<%@page import="com.cochau.model.Khachhang"%>
<%@page import="com.cochau.services.KhachHangService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.DayOfWeek"%>
<%@page import="com.cochau.model.Hoadon"%>
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
<script>
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
<title>Quản Lý Hóa Đơn</title>
</head>
<body class="nav-md">
	<%!public String formatNumberLuong(double luong) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(luong);
	}%>
	
	<!-- Modal add detail bill -->
	<div class="container">
		<div class="modal fade" id="modal_add" role="dialog">
	    <div class="modal-dialog">
	    
	   
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Modal Header</h4>
	        </div>
	         <c:set value="${sessionScope.listKhachHang}" var="khachhang"/>
	         <c:set value="${sessionScope.listNhanVien}" var="nhanvien"/>
	         	<div class="modal-body">
									<form class="form-horizontal"
										action="<c:url value="/HoaDon/Themhoadon"/>" method="post">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="manhanvien">Mã
												Hóa Đơn:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													value="HD<%=System.currentTimeMillis()%>" name="mahoadon"
													id="mahoadon" required="required" readonly>
											</div>
										</div>
										
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="ngaysinh">Ngày
												Lập Hóa Đơn:*</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="ngaylaphoadon"
													required="required" id="datepicker">
											</div>
										</div>
										
										
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="chucvu">Tên khách hàng:</label>
											<div class="col-sm-9">
												<select name="makhachhang" id="chucvu" class="form-control">
													<c:forEach items="${khachhang}" var="khachhang">
													<option value="${khachhang.makhachhang}">
													<c:out value="${khachhang.tenkhachhang}"/>
													</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="chucvu">Tên nhân viên:</label>
											<div class="col-sm-9">
												<select name="manhanvien" id="chucvu" class="form-control">
													<c:forEach items="${nhanvien}" var="nhanvien">
													<option value="${nhanvien.manhanvien}">
													<c:out value="${nhanvien.tennhanvien}"/>
													</option>
													</c:forEach>
												</select>
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
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	</div>
	
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
									<h3>Quản lý hóa đơn</h3>
									<div style="padding-left: 870px"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_add"><span class="glyphicon glyphicon-plus"></span>Thêm hóa đơn</button>
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
												<h2>Danh sách hóa đơn</h2>
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
															<th>Mã hóa đơn</th>
															<th>Tên khách hàng</th>
															<th>Ngày lập hóa đơn</th>
															<th>Nhân viên bán</th>
															<th>Tổng số lượng sản phẩm</th>
															<th>Tổng tiền</th>
															<th>Trạng thái</th>
														</tr>
													</thead>
													<tbody>
														<%
															List<Hoadon> listHoaDon = (List<Hoadon>) session.getAttribute("quanLyHoaDon");
														%>
														<%
															for (Hoadon hoadon : listHoaDon) {
														%>
														<tr>
															<td><%=hoadon.getMahoadon()%></td>
															<td><%=hoadon.getKhachhangByMakhachhang().getTenkhachhang()%></td>
															<td><%=hoadon.getNgaylaphoadon()%></td>
															<td><%=hoadon.getNhanvienByManhanvien().getTennhanvien()%></td>
															<td><%=hoadon.getTongsoluong()%></td>
															<td><%=formatNumberLuong((double) hoadon.getTongtien())%>&nbsp;Đồng</td>
															<td><a class="btn btn-primary btn-xs"
																href="<%=application.getContextPath()%>/HoaDon/ThongTinHoaDon?MaHD=<%=hoadon.getMahoadon()%>">
																	<span class="glyphicon glyphicon-list-alt"></span>&nbsp;Xem
																	thông tin
															</a> <a class="btn btn-danger btn-xs" data-toggle="modal"
																data-target="#xoaHD<%=hoadon.getMahoadon()%>"><span
																	class="glyphicon glyphicon-trash"></span>&nbsp;Xóa</a>
																	</td>
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
					<%
						for (Hoadon hoadon : listHoaDon) {
					%>
					<div class="modal fade" id="xoaHD<%=hoadon.getMahoadon()%>"
						role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h3 class="modal-title">Xóa hóa đơn</h3>
								</div>
								<div class="modal-body">
									<h4>
										Bạn có chắc muốn xóa hóa đơn
										<%=hoadon.getMahoadon()%>
										này ?
									</h4>
								</div>
								<div class="modal-footer">
									<a
										href="<%=application.getContextPath()%>/HoaDon/XoaHoaDon?MaHD=<%=hoadon.getMahoadon()%>"><button
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