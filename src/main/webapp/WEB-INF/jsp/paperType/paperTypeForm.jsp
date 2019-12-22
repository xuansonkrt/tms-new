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
                <i class="fa fa-th"></i> Thêm mới hình thức viết báo
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật hình thức viết báo
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                    <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${paperType.id}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã hình thức</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="code" class="form-control" id="code" placeholder="" value="${paperType.code}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên hình thức</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="name" class="form-control" id="name" placeholder="" value="${paperType.name}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Hệ số</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="unit" class="form-control" id="unit" placeholder="" value="${paperType.unit}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Đơn vị tính</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="unitName" class="form-control" id="unitName" placeholder="" value="${paperType.unitName}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Quy ra giờ chuẩn</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                             <input type="text" name="researchPoint" class="form-control" id="researchPoint" placeholder="" value="${paperType.researchPoint}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Ghi chú</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <textarea maxlength="500" rows="4" cols="50" type="text" name="note" class="form-control" id="note" placeholder="" value="${paperType.note}">
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
	})
</script>