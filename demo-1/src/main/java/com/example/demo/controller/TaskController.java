package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {
	@Autowired
	private TaskService ts;
	
	@GetMapping("/")
	public String View(ModelMap model) {
		ArrayList<com.example.demo.entity.Task> task_list = ts.showTaskList();
		model.addAttribute("task_list", task_list);
		return "index.html";
	}
}
