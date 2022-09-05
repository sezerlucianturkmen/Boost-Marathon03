package com.bilgeadam.icerikyonetimsistemi.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(length = 64)
	private String name;
	@Column(length = 64)
	private String surname;
	@Enumerated(EnumType.STRING)
	private ERole role;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(columnDefinition = "BOOLEAN default true")
	private boolean isEnabled;

	public User() {
		super();
		this.isEnabled = true;
	}

	public User(String name, String surname, ERole role, Date createAt, Date updatedAt) {
		super();
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
		this.isEnabled = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", role=" + role + ", createAt="
				+ createAt + ", updatedAt=" + updatedAt + ", isEnabled=" + isEnabled + "]";
	}

}
