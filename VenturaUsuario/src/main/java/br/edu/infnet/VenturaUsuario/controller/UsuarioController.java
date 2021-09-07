package br.edu.infnet.VenturaUsuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.VenturaUsuario.model.domain.Usuario;
import br.edu.infnet.VenturaUsuario.model.service.UsuarioService;

@RestController
@RequestMapping(path = {"/usuario"})
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value ="/")
	public ResponseEntity logar(Usuario usuario) {
		
		usuario = usuarioService.validar(usuario.getEmail(), usuario.getSenha());
		
		ResponseEntity retorno = ResponseEntity.ok().body(usuario);
		
		return retorno;
	}
}