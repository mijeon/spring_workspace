package com.edu.hibernateapp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	private static HibernateConfig instance;
	private SessionFactory sessionFactory;
	String resource="com/edu/hibernateapp/hibernate/hibernate.cfg.xml";
	
	private HibernateConfig() {
		//설정 xml 읽기
		Configuration config=new Configuration().configure(resource);  //config 객체 생성
		StandardServiceRegistryBuilder sb=new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties());  //(설정맵)  //xml 설정을 ServiceRegistry가 인식함
		
		StandardServiceRegistry registry=sb.build();
		sessionFactory=config.buildSessionFactory(registry);
		
	}
	
	public static HibernateConfig getInstance() {
		if(instance==null) {
			instance=new HibernateConfig();
		}
		return instance;
	}
	
	//sessionFactory 얻기
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//sessionFactory 반납
	public void release(SessionFactory sessionFactory) {
		sessionFactory.close();
	}
}
