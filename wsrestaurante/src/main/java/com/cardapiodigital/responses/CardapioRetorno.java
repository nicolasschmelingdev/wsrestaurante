package com.cardapiodigital.responses;

import java.util.List;

import com.cardapiodigital.entidades.Ingrediente;
import com.cardapiodigital.entidades.Lanche;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class CardapioRetorno {

	private List<Ingrediente> ingredientesAdicionais;

	private List<Lanche> lanchesDisponiveis;

	public List<Ingrediente> getIngredientesAdicionais() {
		return ingredientesAdicionais;
	}

	public void setIngredientesAdicionais(List<Ingrediente> ingredientesAdicionais) {
		this.ingredientesAdicionais = ingredientesAdicionais;
	}

	public List<Lanche> getLanchesDisponiveis() {
		return lanchesDisponiveis;
	}

	public void setLanchesDisponiveis(List<Lanche> lanchesDisponiveis) {
		this.lanchesDisponiveis = lanchesDisponiveis;
	}

}