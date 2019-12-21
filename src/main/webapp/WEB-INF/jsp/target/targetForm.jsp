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
                <i class="fa fa-th"></i> Thêm mới học kỳ
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật học kỳ
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                    <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${target.id}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Nhóm chức danh</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
							
							 <input type="text" class="form-control" disabled="disabled" value="${categoryTypeBO.name}">
							  <input type="hidden" name="theType" class="form-control" id="theType" placeholder="" value="${categoryTypeBO.id}">
						</div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Chức danh</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="staffPropertyId" id="staffPropertyId" >
								<option value="">--- Chọn chức danh ---</option>
								<logic:notEmpty name="lstCategory">
									<c:forEach items="${lstCategory}" var="cat" varStatus="loop">
										<option value="${cat.id}"  ${cat.id == target.staffPropertyId ? 'selected="selected"' : ''}>${cat.name}</option>
									</c:forEach>
								</logic:notEmpty>
							</select>
                        </div>
                    </div>
                    
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Tải giảng dạy</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="eduDuty" class="form-control" id="eduDuty" placeholder="" value="${target.eduDuty}" style="text-align: right;">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tải nghiên cứu</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="researchDuty" class="form-control" id="researchDuty" placeholder="" value="${target.researchDuty}" style="text-align: right;">
                        </div>
                    </div> 
                    
                </div>
            </div>
            <div class="modal-footer area-button">
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> Hủy bỏ</button>
                <button type="submit" class="btn btn-primary" onclick="actionSave(); return false; "><i class="fa fa-save"></i> Lưu lại</button>
            </div>
        </div>
    </form>
</div>
<script>
	$(document).ready(function(){
		$('.select2').select2();
	})
</script>