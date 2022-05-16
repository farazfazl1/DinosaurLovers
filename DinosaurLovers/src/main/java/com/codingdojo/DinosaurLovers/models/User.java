package com.codingdojo.DinosaurLovers.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 200, message = "Username must be 5 - 200 characters long")
	private String userName;
	
	@NotNull
	@Size(min = 5, max = 200, message = "Email must be 5 - 200 characters long")
	@Email(message = "Please enter a valid email address")
	private String email;
	
	@NotNull
	@Size(min = 8, max= 128, message="Password must be between 8 - 128 characters long!")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm password is required!")
	@Size(min = 8, max = 128, message = "")
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Dinosaur> dinosaurs;
    
    public User() {}

	

	public User(Long id,
			@NotNull @Size(min = 5, max = 200, message = "Username must be 5 - 200 characters long") String userName,
			@NotNull @Size(min = 5, max = 200, message = "Email must be 5 - 200 characters long") @Email(message = "Please enter a valid email address") String email,
			@NotNull @Size(min = 8, max = 128, message = "Password must be between 8 - 128 characters long!") String password,
			@NotEmpty(message = "Confirm password is required!") @Size(min = 8, max = 128, message = "") String confirmPassword,
			Date createdAt, Date updatedAt, List<Dinosaur> dinosaurs) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dinosaurs = dinosaurs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Dinosaur> getDinosaurs() {
		return dinosaurs;
	}

	public void setDinosaurs(List<Dinosaur> dinosaurs) {
		this.dinosaurs = dinosaurs;
	}
}
