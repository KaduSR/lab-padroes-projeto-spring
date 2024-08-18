package com.carlos.lab_padroes_projeto_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.lab_padroes_projeto_spring.model.Usuario;
import com.carlos.lab_padroes_projeto_spring.service.UsuarioService;

/**
 * Este {@link RestController} funciona como a nossa <b>Interface Central</b>, abstraindo
 * a complexidade das interações entre o banco de dados e a API externa (ViaCEP), 
 * fornecendo uma API REST clara e acessível.
 * 
 * @autor Carlos
 */
@RestController
@RequestMapping("usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.encontrarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {
        usuarioService.adicionar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        usuarioService.remover(id);
        return ResponseEntity.ok().build();
    }
}
