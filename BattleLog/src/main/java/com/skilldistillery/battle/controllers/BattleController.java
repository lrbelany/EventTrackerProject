package com.skilldistillery.battle.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.battle.entities.Battle;
import com.skilldistillery.battle.services.BattleService;

@RestController
@RequestMapping("api")
public class BattleController {
	@Autowired
	private BattleService btsv;
	
	
	@GetMapping("battles")
	public List<Battle>  getBattles(){
		return btsv.allBattles();
		
		
	}
	@GetMapping("battles/{battleId}")
	public Battle getPost(@PathVariable int battleId, HttpServletResponse res) {
		Battle battle = btsv.findBattleById(battleId);
		if (battle == null) {
			res.setStatus(404);
		}
		return battle;
	}
	@PostMapping("battles")
	public Battle createBattle(@RequestBody Battle battle, HttpServletResponse res, HttpServletRequest req) {
		try {
			btsv.createBattle(battle);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(battle.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			battle = null;
		}
		return battle;
	}
	@DeleteMapping("battles/{battleId}")
	public void delete(@PathVariable Integer battleId, HttpServletResponse res) {
		try {
			if (btsv.deleteBattle(battleId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	@PutMapping("battles/{battleId}")
	public Battle updateBattle(@PathVariable("battleId") Integer battleId, @RequestBody Battle battle, HttpServletResponse res) {
		try {
			battle = btsv.updateBattle(battleId, battle);
			if (battle == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			battle = null;
		}
		return battle;
	}
}
