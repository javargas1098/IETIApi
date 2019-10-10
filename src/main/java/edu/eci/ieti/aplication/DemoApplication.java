package edu.eci.ieti.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.ieti.aplication.config.JwtFilter;

@SpringBootApplication
public class DemoApplication {
	@Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );

        return registrationBean;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}