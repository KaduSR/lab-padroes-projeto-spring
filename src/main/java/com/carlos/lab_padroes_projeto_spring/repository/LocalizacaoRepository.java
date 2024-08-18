package com.carlos.lab_padroes_projeto_spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.lab_padroes_projeto_spring.model.Localizacao;

/**
 * Repositório para operações CRUD na entidade {@link Localizacao}.
 * 
 * @author Carlos
 */
@Repository
public interface LocalizacaoRepository extends CrudRepository<Localizacao, String> {

}
