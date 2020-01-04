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
                <i class="fa fa-th"></i> Thêm mới đơn vị
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật đơn vị
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                    <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${organization.id}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 ">Đơn vị cha</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <tags:orgSelector id="parentIdSave" name="parentId" value="${organization.parentId}"/>
                        </div>
                    </div>
                    
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã đơn vị</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="code" class="form-control" id="code" placeholder="" value="${organization.code}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên đơn vị</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="name" class="form-control" id="name" placeholder="" value="${organization.name}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Ngày thành lập</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <tags:datePicker name="foundedDateShow" value="${organization.foundedDateShow}"/>
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 ">Email</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="email" class="form-control" id="email" placeholder="" value="${organization.email}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 ">Địa điểm</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200"  type="text" name="address" class="form-control" id="address" placeholder="" value="${organization.address}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 ">Số điện thoại</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="20" type="text" name="phoneNumber" class="form-control" id="phoneNumber" placeholder="" value="${organization.phoneNumber}">
                        </div>
                    </div>
                    <div class="row form-group">
                    	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 ">Thứ tự</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="5"  type="text" name="theOrder" class="form-control" id="theOrder" placeholder="" value="${organization.theOrder}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Ghi chú</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <textarea maxlength="500" rows="4" cols="50" type="text" name="note" class="form-control" id="note" placeholder="" value="${organization.note}">
                            </textarea>
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