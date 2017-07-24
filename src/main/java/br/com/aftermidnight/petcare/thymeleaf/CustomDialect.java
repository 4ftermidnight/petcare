package br.com.aftermidnight.petcare.thymeleaf;


import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.aftermidnight.petcare.thymeleaf.processor.ActiveMenuForAttributeTagProcessor;
import br.com.aftermidnight.petcare.thymeleaf.processor.CabecalhoOrdenavelElementTagProcessor;
import br.com.aftermidnight.petcare.thymeleaf.processor.ClassErrorForAttributeTagProcessor;
import br.com.aftermidnight.petcare.thymeleaf.processor.MessageElementTagProcessor;
import br.com.aftermidnight.petcare.thymeleaf.processor.PaginacaoElementTagProcessor;


public class CustomDialect extends AbstractProcessorDialect {

	public CustomDialect() {
		super("AfterMidnight Custom", "am", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassErrorForAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new CabecalhoOrdenavelElementTagProcessor(dialectPrefix));
		processadores.add(new PaginacaoElementTagProcessor(dialectPrefix));
		processadores.add(new ActiveMenuForAttributeTagProcessor(dialectPrefix));
		
		return processadores;
	}

}
