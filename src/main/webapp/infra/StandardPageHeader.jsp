<%@ include file="/infra/CommonHeader.jsp"%>
<%@ page import='br.com.egen.tsegenstdref.dbobj.table.*' %>
<html>
	<head>
		<title><bean:message key="page.title"/></title>
		<%@ include file="/infra/JsImports.jsp"%>
  	<link href="<c:out value="${home}"/>img/favicon.ico" type="image/x-icon" rel="shortcut icon" />
  	<link href="<c:out value="${home}"/>img/favicon.ico" type="image/x-icon" rel="icon" />
	</head>
	<body>
	<div id="maincontainer">
		<header id="mainheader">
			<div class="pagemargin">
      	<a id="mainheadertitle" href="<c:out value="${home}"/>"><bean:message bundle="ApplicationResources" key="main.app.title"/></a>
				<div id="mainlogincontrol">
					<div id="mainlogoutcontainer">
      			<a id="mainlogoutcontainerLabel" href="<c:out value="${home}"/>system/LogonForm.do?logout_action="><bean:message bundle="ApplicationResources" key="main.app.logout"/></a>
	      	</div>
      	</div>
			</div>  
		</header>
		<div id="maincontent" class="pagemargin">
		<%@ include file="/system/MainMenu.jsp"%>
	