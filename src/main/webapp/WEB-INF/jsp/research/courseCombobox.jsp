<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<select class="form-control select2" name="courseId" id="courseId">
    <option value="">--- Chọn lớp học phần ---</option>
    <logic:notEmpty name="lstCourse">
        <c:forEach items="${lstCourse}" var="cat" varStatus="loop">
            <option value="${cat.id}" >${cat.name}</option>
        </c:forEach>
    </logic:notEmpty>
</select>

<script>
	listCourse = new Array();
	<c:forEach items="${lstCourse}" var="item">
		var temp={
			id: '${item.id}',
			subjectName: '${item.subjectName}',
			studentAmount: '${item.studentAmount}'
		}
		listCourse.push(temp);
	</c:forEach>
	$(document).ready(function(){
		$('.select2').select2();
		
		 $('#courseId').on('change', function(){
				for(var i=0; i<listCourse.length; i++){
					if(listCourse[i].id==$('#courseId').val()){
						$('#subjectName').val(listCourse[i].subjectName);
						$('#studentAmount').val(listCourse[i].studentAmount);
					}
				}
				setPoint();
			})
	})
	
	
</script>