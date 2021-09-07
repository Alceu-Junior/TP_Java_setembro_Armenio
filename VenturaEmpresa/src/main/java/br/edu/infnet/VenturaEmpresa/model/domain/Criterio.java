package br.edu.infnet.VenturaEmpresa.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Criterio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(name = "id_vaga", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
	private Vaga vaga;
	private String descricao;
	private int perfil;
	private int peso;
	

	public Criterio() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getPerfil() {
		return perfil;
	}


	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public Vaga getVaga() {
		return vaga;
	}


	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	

}
