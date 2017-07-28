package br.com.aftermidnight.petcare.config.init;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.aftermidnight.petcare.config.JPAConfig;
import br.com.aftermidnight.petcare.config.MailConfig;
import br.com.aftermidnight.petcare.config.ScheduleConfig;
import br.com.aftermidnight.petcare.config.SecurityConfig;
import br.com.aftermidnight.petcare.config.ServiceConfig;
import br.com.aftermidnight.petcare.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JPAConfig.class, ServiceConfig.class, SecurityConfig.class, /*S3Config.class,*/ ScheduleConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class, MailConfig.class };
	}

	@Override
	protected String[] getServletMappings() {//semelhante ao urlmapping do web.xml
		return new String[] { "/" };
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter characterEncodingFilter =  new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("UTF-8");
//		characterEncodingFilter.setForceEncoding(true);
		
		HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter(); //para utilizar o put nas requisições
		return new Filter[] { httpPutFormContentFilter };
				
	}
	
	
	//para configurar alguma coisa que nem lembro mais o que é
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
		
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("spring.profiles.default", "local");// definindo o profile default
		
		//para alterar setar no enviroment do servidor: spring.profiles.active , com valor = local
	}

}
