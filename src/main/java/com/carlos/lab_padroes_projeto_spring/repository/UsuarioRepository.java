package com.carlos.lab_padroes_projeto_spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.lab_padroes_projeto_spring.model.Usuario;

/**
 * Repositório para operações CRUD na entidade {@link Usuario}.
 * 
 * @author Carlos
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
