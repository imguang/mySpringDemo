/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.10.v20160621
 * Generated at: 2016-09-12 07:57:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegisterAndLoginView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<title>登录注册</title>\r\n");
      out.write("<!--用百度的静态资源库的cdn安装bootstrap环境-->\r\n");
      out.write("<!-- Bootstrap 核心 CSS 文件 -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!--font-awesome 核心我CSS 文件-->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!-- 在bootstrap.min.js 之前引入 -->\r\n");
      out.write("<script src=\"http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 核心 JavaScript 文件 -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!--jquery.validate-->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.validate.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/sha1.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tbackground: url(");
      out.print(path);
      out.write("/resources/img/4.jpg) no-repeat;\r\n");
      out.write("\tbackground-size: <span style=\"font-family: 微软雅黑; background-color: rgb(239, 239, 239);\">cover</span>;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form {\r\n");
      out.write("\tbackground: rgba(255, 255, 255, 0.2);\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\tmargin: 100px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#div1 {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#div2 {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".fa {\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttop: 27px;\r\n");
      out.write("\tleft: 6px;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tcolor: #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"], input[type=\"password\"] {\r\n");
      out.write("\tpadding-left: 26px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".checkbox {\r\n");
      out.write("\tpadding-left: 21px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"myModal\" role=\"dialog\"\r\n");
      out.write("\t\t\taria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\" id=\"show_content\">这里是弹窗的内容</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form row\" id=\"div1\">\r\n");
      out.write("\t\t\t<form class=\"form-horizontal col-sm-offset-3 col-md-offset-3\"\r\n");
      out.write("\t\t\t\tid=\"login_form\">\r\n");
      out.write("\t\t\t\t<h3 class=\"form-title\">Login to your account</h3>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-9 col-md-9\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-user fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control required\" type=\"text\" placeholder=\"Username\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"userName\" autofocus=\"autofocus\" maxlength=\"20\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"loginUserName\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-lock fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control required\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Password\" name=\"password\" maxlength=\"8\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"loginPassword\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"checkbox\"> <input type=\"checkbox\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"remember\" value=\"1\" /> Remember me\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" id=\"register_btn\" class=\"\">Create an\r\n");
      out.write("\t\t\t\t\t\t\taccount</a> <input type=\"submit\" class=\"btn btn-success pull-right\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"Login \" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form row\" id=\"div2\">\r\n");
      out.write("\t\t\t<form class=\"form-horizontal col-sm-offset-3 col-md-offset-3\"\r\n");
      out.write("\t\t\t\tid=\"register_form\" method=\"post\" action=\"/count/register\">\r\n");
      out.write("\t\t\t\t<h3 class=\"form-title\">Regist an account</h3>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-9 col-md-9\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-user fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control required\" type=\"text\" placeholder=\"Username\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"userName\" autofocus=\"autofocus\" id=\"registUserName\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-lock fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control required\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Password\" name=\"password\" id=\"registPassword\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-check fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control required\" type=\"password\" name=\"rePassword\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Re-type Your Password\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-envelope fa-lg\"></i> <input\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form-control eamil\" type=\"text\" placeholder=\"Email\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"email\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"form-control required\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"验证码\" name=\"code\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group-addon\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img id=\"kaptchaImage\" src=\"/count/img\" onclick=\"changeCode()\" />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" onclick=\"changeCode()\">看不清楚？换一张！</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" id=\"back_btn\" class=\"pull-left\">Back</a> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"submit\" class=\"btn btn-success pull-right\" value=\"Sign Up \" />\r\n");
      out.write("\t\t\t\t\t\t<!--<input type=\"submit\" class=\"btn btn-info pull-left\" id=\"back_btn\" value=\"Back\" />-->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}