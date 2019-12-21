<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<style>
	.col-3{
		width: 30%;
	}
	.col-9{
		width: 70%;
	}
	.table-header {
		background-color: #03a9f3 !important;
    	color: #fff  !important;
    }
</style>
<div class="list-cat-type">
	<logic:notEmpty name="lstCategoryType">
		<div class="table-responsive-2">
			<table class="table table-striped table-bordered">
				<thead class="table-header">
					<tr class="text-center">
						<td>STT</td>
						<td>Loại danh mục</td>
						<td>Sửa</td>
						<td>Xóa</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lstCategoryType}" var="cat" varStatus="loop">
						<tr>
							<td class="text-center"><c:out value="${loop.index+1}" /></td>
							<td class="select-cat pointer" onclick="prepareShowList('${cat.name}','${cat.id}')"><c:out value="${cat.name}" /></td>
							<td class="text-center pointer btnEdit"  onclick="prepareUpdate('${cat.id}')"><i class="fa fa-edit"></i></td>
							<td class="text-center pointer btnDel" onclick="prepareDelete('${cat.id}')"><i class="fa fa-trash"></i></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</logic:notEmpty>
	<logic:empty name="lstCategoryType">
		<label style="color:red;">Không tìm thấy dữ liệu</label>
		
	</logic:empty>
	
	
</div>


