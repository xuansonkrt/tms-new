<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<div class="card">
    <div class="card-header">
        <label class="title-card"> 
            <logic:empty name="id">
                <i class="fa fa-th"></i> Thêm mới giáo viên
            </logic:empty> 
            <logic:notEmpty name="id">
                <i class="fa fa-th"></i> Cập nhật giáo viên
            </logic:notEmpty>
        </label>
    </div>
    <div class="card-body">
        <form id="formSave" name="formSave" class="form-horizontal">
         <input type="hidden" name="id" class="form-control" id="id" value="${staff.id}">
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Đơn vị</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <tags:orgSelector id="organizationIdIdSave" name="organizationId" value="${staff.organizationId}" />
                </div>

            </div>
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mã giáo viên</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <input type="text" name="code" class="form-control" id="code" value="${staff.code}">
                </div>
                <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Tên giáo viên</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <input type="text" name="name" class="form-control" id="name" value="${staff.name}">
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 ">Ngày sinh</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <tags:datePicker name="dateOfBirthShow" value="${staff.dateOfBirthShow}"/>
                </div>
                <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 ">Giới tính</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
					<div class=" row form-group">
						<div class="col-4">
							<div class="form-check" style="margin-top: 6px;">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" ${staff.gender != 1 ? 'checked' : ''}
									name="genderRadio" id="gender0" value="0"> Nam
								</label>
							</div>
						</div>
						<div class="col-4">
							<div class="form-check" style="margin-top: 6px;">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" ${staff.gender == 1 ? 'checked' : ''}
									name="genderRadio" id="gender1" value="1"> Nữ
								</label>
							</div>
						</div>
						<input type="hidden" name="gender" class="form-control" id="gender" value="${staff.gender}">
					</div>
				</div>
            </div>
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Tên tài khoản</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <input  type="text" name="userName" class="form-control" 
                        id="userName" value="${staff.userName}"
                        ${staff.id != null ? 'disabled="disabled"' : ''} >
                </div>
            </div>
            <logic:empty name="id">
                <div class="row form-group">
                    <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12 required">Mật khẩu</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input autocomplete="off" type="password" name="password" class="form-control" id="password">
                    </div>
                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12 required">Nhập lại mật khẩu</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input autocomplete="off" type="password" name="passwordConfirm" class="form-control" id="passwordConfirm" >
                    </div>
                </div>
            </logic:empty> 
            
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Học hàm</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <select class="form-control select2" name="academicTitleId"
                        id="academicTitleId">
                        <option value="">--- Chọn học hàm ---</option>
                        <logic:notEmpty name="lstAcademicTitle">
                            <c:forEach items="${lstAcademicTitle}" var="cat"
                                varStatus="loop">
                                <option value="${cat.id}"
                                    ${cat.id == staff.academicTitleId ? 'selected="selected"' : ''}>${cat.name}</option>
                            </c:forEach>
                        </logic:notEmpty>
                    </select>
                </div>
                <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Học vị</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <select class="form-control select2" name="academicLevelId"
                        id="academicLevelId">
                        <option value="">--- Chọn học vị ---</option>
                        <logic:notEmpty name="lstAcademicLevel">
                            <c:forEach items="${lstAcademicLevel}" var="cat"
                                varStatus="loop">
                                <option value="${cat.id}"
                                    ${cat.id == staff.academicLevelId ? 'selected="selected"' : ''}>${cat.name}</option>
                            </c:forEach>
                        </logic:notEmpty>
                    </select>
                </div>
            </div>
            <div class="row form-group">
                <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Chức danh nhà giáo</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <select class="form-control select2" name="levelTitleId"
                        id="levelTitleId">
                        <option value="">--- Chọn chức danh nhà giáo ---</option>
                        <logic:notEmpty name="lstLevelTitle">
                            <c:forEach items="${lstLevelTitle}" var="cat"
                                varStatus="loop">
                                <option value="${cat.id}"
                                    ${cat.id == staff.levelTitleId ? 'selected="selected"' : ''}>${cat.name}</option>
                            </c:forEach>
                        </logic:notEmpty>
                    </select>
                </div>
                <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Cấp bậc</label>
                <div class="col-md-3 col-sm-8 col-xs-12">
                    <select class="form-control select2" name="armyRankId"
                        id="armyRankId">
                        <option value="">--- Chọn cấp bậc ---</option>
                        <logic:notEmpty name="lstArmyRank">
                            <c:forEach items="${lstArmyRank}" var="cat"
                                varStatus="loop">
                                <option value="${cat.id}"
                                    ${cat.id == staff.armyRankId ? 'selected="selected"' : ''}>${cat.name}</option>
                            </c:forEach>
                        </logic:notEmpty>
                    </select>
                </div>
            </div>
            <div class="row form-group">
            	<div class="col-6">
            		<div class="row form-group">
	            		<label class="control-label pr-0 col-md-4 col-sm-4 col-xs-12 ">Địa chỉ</label>
		                <div class="col-md-6 col-sm-8 col-xs-12">
		                    <input type="text" name="address" class="form-control" id="address" value="${staff.address}">
		                </div>
            		</div>
	            	<div class="row form-group">
		                <label class="control-label pr-0 col-md-4 ">Số điện thoại</label>
		                <div class="col-md-6">
		                    <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" value="${staff.phoneNumber}">
		                </div>
		               
		            </div>
		            <div class="row form-group">
		                <label class="control-label pr-0 col-md-4 ">Email</label>
		                <div class="col-md-6">
		                    <input type="text" name="email" class="form-control" id="email" value="${staff.email}">
		                </div>
		            </div>
            	</div>
            	<div class="col-6">
            	 <div class="row form-group">
            	 	<label class="control-label pr-0 col-md-4 ">Avartar</label>
            		<div class="col-4 col-md-4 col-sm-12 col-xs-12">
	                    <div style="text-align: center">
	                        <img  style="max-width: 250px" src="${staff.avatar}" class="user-avatar">
	                    </div>
	                    
	
	                    <div style="text-align: center; margin-top: 20px">
	                        <input type='file'  id="input-avatar"/>
	                    </div>
	                    <input type="text" id="avatar" name="avatar"  value="${staff.avatar}" style="display: none">
	
	                </div>
	                </div>
            	</div>
                
            </div>
            
             <div class=" area-button">
                <button type="button" class="btn btn-secondary" onclick="actionCancel(); return false; "><i class="fa fa-close"></i> Hủy bỏ</button>
                <button type="submit" class="btn btn-primary" onclick="actionSave(); return false; "><i class="fa fa-save"></i> Lưu lại</button>
            </div>
        </form>
    </div>
</div>
<script>
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('.user-avatar').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}


	$(document).ready(function(){
		$('.select2').select2();
		$(".form-check label,.form-radio label").append('<i class="input-helper"></i>');
		
		

	    $("#input-avatar").change(function(e) {
	        readURL(this);
	    });
		
	    $('input[name=genderRadio]').on('change', function(){
	    	$('#gender').val($('input[name=genderRadio]:checked').val());
	    })
	    
		/* $('#passwordConfirm').on('blur', function(){
			if($('#passwordConfirm').val()!=$('#password').val()){
				showError('Mật khẩu không khớp');
				$('#passwordConfirm').focus();
			}
		}) */
	})
</script>