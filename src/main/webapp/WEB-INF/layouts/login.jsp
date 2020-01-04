 <%@ page pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đăng nhập</title>
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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/mta.ico" />
    <style>
    	*{
    		font-family: Arial, Helvetica, sans-serif !important;
    	}
    </style>
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
          <div class="row flex-grow">
            <div class="col-lg-4 mx-auto">
              <div class="auth-form-light text-left p-5">
                <div class="brand-logo">
                  <img src="${pageContext.request.contextPath}/assets/images/logo.svg">
                </div>
                <h4><strong>HỆ THỐNG QUẢN LÝ GIÁO VIÊN</strong></h4>
                <h6 class="font-weight-light">Đăng nhập để tiếp tục.</h6>
                <form class="pt-3" action="/user/login" method="POST">
                	<%
					    if (request.getParameter("error") != null) {%>
					         <div style="font-family: Arial, Helvetica, sans-serif" class="alert alert-danger">
                                Tên đăng nhập hoặc mật khẩu chưa đúng!
                            </div>
					  <%  }
					%>
	              
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" name="username" id="username" placeholder="username">
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" name="password" id="password" placeholder="password">
                  </div>
                  <div class="mt-3">
                    <input  style="padding-top: 15px !important; padding-bottom: 15px !important;  " 
                            class="btn btn-block btn-gradient-primary btn-lg font-weight-medium" 
                            type="submit" value="ĐĂNG NHẬP"/>
                  </div>
                  <div class="my-2 d-flex justify-content-between align-items-center">
                    <div class="form-check">
                      <label class="form-check-label text-muted">
                        <input type="checkbox" class="form-check-input" name="remember-me" id="remember-me"> Ghi nhớ đăng nhập </label>
                    </div>
                   <!--  <a href="#" class="auth-link text-black">Forgot password?</a> -->
                  </div>
                  <!-- <div class="mb-2">
                    <button type="button" class="btn btn-block btn-facebook auth-form-btn">
                      <i class="mdi mdi-facebook mr-2"></i>Connect using facebook </button>
                  </div>
                  <div class="text-center mt-4 font-weight-light"> Don't have an account? <a href="register.html" class="text-primary">Create</a> -->
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="${pageContext.request.contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="${pageContext.request.contextPath}/assets/js/off-canvas.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/hoverable-collapse.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/misc.js"></script>
    <!-- endinject -->
  </body>
</html>