<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>

	<!-- menu profile quick info -->
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="role" value="${sessionScope.role}" />

	<div class="col-md-3 left_col">
		<div class="left_col scroll-view">
			<div class="navbar nav_title" style="border: 0;">
				<a href="index.html" class="site_title"><i class="fa fa-paw"></i><span>
						HTTTQL</span></a>
			</div>

			<div class="clearfix"></div>

			<!-- menu profile quick info -->
			<div class="profile clearfix">
				<div class="profile_pic">
					<img src="<c:url value="${user.hinhanh}"/>" alt="..."
						class="img-circle profile_img">
				</div>
				<div class="profile_info">
					<span>Xin chào,</span>
					<h2>${user.tentaikhoan}</h2>
				</div>
			</div>
			<!-- /menu profile quick info -->
			<br />

			<!-- sidebar menu -->
			<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
				<div class="menu_section">
					<ul class="nav side-menu">
						<li><a href="<c:url value="/Home/quanly"/>"><i
								class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
						</li>
						<li><a><i class="fa fa-edit"></i> Quản lý <span
								class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu">

								<!-- role là quản lý -->
								

								<c:if test="${role.role=='quanly'||role.role=='thukho'}">
									<li><a href='<c:url value="/danhSachDonDuyetHang"/>'>Quản lý duyệt hàng</a></li>
									<li><a href='<c:url value="/DeNghiDuyetHang"/>'>Đề nghị nhập hàng</a></li>
									
									
									<li><a
										href="<%=application.getContextPath()%>/SanPham/QuanLySanPham">Quản
											lý sản phẩm</a></li>
								</c:if>

								<c:if test="${role.role=='thukho'||role.role=='quanly'}">
									<li><a
										href='<c:url value="/nhacungcap/quanlynhacungcap"/>'>Quản
											lý nhà cung cấp</a></li>
								</c:if>

								<!-- role là thu ngân -->
								<c:if test="${role.role=='thungan'||role.role=='quanly'}">
									
									<li><a href='<c:url value="/QuanLyKhachHang"/>'>Quản lý khách hàng</a></li>
									<li><a
										href="<%=application.getContextPath()%>/HoaDon/QuanLyHoaDon"">Quản
											lý hóa đơn</a></li>
								</c:if>
							</ul></li>
						<c:if test="${role.role=='quanly'}">
							          <li><a><i class="fa fa-line-chart"></i>Thống kê<span class="fa fa-chevron-down"></span></a>
						                    <ul class="nav child_menu">
						                        
						                        <li><a>Thống kê doanh thu<span class="fa fa-chevron-down"></span></a>
						                          <ul class="nav child_menu">
						                            <li class="sub_menu"><a href="<c:url value="/thongke/chonthongke/doanhthutheothang"/>">Theo tháng</a>
						                            </li>
						                            <li><a  href="<c:url value="/thongke/chonthongke/doanhthutheoquy"/>">Theo quý</a>
						                            </li>
						                          </ul>
						                        </li>
						                        <li><a href="<c:url value="/thongke/chonthongke/thongkenhanvien"/>">Thống kê nhân viên</a>
						                        </li>
						                    </ul>
						               </li>   
						</c:if>

						<li><a href="profile.html"><i class="fa fa-user"></i>Thông
								tin cá nhân<span class="fa fa-chevron-down"></span></a></li>
						<li><a href="contacts.html"><i class="fa fa-group"></i>Danh
								sách thành viên<span class="fa fa-chevron-down"></span></a></li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--Top navigation-->
	<div class="top_nav">
		<div class="nav_menu">
			<nav>
				<div class="nav toggle">
					<a id="menu_toggle"><i class="fa fa-bars"></i></a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li class=""><a href="javascript:;"
						class="user-profile dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false"> <img
							src="<c:url value="${user.hinhanh}"/>" alt="">
						<c:out value="${user.tentaikhoan}" /> <span
							class=" fa fa-angle-down"></span>
					</a>
						<ul class="dropdown-menu dropdown-usermenu pull-right">
							<li><a href="javascript:;"> Profile</a></li>
							<li></li>
							<li><a href="javascript:;">Help</a></li>
							<li><a href="<c:url value="/Home/dangxuat"/>"><i
									class="fa fa-sign-out pull-right"></i> Log Out</a></li>
						</ul></li>

					<li role="presentation" class="dropdown"><a
						href="javascript:;" class="dropdown-toggle info-number"
						data-toggle="dropdown" aria-expanded="false"> <i
							class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
					</a>
						<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
							role="menu">
							<li><a> <span class="image"><img
										src="${user.hinhanh}" alt="Profile Image" /></span> <span> <span>John
											Smith</span> <span class="time">3 mins ago</span>
								</span> <span class="message"> Film festivals used to be
										do-or-die moments for movie makers. They were where... </span>
							</a></li>
							<li><a> <span class="image"><img src=""
										alt="Profile Image" /></span> <span> <span>John Smith</span>
										<span class="time">3 mins ago</span>
								</span> <span class="message"> Film festivals used to be
										do-or-die moments for movie makers. They were where... </span>
							</a></li>
							<li><a> <span class="image"><img src=""
										alt="Profile Image" /></span> <span> <span>John Smith</span>
										<span class="time">3 mins ago</span>
								</span> <span class="message"> Film festivals used to be
										do-or-die moments for movie makers. They were where... </span>
							</a></li>
							<li><a> <span class="image"><img src=""
										alt="Profile Image" /></span> <span> <span>John Smith</span>
										<span class="time">3 mins ago</span>
								</span> <span class="message"> Film festivals used to be
										do-or-die moments for movie makers. They were where... </span>
							</a></li>
							<li>
								<div class="text-center">
									<a> <strong>See All Alerts</strong> <i
										class="fa fa-angle-right"></i>
									</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</nav>
		</div>
	</div>
	<!--Top navigation-->
</body>
</html>