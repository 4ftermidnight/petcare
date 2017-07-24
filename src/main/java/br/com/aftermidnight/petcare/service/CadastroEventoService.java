package br.com.aftermidnight.petcare.service;


import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aftermidnight.petcare.model.Evento;
import br.com.aftermidnight.petcare.repository.Eventos;
import br.com.aftermidnight.petcare.service.exception.ImpossivelExcluirEntidadeException;


@Service
public class CadastroEventoService {

	@Autowired
	private Eventos eventos;
	
	
	@Transactional
	public void salvar (Evento evento){
		eventos.save(evento);
	}


	@Transactional
	public void excluir(Evento evento){
		try {
			eventos.delete(evento.codigo);
			eventos.flush();
		} catch(PersistenceException e){
			throw new ImpossivelExcluirEntidadeException("Impossível excluir esta entidade. Está em uso, por exemplo.");
		}
	}
	
}
