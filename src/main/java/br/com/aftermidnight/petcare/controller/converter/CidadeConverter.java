package br.com.aftermidnight.petcare.controller.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.aftermidnight.petcare.model.Cidade;


public class CidadeConverter implements Converter<String, Cidade> {

	@Override
	public Cidade convert(String source) {
		Cidade cidade = new Cidade();
		
		if(StringUtils.isEmpty(source)) return null;
		
		cidade.setCodigo(Long.valueOf(source));
		return cidade;
	}



}
