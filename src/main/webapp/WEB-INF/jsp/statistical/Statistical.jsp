<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>


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
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Năm học</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
	                        <select class="form-control select2" id="year" name="year">
				                 <option value="2020" selected="selected">2020-2021</option>
				                 <option value="2019">2019-2020</option>
				                 <option value="2018">2018-2019</option>
				                 <option value="2017">2017-2018</option>
				                 <option value="2016">2016-2017</option>
				                 <option value="2015">2015-2016</option>
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
                <label class="title-card"><i class="fa fa-list pr-1"></i><span id="label-org-list"> Danh sách đơn vị</span></label>
                <div style="float: right;">
                </div>
            </div>
            <div class="card-body" id="resultListArea" style="max-height:350px; overflow-y : auto;">
                <%-- <jsp:include page="categoryList.jsp"></jsp:include> --%>
            </div>
        </div>
    </div>
</div>

	
<script>



function actionSearch(){
    var areaId ="resultListArea";
    var url="/bao-cao/search";
    var data = getFormData('formSearch');
    ajaxUpdate("GET",areaId,url,data,null);
}



function reloadTree(){
	$('#lazy').jstree(true).refresh();
}



	$(document).ready(function(){
		actionSearch();
		$('.select2').select2();
		
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