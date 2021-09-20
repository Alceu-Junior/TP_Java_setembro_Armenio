package br.edu.infnet.VenturaUsuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.VenturaUsuario.model.domain.Endereco;
import br.edu.infnet.VenturaUsuario.model.domain.Usuario;
import br.edu.infnet.VenturaUsuario.model.service.EnderecoService;
import br.edu.infnet.VenturaUsuario.model.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	EnderecoService enderecoService;

	@PostMapping(value ="/logar")
	public ResponseEntity logar(@RequestBody Usuario usuario) {
		ResponseEntity<?> retorno = ResponseEntity.noContent().build();
		
		usuario = usuarioService.validar(usuario.getEmail(), usuario.getSenha());
		if (usuario != null) {
			retorno = ResponseEntity.ok().body(usuario);
		}
		return retorno;
	}
	
	 @PostMapping(value ="/criar")
	    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
	        ResponseEntity response = ResponseEntity.badRequest().build();
	        
	        if (usuario != null && usuario.getId() == null) {
	            try {
	            	Endereco endereco = enderecoService.obterPorCep(usuario.getCep());
	            	usuario.setEndereco(endereco.getLogradouro());
	            } catch (Exception e) {
	            	System.out.println(e);
	            }
	            usuarioService.incluir(usuario);
	            ResponseEntity<?> retorno = ResponseEntity.ok().body(usuario);
				return retorno;

	        }
	        return response;
	    }
}
	 