/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-03-09 03:06:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.shop.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.edu.springshop.domain.Category;
import java.util.List;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(8);
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/header.jsp", Long.valueOf(1677142587881L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/footer.jsp", Long.valueOf(1677141830158L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/search.jsp", Long.valueOf(1677140460992L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/header_section.jsp", Long.valueOf(1677457384391L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/insta.jsp", Long.valueOf(1677141769158L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/main_navi.jsp", Long.valueOf(1677142050999L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/preloader.jsp", Long.valueOf(1677140460988L));
    _jspx_dependants.put("/WEB-INF/views/shop/member/../inc/footer_link.jsp", Long.valueOf(1677141696196L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.edu.springshop.domain.Category");
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"Ashion Template\">\r\n");
      out.write("    <meta name=\"keywords\" content=\"Ashion, unica, creative, html\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>Ashion | Template</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Font -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Cookie&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap\"\r\n");
      out.write("    rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Css Styles -->\r\n");
      out.write("    <!-- href=\"/resources/ : 서버 매핑 주소 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/bootstrap.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/font-awesome.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/elegant-icons.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/jquery-ui.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/magnific-popup.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/owl.carousel.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/slicknav.min.css\" type=\"text/css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/shop/css/style.css\" type=\"text/css\">");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- Page Preloder -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write(" <div id=\"preloder\">\r\n");
      out.write("        <div class=\"loader\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Offcanvas Menu Begin -->\r\n");
      out.write("	<!-- \r\n");
      out.write("    	jsp 자체에서 지원하는 태그\r\n");
      out.write("    	왜 사용해야 하는지? 사실 jsp는 디자인 영역이므로 개발자만 사용하는 것이 아니라 퍼블리셔, 웹디자이너와 공유함\r\n");
      out.write("    	이때 JAVA에 대한 비전문가들은 java코드를 이해할 수 없기 때문에 그들이 좀 더 쉽게 다가갈 수 있도록 태그를 지원해줌 (협업)\r\n");
      out.write("     -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("  <div class=\"offcanvas-menu-overlay\"></div>\r\n");
      out.write("    <div class=\"offcanvas-menu-wrapper\">\r\n");
      out.write("        <div class=\"offcanvas__close\">+</div>\r\n");
      out.write("        <ul class=\"offcanvas__widget\">\r\n");
      out.write("            <li><span class=\"icon_search search-switch\"></span></li>\r\n");
      out.write("            <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\r\n");
      out.write("                <div class=\"tip\">2</div>\r\n");
      out.write("            </a></li>\r\n");
      out.write("            <li><a href=\"#\"><span class=\"/icon_bag_alt\"></span>\r\n");
      out.write("                <div class=\"tip\">2</div>\r\n");
      out.write("            </a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"offcanvas__logo\">\r\n");
      out.write("            <a href=\"./index.html\"><img src=\"/resources/shop/img/logo.png\" alt=\"\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"mobile-menu-wrap\"></div>\r\n");
      out.write("        <div class=\"offcanvas__auth\">\r\n");
      out.write("            <a href=\"#\">Login</a>\r\n");
      out.write("            <a href=\"#\">Register</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("	<!-- Offcanvas Menu End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Header Section Begin -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");

	//카테고리 목록 가져오기
	List<Category> categoryList=(List)request.getAttribute("categoryList");

      out.write("\r\n");
      out.write("\r\n");
      out.write(" <header class=\"header\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xl-3 col-lg-2\">\r\n");
      out.write("                    <div class=\"header__logo\">\r\n");
      out.write("                        <a href=\"/index.jsp\"><img src=\"/resources/shop/img/logo.png\" alt=\"\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-xl-6 col-lg-7\">\r\n");
      out.write("                    <nav class=\"header__menu\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li class=\"active\"><a href=\"/\">Home</a></li>\r\n");
      out.write("                            ");
for(int i=0;i<categoryList.size();i++){ 
      out.write("\r\n");
      out.write("                            ");
Category category=categoryList.get(i); 
      out.write("\r\n");
      out.write("                            <li><a href=\"#\">");
      out.print(category.getCategory_name());
      out.write("</a></li>\r\n");
      out.write("                            ");
} 
      out.write("\r\n");
      out.write("                            <li><a href=\"/shop/list\">Shop</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Pages</a>\r\n");
      out.write("                                <ul class=\"dropdown\">\r\n");
      out.write("                                    <li><a href=\"./product-details.html\">Product Details</a></li>\r\n");
      out.write("                                    <li><a href=\"./shop-cart.html\">Shop Cart</a></li>\r\n");
      out.write("                                    <li><a href=\"./checkout.html\">Checkout</a></li>\r\n");
      out.write("                                    <li><a href=\"./blog-details.html\">Blog Details</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3\">\r\n");
      out.write("                    <div class=\"header__right\">\r\n");
      out.write("                        <div class=\"header__right__auth\">\r\n");
      out.write("	                       	<a href=\"/member/loginform\">Login</a>\r\n");
      out.write("                            <a href=\"/member/joinform\">Register</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <ul class=\"header__right__widget\">\r\n");
      out.write("                            <li><span class=\"icon_search search-switch\"></span></li>\r\n");
      out.write("                            <li><a href=\"#\"><span class=\"icon_heart_alt\"></span>\r\n");
      out.write("                                <div class=\"tip\">2</div>\r\n");
      out.write("                            </a></li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                            <a href=\"/payment/cartList.jsp\"><span class=\"icon_bag_alt\"></span>\r\n");
      out.write("                                <div class=\"tip\">2</div></a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"canvas__open\">\r\n");
      out.write("                <i class=\"fa fa-bars\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("	<!-- Header Section End -->\r\n");
      out.write("\r\n");
      out.write("	<section>\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row m=5\">\r\n");
      out.write("				<div class=\"col\">\r\n");
      out.write("					<form id=\"form1\">\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<input type=\"text\" class=\"form-control\" placeholder=\"Enter message\" id=\"t_send\">\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<textarea type=\"text\" class=\"form-control\" id=\"t_receive\"></textarea>\r\n");
      out.write("						</div>\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-primary\" id=\"bt_send\">Send</button>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<!-- Instagram Begin -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<div class=\"instagram\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-1.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-2.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-3.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-4.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-5.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-4 col-sm-4 p-0\">\r\n");
      out.write("                <div class=\"instagram__item set-bg\" data-setbg=\"/resources/shop/img/instagram/insta-6.jpg\">\r\n");
      out.write("                    <div class=\"instagram__text\">\r\n");
      out.write("                        <i class=\"fa fa-instagram\"></i>\r\n");
      out.write("                        <a href=\"#\">@ ashion_shop</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- Instagram End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer Section Begin -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<footer class=\"footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-4 col-md-6 col-sm-7\">\r\n");
      out.write("                <div class=\"footer__about\">\r\n");
      out.write("                    <div class=\"footer__logo\">\r\n");
      out.write("                        <a href=\"./index.html\"><img src=\"/resources/shop/img/logo.png\" alt=\"\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt cilisis.</p>\r\n");
      out.write("                    <div class=\"footer__payment\">\r\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/shop/img/payment/payment-1.png\" alt=\"\"></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/shop/img/payment/payment-2.png\" alt=\"\"></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/shop/img/payment/payment-3.png\" alt=\"\"></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/shop/img/payment/payment-4.png\" alt=\"\"></a>\r\n");
      out.write("                        <a href=\"#\"><img src=\"/resources/shop/img/payment/payment-5.png\" alt=\"\"></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-5\">\r\n");
      out.write("                <div class=\"footer__widget\">\r\n");
      out.write("                    <h6>Quick links</h6>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">About</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Blogs</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Contact</a></li>\r\n");
      out.write("                        <li><a href=\"#\">FAQ</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-2 col-md-3 col-sm-4\">\r\n");
      out.write("                <div class=\"footer__widget\">\r\n");
      out.write("                    <h6>Account</h6>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">My Account</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Orders Tracking</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Checkout</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Wishlist</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-4 col-md-8 col-sm-8\">\r\n");
      out.write("                <div class=\"footer__newslatter\">\r\n");
      out.write("                    <h6>NEWSLETTER</h6>\r\n");
      out.write("                    <form action=\"#\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Email\">\r\n");
      out.write("                        <button type=\"submit\" class=\"site-btn\">Subscribe</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <div class=\"footer__social\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-youtube-play\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-12\">\r\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                <div class=\"footer__copyright__text\">\r\n");
      out.write("                    <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("	<!-- Footer Section End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Search Begin -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<div class=\"search-model\">\r\n");
      out.write("    <div class=\"h-100 d-flex align-items-center justify-content-center\">\r\n");
      out.write("        <div class=\"search-close-switch\">+</div>\r\n");
      out.write("        <form class=\"search-model-form\">\r\n");
      out.write("            <input type=\"text\" id=\"search-input\" placeholder=\"Search here.....\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("	<!-- Search End -->\r\n");
      out.write("\r\n");
      out.write("	<!-- Js Plugins -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<script src=\"/resources/shop/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/mixitup.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/jquery.countdown.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/jquery.slicknav.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/owl.carousel.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/shop/js/main.js\"></script>");
      out.write("\r\n");
      out.write("	<!-- 외부 라이브러리 사용 시 script를 밑에 작성함 -->\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		let ws;\r\n");
      out.write("		\r\n");
      out.write("		//웹소켓을 이용한 서버에 접속\r\n");
      out.write("		function connect(){\r\n");
      out.write("			ws=new WebSocket(\"ws://localhost:7777/chat\");\r\n");
      out.write("			\r\n");
      out.write("			//서버에 접속\r\n");
      out.write("			ws.onopen=function(){\r\n");
      out.write("				console.log(\"서버에 접속됨 onopen\");\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			//서버에 메세지가 도착하면\r\n");
      out.write("			ws.onmessage=function(e){\r\n");
      out.write("				console.log(\"서버가 보낸 데이터\", e.data);\r\n");
      out.write("				\r\n");
      out.write("				//서버가 보낸 메세지를 textrea에 누적\r\n");
      out.write("				$(\"#t_receive\").append(e.data+\"\\n\");\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			//서버와 접속이 끊기면\r\n");
      out.write("			ws.onclose=function(){\r\n");
      out.write("				console.log(\"서버와 접속 끊김\");\r\n");
      out.write("				//끊기는 시점을 발견할 때, 1초의 시간 뒤에 다시 재접속(재귀호출)하여 프로그램의 안정성을 높임 \r\n");
      out.write("				setTimeout(\"connect()\", 1000);  \r\n");
      out.write("			}\r\n");
      out.write("			ws.onerror=function(e){\r\n");
      out.write("				console.log(\"에러발생\" ,e);\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		//서버에 메세지 전송\r\n");
      out.write("		function sendMsg(){\r\n");
      out.write("			let msg=$(\"#t_send\").val();\r\n");
      out.write("			ws.send(msg);\r\n");
      out.write("			\r\n");
      out.write("			$(\"#t_send\").val(\"\");\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(function(){\r\n");
      out.write("			connect();\r\n");
      out.write("			\r\n");
      out.write("            $(\"#bt_send\").click(function(){\r\n");
      out.write("                sendMsg();\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("	</script>\r\n");
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
