package com.skilldistillery.battle.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Battle bt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JpaBattle");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		bt = em.find(Battle.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		bt = null;
	}

	@Test
	void test() {
		assertNotNull(bt);
		assertEquals("paradise plaza", bt.getLocation());
	}

}
