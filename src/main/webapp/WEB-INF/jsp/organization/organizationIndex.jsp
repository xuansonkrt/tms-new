<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%-- <%@ taglib uri="http://primefaces.org/ui" prefix="p" %> --%>

<h1>Lazy loading demo</h1>
	<div id="lazy" class="demo"></div>
	
<script>
	$(document).ready(function(){
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
	})
</script>