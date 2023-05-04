package com.codingdojo.DojoandNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.DojoandNinjas.models.Ninja;


@Repository 
public interface Ninjarepo extends CrudRepository<Ninja, Long>{ 
	List<Ninja> findAll();
}

