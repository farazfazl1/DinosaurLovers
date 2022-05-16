package com.codingdojo.DinosaurLovers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="dinosaurs")
public class Dinosaur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Name must be between 1 - 100 characters long")
	private String name;
	
	@NotNull
	@Min(value = 80, message = "Must be at least 80 pounds")
	private Integer size;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Habitat must be between 1 - 100 characters long")
	private String habitat;
	
	@NotNull
	@Size(min = 2, max = 200, message = "Diet must be between 2 - 200 characters long")
	private String diet;

	@NotNull
	@Size(min = 5, max = 400, message = "Facts must be between 5 - 400 characters long")
	private String facts;
	
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    public Dinosaur() {}

	public Dinosaur(Long id,
			@NotNull @Size(min = 1, max = 100, message = "Name must be between 1 - 100 characters long") String name,
			@NotNull @Min(value = 80, message = "Must be at least 80 pounds") Integer size,
			@NotNull @Size(min = 1, max = 100, message = "Habitat must be between 1 - 100 characters long") String habitat,
			@NotNull @Size(min = 2, max = 200, message = "Diet must be between 2 - 200 characters long") String diet,
			@NotNull @Size(min = 5, max = 400, message = "Facts must be between 5 - 400 characters long") String facts,
			Date createdAt, Date updatedAt, User user) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.habitat = habitat;
		this.diet = diet;
		this.facts = facts;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getFacts() {
		return facts;
	}

	public void setFacts(String facts) {
		this.facts = facts;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}