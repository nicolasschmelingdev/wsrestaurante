package com.cardapiodigital.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngrediente;

    private String txNome;

    public Long getQtIngrediente() {
        return qtIngrediente;
    }

    public void setQtIngrediente(Long qtIngrediente) {
        this.qtIngrediente = qtIngrediente;
    }

    private Double preco;
    
    @Transient
    private Long qtIngrediente;

	public Long getIdingrediente() {
		return idIngrediente;
	}

	public void setIdingrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getTxNome() {
		return txNome;
	}

	public void setTxNome(String txNome) {
		this.txNome = txNome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}