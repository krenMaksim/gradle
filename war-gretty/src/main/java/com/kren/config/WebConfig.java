package com.kren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//@ComponentScan(basePackages = { "com.mycompany.myproject.web.controller" }) где лежат контрллеры

import com.kren.controller.TestController;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = TestController.class)
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	// ПОЧЕМУ НАМ НЕ ВАЖНО КАК ЭТОТ БИН БУДЕТ НАЗЫВАТЬСЯ
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/pages/");
		bean.setSuffix(".jsp");
		bean.setViewClass(JstlView.class);
		return bean;
	}

	// для понимания что @Controller это мы создаем обычные бины
	// @Bean
	// public TestController testController() {
	// return new TestController();
	// }

}
