package com.zup.projetoLoteria.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.projetoLoteria.dto.PlayerDTO;
import com.zup.projetoLoteria.services.PlayerServices;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {
	
	@Autowired
	private PlayerServices pService;
	
	@GetMapping
	public ResponseEntity<PlayerDTO> findByEmail(@RequestBody PlayerDTO dto){
		PlayerDTO player = pService.findByEmail(dto);
		return ResponseEntity.ok().body(player);
	}
	
	@PostMapping 
	public ResponseEntity<PlayerDTO> insert (@RequestBody PlayerDTO dto){
		dto = pService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping
	public ResponseEntity<PlayerDTO> update (@RequestBody PlayerDTO dto){
		dto = pService.update(dto);
		ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(dto.getId()); 
		return ResponseEntity.ok().body(dto);
	}
}
