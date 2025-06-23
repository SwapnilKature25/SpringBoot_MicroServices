package com.it.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// predefined interfaces provided by Spring Framework : InitializingBean, DisposableBean
public class Motor implements InitializingBean, DisposableBean
//public class Motor 
{
	public Motor() {
		System.out.println("Motor.Motor() :: constructor");
	}
	
//	public void start()
//	{
//		System.out.println("Motor starting...");
//	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Programmatic approach : motor started....");
	}
	
	@PostConstruct
	public void m1() throws Exception {
		System.out.println("Annotation : motor started.....");
	}

	public void doWork()
	{
		System.out.println("Motor Pulling the water...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Programmatic approach : motor stopped..");
	}

	@PreDestroy
	public void m2() throws Exception {
		System.out.println("Annotation : motor stopped.....");
	}
	
	
	
//	public void stop()
//	{
//		System.out.println("Motor stopped.");
//	}
	
	
}
