<%@page import="java.text.DecimalFormat"%>
<%@page import="com.cochau.model.Chitiethoadon"%>
<%@page import="com.cochau.model.Hoadon"%>
<%@page import="com.cochau.model.Nhanvien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Thông Tin Hóa Đơn</title>
</head>
<body class="nav-md">
	<%!public String formatNumberLuong(double luong) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(luong);
	}%>
	<div class="container body">
		<div class="main_container">

			<!-- Menu -->
			<c:import url="../menu.jsp" />
			<!-- Menu -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								<a href="<%=application.getContextPath()%>/HoaDon/QuanLyHoaDon">Quản
									lý hóa đơn</a>
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

					<c:set value="${sessionScope.thongTinHoaDon}" var="order"/>
					<c:set value="${sessionScope.thongTinHoaDon.chitiethoadonsByMahoadon}" var="orderList"/>
					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Thông tin hóa đơn</h2>
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
								
									<div style="padding-left: 86%">
										<button type="button" class="btn btn-success">
											<span class="glyphicon glyphicon-print"></span>&nbsp;Print
										</button>
									</div>
									<div class="col-md-12 col-lg-12 col-sm-12">
										<div style="padding: 3%">
											
											<table cellpadding="4" cellspacing="0"
												class="table table-striped table-bordered">
												<tr>
													<td><h5>
															Mã hóa đơn: <c:out value="${order.mahoadon}"/>&nbsp;</h5></td>
													<td><h5>
															Ngày lập hóa đơn: <c:out value="${order.ngaylaphoadon}"/>&nbsp;</h5></td>
												</tr>
												<tr>
													<td><h5>
															Tên nhân viên: <c:out value="${order.nhanvienByManhanvien.tennhanvien}"/>&nbsp;</h5></td>
													<td><h5>
															Tên khách hàng: <c:out value="${order.khachhangByMakhachhang.tenkhachhang}"/>&nbsp;</h5></td>
												</tr>
												<tr>
													<td><h5>
															Tống số lượng sản phẩm: <c:out value="${order.tongsoluong}"/>&nbsp;</h5></td>
													<td><h5>
															Tổng giá trị hóa đơn: <fmt:formatNumber value="${order.tongtien}" type = "number" pattern = "###,###,###"/>&nbsp;Đồng</h5></td>
												</tr>
											</table>
											<hr>
											<h4>Chi tiết sản phẩm</h4>
											<br>
											<table class="table table-striped table-bordered">
												<thead>
												<div style="padding-left: 86%">
												<button class="btn btn-primary" data-toggle="modal"
																data-target="#modal_add_sp">Thêm sản phẩm</button>
												</div>
													<tr>
														<th>Mã sản phẩm</th>
														<th>Tên sản phẩm</th>
														<th>Giá bán</th>
														<th>Số lượng mua</th>
														<th>Tổng tiền</th>
														<th>Thao tác</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${orderList}" var="listOd">
													<c:set value="${listOd.soluong*listOd.sanphamByMasanpham.giaban}" var="tongtienhd"/>
													<tr>
														<td><c:out value="${listOd.masanpham}"></c:out></td>
														<td><c:out value="${listOd.sanphamByMasanpham.tensanpham}"></c:out></td>
														<td><fmt:formatNumber value="${listOd.sanphamByMasanpham.giaban}" type = "number" pattern = "###,###,###"/>&nbsp;Đồng</td>
														<td><c:out value="${listOd.soluong}"></c:out>&nbsp;Sản phẩm</td>
														<td><fmt:formatNumber type = "number" pattern = "###,###,###" value = "${tongtienhd}" /> &nbsp;Đồng</td>
														<td><button class="btn btn-info" data-toggle="modal" data-target="#editorder${listOd.masanpham}">Sửa</button>
														<button class="btn btn-danger" data-toggle="modal" data-target="#modelxoa${listOd.mahoadon}">Xóa</button>
														</td>
													</tr>
													</c:forEach>
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
			
			<!-- Modal xóa -->
			<!-- /page content -->

			<!-- footer content -->

			<!-- /footer content -->
		</div>
	</div>
	
<c:forEach items="${orderList}" var="listCTHDAlert">
<div class="modal fade" id="modelxoa${listCTHDAlert.mahoadon}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Alert Xóa</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h4><strong>Bạn có chắt chắn xóa sản phẩm</strong> <c:out value="${listCTHDAlert.sanphamByMasanpham.tensanpham}"/></h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <a href="<c:url value="/HoaDon/XoaSanPham/Mahoadon/${listCTHDAlert.mahoadon}/Masanpham/${listCTHDAlert.masanpham}"/>"><button type="button" class="btn btn-danger">Xóa</button></a>
      </div>
    </div>
  </div>
</div>
</c:forEach>
<!-- Modal them sp -->
 <!-- Modal content-->
 <div class="container">
		<div class="modal fade" id="modal_add_sp" role="dialog">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Modal Header</h4>
	        </div>
	         <c:set value="${sessionScope.listKhachHang}" var="khachhang"/>
	         <c:set value="${sessionScope.listNhanVien}" var="nhanvien"/>
	         	<div class="modal-body">
									<form class="form-horizontal"
										action="<c:url value="/HoaDon/Themsanpham"/>" method="post">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="chucvu">Tên sản phẩm*</label>
											<div class="col-sm-9">
												<select name="masanpham" id="chucvu" class="form-control">
													<c:forEach items="${sessionScope.listSanPham}" var="sanpham">
													<option value="${sanpham.masanpham}">
													<c:out value="${sanpham.tensanpham}"/>
													</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="ngaysinh">Số lượng*</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="soluong"
													required="required">
											</div>
										</div>
										
										<input type="hidden" id="custId" name="mahoadon" value="${order.mahoadon}">
										
										

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
	      </div></div></div>
	      
	      <!-- model edit order detail -->
	      <c:forEach items="${orderList}" var="listOrderDetail">
<div class="modal fade" id="editorder${listOrderDetail.masanpham}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
 
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Sửa hóa đơn</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
    <div class="modal-body">
									<form class="form-horizontal"
										action="<c:url value="/HoaDon/Suacthoadon"/>" method="post">

										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="chucvu">Tên sản phẩm*</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" value="${listOrderDetail.sanphamByMasanpham.tensanpham}" readonly>
											</div>
										</div>
									
										<div class="form-group has-success has-feedback">
											<label class="col-sm-3 control-label" for="ngaysinh">Số lượng*</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" name="soluongsua"
													required="required">
											</div>
										</div>
										<div>
										<input type="hidden" id="custId" name="masanphamsua" value="${listOrderDetail.masanpham}">
										<input type="hidden" id="custId" name="mahoadonsua" value="${listOrderDetail.mahoadon}">
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
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
    
  </div>
</div>
</c:forEach>
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