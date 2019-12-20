<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-3">
        <div class="card">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-list pr-1"></i>Loại danh mục</label>
                <div style="float: right;">
                    <button class="btn btn-primary" id="btn-add-cat-type" onclick="addCategoryType()">
                        <i class="fa fa-plus pr-1"></i>Thêm mới
                    </button>
                </div>

            </div>
            <div class="card-body card-body-cus">
                <div>
                    <input type="text" class="form-control" id="nameSearch"
                        placeholder="Tìm kiếm loại danh mục" >
                </div>
                <div id="categoryTypeArea">
                    <jsp:include page="categoryTypeIndex.jsp"></jsp:include>
                </div>
                
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
                    <input type="hidden" name="categoryTypeId" class="form-control" id="categoryTypeId">
                    <div class="row form-group">
                        <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Mã loại danh mục</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="code" class="form-control" id="code"  >
                        </div>
                        <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Tên loại danh mục</label>
                        <div class="col-md-3 col-sm-8 col-xs-12">
                            <input type="text" name="name" class="form-control" id="name">
                        </div>
                    </div>
                    
                    <div class="area-button">
                         <button class="btn btn-primary" onclick="actionSearchCategory()">
	                        <i class="fa fa-search pr-1"></i>Tìm kiếm
	                    </button>
                    </div>
                </form>
            </div>
        </div>
        
        <div class="card mt-3">
            <div class="card-header">
                <label class="title-card"><i class="fa fa-list pr-1"></i>Danh sách danh mục</label>
                <div style="float: right;">
                    <button class="btn btn-primary" id="btn-add-cat-type" onclick="addCategoryType()">
                        <i class="fa fa-plus pr-1"></i>Thêm mới
                    </button>
                </div>
            </div>
            <div class="card-body" id="lstCategoryArea">
                <jsp:include page="categoryList.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
<script>
    function addCategoryType(){
        var areaId ="myModal";
        var url="/category-type/add"
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
    }
    function prepareUpdate(id){
        var areaId ="myModal";
        var url="/category-type/"+id;
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
    }
    function prepareDelete(id){
    	confirmDelete(null, function(){
    		var url ="/category-type/delete/"+id;
            ajaxSendData("POST","saveResult",url,null);
    	})
        
    }
    function prepareShowList(id){
        $('#categoryTypeId').val(id);
        actionSearchCategory();
    }
    
    function actionSaveCategoryType(){
        confirmSave(null, function(){
            var url ="/category-type";
            ajaxSendData("POST","saveResult",url,getFormData('formSave'));
            console.log('data', getFormData('formSave'));
        });
    }
    function afterSaveCategoryType(){
        searchCategoryType();
    }
    function searchCategoryType(){
        var areaId ="categoryTypeArea";
        var url="/category-type/search"
        var data ={};
        data['name']=$('#nameSearch').val();
        ajaxUpdate("GET",areaId,url,data,null);
    }
    
    function actionSearchCategory(){
    	var areaId ="lstCategoryArea";
        var url="/category/search"
        var data = getFormData('formSearch');
        ajaxUpdate("GET",areaId,url,data,null);
    }
    $(document).ready(function(){
        $("#nameSearch").on('keyup',function(){
            searchCategoryType()
        });
    })
</script>