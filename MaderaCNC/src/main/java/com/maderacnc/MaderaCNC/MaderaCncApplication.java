package com.maderacnc.MaderaCNC;

import com.maderacnc.MaderaCNC.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class MaderaCncApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaderaCncApplication.class, args);
	} // main
	
	
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
	    registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/pro");
		registrationBean.addUrlPatterns("/api/users/*");
        return registrationBean;
}

} // class MaderaCncApplication