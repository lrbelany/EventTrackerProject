package com.skilldistillery.battle.services;

import java.util.List;

import com.skilldistillery.battle.entities.Battle;

public interface BattleService {

	List<Battle> allBattles();
	Battle findBattleById( int battleId);
	Battle createBattle(Battle battle);
	Battle updateBattle(int BattleId, Battle battle);
    boolean deleteBattle(int battleId);
}
