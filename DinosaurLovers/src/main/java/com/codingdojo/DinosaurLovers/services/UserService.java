package com.codingdojo.DinosaurLovers.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.DinosaurLovers.models.LoginUser;
import com.codingdojo.DinosaurLovers.models.User;
import com.codingdojo.DinosaurLovers.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository use) {
		this.userRepo = use;
	}
	
	//SHOW ALL USERS
	public List<User> allUsers(){
		return userRepo.findAll();
	}
//==========================================================================================
	//Retrieve a specefic User
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
//==========================================================================================
	public User createUser(User newUser, BindingResult result) {
		
		Optional<User> user = userRepo.findByEmail(newUser.getEmail());
		
		if(user.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email exists!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "The confirm password does not match the entered password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashPass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashPass);
		return userRepo.save(newUser);
	}
//==========================================================================================
	public User login(LoginUser loginUser, BindingResult result) {
		
		Optional<User> logUser = userRepo.findByEmail(loginUser.getEmail());
		
		if(!logUser.isPresent()) {
			result.rejectValue("email", "Matches", "There is no user with this email");
			return null;
		}
		
			User user = logUser.get();
			if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid email/password");
			}
			if(result.hasErrors()) {
				return null;
			}
			return user;
	}
//==========================================================================================
	public User findByEmail(String e) {
		Optional<User> result = userRepo.findByEmail(e);
		if(result.isPresent()) {
			return result.get();
		}
		else {
			return null;
		}
	}

}
