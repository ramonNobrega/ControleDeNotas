<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/infra/LovPageHeader.jsp"%>
<div id="helppage">
	<div class="pagetitle">
		<fmt:message key="help.app.title" bundle="${bundle}" />
	</div>
	<div class="formrow">
		<div class="formcell">
			<% String sh = request.getParameter("help"); %><%= ((sh!=null)?sh:"") %>
		</div>
	</div>
</div>
<%@ include file="/infra/LovPageFooter.jsp"%>
