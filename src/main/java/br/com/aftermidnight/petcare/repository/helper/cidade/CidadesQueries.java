package br.com.aftermidnight.petcare.repository.helper.cidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.aftermidnight.petcare.model.Cidade;
import br.com.aftermidnight.petcare.repository.filter.CidadeFilter;


public interface CidadesQueries {

	public Page<Cidade> filtrar(CidadeFilter filtro, Pageable pageable);
	
	public Cidade buscarComEstado(Long codigo);
}
