package com.cardapiodigital.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardapiodigital.entidades.Ingrediente;
import com.cardapiodigital.entidades.Lanche;
import com.cardapiodigital.repositorys.IngredienteRepository;
import com.cardapiodigital.repositorys.LancheRepository;
import com.cardapiodigital.requests.RealizarPedidoRequest;
import com.cardapiodigital.responses.CardapioRetorno;
import com.cardapiodigital.responses.PedidoRetorno;

@Service
public class PedidoService {

	@Autowired
	private PromocaoService promocaoService;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Autowired
	private LancheRepository lancheRepository;

	public CardapioRetorno mostrarCardapio(CardapioRetorno cardapio) {

		cardapio.setIngredientesAdicionais(ingredienteRepository.findAll());
		cardapio.setLanchesDisponiveis(lancheRepository.findAll());

		for (Lanche lanche : cardapio.getLanchesDisponiveis()) {
			switch (lanche.getIdLanche().intValue()) {
			case 1:
				lanche.setIngredientesDoLanche((ingredienteRepository.findAllById(Arrays.asList(2L, 3L, 5L))));
				break;
			case 2:
				lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(3L, 5L)));
				break;
			case 3:
				lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(3L, 4L, 5L)));
				break;
			case 4:
				lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(2L, 3L, 4L, 5L)));
				break;
			case 5:
				break;
			default:
				break;
			}

		}

		return cardapio;
	}

	public PedidoRetorno mostrarPedido(RealizarPedidoRequest request, PedidoRetorno pedido) {

		pedido.setMensagem("Dados do seu pedido: ");
		pedido.setIngredientesAdicionais(ingredienteRepository.findAllById(request.getIdIngredientes()));
		pedido.setLancheEscolhido(lancheRepository.findById(request.getIdLanche()));
		pedido.setValorDoPedido(calcularPreco(request));
		
		Lanche lanche = lancheRepository.findById(request.getIdLanche()).orElse(null);
		
		switch (lanche.getIdLanche().intValue()) {
		case 1:
		    lanche.setIngredientesDoLanche((ingredienteRepository.findAllById(Arrays.asList(2L, 3L, 5L))));
		    break;
		case 2:
		    lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(3L, 5L)));
		    break;
		case 3:
		    lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(3L, 4L, 5L)));
		    break;
		case 4:
		    lanche.setIngredientesDoLanche(ingredienteRepository.findAllById(Arrays.asList(2L, 3L, 4L, 5L)));
		    break;
		case 5:
		    break;
		default:
		    break;
		}


		return pedido;

	}

	public Double calcularPreco(RealizarPedidoRequest request) {

		Double ingredientesAdicionais = 0.0;

		for (Ingrediente ingrediente : ingredienteRepository.findAllById(request.getIdIngredientes())) {
			switch (ingrediente.getIdingrediente().intValue()) {
			case 1:
				ingredientesAdicionais += ingrediente.getPreco() * request.getQtAlface();
				ingrediente.setQtIngrediente(request.getQtAlface());
				break;
			case 2:
				ingredientesAdicionais += ingrediente.getPreco() * request.getQtBacon();
				ingrediente.setQtIngrediente(request.getQtBacon());
				break;
			case 3:
				ingredientesAdicionais += ingrediente.getPreco() * request.getQtHamburguer();
				ingrediente.setQtIngrediente(request.getQtHamburguer());
				break;
			case 4:
				ingredientesAdicionais += ingrediente.getPreco() * request.getQtOvo();
				ingrediente.setQtIngrediente(request.getQtOvo());
				break;
			case 5:
				ingredientesAdicionais += ingrediente.getPreco() * request.getQtQueijo();
				ingrediente.setQtIngrediente(request.getQtQueijo());
				break;
			default:
				break;
			}
		}
		
		return (ingredientesAdicionais + lancheRepository.findById(request.getIdLanche()).get().getPreco()
				- promocaoService.aplicarPromocoes(request)) * promocaoService.promoLight(request);
	}
}
