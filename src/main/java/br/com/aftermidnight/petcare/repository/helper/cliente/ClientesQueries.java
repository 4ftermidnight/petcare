package br.com.aftermidnight.petcare.repository.helper.cliente;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.aftermidnight.petcare.model.Cliente;
import br.com.aftermidnight.petcare.repository.filter.ClienteFilter;


public interface ClientesQueries {
	
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable);
	
	public Cliente buscarComCidadeEstado(Long codigo);
}

