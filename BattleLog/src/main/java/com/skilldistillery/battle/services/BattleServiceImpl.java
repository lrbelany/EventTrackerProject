package com.skilldistillery.battle.services;

import java.util.List;
import java.util.Optional;

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
		Optional<Battle> battleOpt = battleresp.findById(battleId);
		Battle battle = null;
		if (battleOpt.isPresent()) {
			battle = battleOpt.get();
		}
		return battle;
	}

	@Override
	public Battle createBattle(Battle battle) {

		battleresp.saveAndFlush(battle);
		return battle;
	}

	@Override
	public Battle updateBattle(int battleId, Battle battle) {
		Optional<Battle> updateBattle = battleresp.findById(battleId);

		if (updateBattle.isPresent()) {
			Battle update = updateBattle.get();
			update.setWin(true);
			update.setKills(battleId);
			update.setMvpI(true);
			update.setMvpII(true);
			update.setMvpIII(true);
			update.setFirepower(battleId);
			update.setCaptures(battleId);
			update.setPoints(battleId);

			battleresp.save(update);
			return update;

		} else {

			return null;
		}
	}

	@Override
	public boolean deleteBattle(Integer battleId) {

		boolean deleted = false;
		Optional<Battle> toDelete = battleresp.findById(battleId);
		if (toDelete != null) {
			battleresp.deleteById(battleId);
			;
			deleted = true;
		}
		return deleted;
	}

}
