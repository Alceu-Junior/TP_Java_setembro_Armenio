package br.edu.infnet.VenturaEmpresa.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RespostaCriterio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name = "id_resposta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
	private Resposta resposta;
	@JoinColumn(name = "id_criterio", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
	private Criterio criterio;
	

	public RespostaCriterio() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Resposta getResposta() {
		return resposta;
	}


	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}


	public Criterio getCriterio() {
		return criterio;
	}


	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	
	
}
