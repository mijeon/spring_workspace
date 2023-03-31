package com.edu.mvc3.listener.MyListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//서버의 중단 및 가동을 잡아내는 메서드
public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		String dataPath=application.getInitParameter("dataPath");
		String path=application.getRealPath(dataPath);
		application.setAttribute("dataPath", path);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
