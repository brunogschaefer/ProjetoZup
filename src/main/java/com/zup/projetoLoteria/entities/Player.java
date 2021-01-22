package com.zup.projetoLoteria.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	//(fetch = FetchType.LAZY)
	@OneToMany 
	@JoinTable (name = "tb_player_number",
				joinColumns = @JoinColumn(name = "player_id"),
				inverseJoinColumns = @JoinColumn(name = "number_id"))
	private Set<LotoNumber> numbers = new HashSet<>();
	
	public Player () {}
	public Player(Long id, String email) {
		this.id = id;
		this.email = email;
		//new LotoNumber(null, GenerateRandomNumbers.genRandom());
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
	public Set<LotoNumber> getNumbers(){
		return numbers;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}