package com.example.demo.service;



import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository tr;
	
	@Transactional
	public ArrayList<Task> showTaskList() {
		ArrayList<Task> list = (ArrayList<Task>) tr.findAll();
		System.out.println("La lista es "+list);
		return list;
	}
	
	@Transactional
	public void deleteTask(Integer id) {
		try {
			tr.deleteById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public Task loadTask(String taskName) {

		Task t = new Task();
		t.setTASK(taskName);
		t.setDO(false);
		return tr.save(t);
	}
	
	@Transactional
	public void editTaskDo(Integer id) {
		Task t = tr.findById(id).get();
		
		if(t.getDO()) {
			t.setDO(false);
		}else {
			t.setDO(true);
		}
		
		tr.save(t);
	}
	
	@Transactional
	public Task editTask(Integer id, String newTask) {
		
		Task  etn = tr.getById(id);
		etn.setTASK(newTask);
		
		return tr.save(etn);
		
	}
}
