package com.mycompany.controledenotas.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class LogonActionForm extends org.apache.struts.action.ActionForm {
  public static final long serialVersionUID = 1L;

  public LogonActionForm() {
  }

  public String username;
  public String password;
  public String language;

  /**
   * USERNAME: Method to get the field value.
   */
  public String getUsername() {
    return username;
  }

  /**
     * USERNAME: Method to set the field value.
     */
  public void setUsername(String PARAM) {
    username = PARAM;
  }

  /**
     * PASSWORD: Method to get the field value.
     */
  public String getPassword() {
    return password;
  }

  /**
     * PASSWORD: Method to set the field value.
     */
  public void setPassword(String PARAM) {
    password = PARAM;
  }

  /**
     * LANGUAGE: Method to get the field value.
     */
  public String getLanguage() {
    return language;
  }

  /**
     * LANGUAGE: Method to set the field value.
     */
  public void setLanguage(String PARAM) {
    language = PARAM;
  }

  /**
     * Reset all fields.
     */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    username = null;
    password = null;
    language = null;
  }

  /**
     * Validate fields and return errors.
     */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ActionErrors errors = new ActionErrors();
    return errors;
  }

  public String toString() {
    StringBuffer txt = new StringBuffer();
    if (username != null) {
      txt.append("&username=" + username);
    }
    if (password != null) {
      txt.append("&password=" + password);
    }
    if (language != null) {
      txt.append("&language=" + language);
    }
    return txt.toString();
  }
}
