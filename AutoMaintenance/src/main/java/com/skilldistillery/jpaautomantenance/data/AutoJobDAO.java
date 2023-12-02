package com.skilldistillery.jpaautomantenance.data;

import java.util.List;

import com.skilldistillery.jpaautomantenance.entities.AutoJob;

public interface AutoJobDAO {
	
	AutoJob findById (int jobId);
	List<AutoJob> findAll();
	AutoJob create (AutoJob autojob);
	AutoJob udpdate (int jobId, AutoJob autojob);
	boolean delete (int jobId);
	
}
