package br.com.aftermidnight.petcare.repository.helper.cliente;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.aftermidnight.petcare.model.Cliente;
import br.com.aftermidnight.petcare.model.TipoPessoa;
import br.com.aftermidnight.petcare.repository.filter.ClienteFilter;
import br.com.aftermidnight.petcare.repository.paginacao.PaginacaoUtil;


public class ClientesImpl implements ClientesQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> filtrar(ClienteFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		
		//para evitar problemas do lazy load deve-se inicializar o endereco.cidade.estado
		criteria.createAlias("endereco.cidade", "c", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("c.estado", "e", JoinType.LEFT_OUTER_JOIN);

		//para testar
		List<Cliente> l = new ArrayList<Cliente>();
		l.add(new Cliente(1L, "C1", TipoPessoa.FISICA));
		l.add(new Cliente(2L, "C2", TipoPessoa.FISICA));
		l.add(new Cliente(3L, "C3", TipoPessoa.FISICA));
		l.add(new Cliente(4L, "C4", TipoPessoa.FISICA));
		l.add(new Cliente(5L, "C5", TipoPessoa.FISICA));
		return new PageImpl<>(l, pageable, 5);
		
		//return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}

	private Long total(ClienteFilter filtro){
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		criteria.setProjection(Projections.rowCount());
		adicionarFiltro(filtro, criteria);
		return (Long)criteria.uniqueResult();
	}

	private void adicionarFiltro(ClienteFilter filtro, Criteria criteria) {
		if(filtro != null){
			
			if(!StringUtils.isEmpty(filtro.getNome())){
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if(!StringUtils.isEmpty(filtro.getCpfOuCnpj())){
				criteria.add(Restrictions.ilike("cpfOuCnpj", filtro.getCpfOuCnpj(), MatchMode.ANYWHERE));
			}

		}
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarComCidadeEstado(Long codigo) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		criteria.createAlias("endereco.cidade", "c", JoinType.LEFT_OUTER_JOIN)
			.createAlias("c.estado", "e", JoinType.LEFT_OUTER_JOIN)
			.add(Restrictions.eq("codigo", codigo))
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return (Cliente) criteria.uniqueResult();
	}


}
