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
<logic:notEmpty name="lstCategory">
<!--   pagesize="10" -->
	<display:table   class="table table-striped table-bordered" name="lstCategory" 
	        id="row" 	requestURI="/category/search">
		<display:column title="STT" style="width: 30px; text-align: center;">
          <c:out value="${row_rowNum}"/>
        </display:column>
        <display:column title="Sửa" class="pointer btnEdit" style="width: 30px; text-align: center;">
          <i class="fa fa-edit" onclick="prepareUpdateCategory('${row.id}')"></i>
        </display:column>
        <display:column title="Xóa"  class="pointer btnDel" style="width: 30px; text-align: center;">
          <i class="fa fa-trash" onclick="prepareDeleteCategory('${row.id}')"></i>
        </display:column>
		<%-- <display:column sortable="true" title="ID">
			<c:out value="${row.id}" />
		</display:column> --%>
		<display:column property="code" title="Mã danh mục" autolink="true" />
		<display:column property="name" title="Tên danh mục" />
		<display:column property="effectDateShow" title="Ngày hiệu lực" style="text-align: center;"  />
		<!-- format="{0,date,dd/mm/yyyy}" -->
		<display:column property="expiredDateShow" title="Ngày hết hiệu lực" style="text-align: center;" />
		<display:column property="theOrder" title="Thứ tự" />
	</display:table>
</logic:notEmpty>
<logic:empty  name="lstCategory">
	<label style="color:red;">Không tìm thấy dữ liệu</label>
</logic:empty>