package com.skilldistillery.battle.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Battle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kills;

	private boolean win;
	
	
	private boolean mvpsss;
	

	private boolean mvpss;
	

	private boolean mvps;
	
	private int points;
	
	
	private int firepower;
	private int captures;
	
	
	//@JoinColumn(name = "arenaid")
	//private Arena arena;
	
	public Battle() {
		super();
	
	}



	public Battle(int id, int kills, boolean win, boolean mvpsss, boolean mvpss, boolean mvps, int points,
			int firepower, int captures) {
		super();
		this.id = id;
		this.kills = kills;
		this.win = win;
		this.mvpsss = mvpsss;
		this.mvpss = mvpss;
		this.mvps = mvps;
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



	public boolean isMvpsss() {
		return mvpsss;
	}



	public void setMvpsss(boolean mvpsss) {
		this.mvpsss = mvpsss;
	}



	public boolean isMvpss() {
		return mvpss;
	}



	public void setMvpss(boolean mvpss) {
		this.mvpss = mvpss;
	}



	public boolean isMvps() {
		return mvps;
	}



	public void setMvps(boolean mvps) {
		this.mvps = mvps;
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
		return "Battle [id=" + id + ", kills=" + kills + ", win=" + win + ", mvpsss=" + mvpsss + ", mvpss=" + mvpss
				+ ", mvps=" + mvps + ", points=" + points + ", firepower=" + firepower + ", captures=" + captures + "]";
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
