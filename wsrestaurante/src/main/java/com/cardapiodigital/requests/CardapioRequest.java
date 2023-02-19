package com.cardapiodigital.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class CardapioRequest {

	@JsonProperty("idIngredientes")
	private List<Long> idIngredientes;

	@JsonProperty("idLanche")
	private List<Long> idLanche;

	public List<Long> getIdIngredientes() {
		return idIngredientes;
	}

	public void setIdIngredientes(List<Long> idIngredientes) {
		this.idIngredientes = idIngredientes;
	}

	public List<Long> getIdLanche() {
		return idLanche;
	}

	public void setIdLanche(List<Long> idLanche) {
		this.idLanche = idLanche;
	}
}
