package com.mycompany.controledenotas.system;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.aas.entities.Principal;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;

public class LogonAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_logon_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    LogonActionForm f = (LogonActionForm) form;
    try {
      /* Locale setup */
      String localeCombination = f.getLanguage();
      java.util.Locale locale = null;
      if (localeCombination != null && localeCombination.length() > 0) {
        String[] params = localeCombination.split("_");
        String language = null;
        String country = null;
        String variant = null;
        if (params != null) {
          if (params.length > 0) {
            language = params[0];
          }
          if (params.length > 1) {
            country = params[1];
          }
          if (params.length > 2) {
            variant = params[0];
          }
        }
        if (language != null && country != null && variant != null) {
          locale = new java.util.Locale(language, country, variant);
        } else if (language != null && country != null) {
          locale = new java.util.Locale(language, country);
        } else if (language != null) {
          locale = new java.util.Locale(language);
        }
        Locale.setDefault(locale);
        session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
      }
      /* Logon Process */
      session.removeAttribute(com.egen.util.aas.Constants.SUBJECT_SESSION_KEY);
      String authSchema = com.egen.util.aas.Constants.DEFAULT_AUTH_SCHEMA;
      if (authSchema != null && authSchema.length() > 0) {
        javax.security.auth.login.LoginContext lc = new javax.security.auth.login.LoginContext(authSchema, new com.egen.util.aas.CallbackHandler(f.getUsername(), f.getPassword()));
        lc.login();
        javax.security.auth.Subject subject = lc.getSubject();
        /* If login succeed */
        if (subject != null) {
          session.setAttribute(com.egen.util.aas.Constants.SUBJECT_SESSION_KEY, subject);
          /* Redirect page after Logon */
          String request_note = (String) session.getAttribute(com.egen.util.aas.Constants.FORM_REQUEST_NOTE);
          if (request_note != null) {
            session.removeAttribute(com.egen.util.aas.Constants.FORM_REQUEST_NOTE);
            /* Authorization */
            String request_authorization = request_note.substring(0, request_note.indexOf("?") != -1 ? request_note.indexOf("?") : request_note.length());
            java.security.Permission perm = com.egen.util.aas.PermissionFactory.getInstance().getPermission(request_authorization);
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
            try {
              if (!com.egen.util.aas.Utils.permitted(subject, perm)) {
                request.setAttribute("javax.servlet.error.status_code", "404");
                request.setAttribute("javax.servlet.error.message", bundle.getString("warn.actiondenied") + " " + request_authorization);
                request.setAttribute("javax.servlet.error.servlet_name", request_authorization);
                return mapping.findForward("error");
              }
            } catch (Exception e) {
              request.setAttribute("javax.servlet.error.status_code", "404");
              request.setAttribute("javax.servlet.error.message", bundle.getString("warn.actiondenied") + " " + request_authorization);
              request.setAttribute("javax.servlet.error.servlet_name", request_authorization);
              request.setAttribute("javax.servlet.error.exception_type", e.getClass().getName());
              return mapping.findForward("error");
            }
            return new ActionForward(request_note);
          }
        }
      } else {
        Set < com.egen.util.aas.entities.Principal > principals = new HashSet < com.egen.util.aas.entities.Principal > ();
        principals.add(new com.egen.util.aas.entities.Principal(f.getUsername(), com.egen.util.aas.entities.Principal.USERNAME));
        principals.add(new com.egen.util.aas.entities.Principal("master", com.egen.util.aas.entities.Principal.GROUP));
        principals.add(new com.egen.util.aas.entities.Principal("manager", com.egen.util.aas.entities.Principal.GROUP));
        principals.add(new com.egen.util.aas.entities.Principal("user", com.egen.util.aas.entities.Principal.GROUP));
        principals.add(new com.egen.util.aas.entities.Principal("developer", com.egen.util.aas.entities.Principal.GROUP));
        principals.add(new com.egen.util.aas.entities.Principal("admin", com.egen.util.aas.entities.Principal.GROUP));
        Set<Principal> credentials = new HashSet<Principal>();
        Set<Object> privCredentials = new HashSet<Object>();
        javax.security.auth.Subject subject = new javax.security.auth.Subject(false, principals, credentials, privCredentials);
        session.setAttribute(com.egen.util.aas.Constants.SUBJECT_SESSION_KEY, subject);
        /* Redirect page after Logon */
        String request_note = (String) session.getAttribute(com.egen.util.aas.Constants.FORM_REQUEST_NOTE);
        if (request_note != null) {
          session.removeAttribute(com.egen.util.aas.Constants.FORM_REQUEST_NOTE);
          return new ActionForward(request_note);
        }
      }
      actionForward = mapping.findForward("menu");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_logout_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute(com.egen.util.aas.Constants.SUBJECT_SESSION_KEY);
      session.invalidate();
      session = request.getSession(true);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    try {
      form.reset(mapping, request);
      request.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
