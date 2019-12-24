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
    <display:table   class="table table-striped table-bordered" name="resultList" 
            id="row"     requestURI="/staff/search">
        <display:column title="STT" style="width: 30px; text-align: center;">
          <c:out value="${row_rowNum}"/>
        </display:column>
        <display:column title="Sửa" class="pointer btnEdit" style="width: 30px; text-align: center;">
          <i class="fa fa-edit" onclick="prepareUpdate('${row.id}')"></i>
        </display:column>
        <display:column title="Xóa"  class="pointer btnDel" style="width: 30px; text-align: center;">
          <i class="fa fa-trash" onclick="prepareDelete('${row.id}')"></i>
        </display:column>
        <display:column property="code" title="Mã giáo viên" autolink="true" />
        <display:column property="name" title="Tên giáo viên" />
        <display:column property="userName" title="Tài khoản"/>
        <display:column  title="Giới tính"> 
        	<c:choose>
              <c:when test="${ row.gender == 1}" >
                  Nữ
              </c:when>
              <c:otherwise>
                  Nam
              </c:otherwise>
            </c:choose>
        </display:column>
        <display:column property="dateOfBirthShow" title="Ngày sinh" style="text-align: center;"/>
        <display:column property="organizationName" title="Đơn vị" />
        <display:column property="academicLevelName" title="Học vị" />
        <display:column property="academicTitleName" title="Học hàm" />
        <display:column property="levelTitleName" title="CDNG" />
        <display:column property="armyRankName" title="Cấp bậc" />
    </display:table>
</logic:notEmpty>
<logic:empty  name="resultList">
    <label style="color:red;">Không tìm thấy dữ liệu</label>
</logic:empty>