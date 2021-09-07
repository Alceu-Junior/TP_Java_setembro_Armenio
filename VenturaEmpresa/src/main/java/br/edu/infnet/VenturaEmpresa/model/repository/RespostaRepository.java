package br.edu.infnet.VenturaEmpresa.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaEmpresa.model.domain.Resposta;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Integer> {

}
