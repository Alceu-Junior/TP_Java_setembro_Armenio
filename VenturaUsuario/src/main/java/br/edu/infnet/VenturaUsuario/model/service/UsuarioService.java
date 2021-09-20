package br.edu.infnet.VenturaUsuario.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.VenturaUsuario.model.domain.Usuario;
import br.edu.infnet.VenturaUsuario.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario validar(String email, String senha) {
		
		return usuarioRepository.autenticacao(email, senha);
	}

	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Optional<Usuario> FindById(int id) {
		return usuarioRepository.findById(id);
	}
	public Usuario findByEmail(String email) {
		return usuarioRepository.encontrarPorEmail(email);
	}
}