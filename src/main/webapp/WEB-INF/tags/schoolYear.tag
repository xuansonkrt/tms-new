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
String year2="";
    if(!CommonUtil.isNullOrEmpty(value)){
        Long year = new Long(value);
        year++;
        year2 = year.toString();
    }
%>

 <div class=" row form-group" style="margin-left: 0px; margin-right: 0px; ">
    <input maxlength="4"  type="text" name="<%=name%>" class="col-5 form-control" id="<%=id%>" placeholder="" value="<%=value%>" onkeyup="changeYear(this,event);">
    <label class="control-label col-2"> - </label>
    <input  type="text" value="<%= year2 %>" class="col-5  form-control" disabled="disabled" id="<%=id%>_year2" >
</div>

<script>
	function changeYear(el,event){
		console.log('e',$(el).val());
		var value = $(el).val();
		if(value !=""){
			$(el).val(value.replace(/[^\d]/,''));
			
			$("#<%=id%>_year2").val(parseInt($(el).val())+1);
		} else{
			$("#<%=id%>_year2").val("");
		}
		
	}
	
</script>