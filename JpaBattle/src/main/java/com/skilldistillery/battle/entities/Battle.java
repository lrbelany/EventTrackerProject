package com.skilldistillery.battle.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Battle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kills;

	private boolean win;
	
	
	private boolean mvpI;
	

	private boolean mvpII;
	

	private boolean mvpIII;
	
	private int points;
	
	
	private int firepower;
	private int captures;
	
	
	//@JoinColumn(name = "arenaid")
	//private Arena arena;
	
	public Battle() {
		super();
	
	}



	public Battle(int id, int kills, boolean win, boolean mvpI, boolean mvpII, boolean mvpIII, int points,
			int firepower, int captures) {
		super();
		this.id = id;
		this.kills = kills;
		this.win = win;
		this.mvpI = mvpI;
		this.mvpII = mvpII;
		this.mvpIII = mvpIII;
		this.points = points;
		this.firepower = firepower;
		this.captures = captures;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getKills() {
		return kills;
	}



	public void setKills(int kills) {
		this.kills = kills;
	}



	public boolean isWin() {
		return win;
	}



	public void setWin(boolean win) {
		this.win = win;
	}



	public boolean isMvpI() {
		return mvpI;
	}



	public void setMvpI(boolean mvpI) {
		this.mvpI = mvpI;
	}



	public boolean isMvpII() {
		return mvpII;
	}



	public void setMvpII(boolean mvpII) {
		this.mvpII = mvpII;
	}



	public boolean isMvpIII() {
		return mvpIII;
	}



	public void setMvpIII(boolean mvpIII) {
		this.mvpIII = mvpIII;
	}



	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}



	public int getFirepower() {
		return firepower;
	}



	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}



	public int getCaptures() {
		return captures;
	}



	public void setCaptures(int captures) {
		this.captures = captures;
	}



	@Override
	public String toString() {
		return "Battle [id=" + id + ", kills=" + kills + ", win=" + win + ", mvpI=" + mvpI + ", mvpII=" + mvpII
				+ ", mvpIII=" + mvpIII + ", points=" + points + ", firepower=" + firepower + ", captures=" + captures
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battle other = (Battle) obj;
		return id == other.id;
	}

	
}
