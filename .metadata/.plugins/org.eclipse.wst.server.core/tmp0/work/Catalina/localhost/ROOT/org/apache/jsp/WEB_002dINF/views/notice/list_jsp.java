/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-02-20 05:58:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.edu.springboard.domain.ReBoard;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.edu.springboard.domain.ReBoard");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("<!-- jQuery library -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("<!-- Popper JS -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<!-- Latest compiled JavaScript -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<!-- View : https://v2.vuejs.org/v2/guide/#Getting-Started -->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	let app1;\r\n");
      out.write("	\r\n");
      out.write("	const row={\r\n");
      out.write("		template :`\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>1</td>\r\n");
      out.write("				<td @click=\"getDetail(obj.notice_idx)\"><a href=\"#\">{{obj.title}}</a></td>\r\n");
      out.write("				<td>{{obj.writer}}</td>\r\n");
      out.write("				<td>{{obj.regdate}}</td>\r\n");
      out.write("				<td>{{obj.hit}}</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		`,\r\n");
      out.write("		props:['notice'],\r\n");
      out.write("		data(){\r\n");
      out.write("			//모든 레코드 마다 값을 따로 할당함\r\n");
      out.write("			return {\r\n");
      out.write("				//반환할 데이터\r\n");
      out.write("				obj:this.notice\r\n");
      out.write("			};\r\n");
      out.write("		},\r\n");
      out.write("		methods:{\r\n");
      out.write("			getDetail:function(notice_idx){\r\n");
      out.write("				//alert(notice_idx);\r\n");
      out.write("				location.href=\"/notice/detail?notice_idx=\"+notice_idx;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	};\r\n");
      out.write("	\r\n");
      out.write("	function init(){\r\n");
      out.write("		app1=new Vue({\r\n");
      out.write("			el:\"#app1\",\r\n");
      out.write("			components:{\r\n");
      out.write("				row\r\n");
      out.write("			},\r\n");
      out.write("			data:{\r\n");
      out.write("				noticeList:[]\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	//목록 가져오기\r\n");
      out.write("	function getList(){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url:\"/rest/notices\",\r\n");
      out.write("			type:\"get\",\r\n");
      out.write("			success:function(result, status, xhr){\r\n");
      out.write("				console.log(\"서버에서 전송된 결과 : \", result);\r\n");
      out.write("				app1.noticeList=result;\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	$(function(){\r\n");
      out.write("		init();\r\n");
      out.write("		getList();\r\n");
      out.write("		\r\n");
      out.write("		$(\"#bt_regist\").click(function(){\r\n");
      out.write("			//get 방식\r\n");
      out.write("			location.href=\"/notice/registform\";\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container mt-3\" id=\"app1\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col\">\r\n");
      out.write("				<table class=\"table table-hover\">\r\n");
      out.write("					<thead>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<th>No</th>\r\n");
      out.write("							<th>제목</th>\r\n");
      out.write("							<th>작성자</th>\r\n");
      out.write("							<th>등록일</th>\r\n");
      out.write("							<th>조회수</th>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</thead>\r\n");
      out.write("					<tbody>\r\n");
      out.write("						<template v-for=\"notice in noticeList\">\r\n");
      out.write("							<row :key=\"notice.notice_idx\" :notice=\"notice\"/>\r\n");
      out.write("						</template>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td colspan=\"5\">\r\n");
      out.write("								<button type=\"button\" class=\"btn btn-outline-warning\" id=\"bt_regist\">글등록</button>\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</tbody>\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
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
