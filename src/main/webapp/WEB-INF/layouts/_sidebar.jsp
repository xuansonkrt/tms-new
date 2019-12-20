<%@ page pageEncoding="UTF-8" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
  <ul class="nav">
    <li class="nav-item nav-profile">
      <a href="#" class="nav-link">
        <div class="nav-profile-image">
          <img src="assets/images/faces/face1.jpg" alt="profile">
          <span class="login-status online"></span>
          <!--change to offline or busy as needed-->
        </div>
        <div class="nav-profile-text d-flex flex-column">
          <span class="font-weight-bold mb-2">David Grey. H</span>
          <span class="text-secondary text-small">Project Manager</span>
        </div>
        <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/dashboard">
        <span class="menu-title" >Dashboard</span>
        <i class="mdi mdi-home menu-icon"></i>
      </a>
    </li>
    <!-- <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">Basic UI Elements</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-crosshairs-gps menu-icon"></i>
      </a>
      <div class="collapse" id="ui-basic">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="pages/ui-features/buttons.html">Buttons</a></li>
          <li class="nav-item"> <a class="nav-link" href="pages/ui-features/typography.html">Typography</a></li>
        </ul>
      </div>
    </li> -->
   <!--  <li class="nav-item">
      <a class="nav-link" href="/demo">
        <span class="menu-title">Demo</span>
        <i class="mdi mdi-contacts menu-icon"></i>
      </a>
    </li> -->
    
    <!-- <li class="nav-item">
      <a class="nav-link" href="/category">
        <span class="menu-title">Quản lý danh mục</span>
        <i class="mdi mdi-package-variant menu-icon"></i>
      </a>
    </li> -->
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-basic2" aria-expanded="false" aria-controls="ui-basic2">
        <span class="menu-title">Quản lý danh mục</span>
        <i class="menu-arrow"></i>
         <i class="mdi mdi-package-variant menu-icon"></i>
      </a>
      <div class="collapse" id="ui-basic2">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="#">Danh mục đơn vị</a></li>
          <li class="nav-item"> <a class="nav-link" href="/category">Danh mục dùng chung</a></li>
          <li class="nav-item"> <a class="nav-link" href="#">Danh mục học kỳ</a></li>
          <li class="nav-item"> <a class="nav-link" href="#">Danh mục định mức</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-basic3" aria-expanded="false" aria-controls="ui-basic3">
        <span class="menu-title">Kế hoạch đào tạo</span>
        <i class="menu-arrow"></i>
         <i class="mdi mdi-briefcase-check menu-icon"></i>
      </a>
      <div class="collapse" id="ui-basic3">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="#">Học phần</a></li>
          <li class="nav-item"> <a class="nav-link" href="#">Lớp học phần</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">
        <span class="menu-title">Quản lý giáo viên</span>
        <i class="mdi mdi-face menu-icon"></i>
        
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-basic1" aria-expanded="false" aria-controls="ui-basic1">
        <span class="menu-title">Báo cáo cá nhân</span>
        <i class="menu-arrow"></i>
         <i class="mdi mdi-message-bulleted menu-icon"></i>
      </a>
      <div class="collapse" id="ui-basic1">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="#">Tải đào tạo</a></li>
          <li class="nav-item"> <a class="nav-link" href="#">Tải nghiên cứu khoa học</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">
        <span class="menu-title">Báo cáo thống kê</span>
        <i class="mdi mdi-chart-areaspline menu-icon"></i>
      </a>
    </li>
    
  </ul>
</nav>