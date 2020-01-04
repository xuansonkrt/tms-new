<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!-- <!DOCTYPE html> -->
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>QLGV</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/mta.ico" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/toastr.min.css">
    <link rel='stylesheet' href='https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.css'>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/css/select2.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/themes/default/style.min.css">
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js" ></script>
  </head>
  <body>
    <div class="container-scroller">
    
      <tiles:insertAttribute name="navbar" />
      
      <div class="container-fluid page-body-wrapper">
      
        <tiles:insertAttribute name="sidebar" />
        
        <div class="main-panel">
          <div class="content-wrapper">
              <tiles:insertAttribute name="body" />
          </div>
          
          <tiles:insertAttribute name="footer" />
          
        </div>
      </div>
    </div>
      <!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog"> </div>
	
	<div id="saveResult" style="display: none;"> </div>
    <!-- plugins:js -->
    
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/off-canvas.js"></script>
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/hoverable-collapse.js"></script>
    <script  language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/assets/js/misc.js"></script>
    <script language="JavaScript" type="text/javascript" s src="${pageContext.request.contextPath}/assets/js/main.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/moment.js" ></script>
     <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/toastr.min.js" ></script>
     <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/sweetalert.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.9.0/sweetalert2.all.min.js"></script>
    <%-- <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/bootstrap.js" ></script> --%>
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/js/select2.min.js"></script>
    <!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
     <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/dist/jstree.min.js" ></script>
    <script>
	$(document).ready(function(){
		$('#sonnx').on('click', function(){
			var areaId="divArea";
			var url ="/demo"
			ajaxUpdate('get',areaId,url,null);
		});
	});
	
	toastr.options = {
			  "closeButton": false,
			  "debug": false,
			  "newestOnTop": false,
			  "progressBar": false,
			  "positionClass": "toast-bottom-right",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
			}
</script>
  </body>
</html>