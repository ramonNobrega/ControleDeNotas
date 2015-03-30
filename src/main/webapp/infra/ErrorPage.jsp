<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/infra/StandardPageHeader.jsp"%>
<%@ page isErrorPage="true" %> 
<script>
 function print() {
  var mode = false;
  var close = 'popup';
  var extraCss = '';
 	var options = { mode : mode, popClose : close, extraCss : extraCss };
  $('#errorpage').printArea();
 }
</script>
		<div id="mainmenu">
			<div class="pagemargin"></div>
		</div>
		<div id="maincontent" class="pagemargin">
			<form id="errorpageform">
				<div id="errorpage">
					<div class="pagetitle">
						<fmt:message key="error.app.title" bundle="${bundle}" />
					</div>
					<div class="formrow" style="text-align:right;">
						<div class="formcell">
							<jsp:useBean id="now" class="java.util.Date"/>
							<fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" />
						</div>
					</div>
					<div class="formrow">
						<div class="formcell">
							<div id="listTitle" class="blocktitle"><fmt:message key="error.app.message" bundle="${bundle}" /></div>
							<div><c:out value="${requestScope['javax.servlet.error.status_code']}"/></div>
							<div><c:out value="${requestScope['javax.servlet.error.exception']}"/></div>
							<div><c:out value="${requestScope['javax.servlet.error.message']}"/></div>
						</div>
					</div>
				</div>
			</form>
			<div style="margin-top: 20px;">
				<div style="display: inline-block; width: 100%; text-align: right;">
					<button id="errorpageprint" name="errorpageprint" class="ui-button ui-widget ui-state-default ui-corner-all baseButton" onclick="print();return false;" type="button"><span class="ui-button-icon-left"></span><span class="ui-button-text"><fmt:message key="button.print" bundle="${bundle}" /></span></button>				
					<button id="errorpageback" name="errorpageback" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left baseButton" onclick="javascript:history.go(-1);;" type="button"><span class="ui-button-icon-left"></span><span class="ui-button-text"><fmt:message key="button.back" bundle="${bundle}" /></span></button>
				</div>
			</div>
		</div>
<%@ include file="/infra/StandardPageFooter.jsp"%>
  