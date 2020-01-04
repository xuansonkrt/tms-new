<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<style>
.modal-lg {
    width: 75%;
}
</style>

<div class="modal-dialog modal-lg" role="document">
    <form id="formSave" name ="formSave" class="form-horizontal">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <logic:empty name="id">
                <i class="fa fa-th"></i> Thêm mới tải giảng dạy
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Thông tin tải giảng dạy
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                     <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${staffCourse.id}">
                     <input type="hidden" name="staffId" class="form-control" id="staffId" placeholder="" value="${staffCourse.staffId}">
                     <input type="hidden" name="organizationId" class="form-control" id="organizationId" placeholder="" value="${staffCourse.organizationId}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Cấp học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="educationLevelId" id="educationLevelId">
                                <option value="">--- Chọn hình thức ---</option>
                                <logic:notEmpty name="lstEducationLevel">
                                    <c:forEach items="${lstEducationLevel}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == staffCourse.educationLevelId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                            
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Ngày kết thúc</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <tags:datePicker name="finishDateShow" value="${staffCourse.finishDateShow}"/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Lớp học phần</label>
                        <div class="col-md-3 col-sm-8 col-xs-12" id="courseArea">
							<select class="form-control select2" name="courseId" id="courseId">
							    <option value="">--- Chọn lớp học phần ---</option>
							    <logic:notEmpty name="lstCourse">
							        <c:forEach items="${lstCourse}" var="cat" varStatus="loop">
							            <option value="${cat.id}"   ${cat.id == staffCourse.courseId ? 'selected="selected"' : ''}>${cat.name}</option>
							        </c:forEach>
							    </logic:notEmpty>
							</select>
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Hình thức công việc</label>
                        <div class="col-md-3 col-sm-8 col-xs-12"  id="learningTypeArea">
							<select class="form-control select2" name="learningTypeId" id="learningTypeId">
							    <option value="">--- Chọn hình thức công việc ---</option>
							    <logic:notEmpty name="lstLearningType">
							        <c:forEach items="${lstLearningType}" var="cat" varStatus="loop">
							            <option value="${cat.id}" ${cat.id == staffCourse.learningTypeId ? 'selected="selected"' : ''}>${cat.name}</option>
							        </c:forEach>
							    </logic:notEmpty>
							</select>
							<span id="notePoint"></span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Học phần</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                       		<input  type="text" class="form-control" id="subjectName" disabled="disabled">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Sĩ số</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
							<input  type="text" class="form-control" id="studentAmount" disabled="disabled">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Khối lượng công việc</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="number" name="amount" class="form-control" id="amount" placeholder="" value="${staffCourse.amount}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Giờ chuẩn</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                             <input maxlength="100" type="text" name="eduPoint" class="form-control" id="eduPoint" placeholder="" value="${staffCourse.eduPoint}" disabled="disabled">
                        </div>
                         
                    </div>
                </div>
            </div>
            <div class="modal-footer area-button">
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> Hủy bỏ</button>
                <button type="submit" class="btn btn-primary" onclick="actionSaveStaffCourse(); return false; "><i class="fa fa-save"></i> Lưu lại</button>
            </div>
        </div>
    </form>
</div>

<script>
	var listCourse = new Array();
	var listLearningType = new Array(); 
	<c:forEach items="${lstCourse}" var="item">
		var temp={
			id: '${item.id}',
			subjectName: '${item.subjectName}',
			studentAmount: '${item.studentAmount}'
		}
		listCourse.push(temp);
	</c:forEach>;
	<c:forEach items="${lstLearningType}" var="item">
		var temp={
			id: '${item.id}',
			note: '${item.note}',
			unit: '${item.unit}',
			factor: '${item.factor}'
		}
		listLearningType.push(temp);
	</c:forEach>;

	var array = new Array();
	var point = 0;
	var factor = 0;
	var unit = 0;
	<c:forEach items="${lstPaperType}" var="item">
		var temp={
			id: '${item.id}',
			note: '${item.note}',
			point: '${item.researchPoint}',
		}
	   array.push(temp);
	</c:forEach>
	/* function myFunction(data){
		console.log('data',data)
	} */
	
	function setPoint(){
		var amount = $('#amount').val();
		if(amount == '' || factor==0){
			return;
		}
		var a = Math.round((amount*factor/unit) * 100) / 100;
		$('#eduPoint').val(a);
	}
	$(document).ready(function(){
		
		$('#educationLevelId').change(function(event){
        	var areaId ="courseArea";
            var url="/research/get-course/"+$('#educationLevelId').val();
            ajaxUpdate("GET",areaId,url,null,null);
        })
		
        $('#educationLevelId').change(function(event){
        	var areaId ="learningTypeArea";
            var url="/research/get-learning-type/"+$('#educationLevelId').val();
            ajaxUpdate("GET",areaId,url,null,null);
        })
        
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
		
		 $('#courseId').on('change', function(){
			for(var i=0; i<listCourse.length; i++){
				if(listCourse[i].id==$('#courseId').val()){
					$('#subjectName').val(listCourse[i].subjectName);
					$('#studentAmount').val(listCourse[i].studentAmount);
				}
			}
			setPoint();
		})
		
		
		
		$('#amount').on('blur', function(){
			if($('#amount').val()<0){
				$('#amount').val('');
				return;
			}
			setPoint();
		})
		
		for(var i=0; i<array.length; i++){
			if(array[i].id==$('#paperTypeId').val()){
				$('#notePoint').text(array[i].note);
				point = array[i].point;
			}
		}
		 
		 for(var i=0; i<listCourse.length; i++){
				if(listCourse[i].id==$('#courseId').val()){
					$('#subjectName').val(listCourse[i].subjectName);
					$('#studentAmount').val(listCourse[i].studentAmount);
				}
		}
		 
		 for(var i=0; i<listLearningType.length; i++){
				if(listLearningType[i].id==$('#learningTypeId').val()){
					$('#notePoint').text(listLearningType[i].note);
					factor = listLearningType[i].factor;
					unit = listLearningType[i].unit;
				}
		}
	})
</script>