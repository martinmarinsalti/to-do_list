package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/")
	public String addTask(@RequestParam String nt) {
		ts.loadTask(nt);
		System.out.println("PASA");
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String removeTask(@PathVariable("id") Integer id) {	
		try {
			ts.deleteTask(id);
			return "redirect:/";
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}
		
	@GetMapping("/")
	public String editingTask(@PathVariable ("id") Integer idEd) {
		ts.editTask(idEd);
		return "redirect:/";
	}
}
