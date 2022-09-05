package com.bilgeadam.icerikyonetimsistemi.repository.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_subjectdetail")
public class SubjectDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(length = 64, unique = true)
	private String title;
	@Column(length = 120)
	private String description;
	@Column(length = 5000)
	private String article;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(columnDefinition = "BOOLEAN default true")
	private boolean isEnabled;

	public SubjectDetail() {
		super();
		this.isEnabled = true;
	}

	public SubjectDetail(Subject subject, User user, String title, String description, String article, Date createAt,
			Date updatedAt) {
		super();
		this.subject = subject;
		this.user = user;
		this.title = title;
		this.description = description;
		this.article = article;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
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
		return "SubjectDetail [id=" + id + ", subject=" + subject + ", user=" + user + ", title=" + title
				+ ", description=" + description + ", article=" + article + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + ", isEnabled=" + isEnabled + "]";
	}

}
