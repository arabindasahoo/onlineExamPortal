package com.exam.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	
	@Column(length = 5000)
	private String content;
	
	private String answer;
	
	@Transient
	private String givenAnswer;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String image;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Question(String content, String answer, String option1, String option2, String option3, String option4,
			String image) {
		super();
		this.content = content;
		this.answer = answer;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.image = image;
	}


	public Long getQid() {
		return qid;
	}


	public void setQid(Long qid) {
		this.qid = qid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public String getGivenAnswer() {
		return givenAnswer;
	}


	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}
	
	
	
	
}
