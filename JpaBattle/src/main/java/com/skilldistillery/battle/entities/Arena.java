package com.skilldistillery.battle.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Arena {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int arenaId;
	
	
	private String arena;

	//@OneToMany(mappedBy = "battle")
    //List<Battle> battles;
}
