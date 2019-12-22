<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="">
    <div class="card">
        <div class="card-header">
            <label class="title-card"><i class="fa fa-search pr-1"></i>Thông tin tìm kiếm</label>
        </div>
        <div class="card-body">
            <form id="formSearch" name="formSearch" class="form-horizontal">
                <div class="row form-group">
                    <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Mã hình thức</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="code" class="form-control" id="code">
                    </div>
                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Tên hình thức</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                </div>
                <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Cấp học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <select class="form-control select2" name="educationLevelId" id="educationLevelId" >
                                <option value="">--- Chọn tất cả ---</option>
                                <logic:notEmpty name="lstEducationLevel">
                                    <c:forEach items="${lstEducationLevel}" var="cat" varStatus="loop">
                                        <option value="${cat.id}" >${cat.name}</option>
                                    </c:forEach>
                                </logic:notEmpty>
                            </select>
                        </div>
                    </div>
                <div class="area-button">
                    <button class="btn btn-primary" onclick="actionSearch(); return false;">
                        <i class="fa fa-search pr-1"></i>Tìm kiếm
                    </button>
                </div>
            </form>
        </div>
    </div>

    <div class="card mt-3">
        <div class="card-header">
            <label class="title-card"><i class="fa fa-list pr-1"></i>Danh sách hình thức môn học</label>
            <div style="float: right;">
                <button class="btn btn-primary" id="btn-add-cat-type" onclick="add()"> 
                    <i class="fa fa-plus pr-1"></i>Thêm mới
                </button>
            </div>
        </div>
        <div class="card-body" id="lstLearningType" style="max-height: 350px; overflow-y: auto;">
        
        </div>
    </div>
</div>

<script>
	function add(){
		var areaId ="myModal";
        var url="/learning-type/add"
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
	}
	
	function actionSaveTerm(){
		confirmSave(null, function(){
            var url ="/learning-type";
            ajaxSendData("POST","saveResult",url,getFormData('formSave'),null);
        });
	}
	
	function actionSearch(){
    	var areaId ="lstLearningType";
        var url="/learning-type/search"
        var data = getFormData('formSearch');
        ajaxUpdate("GET",areaId,url,data,null);
        
    }
	
	function afterSave(){
		actionSearch();
	}
	
	function prepareUpdate(id){
		var areaId ="myModal";
        var url="/learning-type/"+id;
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
	}
	
	function prepareDelete(id){
    	confirmDelete(null, function(){
    		var url ="/learning-type/delete/"+id;
            ajaxSendData("POST","saveResult",url,null);
    	})
        
    }
	$(document).ready(function(){
		$('.select2').select2();
		actionSearch();
	})
</script>