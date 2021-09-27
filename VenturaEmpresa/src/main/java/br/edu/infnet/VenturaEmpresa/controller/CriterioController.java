package br.edu.infnet.VenturaEmpresa.controller;

import br.edu.infnet.VenturaEmpresa.model.domain.Criterio;
import br.edu.infnet.VenturaEmpresa.model.domain.Vaga;
import br.edu.infnet.VenturaEmpresa.model.repository.CriterioRepository;
import br.edu.infnet.VenturaEmpresa.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CriterioController {
	
	@Autowired
	private CriterioRepository criterioRepository;

	@GetMapping(value = "criterio/{id}")
	public ResponseEntity obterPorId(@PathVariable int id) {
		
		ResponseEntity retorno = ResponseEntity.notFound().build();
		Criterio criterio = this.findById(id);
		if (criterio != null) {
			
			retorno = ResponseEntity.ok().body(criterio);
		}
		return retorno;
	}
	
	private Criterio findById(int id) {
		
		Criterio retorno = null;
		try {
			retorno = criterioRepository.findById(id).get();
			
		}catch(Exception e) {
			
		}
		return retorno;
	}
	
	

	@PostMapping(value = "criterio/")
	public ResponseEntity incluirCriterio(@RequestBody Criterio criterio) {
		
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		if(criterio != null) {
			Criterio criterioInserido = criterioRepository.save(criterio);
			retorno = ResponseEntity.ok().body(criterioInserido);
		}
		return retorno;
	}
	/*
	@GetMapping(value = "criterio/lista/vaga/{id}")
	public ResponseEntity listarPorIdVaga(@PathVariable Integer id) {
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		List<Criterio> criterios;
		try {
			criterios = (List<Criterio>) criterioRepository.findByIdVaga(id);
		}catch (Exception e) {
			return retorno;
		}
		
		retorno = ResponseEntity.ok().body(criterios);
		
		return retorno;
	}

	@GetMapping(value = "/excluir/{id}")
	public ResponseEntity excluir(@PathVariable Integer id) {
		ResponseEntity retorno = ResponseEntity.badRequest().build();
		
		if(criterioRepository.findById(id) != null) {
			retorno = ResponseEntity.ok().body(criterioRepository.findById(id));
			criterioRepository.deleteById(id);
			return retorno;
		}
		return retorno;
	}
	 */
}