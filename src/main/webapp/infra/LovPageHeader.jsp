<%@ include file="/infra/CommonHeader.jsp"%>
<%@ page import='br.com.egen.tsegenstdref.dbobj.table.*' %>
<html>
	<head>
		<title><bean:message key="page.title"/></title>
		<%@ include file="/infra/JsImports.jsp"%>
  	<link href="<c:out value="${home}"/>img/favicon.ico" type="image/x-icon" rel="shortcut icon" />
  	<link href="<c:out value="${home}"/>img/favicon.ico" type="image/x-icon" rel="icon" />
  	<script>
			$(document).ready(function() {
				$('#lovexitcontrol').click(function() {
					window.close();
				});
			});  	
  	</script>
	</head>
	<body>
	<div id="maincontainer">
		<header id="lovheader">
			<div class="pagemargin">
				<div id="lovexitcontrol" class="ui-state-active ui-icon ui-icon-close">
      	</div>
			</div>  
		</header>
		<div id="maincontent" class="pagemargin">
	