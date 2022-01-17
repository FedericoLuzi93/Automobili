package it.luzi.automobili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

public class AutomobiliApplication extends SpringBootServletInitializer
{
//	@Bean
//	public ModelMapper modelMapper()
//	{
//		return new ModelMapper();
//	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(AutomobiliApplication.class);
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(AutomobiliApplication.class, args);
	}

}
