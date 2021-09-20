package br.edu.infnet.venturaWEB.model.service;

import br.edu.infnet.venturaWEB.model.domain.Vaga;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.venturaWEB.model.domain.Usuario;

import java.util.List;

@FeignClient(url="http://localhost:8082/", name = "vaga")
public interface VagaService {

	@PostMapping(value = "/", name = "criar")
	Vaga criarVaga(@RequestBody Vaga vaga);

	@GetMapping(value = "/lista", name = "listar")
	List<Vaga> listarTodasVagas();

	@GetMapping(value = "/lista/usuario/{id}", name = "listarPorUsuario")
	List<Vaga> listarPorUsuario(@PathVariable int id);

	@GetMapping(value = "/excluir/{id}", name = "excluir")
	Vaga excluirVaga(@PathVariable int id);
}
/**
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import br.edu.infnet.venturaWEB.model.domain.Usuario;
import br.edu.infnet.venturaWEB.model.domain.Vaga;
import br.edu.infnet.venturaWEB.model.repository.UsuarioRepository;


@Service
public class VagaService {
	
	private final String REST_URI = "http://localhost:8082/vaga/";
	private final Client client = ClientBuilder.newClient();
	
	public List<Vaga> listarPorIDUsuario(int idUsuario) {
		return client
				.target(REST_URI)
				.path("usuario")
				.path(String.valueOf(idUsuario))
				.request(MediaType.APPLICATION_JSON)
				.get(Usuario.class);
		}
	}
**/

