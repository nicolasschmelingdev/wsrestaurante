package com.cardapiodigital.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class AlterarPrecoIngredienteRequest {
	
	@JsonProperty("idIngrediente")
	private Long idIngrediente;
	
	@JsonProperty("preco")
	private Double preco;

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
