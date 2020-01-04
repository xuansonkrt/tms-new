<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<style>
    .table-header,thead {
        background-color: #03a9f3 !important;
        color: #fff  !important;
        text-align: center;
    }
</style>
<logic:notEmpty name="resultList">
<!--   pagesize="10" -->
<table class="table table-striped table-bordered" style="width:100%">
<thead>
  <tr>
    <th rowspan="2">Đơn vị</th>
    <th colspan="3">Tải đào tạo</th>
	<th colspan="3">Tải NCKH</th>
  </tr>
  <tr>
	<th>Thực tải</th>
	<th>Yêu cầu</th>
	<th>% Đào tạo</th>
	<th>Thực tải</th>
	<th>Yêu cầu</th>
	<th>% NCKH</th>
  </tr>
</thead>
<tbody>

  <c:forEach items="${resultList}" var="reviewListId">
	  <tr>
		<td><c:out value="${reviewListId.name}" /></td>
		<td><c:out value="${reviewListId.gio_nc}" /></td>
		<td><c:out value="${reviewListId.tai_nc}" /></td>
		<td><c:out value="${reviewListId.NC_effecientcy}" /><span>%</span></td>
		<td><c:out value="${reviewListId.gio_gd}" /></td>
		<td><c:out value="${reviewListId.tai_gd}" /></td>
		<td><c:out value="${reviewListId.GD_effecientcy}" /><span>%</span></td>
	  </tr>
	</c:forEach>
</tbody>
</table>
</logic:notEmpty>
<logic:empty  name="resultList">
    <label style="color:red;">Không tìm thấy dữ liệu</label>
</logic:empty>