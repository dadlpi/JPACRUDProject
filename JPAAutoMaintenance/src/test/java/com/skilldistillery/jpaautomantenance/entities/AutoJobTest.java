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
	private AutoJob autoJob;

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
		autoJob = em.find(AutoJob.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		autoJob = null;
	}
	
	
	

	@Test
	void test_AutoJob_basic_mappings() {
		assertNotNull(autoJob);
		assertEquals(1, autoJob.getId() );
		assertTrue(autoJob.getIntervalBetweenJob() > 0);
		assertEquals("2023-12-03T17:54:02", autoJob.getCreateDate().toString() );
		assertEquals(2023, autoJob.getCreateDate().getYear() );
//		assertEquals(LocalDateTime.of(2014, 5, 26, 21, 04, 30), rental.getReturnDate());
	}

	@Test
	void test() {
		
	}

}
