<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- <!DOCTYPE html> -->
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>sonnx</title>
    <!-- plugins:css -->
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
    
      <!-- partial:../partials/_navbar.html -->
      <tiles:insertAttribute name="navbar" />
      <!-- partial -->
      
      <div class="container-fluid page-body-wrapper">
      
        <!-- partial:../partials/_sidebar.html -->
        <tiles:insertAttribute name="sidebar" />
        <!-- partial -->
        
        <div class="main-panel">
          <div class="content-wrapper">
              <tiles:insertAttribute name="body" />
          </div>
          <!-- content-wrapper ends -->
          
          <!-- partial:../partials/_footer.html -->
          <tiles:insertAttribute name="footer" />
          <!-- partial -->
          
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script language="JavaScript" type="text/javascript"  src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js" ></script>
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
    
    <script>
	$(document).ready(function(){
		$('#sonnx').on('click', function(){
			var areaId="divArea";
			var url ="/demo"
			ajaxUpdate('get',areaId,url,null);
		});
	});
</script>
  </body>
</html>