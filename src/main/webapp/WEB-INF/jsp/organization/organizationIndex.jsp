<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%-- <%@ taglib uri="http://primefaces.org/ui" prefix="p" %> --%>


<div class="row">
    <div class="col-3">
        <div class="card">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-list pr-1"></i>Chọn đơn vị</label>
                <!-- <div style="float: right;">
                    <button class="btn btn-primary" id="btn-add-cat-type" onclick="addCategoryType()">
                        <i class="fa fa-plus pr-1"></i>Thêm mới
                    </button>
                </div> -->

            </div>
            <div class="card-body card-body-cus">
				<div id="lazy" class="demo"></div>
            </div>
        </div>
    </div>
    <div class="col-9 pl-0">
        <div class="card">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-search pr-1"></i>Thông tin tìm kiếm</label>
            </div>
            <div class="card-body">
                <form id="formSearch" name ="formSearch" class="form-horizontal">
                    <input type="hidden" name="parentId" class="form-control" id="parentId">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Mã đơn vị</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="code" class="form-control" id="code"  >
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Tên đơn vị</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="name" class="form-control" id="name">
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
                <label class="title-card"><i class="fa fa-list pr-1"></i><span id="label-org-list"> Danh sách đơn vị</span></label>
                <div style="float: right;">
                    <button class="btn btn-primary" id="btn-add-cat-type" onclick="add()">
                        <i class="fa fa-plus pr-1"></i>Thêm mới
                    </button>
                </div>
            </div>
            <div class="card-body" id="resultListArea" style="max-height:350px; overflow-y : auto;">
                <%-- <jsp:include page="categoryList.jsp"></jsp:include> --%>
            </div>
        </div>
    </div>
</div>

	
<script>
function add(){
    var areaId ="myModal";
    var url="/organization/add"
    ajaxUpdate("GET",areaId,url,null, function(){
        $('#myModal').modal('show');
    });
}

function actionSave(){
	if(validateBeforeSave()){
		confirmSave(null, function(){
	        var url ="/organization";
	        ajaxSendData("POST","saveResult",url,getFormData('formSave'),null);
	    });
	}
    
}

function actionSearch(){
    var areaId ="resultListArea";
    var url="/organization/search"
    var data = getFormData('formSearch');
    ajaxUpdate("GET",areaId,url,data,null);
}

function afterSave(){
    actionSearch();
    reloadTree();
}

function prepareUpdate(id){
    var areaId ="myModal";
    var url="/organization/"+id;
    ajaxUpdate("GET",areaId,url,null, function(){
        $('#myModal').modal('show');
    });
}

function prepareDelete(id){
    confirmDelete(null, function(){
        var url ="/organization/delete/"+id;
        ajaxSendData("POST","saveResult",url,null);
    })
    
}
function reloadTree(){
	$('#lazy').jstree(true).refresh();
}

function validateBeforeSave(){
	if($('#formSave #code').val()==''){
		showError('Chưa nhập mã đơn vị!');
		$('#formSave #code').focus();
		return false;
	}
	
	if($('#formSave #name').val()==''){
		showError('Chưa nhập tên đơn vị!');
		$('#formSave #name').focus();
		return false;
	}
	
	if($('#formSave #foundedDateShow').val()==''){
		showError('Chưa nhập ngày thành lập!');
		$('#formSave #foundedDateShow').focus();
		return false;
	}
	
	
	return true;
}

	$(document).ready(function(){
		actionSearch();
		
		// lazy demo
		$('#lazy').jstree({
			'core' : {
				'data' : {
					"url" : function (node) {
		                return node.id === '#' ? "/organization/get-root" : "/organization/get-children/" + node.id;

		            },
					"data" : function (node) {
						return { "id" : node.id };
					}
				}
			}
		});
		
		$('#lazy').on("changed.jstree", function (e, data) {
			if(data.selected.length) {
				$('#label-org-list').text(data.instance.get_node(data.selected[0]).text);
				$('#parentId').val(data.instance.get_node(data.selected[0]).id);
				actionSearch();
			}
		})
	})
</script>