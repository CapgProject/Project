package com.cg.TestManagement.dto;

import java.math.BigInteger;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String[] questionOptions;
	private String questionTitle;
	private Integer questionAnswer;
	private Double questionMarks;
	private Integer chosenAnswer;
	private Double marksScored;
	private Boolean isDeleted;

	@ManyToOne
	@JoinColumn(name = "test_id")
	private OnlineTest onlinetest;

	public OnlineTest getOnlinetest() {
		return onlinetest;
	}

	public void setOnlinetest(OnlineTest onlinetest) {
		this.onlinetest = onlinetest;
	}

	public Question() {
		super();
	}

	public Question(Long questionId, String[] questionOptions, String questionTitle, Integer questionAnswer,
			Double questionMarks, Double marksScored, BigInteger testId) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = -1;
		this.marksScored = marksScored;
		this.isDeleted = false;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String[] getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(String[] questionOptions) {
		this.questionOptions = questionOptions;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public Double getQuestionMarks() {
		return questionMarks;
	}

	public void setQuestionMarks(Double questionMarks) {
		this.questionMarks = questionMarks;
	}

	public Integer getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(Integer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public Double getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(Double marksScored) {
		this.marksScored = marksScored;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionOptions=" + Arrays.toString(questionOptions)
				+ ", questionTitle=" + questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks="
				+ questionMarks + ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + ", testId=" + "]";
	}

	@Override
	public int hashCode() {
		return this.questionId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			return this.hashCode() == obj.hashCode();
		} else {
			return false;
		}
	}

}
