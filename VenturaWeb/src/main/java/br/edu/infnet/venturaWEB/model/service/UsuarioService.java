package br.edu.infnet.venturaWEB.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.venturaWEB.model.domain.Usuario;

@FeignClient(url="http://localhost:8081/", name = "usuario")
public interface UsuarioService {

  @PostMapping(value = "/logar", name = "logar")
  Usuario validar(@RequestBody Usuario usuario);
  
  @PostMapping(value = "/criar", name = "criar")
  Usuario criarConta(@RequestBody Usuario usuario);
}


/**
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import br.edu.infnet.venturaWEB.model.domain.Usuario;
import br.edu.infnet.venturaWEB.model.repository.UsuarioRepository;
 
@Service
public class UsuarioService {
	
	private final String REST_URI = "http://localhost:8083/usuarios";
	private final Client client = ClientBuilder.newClient();
	
	public Usuario obterPorEmail(String email) {
		return client
				.target(REST_URI)
				.path("email")
				.path(email)
				.request()
				.get(Usuario.class);
		}

	public Usuario criarConta(Usuario usuario) {
		
		return client.
				target(REST_URI)
				.request()
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Usuario.class);
	}
}
**/

