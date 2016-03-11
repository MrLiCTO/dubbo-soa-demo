package com.nongyi.www.process.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;



public class ExceptionResolverCustom implements HandlerExceptionResolver {
	
	private static Logger logger = Logger.getLogger(ExceptionResolverCustom.class);  

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("message",ex.getMessage());
		
		mv.setViewName("/error");
		
		logger.error(ex.getMessage(),ex);
		
		return mv;
	}



	
}
