package com.zup.projetoLoteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zup.projetoLoteria.entities.LotoNumber;

@Repository
public interface LotoNumberRepository extends JpaRepository <LotoNumber, Long>{

}
