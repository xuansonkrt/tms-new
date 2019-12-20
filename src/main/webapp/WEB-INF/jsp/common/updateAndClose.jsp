<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<logic:notEmpty name="status">
	<logic:equal  name="status" value="success">
		<logic:notEmpty name="message">
			<script>
				toastr["success"](`${message}`);
			</script>
		</logic:notEmpty>
		<logic:empty name="message">
			<script>
				toastr["success"]("Thao tác thực hiện thành công!");
			</script>
		</logic:empty>
		
		<script>
			$('#myModal').modal('hide');
		</script>
	</logic:equal>
	<logic:equal  name="status" value="error">
		<logic:notEmpty name="message">
			<script>
				toastr["error"](`${message}`);
			</script>
		</logic:notEmpty>
		<logic:empty name="message">
			<script>
				toastr["error"]("Có lỗi xảy ra!");
			</script>
		</logic:empty>
	</logic:equal>
	<logic:notEmpty name="callback">
		<script>
			eval(`${callback}()`);
		</script>
	</logic:notEmpty>
</logic:notEmpty>