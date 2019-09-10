package com.luv2code.springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//everything here and in DemoAppConfig is only to make the java configuration Spring 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DemoAppConfig.class };//we only add { DemoAppConfig.class } for the class we just made before this one
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}






