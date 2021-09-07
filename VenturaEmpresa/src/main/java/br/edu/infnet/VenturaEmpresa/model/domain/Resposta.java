package br.edu.infnet.VenturaEmpresa.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Resposta{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idUsuario;
	@JoinColumn(name = "id_vaga", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
	private Vaga vaga;
	private Date data;
	private float indice;
	
	
	

	public Resposta() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Vaga getVaga() {
		return vaga;
	}


	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public float getIndice() {
		return indice;
	}


	public void setIndice(float indice) {
		this.indice = indice;
	}

	
}
