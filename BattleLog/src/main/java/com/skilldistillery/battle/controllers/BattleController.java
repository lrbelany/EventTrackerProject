package com.skilldistillery.battle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
