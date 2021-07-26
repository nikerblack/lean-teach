package com.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;
import com.demo.entity.Position;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e join e.persona p where p.name like ?1 ")
	List<Employee> findEmployeesByName(String name);
	
	@Query("select e from Employee e join e.position p where p.name like ?1 ")
	List<Employee> findEmployeesByPosition(String name);

	@Query("select e from Employee e join e.persona p join e.position pt where p.name like ?1 and pt.name like ?2 ")
	List<Employee> findEmployeesByNameAndPosition(String name, Double postion);
	
	List<Employee> findByPosition(Position postion, Sort sort);

	
}
