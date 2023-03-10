package com.cardapiodigital.responses;

import java.util.List;
import java.util.Optional;

import com.cardapiodigital.entidades.Ingrediente;
import com.cardapiodigital.entidades.Lanche;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class PedidoRetorno {

    private String mensagem;

    private Optional<Lanche> lancheEscolhido;

    private List<Ingrediente> ingredientesAdicionais;

    private Double valorDoPedido;

    private List<String> temPromocao;

    public Double getValorDoPedido() {
	return valorDoPedido;
    }

    public void setValorDoPedido(Double valorDoPedido) {
	this.valorDoPedido = valorDoPedido;
    }

    public List<Ingrediente> getIngredientesAdicionais() {
	return ingredientesAdicionais;
    }

    public void setIngredientesAdicionais(List<Ingrediente> ingredientesAdicionais) {
	this.ingredientesAdicionais = ingredientesAdicionais;
    }

    public String getMensagem() {
	return mensagem;
    }

    public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
    }

    public Optional<Lanche> getLancheEscolhido() {
	return lancheEscolhido;
    }

    public void setLancheEscolhido(Optional<Lanche> lancheEscolhido) {
	this.lancheEscolhido = lancheEscolhido;
    }

    public List<String> getTemPromocao() {
        return temPromocao;
    }

    public void setTemPromocao(List<String> temPromocao) {
        this.temPromocao = temPromocao;
    }

}