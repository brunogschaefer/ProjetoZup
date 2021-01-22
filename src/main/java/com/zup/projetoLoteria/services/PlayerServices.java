package com.zup.projetoLoteria.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.projetoLoteria.dto.PlayerDTO;
import com.zup.projetoLoteria.entities.GenerateRandomNumbers;
import com.zup.projetoLoteria.entities.LotoNumber;
import com.zup.projetoLoteria.entities.Player;
import com.zup.projetoLoteria.repository.LotoNumberRepository;
import com.zup.projetoLoteria.repository.PlayerRepository;

@Service
public class PlayerServices {
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private LotoNumberRepository numberRepository;
	
	@Transactional (readOnly = true)
	public List<PlayerDTO> findAll(){
		List<Player> list = playerRepository.findPlayersWithNumbers();
		return list.stream().map(x -> new PlayerDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional 
	public PlayerDTO insert(PlayerDTO dto) {
		Player player = new Player (null, dto.getEmail());
		LotoNumber number = new LotoNumber(null, GenerateRandomNumbers.genRandom());
		player.getNumbers().add(number);
		player = playerRepository.save(player);
		number = numberRepository.save(number);
		return new PlayerDTO(player);
	}
}
