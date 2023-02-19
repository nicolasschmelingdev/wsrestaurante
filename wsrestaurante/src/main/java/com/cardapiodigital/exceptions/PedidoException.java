package com.cardapiodigital.exceptions;

import com.cardapiodigital.requests.RealizarPedidoRequest;

public class PedidoException extends AssertionError {
	/**
	* 
	*/
	private static final long serialVersionUID = 1524827683688630544L;

	public PedidoException(String mensagem) {
		super(mensagem);
	}

	public static void verificarQuantidadeIngredientes(RealizarPedidoRequest request) throws PedidoException {
		if (request.getIdIngredientes().contains(1L) && request.getQtAlface() == null) {
			throw new PedidoException("É necessário incluir a quantidade desejada do ingrediente solicitado");
		}
		if (request.getIdIngredientes().contains(2L) && request.getQtBacon() == null) {
			throw new PedidoException("É necessário incluir a quantidade desejada do ingrediente solicitado");
		}
		if (request.getIdIngredientes().contains(3L) && request.getQtHamburguer() == null) {
			throw new PedidoException("É necessário incluir a quantidade desejada do ingrediente solicitado");
		}
		if (request.getIdIngredientes().contains(4L) && request.getQtOvo() == null) {
			throw new PedidoException("É necessário incluir a quantidade desejada do ingrediente solicitado");
		}
		if (request.getIdIngredientes().contains(5L) && request.getQtQueijo() == null) {
			throw new PedidoException("É necessário incluir a quantidade desejada do ingrediente solicitado");
		}

	}
}
