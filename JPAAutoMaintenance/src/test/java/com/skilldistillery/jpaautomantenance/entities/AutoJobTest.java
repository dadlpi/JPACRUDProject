package com.skilldistillery.jpaautomantenance.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class AutoJobTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private AutoJob AutoJob;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAAutoMaintenance");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		AutoJob = em.find(AutoJob.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		AutoJob = null;
	}
	
	
	

	@Test
	void test_AutoJob_basic_mappings() {
		assertNotNull(AutoJob);
		assertEquals("Brake", AutoJob.getNameOfJob());
	}

	@Test
	void test() {
		
	}

}
