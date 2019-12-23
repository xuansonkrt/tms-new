<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<select class="form-control select2" name="subjectId" id="subjectId">
    <option value="">--- Chọn môn học ---</option>
    <logic:notEmpty name="lstSubject">
        <c:forEach items="${lstSubject}" var="cat" varStatus="loop">
            <option value="${cat.id}" >${cat.name}</option>
        </c:forEach>
    </logic:notEmpty>
</select>

<script>
	$(document).ready(function(){
		$('.select2').select2();
	})
</script>