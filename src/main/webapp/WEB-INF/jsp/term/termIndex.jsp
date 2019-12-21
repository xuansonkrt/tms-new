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
                    <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Mã học kỳ</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="code" class="form-control" id="code">
                    </div>
                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Tên học kỳ</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                </div>
                <div class="row form-group">
                    <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Năm</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="year" class="form-control" id="year">
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
            <label class="title-card"><i class="fa fa-list pr-1"></i>Danh sách học kỳ</label>
            <div style="float: right;">
                <button class="btn btn-primary" id="btn-add-cat-type" onclick="addTerm()"> 
                    <i class="fa fa-plus pr-1"></i>Thêm mới
                </button>
            </div>
        </div>
        <div class="card-body" id="lstTerm"
            style="max-height: 350px; overflow-y: auto;">
            <%-- <jsp:include page="termList.jsp"></jsp:include> --%>
        </div>
    </div>
</div>

<script>
	function addTerm(){
		var areaId ="myModal";
        var url="/term/add"
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
	}
	
	function actionSaveTerm(){
		confirmSave(null, function(){
            var url ="/term";
            ajaxSendData("POST","saveResult",url,getFormData('formSave'),null);
        });
	}
	
	function actionSearch(){
    	var areaId ="lstTerm";
        var url="/term/search"
        var data = getFormData('formSearch');
        ajaxUpdate("GET",areaId,url,data,null);
        
    }
	
	function afterSaveTerm(){
		actionSearch();
	}
	
	function prepareUpdate(id){
		var areaId ="myModal";
        var url="/term/"+id;
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
	}
	
	function prepareDelete(id){
    	confirmDelete(null, function(){
    		var url ="/term/delete/"+id;
            ajaxSendData("POST","saveResult",url,null);
    	})
        
    }
	$(document).ready(function(){
		actionSearch();
	})
</script>