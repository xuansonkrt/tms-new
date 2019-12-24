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
	
</style>
<% if(StringUtils.isEmpty(id)){
    id=name;
} %>


<div class="container">
    <div class="row">
        <div style="width: 100%">
            <div class="form-group">
                <div class='input-group date' id=''>
                    <input type='text' name="<%=name%>" value="<%=value%>" id="<%=id%>"  class="form-control" />
                    <span class="input-group-addon" onclick="$('#<%=id%>').trigger('focus');">
                        <span class="fa fa-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript" charset="UTF-8">
            $(function () {
            	$('#<%=id%>').datepicker({
            		format: 'dd/mm/yyyy',
            		todayHighlight:"true",
            		autoclose:"true",
            		language:"vn"
            	});
            });
        </script>
    </div>
</div>