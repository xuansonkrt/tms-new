 <%@ page pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đổi mật khẩu</title>
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
                <h6 class="font-weight-light">Đổi mật khẩu</h6>
                <form class="pt-3" action="/user/change-password" method="POST">
                	<%
					    if (request.getParameter("error") != null) {%>
					         <div style="font-family: Arial, Helvetica, sans-serif" class="alert alert-danger">
                                Mật khẩu cũ không chính xác!
                            </div>
					  <%  } %>
					  
					  <%
					    if (request.getParameter("success") != null) {%>
					         <div style="font-family: Arial, Helvetica, sans-serif" class="alert alert-success">
                                Đổi mật khẩu thành công!
                            </div>
                            <script>
	                            setTimeout(function(){
	                            	location.href="/logout";
	                            }, 1000);
                            </script>
					  <%  } %>
	              
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" name="passwordOld" id="passwordOld" placeholder="Mật khẩu cũ">
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" name="passwordNew" id="passwordNew" placeholder="Mật khẩu mới">
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" name="passwordConfirm" id="passwordConfirm" placeholder="Nhập lại mật khẩu">
                  </div>
                  <span id="error" style="color: red;"></span>
                  <div class="mt-3">
                    <input id="btnSubmit" style="padding-top: 15px !important; padding-bottom: 15px !important;  " 
                            class="btn btn-block btn-gradient-primary btn-lg font-weight-medium" 
                            type="submit" value="ĐỔI MẬT KHẨU" disabled="disabled"/>
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
  
  <script type="text/javascript">
  	$(document).ready(function(){
  		$('#passwordConfirm').on('keyup',function(){
  			if($('#passwordConfirm').val() != $('#passwordNew').val()){
  				$('#error').text('Mật khẩu không khớp!');
  				$("#btnSubmit").attr("disabled", true);
  				return;
  			} else{
  				$('#error').text('');
  				$("#btnSubmit").attr("disabled", false);
  			}
  			
  			if($('#passwordOld').val() && $('#passwordConfirm').val() && $('#passwordNew').val()){
  				$("#btnSubmit").attr("disabled", false);
  			} else{
  				$("#btnSubmit").attr("disabled", true);
  			}
  		})
  		
  		$('#passwordNew').on('keyup',function(){
  			
  			if($('#passwordConfirm').val() != $('#passwordNew').val()){
  				$('#error').text('Mật khẩu không khớp!');
  				$("#btnSubmit").attr("disabled", true);
  				return;
  			} else{
  				$('#error').text('');
  				$("#btnSubmit").attr("disabled", false);
  			}
  			
  			
  			if($('#passwordOld').val() && $('#passwordConfirm').val() && $('#passwordNew').val()){
  				$("#btnSubmit").attr("disabled", false);
  			} else{
  				$("#btnSubmit").attr("disabled", true);
  			}
  		})
  		
  		$('#passwordOld').on('keyup',function(){
  			if($('#passwordOld').val() && $('#passwordConfirm').val() && $('#passwordNew').val()){
  				$("#btnSubmit").attr("disabled", false);
  			} else{
  				$("#btnSubmit").attr("disabled", true);
  			}
  		})
  	})
  </script>
</html>