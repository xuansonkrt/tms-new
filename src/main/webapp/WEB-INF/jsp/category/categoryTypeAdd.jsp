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
				<i class="fa fa-th"></i> Thêm mới loại danh mục
			</logic:empty>
					<logic:notEmpty name="id">
				<i class="fa fa-th"></i> Cập nhật loại danh mục
			</logic:notEmpty>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${categoryType.id}">
					<div class="row form-group">
						<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã loại danh mục</label>
						<div class="col-md-3 col-sm-8 col-xs-12">
							<input type="text" name="code" class="form-control" id="code" placeholder="" value="${categoryType.code}">
							<%-- <html:text name="categoryType" property="name" styleClass="form-control"></html:text> --%>
						</div>
						<label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên loại danh mục</label>
						<div class="col-md-3 col-sm-8 col-xs-12">
							<input type="text" name="name" class="form-control" id="name" placeholder="" value="${categoryType.name}">
						</div>
					</div>
					<div class="row form-group">
						<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Ngày hiệu lực</label>
						<div class="col-md-3 col-sm-8 col-xs-12">
							<tags:datePicker name="effectDate" />
						</div>
						<label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Ngày hết hạn</label>
						<div class="col-md-3 col-sm-8 col-xs-12">
							<tags:datePicker name="expiredDate" />
						</div>
					</div>
					
				</div>
			</div>
			<div class="modal-footer area-button">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> Hủy bỏ</button>
				<button type="submit" class="btn btn-primary" onclick="actionSaveCategoryType(); return false; "><i class="fa fa-save"></i> Lưu lại</button>
			</div>
		</div>
	</form>
</div>