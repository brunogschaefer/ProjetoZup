package com.zup.projetoLoteria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.projetoLoteria.dto.LotoNumberDTO;
import com.zup.projetoLoteria.entities.LotoNumber;
import com.zup.projetoLoteria.repository.LotoNumberRepository;

@Service
public class LotoNumberServices {
	
	@Autowired
	private LotoNumberRepository lotoRepository;
	
	@Transactional (readOnly = true)
	public List<LotoNumberDTO> findAll(){
		List<LotoNumber> list = lotoRepository.findAll();
		return list.stream().map(x -> new LotoNumberDTO(x)).collect(Collectors.toList());
	}

}
