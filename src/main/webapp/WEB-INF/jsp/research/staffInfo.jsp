<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<div class="card">
        <div class="card-header">
            <label class="title-card"><i class="fa fa-info-circle pr-1"></i>Thông tin giáo viên</label>
        </div>
        <div class="card-body">
            <form id="formSearch2" name="formSearch2" class="form-horizontal">
                <div class="row form-group">
                	<div class="col-md-2 col-sm-12 col-xs-12">
                		<img  style="max-width: 150px" src="${staffBean.avatar}" class="user-avatar">
                	</div>
                	<div class="col-md-10 col-sm-12 col-xs-12">
                		 <div class="row form-group">
                		 	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Giáo viên</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <select class="form-control select2" id="cbStaff">
			                      <!--   <option value="">--- Chọn giáo viên ---</option> -->
			                        <logic:notEmpty name="lstStaff">
			                            <c:forEach items="${lstStaff}" var="cat" varStatus="loop">
			                                <option value="${cat.id}"
			                                    ${cat.id == staffBean.id ? 'selected="selected"' : ''}>${cat.name}</option>
			                            </c:forEach>
			                        </logic:notEmpty>
			                    </select>
		                    </div>
		                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Giới tính</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <div class=" row form-group">
									<div class="col-6">
										<div class="form-check" style="margin-top: 6px;">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" ${staffBean.gender != 1 ? 'checked' : ''}
												name="genderRadio" id="gender0" value="0"> Nam
											</label>
										</div>
									</div>
									<div class="col-6">
										<div class="form-check" style="margin-top: 6px;">
											<label class="form-check-label"> <input type="radio"
												class="form-check-input" ${staffBean.gender == 1 ? 'checked' : ''}
												name="genderRadio" id="gender1" value="1"> Nữ
											</label>
										</div>
									</div>
								</div>
		                    </div>
                		 </div>
                		 <div class="row form-group">
                		 	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Ngày sinh</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control" id="dateOfBirthShow" value="${staffBean.dateOfBirthShow}" disabled="disabled">
		                    </div>
		                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Địa chỉ</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control" id="address" value="${staffBean.address}" disabled="disabled">
		                    </div>
                		 </div>
                		 <div class="row form-group">
                		 	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Email</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control"  id="email" value="${staffBean.email}" disabled="disabled">
		                    </div>
		                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Số điện thoại</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control"  id="phoneNumber" value="${staffBean.phoneNumber}" disabled="disabled">
		                    </div>
                		 </div>
                		 <div class="row form-group">
                		 	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Học hàm</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control"  id="academicTitleName" value="${staffBean.academicTitleName}" disabled="disabled">
		                    </div>
		                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Học vị</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text" class="form-control"  id="academicLevelName" value="${staffBean.academicLevelName}" disabled="disabled">
		                    </div>
                		 </div>
                		 <div class="row form-group">
                		 	<label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Chức danh nhà giáo</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text"  class="form-control"  id="levelTitleName" value="${staffBean.levelTitleName}" disabled="disabled">
		                    </div>
		                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Cấp bậc</label>
		                    <div class="col-md-3 col-sm-8 col-xs-12">
		                        <input type="text"  class="form-control"  id="armyRankName" value="${staffBean.armyRankName}" disabled="disabled">
		                    </div>
                		 </div>
                	</div>
                </div>
            </form>
        </div>
    </div>
    
    <script>
    	$(document).ready(function(){
    		$('.select2').select2();
    		//checkbox and radios
    	    $(".form-check label,.form-radio label").append('<i class="input-helper"></i>');
    		
    		$('#cbStaff').change(function(event){
    			loadStaffInfo();
    			actionSearch();
    			actionSearchCourse();
    		})
    	})
    </script>