package com.skilldistillery.jpaautomantenance.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_AUTO_JOB") //This is an optional annotation
public class AutoJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME_OF_JOB", nullable=false)
	private String nameOfJob;
	
	@Column(name="CREATE_DATE", nullable=true)
	private LocalDateTime createDate;
	
	
	
	

	public AutoJob() {
		super();
	}

	public AutoJob(int id, String nameOfJob, LocalDateTime createDate) {
		super();
		this.id = id;
		this.nameOfJob = nameOfJob;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfJob() {
		return nameOfJob;
	}

	public void setNameOfJob(String nameOfJob) {
		this.nameOfJob = nameOfJob;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoJob other = (AutoJob) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "AutoJob [id=" + id + ", nameOfJob=" + nameOfJob + ", createDate=" + createDate + "]";
	}
	
	
	
	


}