package com.deekol.tcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.tcd.domain.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Long>{
}
