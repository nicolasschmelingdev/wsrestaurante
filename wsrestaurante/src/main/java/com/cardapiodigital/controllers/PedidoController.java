package com.cardapiodigital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cardapiodigital.exceptions.PedidoException;
import com.cardapiodigital.repositorys.IngredienteRepository;
import com.cardapiodigital.repositorys.LancheRepository;
import com.cardapiodigital.requests.AlterarPrecoIngredienteRequest;
import com.cardapiodigital.requests.RealizarPedidoRequest;
import com.cardapiodigital.responses.AlterarPrecoIngredienteRetorno;
import com.cardapiodigital.responses.CardapioRetorno;
import com.cardapiodigital.responses.PedidoRetorno;
import com.cardapiodigital.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Autowired
	private LancheRepository lancheRepository;

	@GetMapping("/cardapioTemplate")
	public ModelAndView form() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CardapioDigital");
		return modelAndView;

	}

	@GetMapping("/cardapio")
	public CardapioRetorno cardapio() {

		CardapioRetorno cardapio = new CardapioRetorno();

		pedidoService.mostrarCardapio(cardapio);
		
		return cardapio;
	}

	@PostMapping("/alterarPrecoIngrediente")
	public AlterarPrecoIngredienteRetorno alterarPrecoIngrediente(@RequestBody AlterarPrecoIngredienteRequest request){
		
		AlterarPrecoIngredienteRetorno retorno = new AlterarPrecoIngredienteRetorno();
		
		ingredienteRepository.updatePreco(request.getIdIngrediente(), request.getPreco());
		
		lancheRepository.updateLanchePreco();
		
		retorno.setMensagem("Resumo da alteração: ");
		retorno.setIngredienteAlterado(ingredienteRepository.findById(request.getIdIngrediente()).orElse(null));
		retorno.setNovoPreco(request.getPreco());
		
		return retorno;
		
	}
	
	@PostMapping("/realizarPedido")
	public PedidoRetorno calcularPreco(@RequestBody RealizarPedidoRequest request) {

		PedidoRetorno pedido = new PedidoRetorno();

		if (request.getIdLanche() == null) {
			request.setIdLanche(0L);
		}

		try {

			PedidoException.verificarQuantidadeIngredientes(request);

			pedidoService.mostrarPedido(request, pedido);

		} catch (PedidoException e) {

			pedido.setMensagem("Erro ao realizar pedido" + e.getMessage());

		}

		return pedido;
	}
}
