package com.skilldistillery.battle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.battle.entities.Battle;
import com.skilldistillery.battle.respositories.BattleRepository;


@Service
public class BattleServiceImpl implements BattleService {

	@Autowired
	private BattleRepository battleresp;
	
	
	@Override
	public List<Battle> allBattles() {
		
		return battleresp.findAll();
	}

	@Override
	public Battle findBattleById(int battleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Battle createBattle(Battle battle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Battle updateBattle(int BattleId, Battle battle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBattle(int battleId) {
		// TODO Auto-generated method stub
		return false;
	}

}
