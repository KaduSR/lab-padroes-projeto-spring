package com.carlos.lab_padroes_projeto_spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.lab_padroes_projeto_spring.model.Localizacao;
import com.carlos.lab_padroes_projeto_spring.model.Usuario;
import com.carlos.lab_padroes_projeto_spring.repository.LocalizacaoRepository;
import com.carlos.lab_padroes_projeto_spring.repository.UsuarioRepository;
import com.carlos.lab_padroes_projeto_spring.service.UsuarioService;
import com.carlos.lab_padroes_projeto_spring.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link UsuarioService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author Carlos
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Usuario> listarTodos() {
		// Buscar todos os Usuários.
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario encontrarPorId(Long id) {
		// Buscar Usuário por ID.
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	@Override
	public void adicionar(Usuario usuario) {
		salvarUsuarioComCep(usuario);
	}

	@Override
	public void atualizar(Long id, Usuario usuario) {
		// Buscar Usuário por ID, caso exista:
		Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
		if (usuarioBd.isPresent()) {
			salvarUsuarioComCep(usuario);
		}
	}

	@Override
	public void remover(Long id) {
		// Remover Usuário por ID.
		usuarioRepository.deleteById(id);
	}

	private void salvarUsuarioComCep(Usuario usuario) {
		// Verificar se a Localizacao do Usuário já existe (pelo CEP).
		String cep = usuario.getLocalizacao().getCep();
		Localizacao localizacao = localizacaoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Localizacao novaLocalizacao = viaCepService.consultarCep(cep);
			localizacaoRepository.save(novaLocalizacao);
			return novaLocalizacao;
		});
		usuario.setLocalizacao(localizacao);
		// Inserir Usuário, vinculando a Localizacao (nova ou existente).
		usuarioRepository.save(usuario);
	}

}
