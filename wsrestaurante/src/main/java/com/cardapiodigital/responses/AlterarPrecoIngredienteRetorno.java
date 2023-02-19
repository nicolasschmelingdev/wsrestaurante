package com.cardapiodigital.responses;

import com.cardapiodigital.entidades.Ingrediente;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class AlterarPrecoIngredienteRetorno {

	private String mensagem;

	private Ingrediente ingredienteAlterado;

	private Double novoPreco;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Ingrediente getIngredienteAlterado() {
		return ingredienteAlterado;
	}

	public void setIngredienteAlterado(Ingrediente ingredienteAlterado) {
		this.ingredienteAlterado = ingredienteAlterado;
	}

	public Double getNovoPreco() {
		return novoPreco;
	}

	public void setNovoPreco(Double novoPreco) {
		this.novoPreco = novoPreco;
	}

}