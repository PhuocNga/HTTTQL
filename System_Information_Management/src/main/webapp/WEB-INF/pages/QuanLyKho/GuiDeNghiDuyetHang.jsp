<%@page import="java.util.ArrayList"%>
<%@page import="com.cochau.model.Sanpham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/nprogress/nprogress.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css "/> " rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css "/>" rel="stylesheet">
            <link href="<c:url value="/resources/build/css/custom.min.css "/>" rel="stylesheet">
            <title>Duyệt hàng</title>
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
                                            <h3>Đơn đề nghị nhập hàng</h3>
                                            
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


                                            <div class="col-md-6 col-sm-6 col-xs-6">

                                                <div class="x_panel">

                                                    <div class="x_title">
                                                        <h2>Danh sách sản phẩm</h2>
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
                                                                    <th>Mã sản phẩm</th>
                                                                    <th>Mã nhà cung cấp</th>
                                                                    <th>Đề nghị nhập</th>
                                                                </tr>
                                                            </thead>


                                                            <tbody>
                                                                <c:if test="${!empty sp}">
                                                                    <c:forEach items="${sp}" var="sp">
                                                                        <tr>
                                                                            <td>${sp.masanpham}</td>
                                                                            
                                                                            <td>${sp.manhacungcap}</td>
                                                                         
                                                                            <td><a class="btn btn-primary btn-xs" href="<c:url value='/nhap/${sp.masanpham}'/>">Thêm vào đơn</a>
                                                                                </td>
                                                                         </tr>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-1 col-sm-1 col-xs-1"></div>
                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                            <br><br><br>
                                            <center> <h2 style="font-style: oblique;">Đơn đề nghị duyệt nhập hàng</h2></center>
                                            </b>
                                           <p style="color: red;text-align: center;">${dh}</p>
                                            <p style="color: red;text-align: center;">${error}</p>
                                            <form>
                                            <table class="table">
                                            
                                            <tr >
                                            
                                            		<th>Mã</th>
                                            		<th>Tên sp</th>
                                            		<th>Nhà cc </th>
                                            		<th>SL</th>
                                            		<th>Xóa</th>
                                            		
                                            </tr>
                                         
                                            <%
                                            ArrayList<Sanpham> arr=new ArrayList<>();
                                            if(session.getAttribute("dssp")!=null){
                                            arr=(ArrayList<Sanpham>)session.getAttribute("dssp");
                                            
                                            if(arr!=null) {
                                            	for(int i=0;i<arr.size();i++){
                                            	%>
                                            	
                                            
                                            	<tr>
                                            		<td> <%=arr.get(i).getMasanpham()%></td>
                                            		<td><%=arr.get(i).getTensanpham()%> </td>
                                            		<td><%=arr.get(i).getNhacungcapByManhacungcap().getTennhacungcap()%> </td>
                                            		<td><input type="number" value="1" name="soluong<%=i%>" id="soluong<%=i%>" style="width: 60%"></td>
                                            		<input hidden="true"  id="tien<%=i%>" type="text" value="3123123">
                                            		<td><a href="XoaSPham/<%=arr.get(i).getMasanpham()%>" style="color: red;">X</a></td>
                                            	</tr>
                                            	
                                            	<%} }}%>
                                            	<tr>
                                            		<td> </td>
                                            		<td><button id="tong" type="button" class="btn btn-primary" data-toggle="modal" data-target="#themncc"><span class="glyphicon glyphicon-plus"></span>Tổng chi tiết</button></td>
                                            		<%if(arr.size()==0){ %>
                                            		<td><button type="button" id="denghi" class="btn btn-success" disabled="true">Đề nghị nhập</button></td>
                                            		<%}else{ %>
                                            		<td><button type="button" id="denghi" class="btn btn-success">Đề nghị nhập</button></td>
                                            		<%} %>
                                            		<td></td>
                                            	</tr>
                                            </table> 
                                            </form>
                                            
                                            
                                            
                                            </div>
                                            <script type="text/javascript">
                                            $(document).ready(function(){
                                            	var tongtien=0;
                                        		var counttien=0;
                                                $("#tong").click(function(){
                                                	
                                                		var count=0;
                                                		var pari=0;
                                                		
                                                		for(var i=0;i<<%=arr.size()%>;i++){
														 pari=parseInt(document.getElementById("soluong"+i).value);
														tongtien=parseInt(document.getElementById("tien"+i).value)*pari;
														count+=pari;	
														 counttien+=tongtien;
														 
														
 


				                                            
                                                    	}
                                                		 $("#sl").html("Tổng số lượng sản phẩm của đơn hàng <b>"+count+" cái</b>");
                                                		 $("#st").html("Tổng số tiền trong đơn hàng <b>"+counttien+"VNĐ </b>");
                                                    	
                                                    	
                                                   
                                              
                                            });	
                                                $("#denghi").click(function(){
                                                	var count=0;
                                            		var pari=0;
                                            		var chuoiSl="";
                                            		
                                            		for(var i=0;i<<%=arr.size()%>;i++){
													 pari=parseInt(document.getElementById("soluong"+i).value);
													 chuoiSl+=pari+"slsl";
													tongtien=parseInt(document.getElementById("tien"+i).value)*pari;
													count+=pari;	
													 counttien+=tongtien;
													 
													



			                                            
                                                	}
                                                
                                            		// similar behavior as clicking on a link
                                            		window.location.href = "DeNghiNhapHangVe/"+counttien+"-"+count+"-"+chuoiSl;
                                                   
                                                });	
                                            });	
                                            </script> 


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
                                            <h3 class="modal-title">Chi tiết hóa đơn hiện tại</h3>
                                        </div>
                                        <div class="modal-body">
                                           <div id="sl"></div>
                                           <div id="st"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                    <!-- page content -->
                    
        <footer>
          <div class="pull-right">
            Hệ thống thông tin quản lý - đề tài:quản lý cửa hàng điện thoại
          </div>
          <div class="clearfix"></div>
        </footer>
                </div>
            </div>
            <!-- jQuery -->
            <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js " />"></script>

            <!-- Bootstrap -->
            <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js " />"></script>
            <!-- FastClick -->
            <script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js " />"></script>">

            <!-- NProgress -->
            <script src="<c:url value="/resources/vendors/nprogress/nprogress.js " />"></script>
            <!-- iCheck -->
            <script src="<c:url value="/resources/vendors/iCheck/icheck.min.js " />"></script>
            <!-- Datatables -->
            <script src="<c:url value="/resources/vendors/datatables.net/js/jquery.dataTables.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js " />"></script>
            <script src=" <c:url value="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js " />"></script>
            <script src=" <c:url value="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js " />"></script>
            <script src="<c:url value="/resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/jszip/dist/jszip.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/pdfmake/build/pdfmake.min.js " />"></script>
            <script src="<c:url value="/resources/vendors/pdfmake/build/vfs_fonts.js " />"></script>
            <!-- Custom Theme Scripts -->
            <script src="<c:url value="/resources/build/js/custom.min.js " />"></script>
        </body>

        </html>