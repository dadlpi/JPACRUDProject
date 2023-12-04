package com.skilldistillery.jpaautomantenance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.jpaautomantenance.data.AutoJobDAO;
import com.skilldistillery.jpaautomantenance.data.AutoJobDaoImpl;
import com.skilldistillery.jpaautomantenance.entities.AutoJob;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//NOTE YOU DO NOT NEED ENTITY MANAGER FACTORY NOR ENTITY MANAGER HERE SINCE DAO impl handles that

@SpringBootTest
class AutoMaintenanceApplicationTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private AutoJobDAO autoJobDao;

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
		autoJobDao = new AutoJobDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		autoJobDao = null;
	}

	
	
	
	@Test
	void test_find_all_jobs() {
		assertNotNull(autoJobDao);
		List<AutoJob> allJobs = autoJobDao.findAll();
		assertTrue( allJobs.size() > 0 && allJobs.size() <= 4); 
		
//		assertTrue( >0 && <2 , lab.getRangeOfCustomers(2, 5).size() ); 
//		assertEquals( 4 , lab.getRangeOfCustomers(2, 5).get(0).getFirstName() ); 
	}
	

//	@Test
//	void test() {
//		
//	}

	
	

}
