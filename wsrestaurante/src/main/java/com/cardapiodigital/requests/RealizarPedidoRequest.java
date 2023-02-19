package com.cardapiodigital.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class RealizarPedidoRequest {

    @JsonProperty("idIngredientes")
    private List<Long> idIngredientes;

    @JsonProperty("qtAlface")
    private Long qtAlface;

    @JsonProperty("qtBacon")
    private Long qtBacon;

    @JsonProperty("qtHamburguer")
    private Long qtHamburguer;

    @JsonProperty("qtOvo")
    private Long qtOvo;

    @JsonProperty("qtQueijo")
    private Long qtQueijo;

    @JsonProperty("idLanche")
    private Long idLanche;

	public List<Long> getIdIngredientes() {
		return idIngredientes;
	}

	public void setIdIngredientes(List<Long> idIngredientes) {
		this.idIngredientes = idIngredientes;
	}

	public Long getQtAlface() {
		return qtAlface;
	}

	public void setQtAlface(Long qtAlface) {
		this.qtAlface = qtAlface;
	}

	public Long getQtBacon() {
		return qtBacon;
	}

	public void setQtBacon(Long qtBacon) {
		this.qtBacon = qtBacon;
	}

	public Long getQtHamburguer() {
		return qtHamburguer;
	}

	public void setQtHamburguer(Long qtHamburguer) {
		this.qtHamburguer = qtHamburguer;
	}

	public Long getQtOvo() {
		return qtOvo;
	}

	public void setQtOvo(Long qtOvo) {
		this.qtOvo = qtOvo;
	}

	public Long getQtQueijo() {
		return qtQueijo;
	}

	public void setQtQueijo(Long qtQueijo) {
		this.qtQueijo = qtQueijo;
	}

	public Long getIdLanche() {
		return idLanche;
	}

	public void setIdLanche(Long idLanche) {
		this.idLanche = idLanche;
	}

}
