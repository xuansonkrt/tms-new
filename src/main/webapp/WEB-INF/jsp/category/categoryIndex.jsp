<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-3">
		<div class="card">
			<div class="card-header">
				<label class="title-card">Loại danh mục</label>
				<div style="float: right;">
					<button class="btn btn-primary" id="btn-add-cat-type" onclick="addCategoryType()">
						<i class="fa fa-plus pr-1"></i>Thêm mới
					</button>
				</div>

			</div>
			<div class="card-body">
				<div>
					<input type="text" class="form-control" id="name" placeholder="Tìm kiếm loại danh mục" >
				</div>
				<div>
					<jsp:include page="categoryTypeIndex.jsp"></jsp:include>
				</div>
				
			</div>
		</div>
	</div>
	<div class="col-9">
		
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
		alert('id'+id);
	}
	function prepareShowList(id){
		alert('id'+id);
	}
	
	function actionSaveCategoryType(){
		var url ="/category-type";
		ajaxSendData("POST",null,url,getFormData('formSave'));
		console.log('data', getFormData('formSave'));
	}
</script>