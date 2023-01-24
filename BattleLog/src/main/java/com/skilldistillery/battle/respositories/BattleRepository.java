package com.skilldistillery.battle.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.battle.entities.Battle;

public interface BattleRepository extends JpaRepository<Battle, Integer> {

}
