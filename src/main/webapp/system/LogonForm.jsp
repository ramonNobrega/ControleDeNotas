<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/infra/PublicPageHeader.jsp"%>
<html:form action="system/LogonForm.do" method="post" styleClass="baseForm" target="_self">
  <table  class="bannerFormTable" style="width:80%;">
    <tr  class="bannerFormTr">
      <td  class="bannerFormTd">
        <bean:message bundle="ApplicationResources" key="login.title"/>

      </td>
    </tr>
  </table>
  <table  class="messageTable" style="width:100%;">
    <td  class="messageTd">
      <html:errors/>
    </td>
  </tr>
</table>
<table  class="itemTable" style='width:80%;'>
  <tr  class="itemTableTr">
    <td  class="itemTableTd">
      <table class="itemTable"  style="width:100%;">
        <tr  class="itemTr">
          <td  class="formLabel">
            <span  class="spamFormLabel" >
              <bean:message bundle="ApplicationResources" key="login.username"/>
            </span>
          </td>
          <td  class="formField">
            <html:text property="username" styleClass="baseField" size="30"/>
          </td>
        </tr>
        <tr  class="itemTr">
          <td  class="formLabel">
            <span  class="spamFormLabel" >
              <bean:message bundle="ApplicationResources" key="login.password"/>
            </span>
          </td>
          <td  class="formField">
            <html:password property="password" styleClass="baseField" size="30"/>
          </td>
        </tr>
        <html:hidden property="language"/>
      </table>
    </td>
    <td  class="itemTableTd">
      <table  class="buttonTableRight">
        <tr  class="buttonItemTrSIZE">
          <td  class="buttonItemTdSIZE">
            <html:submit styleId="logon_action" styleClass="baseButton">
              <bean:message bundle="ApplicationResources" key="login.login"/>
            </html:submit>
          </td>
        </tr>
        <tr  class="buttonItemTrSIZE">
          <td  class="buttonItemTdSIZE">
            <html:submit styleId="logout_action" styleClass="baseButton">
              <bean:message bundle="ApplicationResources" key="login.logout"/>
            </html:submit>
          </td>
        </tr>
        <tr  class="buttonItemTrSIZE">
          <td  class="buttonItemTdSIZE">
            <html:submit accesskey="l" styleId="resetfull_action" styleClass="baseButton">
              <bean:message bundle="ApplicationResources" key="jsp.reset"/>
            </html:submit>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</html:form>
<script type="text/javascript">
  var focusControl = document.forms[0].elements["username"];
  if (focusControl.type != "hidden"){
    focusControl.focus();
  }
</script>


<%@ include file="/infra/StandardPageFooter.jsp"%>
