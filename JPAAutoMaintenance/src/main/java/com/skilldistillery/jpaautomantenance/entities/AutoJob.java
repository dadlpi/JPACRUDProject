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
	
	//CLASS MEMBERS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME_OF_JOB", nullable=false)
	private String nameOfJob;
	
	@Column(name="INTERVAL_BETWEEN_JOB", nullable=false)
	private int intervalBetweenJob;
	
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	
	@Column(name="CREATE_DATE", nullable=false)
	private LocalDateTime createDate;
	
	@Column(name="CREATOR_ID", nullable=false)
	private String creatorId;
	
	@Column(name="MODIFY_DATE", nullable=true)
	private LocalDateTime modifyDate;
	
	@Column(name="MODIFIER_ID", nullable=true)
	private String modifierId;
	
	@Column(name="ACTIVE_IND", nullable=false)
	private String activeInd;


	
	
	
	//CONSTRUCTORS
	public AutoJob() {
		super();
	}

	public AutoJob(String nameOfJob, int intervalBetweenJob, LocalDateTime createDate, String creatorId,
			String activeInd) {
		super();
		this.nameOfJob = nameOfJob;
		this.intervalBetweenJob = intervalBetweenJob;
		this.createDate = createDate;
		this.creatorId = creatorId;
		this.activeInd = activeInd;
	}

	public AutoJob(String nameOfJob, int intervalBetweenJob, String description, LocalDateTime createDate,
			String creatorId, String activeInd) {
		super();
		this.nameOfJob = nameOfJob;
		this.intervalBetweenJob = intervalBetweenJob;
		this.description = description;
		this.createDate = createDate;
		this.creatorId = creatorId;
		this.activeInd = activeInd;
	}

	
	
	
	//GETTERS SETTERS 
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

	public int getIntervalBetweenJob() {
		return intervalBetweenJob;
	}

	public void setIntervalBetweenJob(int intervalBetweenJob) {
		this.intervalBetweenJob = intervalBetweenJob;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

	
	
	//HASHCODE 
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

	
	
	
	//TO_STRING
	@Override
	public String toString() {
		return "AutoJob [id=" + id + ", nameOfJob=" + nameOfJob + ", intervalBetweenJob=" + intervalBetweenJob
				+ ", description=" + description + ", createDate=" + createDate + ", creatorId=" + creatorId
				+ ", modifyDate=" + modifyDate + ", modifierId=" + modifierId + ", activeInd=" + activeInd + "]";
	}
	
	
	
	
	


}