package com.cardapiodigital.services;

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

	public Double promoLight(RealizarPedidoRequest request) {

		boolean blAlface = false;
		boolean blBacon = false;

		for (Ingrediente ingrediente : ingredienteRepository.findAllById(request.getIdIngredientes())) {
			if (ingrediente.getIdingrediente().equals(1L)) {
				blAlface = true;
			}
			if ((ingrediente.getIdingrediente().equals(2L) && request.getQtBacon() != 0)
					|| lancheRepository.findById(request.getIdLanche()).get().getIdLanche().equals(4L)
					|| lancheRepository.findById(request.getIdLanche()).get().getIdLanche().equals(1L)) {
				blBacon = true;
			}
		}

		if (blAlface && !blBacon) {
			return 0.9;
		}

		return 1.0;
	}

	public Double aplicarPromocoes(RealizarPedidoRequest request) {

		Double descontoCarne = 0.0;
		Double descontoQueijo = 0.0;

		if (request.getQtHamburguer() == null) {
			request.setQtHamburguer(0L);
		}
		if (request.getQtQueijo() == null) {
			request.setQtQueijo(0L);
		}

		if ((lancheRepository.findById(request.getIdLanche()) != null)
				&& !lancheRepository.findById(request.getIdLanche()).get().getIdLanche().equals(5L)) {
			if (request.getQtHamburguer() >= 2) {
				Long fatorQueijoLanche = (request.getQtHamburguer() + 1) / 3;
				descontoQueijo = fatorQueijoLanche * 1.5;
			}
			if (request.getQtHamburguer() >= 2) {
				Long fatorCarneLanche = (request.getQtHamburguer() + 1) / 3;
				descontoCarne = fatorCarneLanche * 3.0;
			}
			return (descontoQueijo + descontoCarne);

		} else if (request.getQtHamburguer() >= 3 || request.getQtQueijo() >= 3) {

			Long fatorDescontoCarne = request.getQtHamburguer() / 3;
			Long fatorDescontoQueijo = request.getQtQueijo() / 3;

			descontoCarne = fatorDescontoCarne * 3.0;
			descontoQueijo = fatorDescontoQueijo * 1.5;
		}

		return (descontoQueijo + descontoCarne);

	}
}
