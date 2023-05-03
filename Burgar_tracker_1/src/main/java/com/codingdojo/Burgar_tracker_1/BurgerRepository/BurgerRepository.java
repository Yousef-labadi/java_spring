package com.codingdojo.Burgar_tracker_1.BurgerRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Burgar_tracker_1.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	// this method retrieves all the burgers from the database
	List<Burger> findAll();
	
	
	

}
