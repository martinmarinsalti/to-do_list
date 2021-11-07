package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ID;
	private String TASK;
	private Boolean DO;
	
	public Task(){};
	
	public Boolean getDO() {
		return DO;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public String getTASK() {
		return TASK;
	}
	
	public void setDO(Boolean dO) {
		DO = dO;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public void setTASK(String tASK) {
		TASK = tASK;
	}
	
//	public Task(Integer Id, String Task, Boolean Do){
//		this.TASK = Task;
//		this.ID = Id;
//		this.DO = Do;
//	}
}
