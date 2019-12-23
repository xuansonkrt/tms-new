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
                <i class="fa fa-th"></i> Thêm mới lớp học phần
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật lớp học phần
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                     <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${course.id}">
                   
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Cấp đào tạo</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="educationLevelId" id="educationLevelId" >
                                <option value="">--- Chọn cấp đào tạo ---</option>
                                <logic:notEmpty name="lstEducationLevel">
                                    <c:forEach items="${lstEducationLevel}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == course.educationLevelId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Môn học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12" id="subjectArea">
                            <select class="form-control select2" name="subjectId" id="subjectId" >
                                <option value="">--- Chọn môn học ---</option>
                                <logic:notEmpty name="lstSubject">
                                    <c:forEach items="${lstSubject}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == course.subjectId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                        </div>
                    </div>
                     <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã lớp học phần</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="code" class="form-control" id="code" placeholder="" value="${course.code}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên lớp học phần</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="name" class="form-control" id="name" placeholder="" value="${course.name}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Học kì</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="termId" id="termId" >
                                <option value="">--- Chọn học kì ---</option>
                                <logic:notEmpty name="lstTerm">
                                    <c:forEach items="${lstTerm}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == course.termId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Sĩ số</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="5" type="text" name="studentAmount" class="form-control" id="studentAmount" placeholder="" value="${course.studentAmount}">
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="modal-footer area-button">
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> Hủy bỏ</button>
                <button type="submit" class="btn btn-primary" onclick="actionSaveTerm(); return false; "><i class="fa fa-save"></i> Lưu lại</button>
            </div>
        </div>
    </form>
</div>

<script>
	$(document).ready(function(){
		$('.select2').select2();
		
		$('#educationLevelId').change(function(event){
        	var areaId ="subjectArea";
            var url="/course/get-subject/"+$('#educationLevelId').val();
            var data = getFormData('formSearch');
            ajaxUpdate("GET",areaId,url,data,null);
        })
	})
</script>