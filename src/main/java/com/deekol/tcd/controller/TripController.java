package com.deekol.tcd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.tcd.domain.TripEntity;
import com.deekol.tcd.repository.TripRepository;

@RestController
@RequestMapping("trip")
public class TripController {
	private final TripRepository tripRepository;
	
	public TripController(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}
	
	@GetMapping
	public List<TripEntity> list() {
		return tripRepository.findAll();
	}
	
	@GetMapping("{id}")
	public TripEntity getOne(@PathVariable("id") TripEntity trip) {
		return trip;
	}
	
}
