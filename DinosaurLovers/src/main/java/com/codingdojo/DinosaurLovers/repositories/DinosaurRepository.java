package com.codingdojo.DinosaurLovers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.DinosaurLovers.models.Dinosaur;
import com.codingdojo.DinosaurLovers.models.User;


public interface DinosaurRepository extends CrudRepository<Dinosaur, Long>{
	List<Dinosaur> findAll();
	List<Dinosaur> findAllByUser(User user);
}
