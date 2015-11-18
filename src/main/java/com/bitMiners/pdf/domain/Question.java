package com.bitMiners.pdf.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Question {

	@Id @GeneratedValue
	private int id;
	@NotEmpty
	private String heading;
	@NotEmpty
	private String questionContent;
    private Date dateCreated;
    
    @ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
    @JoinColumn(name="questionType_id")
    private QuestionType questionType;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="question")
    private List<Answer> answers;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    public Question(){}

    
	public String getHeading() {
		return heading;
	}


	public void setHeading(String heading) {
		this.heading = heading;
	}


	public QuestionType getQuestionType() {
		return questionType;
	}


	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}


	public List<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
    
}
