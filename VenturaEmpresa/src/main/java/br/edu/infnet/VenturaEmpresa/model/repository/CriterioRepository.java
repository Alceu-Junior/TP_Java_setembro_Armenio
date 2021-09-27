package br.edu.infnet.VenturaEmpresa.model.repository;

import br.edu.infnet.VenturaEmpresa.model.domain.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaEmpresa.model.domain.Criterio;

import java.util.List;

@Repository
public interface CriterioRepository extends CrudRepository<Criterio, Integer> {
/*
    List<Criterio> findByIdUsuario(int idUsuario);

    List<Criterio> findByIdVaga(int id_vaga);

 */

}
