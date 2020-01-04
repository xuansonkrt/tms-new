<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="">
    <div id="staffInfoArea">
         <jsp:include page="staffInfo.jsp"></jsp:include>
    </div>

	<div class="card mt-3">
	     <div class="card-header">
	          <label class="title-card"><i class="fa fa-list pr-1"></i>Bài báo khoa học</label>
	          <div style="float: right;">
	               <button class="btn btn-primary" id="btn-add-cat-type" onclick="add()">
	                    <i class="fa fa-plus pr-1"></i>Thêm mới
	               </button>
	          </div>
	     </div>
	     <div class="card-body"style="max-height: 350px; overflow-y: auto;">
	          <form id="formSearch" name="formSearch" class="form-horizontal">
	          <input type="hidden" name="id" class="form-control" id="staffId" placeholder="" value="${staffPaper.staffId}">
	          	<div class="row form-group">
	               <label class="control-label pr-0 col-md-2 col-sm-4 col-xs-12">Học kỳ</label>
	               <div class="col-md-3 col-sm-8 col-xs-12">
	                    <select class="form-control select2" id="term" name="term">
	                    	<option value="" selected="selected">Cả năm</option>
			                 <option value="1">Học kỳ 1</option>
			                 <option value="2">Học kỳ 2</option>
			            </select>
	               </div>
	               <label class="control-label pr-0 col-md-3 col-sm-4 col-xs-12">Năm học</label>
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
	          </form>
	          
	          <div id="staffPaperArea">
			       
			  </div>
	     </div>
	</div>
    
    
</div>

<script>

function validateBeforeSave(){
	/* if(!$('#formSave>#paperTypeId').val()){
		showError('Chưa chọn hình thức viết báo!');
		$('#formSave #paperTypeId').focus();
		return false;
	}
	if(!$('#formSave>#code').val()){
		showError('Chưa nhập mã bài báo!');
		$('#formSave #code').focus();
		return false;
	}
	
	if(!$('#formSave>#name').val()){
		showError('Chưa nhập tên bài báo!');
		$('#formSave #name').focus();
		return false;
	}
	
	if(!$('#formSave>#numberAuthor').val()){
		showError('Chưa nhập số tác giả!');
		$('#formSave #numberAuthor').focus();
		return false;
	}
	
	if(!$('#formSave>#author').val()){
		showError('Chưa nhập tác giả!');
		$('#formSave #author').focus();
		return false;
	}
	if(!$('#formSave>#publishDateShow').val()){
		showError('Chưa nhập ngày xuất bản!');
		$('#formSave #publishDateShow').focus();
		return false;
	}
	 */
	return true;
}

    function loadStaffInfo(){
        var areaId ="staffInfoArea";
        var url="/research/staff/"+$('#cbStaff').val();
        ajaxUpdate("GET",areaId,url,null,null);
    }
    
    function loadStaffPaper(){
        var areaId ="staffPaperArea";
        var url="/research/staff-paper"
        ajaxUpdate("GET",areaId,url,null,null);
    }
    
    
    function add(){
        var areaId ="myModal";
        var url="/research/staff-paper/add/"+$('#cbStaff').val();
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
            $('#formSave>#staffId').val( $('#cbStaff').val());
        });
    }
    
    function actionSaveTerm(){
    	if(validateBeforeSave()){
    		confirmSave(null, function(){
                var url ="/research/staff-paper";
                ajaxSendData("POST","saveResult",url,getFormData('formSave'),null);
            });
    	}
    	
        
    }
    
    function actionSearch(){
        var areaId ="staffPaperArea";
        var url="/research/staff-paper"
        var data = getFormData('formSearch');
        ajaxUpdate("GET",areaId,url,data,null);
        
    }
    
    function afterSave(){
        actionSearch();
    }
    
    function prepareUpdate(id){
        var areaId ="myModal";
        var url="/research/staff-paper/"+id;
        ajaxUpdate("GET",areaId,url,null, function(){
            $('#myModal').modal('show');
        });
    }
    
    function prepareDelete(id){
        confirmDelete(null, function(){
            var url ="/research/staff-paper/delete/"+id;
            ajaxSendData("POST","saveResult",url,null);
        })
        
    }
    $(document).ready(function(){
    	$('.select2').select2();
        actionSearch();
        
        $('#staffId').change(function(event){
			loadStaffInfo();
		})
		 $('#term').change(function(event){
			 actionSearch();
		})
		 $('#year').change(function(event){
			 actionSearch();
		})
		
    })
</script>