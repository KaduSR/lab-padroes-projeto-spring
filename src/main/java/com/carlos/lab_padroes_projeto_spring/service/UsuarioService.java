package com.carlos.lab_padroes_projeto_spring.service;

import com.carlos.lab_padroes_projeto_spring.model.Usuario;

/**
 * Interface que define o padrão <b>Strategy</b> para o domínio de Usuario. 
 * Permite a implementação de diversas estratégias para a gestão de Usuarios.
 * 
 * @author Carlos
 */
public interface UsuarioService {

    /**
     * Recupera todos os Usuarios cadastrados.
     * 
     * @return Iterable contendo todos os Usuarios.
     */
    Iterable<Usuario> listarTodos();

    /**
     * Recupera um Usuario pelo seu identificador.
     * 
     * @param id Identificador único do Usuario.
     * @return Usuario correspondente ao identificador.
     */
    Usuario encontrarPorId(Long id);

    /**
     * Adiciona um novo Usuario ao sistema.
     * 
     * @param Usuario Objeto contendo os dados do Usuario a ser adicionado.
     */
    void adicionar(Usuario Usuario);

    /**
     * Atualiza os dados de um Usuario existente.
     * 
     * @param id Identificador único do Usuario a ser atualizado.
     * @param Usuario Objeto contendo os novos dados do Usuario.
     */
    void atualizar(Long id, Usuario Usuario);

    /**
     * Remove um Usuario do sistema pelo seu identificador.
     * 
     * @param id Identificador único do Usuario a ser removido.
     */
    void remover(Long id);

}
