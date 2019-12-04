package com.fivepoints.fivesn.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 80, nullable = false)
	private String name;
	@Column(length = 80, nullable = false)
	private String surname;
	@Column(length = 80, nullable = false)
	@Email
	private String email;
	@Column(length = 80, nullable = false)
	private String password;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private Long phone;
	@Column(length = 80, nullable = false)
	private String description;
	private Role role;
	private Gender gender;
	private Boolean enabled;
	private Boolean blocked;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthDay(Date birthDay) {
		this.birthday = birthDay;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User() {
		super();
	}

	public User(String name, String surname, @Email String email, String password, Date birthday, Long phone,
			String description, Role role, Gender gender, Boolean enabled, Boolean blocked) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phone = phone;
		this.description = description;
		this.role = role;
		this.gender = gender;
		this.enabled = enabled;
		this.blocked = blocked;
	}

}
