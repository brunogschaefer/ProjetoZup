package com.zup.projetoLoteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zup.projetoLoteria.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	@Query ("SELECT DISTINCT obj FROM Player obj JOIN FETCH obj.numbers ORDER BY obj.id ASC")
	List<Player> findPlayersWithNumbers();

}
