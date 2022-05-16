package com.codingdojo.DinosaurLovers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DinosaurLovers.models.Dinosaur;
import com.codingdojo.DinosaurLovers.models.User;
import com.codingdojo.DinosaurLovers.repositories.DinosaurRepository;

@Service
public class DinosaurService {
	
	private final DinosaurRepository repo;
	
	public DinosaurService(DinosaurRepository r) {
		this.repo = r;
	}
	
	//SHOW ALL DINOSAURS
	public List<Dinosaur> allDinosaurs(){
		return repo.findAll();
	}
	
	//CREATE A DINOSAUR
	public Dinosaur createDino(Dinosaur d) {
		return repo.save(d);
	}
	
	//UPDATE A DINOSAUR
	public Dinosaur updateDino(Dinosaur d) {
		return repo.save(d);
	}
	
	//Find a Dino of User
	public List<Dinosaur> findDinoOfUser(User u){
		return repo.findAllByUser(u);
	}
	
	//Retrieve a specefic Dino
	public Dinosaur findDinoById(Long id) {
		Optional<Dinosaur> optionalDino = repo.findById(id);
		
		if(optionalDino.isPresent()) {
			return optionalDino.get();
		}
		else {
			return null;
		}
	}
	
	//DELETE
	public void deleteDino(Long id) {
		Optional<Dinosaur> deleteIt = repo.findById(id);
		if(deleteIt.isPresent()) {
			repo.deleteById(id);
		}
	}

}
