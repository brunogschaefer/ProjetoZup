package com.zup.projetoLoteria.dto;

import java.io.Serializable;

import com.zup.projetoLoteria.entities.LotoNumber;

public class LotoNumberDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String number;
	
	public LotoNumberDTO () {}
	public LotoNumberDTO(Long id, String number) {
		this.id = id;
		this.number = number;
	}
	public LotoNumberDTO(LotoNumber entity) {
		id = entity.getId();
		number = entity.getNumber();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
