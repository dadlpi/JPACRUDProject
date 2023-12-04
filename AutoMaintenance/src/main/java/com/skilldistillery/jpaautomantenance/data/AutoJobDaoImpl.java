package com.skilldistillery.jpaautomantenance.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpaautomantenance.entities.AutoJob;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutoJobDaoImpl implements AutoJobDAO {
	
	//NOTE - there is no em.getTransaction.being/commit
	//NOTE - there is no em.close();
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public AutoJob findById(int jobId) {
		return em.find(AutoJob.class, jobId);
	}

	@Override
	public List<AutoJob> findAll() {
			String sql = "select j from AutoJob j";
			List<AutoJob> autoJobs = em.createQuery(sql, AutoJob.class)
					.getResultList();
			return autoJobs;
	}

	@Override
	public AutoJob create(AutoJob autojob) {
			em.persist(autojob);
		return autojob;
	}

	@Override
	public AutoJob udpdate(int jobId, AutoJob autojob) {
		AutoJob autoJobFound = em.find(AutoJob.class, jobId);
		
		if(autoJobFound != null) {
			
			autoJobFound.setActiveInd(autojob.getActiveInd());
			autoJobFound.setDescription(autojob.getDescription());
		}
		
		return autoJobFound;
	}

	
	@Override
	public boolean delete(int jobId) {
		AutoJob autoJobFound = em.find(AutoJob.class, jobId);
		boolean successfullyRemoved = false;
		if(autoJobFound != null) {
			em.remove(autoJobFound);
			successfullyRemoved = !em.contains(autoJobFound);
		}
		return successfullyRemoved;
	}

}
