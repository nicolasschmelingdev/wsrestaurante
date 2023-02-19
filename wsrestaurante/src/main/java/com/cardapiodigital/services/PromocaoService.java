package com.cardapiodigital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardapiodigital.entidades.Ingrediente;
import com.cardapiodigital.repositorys.IngredienteRepository;
import com.cardapiodigital.repositorys.LancheRepository;
import com.cardapiodigital.requests.RealizarPedidoRequest;

@Service
public class PromocaoService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private LancheRepository lancheRepository;

    private List<String> txPromocoes;

    public Double promoLight(RealizarPedidoRequest request) {

	boolean blAlface = false;
	boolean blBacon = false;

	for (Ingrediente ingrediente : ingredienteRepository.findAllById(request.getIdIngredientes())) {
	    if (ingrediente.getIdingrediente()
		    .equals(1L)) {
		blAlface = true;
	    }
	    if ((ingrediente.getIdingrediente()
		    .equals(2L) && request.getQtBacon() != 0) || lancheRepository.findById(request.getIdLanche())
			    .get()
			    .getIdLanche()
			    .equals(4L)
		    || lancheRepository.findById(request.getIdLanche())
			    .get()
			    .getIdLanche()
			    .equals(1L)) {
		blBacon = true;
	    }
	}

	if (blAlface && !blBacon) {

	    getTxPromocoes().add("Tem promoção Light!");

	    return 0.9; // preço com 10% de desconto
	}

	return 1.0; // preço integral
    }

    public Double aplicarPromocoes(RealizarPedidoRequest request) {

	Double descontoCarne = 0.0;
	Double descontoQueijo = 0.0;

	if (request.getQtHamburguer() == null) { // evita nullPointerException
	    request.setQtHamburguer(0L);
	}
	if (request.getQtQueijo() == null) { // evita nullPointerException
	    request.setQtQueijo(0L);
	}

	if ((lancheRepository.findById(request.getIdLanche()) != null)
		&& !lancheRepository.findById(request.getIdLanche())
			.get()
			.getIdLanche()
			.equals(0L)) {

	    if (request.getQtQueijo() >= 2) {
		Long fatorQueijoLanche = (request.getQtQueijo() + 1) / 3;
		descontoQueijo = fatorQueijoLanche * 1.5;

		getTxPromocoes().add("Tem promoção Muito Queijo!");
	    }
	    if (request.getQtHamburguer() >= 2) {
		Long fatorCarneLanche = (request.getQtHamburguer() + 1) / 3;
		descontoCarne = fatorCarneLanche * 3.0;

		getTxPromocoes().add("Tem promoção Muita Carne!");
	    }

	    return (descontoQueijo + descontoCarne);

	}

	if (request.getQtHamburguer() >= 3) {

	    Long fatorDescontoCarne = request.getQtHamburguer() / 3;
	    descontoCarne = fatorDescontoCarne * 3.0;
	    getTxPromocoes().add("Tem promoção Muita Cartne!");

	}
	if (request.getQtQueijo() >= 3) {

	    Long fatorDescontoQueijo = request.getQtQueijo() / 3;
	    descontoQueijo = fatorDescontoQueijo * 1.5;
	    getTxPromocoes().add("Tem promoção Muito Queijo!");
	}

	return (descontoQueijo + descontoCarne);

    }

    public List<String> getTxPromocoes() {
	return txPromocoes;
    }

    public void setTxPromocoes(List<String> txPromocoes) {
	this.txPromocoes = txPromocoes;
    }
}
