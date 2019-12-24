<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="" id="searchArea">
    <div class="card">
        <div class="card-header">
            <label class="title-card"><i class="fa fa-search pr-1"></i>Thông tin tìm kiếm</label>
        </div>
        <div class="card-body">
            <form id="formSearch" name="formSearch" class="form-horizontal">
                <div class="row form-group">
                    <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Mã giáo viên</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="code" class="form-control" id="code">
                    </div>
                    <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Tên giáo viên</label>
                    <div class="col-md-3 col-sm-8 col-xs-12">
                        <input type="text" name="name" class="form-control" id="name">
                    </div>
                </div>
               <%--  <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Đơn vị</label>
	                    <div class="col-md-3 col-sm-8 col-xs-12">
	                        <tags:orgSelector id="organizationIdIdSearch" name="organizationId"/>
	                    </div>
                         
                    </div> --%>
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
            <label class="title-card"><i class="fa fa-list pr-1"></i>Danh sách giáo viên</label>
            <div style="float: right;">
                <button class="btn btn-primary" id="btn-add-cat-type" onclick="add()"> 
                    <i class="fa fa-plus pr-1"></i>Thêm mới
                </button>
            </div>
        </div>
        <div class="card-body" id="resultListArea" style="max-height: 350px; overflow-y: auto;">
        
        </div>
    </div>
</div>
<div class="" id="formArea">
	
</div>
<script>
	function add(){
		var areaId ="formArea";
        var url="/staff/add"
        ajaxUpdate("GET",areaId,url,null, function(){
        	$('#searchArea').hide();
            $('#formArea').show();
        });
	}
	
	function actionSave(){
		confirmSave(null, function(){
			//upload file
			if($("#input-avatar")[0].files[0]){
				var formData = new FormData();
				formData.append('file', $("#input-avatar")[0].files[0]);
				$.ajax({
			           url: "/api/upload/upload-image",
			           type: "POST",
			           enctype: 'multipart/form-data',
			           processData: false,  // Important!
			           contentType: false,
			           cache: false,
			           data: formData,
			           success: function (data) {
			        	   if (data.success) {
								$("#avatar").val(data.link);
								 var url = "/staff";
					   				ajaxSendData("POST", "saveResult", url, getFormData('formSave'),
					   					null);
							} else{
								showError(data.message);
							}
			        	  
			           }.bind(this),
			           error: function (xhr, status, err) {
			               console.log(err.toString());
			           }
			       });
			} else{
				var url = "/staff";
   				ajaxSendData("POST", "saveResult", url, getFormData('formSave'),
   					null);
			}
			
			
			
		});
	}

	function actionSearch() {
		var areaId = "resultListArea";
		var url = "/staff/search"
		var data = getFormData('formSearch');
		ajaxUpdate("GET", areaId, url, data, null);

	}

	function afterSave() {
		$('#searchArea').show();
		$('#formArea').hide();
		actionSearch();
	}

	function actionCancel() {
		$('#searchArea').show();
		$('#formArea').hide();
		actionSearch();
	}

	function prepareUpdate(id) {
		var areaId = "formArea";
		var url = "/staff/" + id;
		ajaxUpdate("GET", areaId, url, null, function() {
			$('#searchArea').hide();
			$('#formArea').show();
		});
	}

	function prepareDelete(id) {
		confirmDelete(null, function() {
			var url = "/staff/delete/" + id;
			ajaxSendData("POST", "saveResult", url, null);
		})

	}
	$(document).ready(function() {
		$('.select2').select2();
		actionSearch();
	})
</script>