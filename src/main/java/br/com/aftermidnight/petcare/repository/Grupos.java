package br.com.aftermidnight.petcare.repository;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aftermidnight.petcare.model.Grupo;


@Repository
public interface Grupos extends Serializable, JpaRepository<Grupo, Long> {

}
