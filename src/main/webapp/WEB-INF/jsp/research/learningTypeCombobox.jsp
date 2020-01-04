<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<select class="form-control select2" name="learningTypeId" id="learningTypeId">
    <option value="">--- Chọn hình thức công việc ---</option>
    <logic:notEmpty name="lstLearningType">
    	<option value="">sonnx</option>
        <c:forEach items="${lstLearningType}" var="cat" varStatus="loop">
            <option value="${cat.id}" >${cat.name}</option>
        </c:forEach>
    </logic:notEmpty>
</select>
<span id="notePoint"></span>
<script>
	listLearningType = new Array();
	<c:forEach items="${lstLearningType}" var="item">
	var temp={
			id: '${item.id}',
			note: '${item.note}',
			unit: '${item.unit}',
			factor: '${item.factor}'
	}
	listLearningType.push(temp);
	</c:forEach>
	$(document).ready(function(){
		$('.select2').select2();
		
		$('#learningTypeId').on('change', function(){
			for(var i=0; i<listLearningType.length; i++){
				if(listLearningType[i].id==$('#learningTypeId').val()){
					$('#notePoint').text(listLearningType[i].note);
					factor = listLearningType[i].factor;
					unit = listLearningType[i].unit;
				}
			}
			setPoint();
		}) 
	})
</script>