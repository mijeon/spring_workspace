package com.edu.db.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*	Listener는 application 내장객체를 만나게 해주는 시점을 결정해줌
 	ApplicationContext (스프링 컨테이너)
 	ServletContext (어플리케이션 내장객체의 자료형)
 	ServletConfig (init()의 매개변수로써 초기화 파라미터인 init-param 값을 가지고 있거나,
 	ServletContext를 얻어올 때 사용되는 환경정보 객체) */
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Application 내장객체 얻기
		ServletContext application=sce.getServletContext();
		//리스너의 실제경로를 가져와야 하므로 web.xml에 등록해야함
		String savePath=sce.getServletContext().getInitParameter("savePath");
		savePath=application.getRealPath(savePath);  //경로 덮어쓰기
		application.setAttribute("savePath", savePath);  
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
