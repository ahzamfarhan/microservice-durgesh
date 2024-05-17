package com.lcwd.userservice.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lcwd.userservice.models.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "micro_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@Column(name = "id")
	private String userId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "about")
	private String about;
	@Transient
	private List<Rating> ratings = new ArrayList<Rating>();
}
