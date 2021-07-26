package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

}
