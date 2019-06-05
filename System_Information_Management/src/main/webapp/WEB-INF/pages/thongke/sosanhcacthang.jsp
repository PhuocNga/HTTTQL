<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>So sánh doanh thu theo tháng</title>
	    <!-- Bootstrap -->
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
    <!-- iCheck -->
    <link href="<c:url value="/resources/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/build/css/custom.min.css"/>" rel="stylesheet">

    <!-- Datatables -->
    <link href="<c:url value="/resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"/>" rel="stylesheet">

	<script type="text/javascript">
		window.onload = function(){
			document.getElementById('sel1').onchange = function(){
				document.getElementById('formnam').submit();
			}
		}
	</script>
       <style>
#stackchart {
  width: 100%;
  height: 500px;
  font-size: 11px;
}

.amcharts-pie-slice {
  transform: scale(1);
  transform-origin: 50% 50%;
  transition-duration: 0.3s;
  transition: all .3s ease-out;
  -webkit-transition: all .3s ease-out;
  -moz-transition: all .3s ease-out;
  -o-transition: all .3s ease-out;
  cursor: pointer;
  box-shadow: 0 0 30px 0 #000;
}

.amcharts-pie-slice:hover {
  transform: scale(1.1);
  filter: url(#shadow);
}							
</style>
    <script src="<c:url value="/resources/build/js/abc.js"/>"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="<c:url value="/resources/build/js/export.min.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/build/css/amchart.css"/>" type="text/css" media="all" />
    <script src="<c:url value="/resources/build/js/light.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/amcharts/3.21.12/plugins/export/libs/fabric.js/fabric.min.js"></script>
    <script type="text/javascript" src="http://amcharts.com/lib/3/plugins/export/libs/FileSaver.js/FileSaver.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/amcharts/3.21.12/plugins/export/libs/pdfmake/pdfmake.js"></script>
    <!--Pie chart-->
    <script src="https://www.amcharts.com/lib/3/pie.js"></script>
</head>
<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            <c:import url="../menu.jsp"/>
		<%List<Object[]>listCompare1=(ArrayList)session.getAttribute("compare1");
		List<Object[]>listCompare2=(ArrayList)session.getAttribute("compare2");
		List<String>listMonthYear=(ArrayList)session.getAttribute("listMonthYear");
		%>
	
            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">

                    <div class="x-panel">
                        <div class="x_title">
                            <h2>So sánh doanh thu theo tháng</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <c:set var="listYear" value="${sessionScope.year}"/>
                        <c:set var="listMonth" value="${sessionScope.month}"/>
                         <form action="<c:url value="/thongke/sosanhdoanhthuthang"/>">
                        <div class="x_content">
                       <div style="font-size: 17px;color: #008B8B;">Điều kiện so sánh 1</div>
                            <div class="btn-group">
                                <p><strong>Chọn năm</strong></p>
                                
                                <select class="form-control" id="sel1" name="yearcompare1">
                                <c:forEach  items="${listYear}" var="year">
                              <option value="${year}" ><c:out value="${year}"/></option>
                                </c:forEach>
                              </select>
                         
                            </div>
                            <div class="btn-group">
                                <p><strong>Chọn tháng</strong></p>
                                <select class="form-control" id="sel1" name="monthcompare1">
                                <c:forEach items="${listMonth}" var="month" >
                                <option value="${month}"><c:out value="${month}"/></option>
                                </c:forEach>
                              </select>
                            </div>
                            
                            <div style="font-size: 17px;color: #008B8B;">Điều kiện so sánh 2</div>
                             <div class="btn-group">
                                <p><strong>Chọn năm</strong></p>
                                <select class="form-control" id="sel1" name="yearcompare2">
                                <c:forEach items="${listYear}" var="year" >
                                <option value="${year}"><c:out value="${year}"/></option>
                                </c:forEach>
                              </select>
                            </div>
                            
                             <div class="btn-group">
                                <p><strong>Chọn tháng</strong></p>
                                <select class="form-control" id="sel1" name="monthcompare2">
                                <c:forEach items="${listMonth}" var="month" >
                                <option value="${month}"><c:out value="${month}"/></option>
                                </c:forEach>
                              </select>
                            </div>

                            <div class="btn-group">
                                <p><strong>Thao tác</strong></p>
                                <button class="btn btn-primary">Thống kê</button>
                            </div>
                        </div>
						</form>

                        <div class="row">

                            <!-- bar chart -->
                            <div id="bieudocot">
                            <div class="col-md-12 col-sm-12 col-xs-12">

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Doanh thu trong tháng <c:out value="${sessionScope.quarter_year.get(0)}"/> -<c:out value="${sessionScope.quarter_year.get(1)}"/>
                                        và trong tháng <c:out value="${sessionScope.quarter_year.get(2)}"/> -<c:out value="${sessionScope.quarter_year.get(3)}"/> của từng sản phẩm
                                        </h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">Settings 1</a>
                                                    </li>
                                                    <li><a href="#">Settings 2</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <div id="stackchart"></div>
                                    </div>
                                </div>
                            </div>
							</div>

                        </div>

                    </div>
                </div>
            </div>
            <!-- /page content -->
					
					
        </div>
    </div>

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/vendors/fastclick/lib/fastclick.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/vendors/nprogress/nprogress.js"/>"></script>
    <!-- morris.js -->
    <script src="<c:url value="/resources/vendors/raphael/raphael.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/morris.js/morris.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/Chart.js/dist/Chart.min.js"/>"></script>
    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/build/js/custom.min.js"/>"></script>
    <!--table jquery-->
    <script src="<c:url value="/resources/vendors/jquery_table/jquery.dynatable.js"/>"></script>
    <!---->
    <!-- Datatables -->
    <script src="<c:url value="/resources/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-buttons/js/buttons.print.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/jszip/dist/jszip.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/pdfmake/build/pdfmake.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/pdfmake/build/vfs_fonts.js"/>"></script>
	
	
	
	
    <!--chart-->
<script>
<%if(listCompare1!=null&&listCompare2!=null){%>
var chart = AmCharts.makeChart("stackchart", {
    "type": "serial",
    "theme": "light",
    "legend": {
        "autoMargins": false,
        "borderAlpha": 0.2,
        "equalWidths": false,
        "horizontalGap": 10,
        "markerSize": 10,
        "useGraphSettings": true,
        "valueAlign": "left",
        "valueWidth": 0
    },
    "dataProvider": [{
        <%for(int i=0;i<listCompare1.size();i++){%>
        "year": "<%=listMonthYear.get(0)+"/"+listMonthYear.get(1)%>",
        "<%=String.valueOf(listCompare1.get(i)[0])%>": <%=Double.parseDouble(listCompare1.get(i)[2]+"")%>,
      <%}%>
    }, {
        <%for(int j=0;j<listCompare2.size();j++){%>
        "year": "<%=listMonthYear.get(2)+"/"+listMonthYear.get(3)%>",
        "<%=String.valueOf(listCompare2.get(j)[0])%>": <%=Double.parseDouble(listCompare2.get(j)[2]+"")%>,
        <%}%>
    }],
    "valueAxes": [{
        "stackType": "100%",
        "axisAlpha": 0,
        "gridAlpha": 0,
        "labelsEnabled": false,
        "position": "left"
    }],
    "graphs": [
              <%for(int i=0;i<listCompare1.size();i++){%>
               {
        "balloonText": "[[title]], [[category]]<br><span style='font-size:14px;'><b>[[value]]</b> ([[percents]]%)</span>",
        "fillAlphas": 0.9,
        "fontSize": 11,
        "labelText": "[[percents]]%",
        "lineAlpha": 0.5,
        "title": "<%=String.valueOf(listCompare1.get(i)[0])%>",
        "type": "column",
        "valueField": "<%=String.valueOf(listCompare1.get(i)[0])%>"
    },<%}%>],
    "marginTop": 30,
    "marginRight": 0,
    "marginLeft": 0,
    "marginBottom": 40,
    "autoMargins": false,
    "categoryField": "year",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha": 0,
        "gridAlpha": 0
    },
    "export": {
    	"enabled": true
     }

});
<%}%>
</script>
</body>
</html>