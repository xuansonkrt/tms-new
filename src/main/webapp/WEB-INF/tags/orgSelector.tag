<%@tag import="application.common.CommonUtil"%>
<%@tag import="org.springframework.util.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<%@ attribute name="name" required="true" %>
<%@ attribute name="id" %>
<%@ attribute name="style" %>
<%@ attribute name="value" %>

<style>
/* thead {
	background-color: #fff !important;
	color: #000 !important;
} */


</style>
<% if(StringUtils.isEmpty(id)){
    id=name;
} 
%>

<div class="form-group">
	<div class='input-group date' id=''>
		<input type='text'  id="<%=id+"_parentName"%>" class="form-control" readonly="readonly"/> 
		<input type='hidden' name="<%=name%>" value="<%=value%>" id="<%=id%>" class="form-control" /> 
		<span class="input-group-addon" onclick="showPopup();"> 
			<span class="fa fa-search btnEdit"></span>
		</span>
		<span class="input-group-addon" onclick="showPopup();"> 
			<span class="fa fa-close btnDel"></span>
		</span>
	</div>
</div>
<div id="myModalOrgSelecter" class="modal fade" role="dialog" style="z-index: 9999;"> </div>
<script>
function showPopup(){
    var areaId ="myModalOrgSelecter";
    var url="/organization/popup"
    ajaxUpdate("GET",areaId,url,null, function(){
        $('#myModalOrgSelecter').modal('show');
    });
}
function selectOrg(id, name){
	$('#<%=id%>').val(id);
	$('#<%=id+"_parentName"%>').val(name);
	$('#myModalOrgSelecter').modal('hide');
}

$(document).ready(function(){
	var id =$('#<%=id%>').val();
	if(id){
		$.ajax({
	           url: "/organization/info/"+id,
	           type: "GET",
	           dataType: "json",
	           traditional: true,
	           success: function (data) {
	               if (data) {
	            	   $('#<%=id+"_parentName"%>').val(data.name);
	               }
	               else {

	               }
	           }.bind(this),
	           error: function (xhr, status, err) {
	               console.log(err.toString());
	           }
	       });
	}
   	
})


</script>