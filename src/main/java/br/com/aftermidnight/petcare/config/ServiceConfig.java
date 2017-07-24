package br.com.aftermidnight.petcare.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.aftermidnight.petcare.service.CadastroClienteService;


@Configuration
@ComponentScan(basePackageClasses = { CadastroClienteService.class  })
public class ServiceConfig {

	
}
