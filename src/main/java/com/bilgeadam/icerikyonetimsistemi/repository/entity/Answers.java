package com.bilgeadam.icerikyonetimsistemi.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_answers")
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	private Questions questions;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String answers;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(columnDefinition = "BOOLEAN default true")
	private boolean isEnabled;

	public Answers() {
		super();
		this.isEnabled = true;
	}

	public Answers(Questions questions, User user, String answers, Date createAt, Date updatedAt) {
		super();
		this.questions = questions;
		this.user = user;
		this.answers = answers;
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

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
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
		return "Answers [id=" + id + ", questions=" + questions + ", user=" + user + ", answers=" + answers
				+ ", createAt=" + createAt + ", updatedAt=" + updatedAt + ", isEnabled=" + isEnabled + "]";
	}

}
