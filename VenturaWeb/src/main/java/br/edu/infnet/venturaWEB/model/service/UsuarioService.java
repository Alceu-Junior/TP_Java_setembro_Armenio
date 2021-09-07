package br.edu.infnet.venturaWEB.model.service;

import java.util.List;

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
				.request(MediaType.APPLICATION_JSON)
				.get(Usuario.class);
		}

	public Usuario criarConta(Usuario usuario) {
		
		return client.target(REST_URI)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON), Usuario.class);
	}


