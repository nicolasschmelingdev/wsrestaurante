package com.cardapiodigital.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardapiodigital.entidades.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE tblanche L " + "JOIN (SELECT idlanche, SUM(preco) AS preco "
			+ "      FROM (SELECT DISTINCT L.idlanche, I.preco " + "            FROM tblanche L "
			+ "            JOIN tblanche_ingrediente LI ON L.idlanche = LI.idlanche "
			+ "            JOIN tbingrediente I ON LI.idingrediente = I.idingrediente) AS T "
			+ "      GROUP BY idlanche) AS T ON L.idlanche = T.idlanche " + "SET L.preco = T.preco", nativeQuery = true)
	void updateLanchePreco();

}