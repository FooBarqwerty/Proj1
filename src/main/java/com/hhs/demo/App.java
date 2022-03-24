package com.hhs.demo;

import com.hhs.demo.controller.AppCtrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	ApplicationContext applicationContext;

	App(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
		new App(applicationContext);
		applicationContext.getBean(AppCtrl.class).run();
	}
}