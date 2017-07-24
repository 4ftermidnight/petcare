package br.com.aftermidnight.petcare.repository;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aftermidnight.petcare.model.Permissao;


@Repository
public interface Permissoes extends Serializable, JpaRepository<Permissao, Long> {

}
