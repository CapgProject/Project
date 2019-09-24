package com.cg.TestManagement.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class OnlineTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private Long testId;
	@Column(name = "test_name")
	private String testName;
	@Column(name = "test_duration")
	private LocalTime testDuration;
	
	@OneToMany(mappedBy = "onlinetest", cascade=CascadeType.ALL)
	private Set<Question> testQuestions;
	@Column(name = "test_total_marks")
	private Double testTotalMarks;
	@Column(name = "test_marks_scored")
	private Double testMarksScored;
	@Column(name = "test_start_time")
	private LocalDateTime startTime;
	@Column(name = "test_end_time")
	private LocalDateTime endTime;
	@Column(name = "is_test_assigned")
	private Boolean isTestAssigned;
	@Column(name = "is_deleted")
	private Boolean isDeleted;

	public OnlineTest() {
		super();
	}

	public OnlineTest(String testName, LocalTime testDuration, Set<Question> testQuestions,
			Double testTotalMarks, Double testMarksScored, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.testId = null;
		this.testName = testName;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isTestAssigned = false;
		this.isDeleted = false;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public Set<Question> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public Double getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(Double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public Double getTestMarksScored() {
		return testMarksScored;
	}

	public void setTestMarksScored(Double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsTestAssigned() {
		return isTestAssigned;
	}

	public void setIsTestAssigned(Boolean isTestAssigned) {
		this.isTestAssigned = isTestAssigned;
	}
	
	public Boolean getIsdeleted() {
		return isDeleted;
	}

	public void setIsdeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "OnlineTest [testId=" + testId + ", testName=" + testName + ", testDuration=" + testDuration
				+ ", testQuestions=" + testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", startTime=" + startTime + ", endTime=" + endTime + ", isTestAssigned="
				+ isTestAssigned + "]";
	}

	@Override
	public int hashCode() {
		return this.testId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null)
		{
			return this.hashCode() == obj.hashCode();
		}
		else {
			return false;
		}
	}
}
