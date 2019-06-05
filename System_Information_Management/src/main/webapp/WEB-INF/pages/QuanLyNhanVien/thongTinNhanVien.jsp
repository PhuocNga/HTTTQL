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
<title>Thông Tin Nhân Viên</title>
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
        $( "#datepicker1" ).datepicker({
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
	<%!public String formatNumberLuong(double luong) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(luong);
	}%>

	<%
		Nhanvien listThongTin = (Nhanvien) session.getAttribute("thongTinNhanVien");
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
									<div style="padding-left: 71%">
										<button type="button" class="btn btn-success btn-xs"
											data-toggle="modal" data-target="#khenthuong">
											<span class="glyphicon glyphicon-ok-circle"></span>&nbsp;Khen
											thưởng
										</button>
										<button type="button" class="btn btn-primary btn-xs"
											data-toggle="modal" data-target="#kiluat">
											<span class="glyphicon glyphicon-ban-circle"></span>&nbsp;Kỉ
											luật
										</button>
										<button type="button" class="btn btn-danger btn-xs"
											data-toggle="modal"
											data-target="#sathai<%=listThongTin.getManhanvien()%>">
											<span class="glyphicon glyphicon-remove-circle"></span>&nbsp;Sa
											thải
										</button>
									</div>
									<div class="col-md-12 col-lg-12 col-sm-12">
										<div style="padding: 3%">
											<table cellpadding="4" cellspacing="0"
												class="table table-striped table-bordered"
												style="text-align: center;">
												<tr>
													<td>Mã nhân viên</td>
													<td><%=listThongTin.getManhanvien()%></td>
												</tr>
												<tr>
													<td>Tên nhân viên</td>
													<td><%=listThongTin.getTennhanvien()%></td>
												</tr>
												<tr>
													<td>Ngày sinh</td>
													<td><%=listThongTin.getNgaysinh()%></td>
												</tr>
												<tr>
													<td>Giới tính</td>
													<td><%=listThongTin.getGioitinh()%></td>
												</tr>
												<tr>
													<td>Số điện thoại</td>
													<td><%=listThongTin.getSodienthoai()%></td>
												</tr>
												<tr>
													<td>Địa chỉ</td>
													<td><%=listThongTin.getDiachi()%></td>
												</tr>
												<tr>
													<td>Chức vụ</td>
													<td><%=listThongTin.getChucvuByMachucvu().getTenchucvu()%></td>
												</tr>
												<tr>
													<td>Lương</td>
													<td><%=formatNumberLuong((double) listThongTin.getChucvuByMachucvu().getLuong())%>&nbsp;Đồng
													</td>
												</tr>

												<%
													List<KhenthuongNhanvien> listKhenThuong_NhanVien = (List<KhenthuongNhanvien>) session
															.getAttribute("listKhenThuong_Nhanvien");
												%>
												<%
													double khenThuong = 0;
												%>
												<%
													for (int i = 0; i < listKhenThuong_NhanVien.size(); i++) {
												%>
												<%
													double hinhThucKhenThuong = Double.parseDouble(
																listKhenThuong_NhanVien.get(i).getKhenthuongByMakhenthuong().getHinhthuckhenthuong());
												%>

												<%
													khenThuong = khenThuong + hinhThucKhenThuong;
												%>
												<%
													}
												%>

												<tr>
													<td>Khen thưởng</td>
													<td>+<%=formatNumberLuong(khenThuong)%>&nbsp;Đồng
														&nbsp;
														<button type="button" class="btn btn-primary btn-xs"
															data-toggle="modal" data-target="#chitietkhenthuong">
															<span class="glyphicon glyphicon-remove-circle"></span>&nbsp;Chi
															tiết
														</button></td>
												</tr>

												<%
													List<KyluatNhanvien> listKyLuat_NhanVien = (List<KyluatNhanvien>) session
															.getAttribute("listKyLuat_NhanVien");
												%>
												<%
													double kyluat = 0;
												%>
												<%
													for (int i = 0; i < listKyLuat_NhanVien.size(); i++) {
												%>
												<%
													double hinhThucKyLuat = Double.parseDouble(listKyLuat_NhanVien.get(i).getKyluatByMakyluat().getMucdo());
												%>

												<%
													kyluat = kyluat + hinhThucKyLuat;
												%>
												<%
													}
												%>

												<tr>
													<td>Kỉ luật</td>
													<td>-<%=formatNumberLuong(kyluat)%>&nbsp;Đồng &nbsp;
														<button type="button" class="btn btn-primary btn-xs"
															data-toggle="modal" data-target="#chitietkyluat">
															<span class="glyphicon glyphicon-remove-circle"></span>&nbsp;Chi
															tiết
														</button></td>
												</tr>
											</table>
										</div>
									</div>


									<%
										List<Khenthuong> listKhenThuong = (List<Khenthuong>) session.getAttribute("listKhenThuong");
									%>
									<div class="modal fade" id="khenthuong" role="dialog">
										<div class="modal-dialog">

											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Khen thưởng nhân viên</h3>
												</div>
												<div class="modal-body">
													<form class="form-horizontal"
														action="<%=application.getContextPath()%>/NhanVien/KhenThuongNhanVien">

														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="manhanvien">Mã
																nhân viên:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	value="<%=listThongTin.getManhanvien()%>"
																	name="manhanvien" id="manhanvien" required="required"
																	readonly>
															</div>
														</div>
														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="manhanvien">Tên
																nhân viên:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	value="<%=listThongTin.getTennhanvien()%>" readonly>
															</div>
														</div>
														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="chucvu">Lý
																do khen thưởng:</label>
															<div class="col-sm-9">
																<select name="khenthuong" id="khenthuong"
																	class="form-control">
																	<%
																		for (Khenthuong khenthuong : listKhenThuong) {
																	%>
																	<option value="<%=khenthuong.getMakhenthuong()%>"><%=khenthuong.getLydokhenthuong()%></option>
																	<%
																		}
																	%>
																</select>
															</div>
														</div>

														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="ngaysinh">Ngày
																khen thưởng:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" id="datepicker"
																	name="ngaykhenthuong" required="required">
															</div>
														</div>
														<hr>
														<div style="text-align: center" class="col-sm-12">
															<button type="submit" class="btn btn-primary btn-block">
																<span class="glyphicon glyphicon-ok-circle"></span> Khen
																thưởng
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
										List<Kyluat> listKyLuat = (List<Kyluat>) session.getAttribute("listKyLuat");
									%>
									<div class="modal fade" id="kiluat" role="dialog">
										<div class="modal-dialog">

											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Kỷ Luật nhân viên</h3>
												</div>
												<div class="modal-body">
													<form class="form-horizontal"
														action="<%=application.getContextPath()%>/NhanVien/KyLuatNhanVien">

														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="manhanvien">Mã
																nhân viên:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	value="<%=listThongTin.getManhanvien()%>"
																	name="manhanvien" id="manhanvien" required="required"
																	readonly>
															</div>
														</div>
														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="manhanvien">Tên
																nhân viên:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	value="<%=listThongTin.getTennhanvien()%>" readonly>
															</div>
														</div>
														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="chucvu">Lý
																do kỷ luật:</label>
															<div class="col-sm-9">
																<select name="kyluat" id="kyluat" class="form-control">
																	<%
																		for (Kyluat listkyluat : listKyLuat) {
																	%>
																	<option value="<%=listkyluat.getMakyluat()%>"><%=listkyluat.getLydokyluat()%></option>
																	<%
																		}
																	%>
																</select>
															</div>
														</div>

														<div class="form-group has-success has-feedback">
															<label class="col-sm-3 control-label" for="ngaysinh">Ngày
																kỷ luật:</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"  id="datepicker1"
																	name="ngaykyluat" required="required">
															</div>
														</div>
														<hr>
														<div style="text-align: center" class="col-sm-12">
															<button type="submit" class="btn btn-primary btn-block">
																<span class="glyphicon glyphicon-ban-circle"></span> Kỷ
																luật
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




									<div class="modal fade" id="chitietkhenthuong" role="dialog">
										<div class="modal-dialog">

											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Chi tiết khen thưởng</h3>
												</div>
												<div class="modal-body">
													<table cellpadding="4" cellspacing="0"
														class="table table-striped table-bordered"
														style="text-align: center;">

														<tr>
															<td>Mã nhân viên</td>
															<td><%=listThongTin.getManhanvien()%></td>
														</tr>
														<tr>
															<td>Tên nhân viên</td>
															<td><%=listThongTin.getTennhanvien()%></td>
														</tr>
													</table>

													<table class="table table-striped table-bordered">
														<thead>
															<tr>
																<th>Mã khen thưởng</th>
																<th>Lý do khen thưởng</th>
																<th>Hình thức khen thưởng</th>
																<th>Ngày khen thưởng</th>
															</tr>
														</thead>
														<tbody>
															<%
																for (KhenthuongNhanvien chitietkhenthuong : listKhenThuong_NhanVien) {
															%>
															<tr>
																<td><%=chitietkhenthuong.getMakhenthuong()%></td>
																<td><%=chitietkhenthuong.getKhenthuongByMakhenthuong().getLydokhenthuong()%></td>
																<td>+&nbsp;<%=formatNumberLuong(
						Double.parseDouble(chitietkhenthuong.getKhenthuongByMakhenthuong().getHinhthuckhenthuong()))%>&nbsp;Đồng
																</td>
																<td><%=chitietkhenthuong.getNgaykhenthuong()%></td>
															</tr>
															<%
																}
															%>
														</tbody>
													</table>

												</div>
												<div class="modal-footer">
													<button type="submit" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>



									<div class="modal fade" id="chitietkyluat" role="dialog">
										<div class="modal-dialog">

											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Chi tiết kỷ luật</h3>
												</div>
												<div class="modal-body">
													<table cellpadding="4" cellspacing="0"
														class="table table-striped table-bordered"
														style="text-align: center;">

														<tr>
															<td>Mã nhân viên</td>
															<td><%=listThongTin.getManhanvien()%></td>
														</tr>
														<tr>
															<td>Tên nhân viên</td>
															<td><%=listThongTin.getTennhanvien()%></td>
														</tr>
													</table>

													<table class="table table-striped table-bordered">
														<thead>
															<tr>
																<th>Mã kỷ luât</th>
																<th>Lý do kỷ luật</th>
																<th>Hình thức kỷ luật</th>
																<th>Ngày kỷ luật</th>
															</tr>
														</thead>
														<tbody>
															<%
																for (KyluatNhanvien chitietkyluat : listKyLuat_NhanVien) {
															%>
															<tr>
																<td><%=chitietkyluat.getMakyluat()%></td>
																<td><%=chitietkyluat.getKyluatByMakyluat().getLydokyluat()%></td>
																<td>-&nbsp;<%=formatNumberLuong(Double.parseDouble(chitietkyluat.getKyluatByMakyluat().getMucdo()))%>&nbsp;Đồng
																</td>
																<td><%=chitietkyluat.getNgaykyluat()%></td>
															</tr>
															<%
																}
															%>
														</tbody>
													</table>

												</div>
												<div class="modal-footer">
													<button type="submit" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</div>
											</div>
										</div>
									</div>


									<div class="modal fade"
										id="sathai<%=listThongTin.getManhanvien()%>" role="dialog">
										<div class="modal-dialog">

											<!-- Modal content-->
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Sa thải nhân viên</h3>
												</div>
												<div class="modal-body">
													<h4>
														Bạn có chắc muốn sa thải nhân viên
														<%=listThongTin.getManhanvien()%>
														này ?
													</h4>
												</div>
												<div class="modal-footer">
													<a
														href="<%=application.getContextPath()%>/NhanVien/XoaNhanVien?MaNV=<%=listThongTin.getManhanvien()%>"><button
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