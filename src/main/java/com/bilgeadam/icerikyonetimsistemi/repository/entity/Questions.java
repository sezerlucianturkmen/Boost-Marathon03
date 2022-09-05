package com.bilgeadam.icerikyonetimsistemi.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private SubjectDetail subjectDetail;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(length = 64, unique = true)
	private String title;
	@Column(length = 255)
	private String question;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(columnDefinition = "BOOLEAN default true")
	private boolean isEnabled;

	public Questions() {
		super();
		this.isEnabled = true;
	}

	public Questions(SubjectDetail subjectDetail, User user, String title, String question, Date createAt,
			Date updatedAt) {
		super();
		this.subjectDetail = subjectDetail;
		this.user = user;
		this.title = title;
		this.question = question;
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

	public SubjectDetail getSubjectDetail() {
		return subjectDetail;
	}

	public void setSubjectDetail(SubjectDetail subjectDetail) {
		this.subjectDetail = subjectDetail;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
		return "Questions [id=" + id + ", subjectDetail=" + subjectDetail + ", user=" + user + ", title=" + title
				+ ", question=" + question + ", createAt=" + createAt + ", updatedAt=" + updatedAt + ", isEnabled="
				+ isEnabled + "]";
	}

}
