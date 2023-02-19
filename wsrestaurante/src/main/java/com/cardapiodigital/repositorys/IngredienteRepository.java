package com.cardapiodigital.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardapiodigital.entidades.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

	@Modifying
	@Transactional
    @Query("UPDATE Ingrediente i SET i.preco = :preco WHERE i.id = :id")
    void updatePreco(@Param("id") Long id, @Param("preco") Double preco);
	
}
