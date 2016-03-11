package com.nongyi.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ServiceStart {
	
		
		private static final Log log = LogFactory.getLog(ServiceStart.class);
		
		public static void main(String[] args) {
			try {
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				context.start();
			} catch (Exception e) {
				log.error("== ServiceStart context start error:",e);
			}
			synchronized (ServiceStart.class) {
				while (true) {
					try {
						ServiceStart.class.wait();
					} catch (InterruptedException e) {
						log.error("== synchronized error:",e);
					}
				}
			}
		}
	
}
