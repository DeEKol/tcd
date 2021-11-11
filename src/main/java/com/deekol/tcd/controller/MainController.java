package com.deekol.tcd.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deekol.tcd.repository.TripRepository;

@Controller
@RequestMapping("/")
public class MainController {
	private final TripRepository tripRepository;
	
	public MainController(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}
	
	@GetMapping
	public String main(Model model) {		
		model.addAttribute("frontendData", tripRepository.findAll());
		
		return "index";
	}
}
