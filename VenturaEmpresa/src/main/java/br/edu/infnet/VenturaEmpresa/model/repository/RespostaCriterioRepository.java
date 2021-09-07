package br.edu.infnet.VenturaEmpresa.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaEmpresa.model.domain.RespostaCriterio;

@Repository
public interface RespostaCriterioRepository extends CrudRepository<RespostaCriterio, Integer> {

}
