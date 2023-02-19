package com.cardapiodigital.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblanche")
public class Lanche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLanche;

	private String txNome;

	private Double preco;
	
	@Transient
	private List<Ingrediente> ingredientesDoLanche;

	public Long getIdLanche() {
		return idLanche;
	}

	public void setIdlanche(Long idlanche) {
		this.idLanche = idlanche;
	}

	public String getTxnome() {
		return txNome;
	}

	public void setTxnome(String txNome) {
		this.txNome = txNome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Ingrediente> getIngredientesDoLanche() {
		return ingredientesDoLanche;
	}

	public void setIngredientesDoLanche(List<Ingrediente> ingredientesDoLanche) {
		this.ingredientesDoLanche = ingredientesDoLanche;
	}
}