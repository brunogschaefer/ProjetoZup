package com.zup.projetoLoteria.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.zup.projetoLoteria.entities.Player;

public class PlayerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	
	List<LotoNumberDTO> list = new ArrayList<>();
	
	public PlayerDTO () {}
	public PlayerDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	public PlayerDTO(Player entity) {
		id = entity.getId();
		email = entity.getEmail();
		list = entity.getNumbers().stream().map(x -> new LotoNumberDTO(x)).collect(Collectors.toList());;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<LotoNumberDTO> getList() {
		return list;
	}
}
