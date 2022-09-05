package com.bilgeadam.icerikyonetimsistemi.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_lesson")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(columnDefinition = "BOOLEAN default true")
	private boolean isEnabled;

	public Lesson() {
		super();
		this.isEnabled = true;
	}

	public Lesson(String name, String description, Date createAt, Date updatedAt) {
		super();
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Lesson [id=" + id + ", name=" + name + ", description=" + description + ", createAt=" + createAt
				+ ", updatedAt=" + updatedAt + ", isEnabled=" + isEnabled + "]";
	}

}
