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
                <i class="fa fa-th"></i> Thêm mới bài báo
            </logic:empty>
                    <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật bài báo
            </logic:notEmpty>
                </h5>
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                     <input type="hidden" name="id" class="form-control" id="id" placeholder="" value="${staffPaper.id}">
                     <input type="hidden" name="id" class="form-control" id="staffId" placeholder="" value="${staffPaper.staffId}">
                     <input type="hidden" name="id" class="form-control" id="organizationId" placeholder="" value="${staffPaper.organizationId}">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Hình thức viết báo</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="paperTypeId" id="paperTypeId">
                                <option value="">--- Chọn hình thức ---</option>
                                <logic:notEmpty name="lstPaperType">
                                    <c:forEach items="${lstPaperType}" var="cat" varStatus="loop">
                                        <option value="${cat.id}"   ${cat.id == staffPaper.paperTypeId ? 'selected="selected"' : ''}>${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                            <span id="notePoint"></span>
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã bài báo</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="code" class="form-control" id="code" placeholder="" value="${staffPaper.code}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên bài báo</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="name" class="form-control" id="name" placeholder="" value="${staffPaper.name}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Số tác giả</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="number" name="numberAuthor" class="form-control" id="numberAuthor" placeholder="" value="${staffPaper.numberAuthor}">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tác giả</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="200" type="text" name="author" class="form-control" id="author" placeholder="" value="${staffPaper.author}">
                        </div>
                    </div>
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Giờ chuẩn</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input maxlength="100" type="text" name="researchPoint" class="form-control" id="researchPoint" placeholder="" value="${staffPaper.researchPoint}" disabled="disabled">
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Ngày xuất bản</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <tags:datePicker name="publishDateString" value="${staffPaper.publishDateString}"/>
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
	var array = new Array();
	var point = 0;
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
		var numAuthor = $('#numberAuthor').val();
		if(numAuthor == '' || point==0){
			return;
		}
		var a = Math.round(point/numAuthor * 100) / 100;
		$('#researchPoint').val(a);
	}
	$(document).ready(function(){
		$('.select2').select2();
		
		 $('#paperTypeId').on('change', function(){
			 if($('#paperTypeId').val()==''){
				 $('#notePoint').text('');
					point = 0;
			 }
			for(var i=0; i<array.length; i++){
				if(array[i].id==$('#paperTypeId').val()){
					$('#notePoint').text(array[i].note);
					point = array[i].point;
				}
			}
			setPoint();
		}) 
		
		$('#numberAuthor').on('blur', function(){
			if($('#numberAuthor').val()<0){
				$('#numberAuthor').val('');
				return;
			}
			setPoint();
		})
	})
</script>