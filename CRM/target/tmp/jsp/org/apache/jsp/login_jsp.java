package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>oracleoaec客户关系管理系统</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "uiImport.jsp", out, false);
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div data-options=\"region:'north',border:false\" style=\"height:80px;background:#FFFFFF;padding:10px\">\r\n");
      out.write("\t\t<div align=\"center\"  style=\"padding-top: 10px\">\r\n");
      out.write("\t\t\t<img src=\"images/oracle.png\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div data-options=\"region:'south',border:false\"\r\n");
      out.write("\t\tstyle=\"height:50px;background:#FFFFFF;padding:10px;\">\r\n");
      out.write("\t\t<div align=\"center\" style=\"margin-top: 10px\">\r\n");
      out.write("\t\t\t&copy;<a href=\"http://www.oracleoaec.net/\">2016 上海海文信息技术有限公司</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div data-options=\"region:'center'\" style=\"background-image:url('images/backgroud.png');padding-top: 10%\">\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t<div class=\"easyui-panel\" style=\"width:100%;max-width:600px;\">\r\n");
      out.write("\t\t\t\t<div style=\"float: left;margin-left: 40px;margin-top:30px;margin-bottom: 30px\">\r\n");
      out.write("\t\t\t\t\t<img src=\"images/logo.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"float: left;margin: 40px 10px;padding-left: 40px;\">\r\n");
      out.write("\t\t\t\t\t<h2 align=\"center\">用户登陆</h2>\r\n");
      out.write("\t\t\t\t\t<form id=\"ff\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"username\" class=\"label-top\">用户名:</label> <input id=\"username\" style=\"width: 180px\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-options=\"required:true,iconCls:'icon-man',iconWidth:38,prompt:'用户名...',validType:'email',validateOnCreate:false,validateOnBlur:true,invalidMessage:'请输入有效用户名',invalidMessage:'用户名无效!'\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"pass\" class=\"label-top\">密&nbsp;码:</label> <input id=\"pass\" name=\"pass\" style=\"width: 180px\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"easyui-textbox\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdata-options=\"required:true,iconCls:'icon-lock',iconWidth:38,validType:'length[6,16]',validateOnCreate:false,validateOnBlur:true\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:$('#forgot-dlg').dialog('open')\">忘记密码?</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t<div style=\"text-align:center;padding:5px 35px\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"login()\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width:80px\">登陆</a> <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"javascript:$('#ff').form('resetValidation').form('reset')\" style=\"width:80px\">重置</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"forgot-dlg\" class=\"easyui-dialog\" style=\"width:400px\" closed=\"true\" title=\"忘记密码\"\r\n");
      out.write("\t\tbuttons=\"#forgot-dlg-buttons\" closable=\"false\">\r\n");
      out.write("\t\t<form id=\"forgot-ff\" method=\"post\" style=\"margin-left: 20px\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<label for=\"username\" class=\"label-top\">用户名:</label> <input class=\"easyui-validatebox\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"missingMessage:'请输入用户名!',tipPosition:'bottom',required:true,validateOnCreate:false,validateOnBlur:true,validType:['email','length[4,20]']\"\r\n");
      out.write("\t\t\t\t\t\tinvalidMessage=\"用户名无效!请重新输入!\"  id=\"username\"\r\n");
      out.write("\t\t\t\t\t\tname=\"username\" style=\"width: 200px\" />\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<label for=\"phoneNo\" class=\"label-top\">手机号:</label> <input class=\"easyui-validatebox\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"missingMessage:'请输入手机号!',tipPosition:'bottom',required:true,validateOnCreate:false,validateOnBlur:true,validType:'mobile'\"\r\n");
      out.write("\t\t\t\t\t\tid=\"phoneNo\" name=\"phoneNo\" style=\"width: 200px\" />\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"forgot-dlg-buttons\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\" onclick=\"reqResetPass()\"\r\n");
      out.write("\t\t\tstyle=\"width:90px\">确认</a> <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\ticonCls=\"icon-cancel\"\r\n");
      out.write("\t\t\tonclick=\"javascript:$('#forgot-ff').form('resetValidation').form('reset');$('#forgot-dlg').dialog('close');\"\r\n");
      out.write("\t\t\tstyle=\"width:90px\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction login(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar pwd=$(\"#pass\").val();\r\n");
      out.write("\t\t\t//pwd=hex_sha1(pwd);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t$.post('login.do',{username:$('#username').val(),pass:pwd},function(data){\r\n");
      out.write("\t\t\t//alert(data);\r\n");
      out.write("\t\t\tif(data==\"1\"){\r\n");
      out.write("\t\t\t\twindow.location.href=\"main.jsp\";\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$.messager.alert('error','用户名和密码不匹配请确认!','error');\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction reqResetPass(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#forgot-ff').form('submit', {\r\n");
      out.write("\t\t\turl : \"reqResetPass.do\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tif (data == 1) {\r\n");
      out.write("\t\t\t\t\t//重置验证\r\n");
      out.write("\t\t\t\t\t$('#forgot-ff').form('resetValidation');\r\n");
      out.write("\t\t\t\t\t//表单重置\r\n");
      out.write("\t\t\t\t\t$('#forgot-ff').form('reset');\r\n");
      out.write("\t\t\t\t\t//关闭对话框\r\n");
      out.write("\t\t\t\t\t$('#forgot-dlg').dialog('close')\r\n");
      out.write("\t\t\t\t\t$.messager.alert('OK', '重置密码请求已发出,请等待管理员处理!', 'info');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
