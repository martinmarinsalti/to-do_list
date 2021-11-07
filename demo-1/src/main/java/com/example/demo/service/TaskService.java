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
}
