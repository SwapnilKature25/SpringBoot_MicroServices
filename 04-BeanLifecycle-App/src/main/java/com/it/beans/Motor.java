package com.it.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Motor implements InitializingBean, DisposableBean
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
		System.out.println("motor started....");
	}

	public void doWork()
	{
		System.out.println("Motor Pulling the water...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("motor stopped..");
	}

	
	
	
//	public void stop()
//	{
//		System.out.println("Motor stopped.");
//	}
	
	
}
