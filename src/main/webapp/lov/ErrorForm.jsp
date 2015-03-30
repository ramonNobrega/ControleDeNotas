<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/infra/LovPageHeader.jsp"%>
<div id="helppage">
	<div class="pagetitle">
		<fmt:message key="error.app.title" bundle="${bundle}" />
	</div>
	<div class="formrow">
		<div class="formcell">
			<% String erros = request.getParameter("erros"); %>
			<%= ((erros!=null)?erros:"") %>
		</div>
	</div>
</div>
<%@ include file="/infra/LovPageFooter.jsp"%>
