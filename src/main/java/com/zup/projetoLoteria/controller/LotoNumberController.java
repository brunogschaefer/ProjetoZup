package com.zup.projetoLoteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.projetoLoteria.dto.LotoNumberDTO;
import com.zup.projetoLoteria.services.LotoNumberServices;

@RestController
@RequestMapping(value = "/numbers")
public class LotoNumberController {
	
	@Autowired
	private LotoNumberServices lotoService;
	
	@GetMapping
	public ResponseEntity<List<LotoNumberDTO>> findAll(){
		List<LotoNumberDTO> list = lotoService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
