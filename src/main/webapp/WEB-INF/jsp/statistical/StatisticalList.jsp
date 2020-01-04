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
<table style="width:100%">
  <tr>
    <th>name</th>
    <th>code</th>
	<th>gio_nc</th>
	<th>nc_effic</th>
	<th>gio_gd</th>
	<th>gd_effic</th>
	<th>tai_gd</th>
	<th>tai_nc</th>
  </tr>
  <c:forEach items="${resultList}" var="reviewListId">
	  <tr>
		<td><c:out value="${reviewListId.name}" /></td>
	    <td><c:out value="${reviewListId.code}" /></td>
		<td><c:out value="${reviewListId.gio_nc}" /></td>
		<td><c:out value="${reviewListId.NC_effecientcy}" /></td>
		<td><c:out value="${reviewListId.gio_gd}" /></td>
		<td><c:out value="${reviewListId.GD_effecientcy}" /></td>
		<td><c:out value="${reviewListId.tai_gd}" /></td>
		<td><c:out value="${reviewListId.tai_nc}" /></td>
	  </tr>
	</c:forEach>
</table>
</logic:notEmpty>
<logic:empty  name="resultList">
    <label style="color:red;">Không tìm thấy dữ liệu</label>
</logic:empty>