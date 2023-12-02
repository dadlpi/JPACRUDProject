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
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public AutoJob findById(int jobId) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutoJob udpdate(int jobId, AutoJob autojob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int jobId) {
		// TODO Auto-generated method stub
		return false;
	}

}
