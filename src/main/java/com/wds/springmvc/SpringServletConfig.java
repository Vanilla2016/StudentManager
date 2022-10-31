package com.wds.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@ComponentScan("com.wds.springmvc")
//@EnableWebMvc
public class SpringServletConfig {
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver vs = new InternalResourceViewResolver();
		vs.setPrefix("/WEB-INF/views");
		return vs;
	}

}
