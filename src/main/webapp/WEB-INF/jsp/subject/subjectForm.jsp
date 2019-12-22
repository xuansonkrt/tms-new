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
                <i class="fa fa-th"></i> Thêm mới môn học
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật môn học
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                    <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${subject.id}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã môn học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="code" class="form-control" id="code" placeholder="" value="${subject.code}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên môn học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="name" class="form-control" id="name" placeholder="" value="${subject.name}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Cấp học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="educationLevelId" id="educationLevelId" >
                                <option value="">--- Chọn tất cả ---</option>
                                <logic:notEmpty name="lstEducationLevel">
                                    <c:forEach items="${lstEducationLevel}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == subject.educationLevelId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Đơn vị</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                           <%--  <select class="form-control select2" name="educationLevelId" id="educationLevelId" >
                                <option value="">--- Chọn tất cả ---</option>
                                <logic:notEmpty name="lstEducationLevel">
                                    <c:forEach items="${lstEducationLevel}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == subject.educationLevelId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select> --%>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Số tín chỉ</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="5"  type="text" name="credit" class="form-control" id="credit" placeholder="" value="${subject.credit}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Số tiết</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="5" type="text" name="classPeriod" class="form-control" id="classPeriod" placeholder="" value="${subject.classPeriod}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Ghi chú</label>
                        <div class="col-md-9 col-sm-8 col-xs-12">
                            <textarea maxlength="500" rows="4" cols="50" type="text" name="note" class="form-control" id="note" placeholder="" value="${subject.note}">
                            </textarea>
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
	})
</script>