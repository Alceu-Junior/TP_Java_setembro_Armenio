package br.edu.infnet.VenturaEmpresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.VenturaEmpresa.model.domain.Vaga;
import br.edu.infnet.VenturaEmpresa.model.repository.VagaRepository;


@RestController
@RequestMapping(path = {"/vaga"})
public class VagaController {
	
	@Autowired
	private VagaRepository vagaRepository;

	@GetMapping(value = "/{id}")
	public ResponseEntity obterPorId(@PathVariable int id) {
		
		ResponseEntity retorno = ResponseEntity.notFound().build();
		Vaga vaga = this.findById(id);
		if (vaga != null) {
			
			retorno = ResponseEntity.ok().body(vaga);
		}
		return retorno;
	}
	
	private Vaga findById(int id) {
		
		Vaga retorno = null;
		try {
			retorno = vagaRepository.findById(id).get();
			
		}catch(Exception e) {
			
		}
		return retorno;
	}
	
	

	@PostMapping(value = "/")
	public ResponseEntity incluirVaga(@RequestBody Vaga vaga) {
		
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		if(vaga != null) {
			Vaga vagaInserida = vagaRepository.save(vaga);
			retorno = ResponseEntity.ok().body(vagaInserida);
		}
		return retorno;
	}	
	
	@GetMapping(value = "/lista")
	public ResponseEntity listar() {
		
		List<Vaga> vagas = (List<Vaga>) vagaRepository.findAll();
		
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		retorno = ResponseEntity.ok().body(vagas);
		
		return retorno;
	}
	
	@GetMapping(value = "/excluir/{id}")
	public ResponseEntity excluir(@PathVariable Integer id) {
		
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		if(vagaRepository.findById(id) != null) {
			retorno = ResponseEntity.ok().body(vagaRepository.findById(id));
			vagaRepository.deleteById(id);

		}
		return retorno;
	}
}