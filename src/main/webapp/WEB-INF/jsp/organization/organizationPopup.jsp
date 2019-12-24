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
    <div  class="form-horizontal">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i class="fa fa-th"></i> Chọn đơn vị
                </h5>
                <button type="button" class="close" onclick="$('#myModalOrgSelecter').modal('hide'); return false;" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <div class="form-group">
                    <div class="row">
    <div class="col-3">
        <div class="card">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-list pr-1"></i>Chọn đơn vị</label>
            </div>
            <div class="card-body card-body-cus-2" style="overflow-x: auto">
				<div id="lazy-popup" class="demo"></div>
            </div>
        </div>
    </div>
    <div class="col-9 pl-0">
        <div class="card">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-search pr-1"></i>Thông tin tìm kiếm</label>
            </div>
            <div class="card-body">
                <form id="formSearchPopup" name ="formSearchPopup" class="form-horizontal">
                    <input type="hidden" name="parentId" class="form-control" id="parentIdPopup">
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
                         <button class="btn btn-primary" onclick="actionSearchPopup(); return false;">
	                        <i class="fa fa-search pr-1"></i>Tìm kiếm
	                    </button>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="card mt-3">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-list pr-1"></i><span id="label-org-list-popup"> Danh sách đơn vị</span></label>
               
            </div>
            <div class="card-body" id="resultListAreaPopup" style="max-height:250px; overflow-y : auto;">
                <%-- <jsp:include page="categoryList.jsp"></jsp:include> --%>
            </div>
        </div>
    </div>
</div>
                    
                </div>
            </div>
            <div class="modal-footer area-button">
                <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-close"></i> Hủy bỏ</button>
            </div>
        </div>
    </div>
</div>



	
<script>

function actionSearchPopup(){
    var areaId ="resultListAreaPopup";
    var url="/organization/search-popup"
    var data = getFormData('formSearchPopup');
    ajaxUpdate("GET",areaId,url,data,null);
}


	$(document).ready(function(){
		actionSearchPopup();
		
		// lazy demo document.forms['formSearchPopup']
		 $('#lazy-popup').jstree({
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
		
		$('#lazy-popup').on("changed.jstree", function (e, data) {
			if(data.selected.length) {
				$('#label-org-list-popup').text(data.instance.get_node(data.selected[0]).text);
				$('#parentIdPopup').val(data.instance.get_node(data.selected[0]).id);
				actionSearchPopup();
			}
		}) 
	})
</script>