package com.cg.TestManagement.test;

import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.TestManagement.exception.UserException;
import com.cg.TestManagement.dto.OnlineTest;
import com.cg.TestManagement.dto.Question;
import com.cg.TestManagement.dto.User;
import com.cg.TestManagement.service.Service;
import com.cg.TestManagement.service.ServiceImpl;

class OnlineTestManagementJUnit {

	Service service;

	@BeforeEach
	void createObject() {
		service = new ServiceImpl();
	}

	@Test
	void assignTestUnitTest() throws UserException{		
		Assertions.assertEquals(new Boolean(true), service.assignTest(Long.valueOf(7), Long.valueOf(10)));
		Assertions.assertThrows(UserException.class, ()->{service.assignTest(Long.valueOf(3), Long.valueOf(2));});
	}

	@Test
	void searchUserUnitTest() throws UserException {
		Assertions.assertEquals("Swanand", service.searchUser(Long.valueOf(1)).getUserName());
		Assertions.assertThrows(UserException.class, ()->{service.searchUser(Long.valueOf(100));});
	}

	@Test
	void searchTestUnitTest() throws UserException {
		Assertions.assertEquals("opopop", service.searchTest(Long.valueOf(2)).getTestName());
		Assertions.assertThrows(UserException.class, ()->{service.searchTest(Long.valueOf(101));});
	}
	
	@Test
	void chosenAnswerUnitTest() throws UserException {
		OnlineTest test = service.searchTest(Long.valueOf(1));
		Question question = service.showQuestion(test, Long.valueOf(101));
		Assertions.assertTrue(question.getChosenAnswer()>=0 && question.getChosenAnswer()<=3);
		Assertions.assertFalse(question.getChosenAnswer()>=4);
	}
	
	@Test
	void registerUserUnitTest() throws UserException {
		User addedUser = new User(null, "Ram", "Ramnaresh@123", null, new Boolean(false));
		User registeredUser = service.registerUser(addedUser);
		Assertions.assertEquals(registeredUser, service.searchUser(addedUser.getUserId()));
	}
	
	@Test
	void answerQuestionUnitTest() throws UserException {
		OnlineTest test = service.searchTest(Long.valueOf(2));
		Question question = service.showQuestion(test, Long.valueOf(102));
		Assertions.assertEquals(new Boolean(true), service.answerQuestion(test, question, 1));
		Assertions.assertThrows(UserException.class, ()->{service.answerQuestion(service.searchTest(Long.valueOf(10)), question, 2);});
	}
	
	@Test
	void addTestUnitTest() throws UserException {
		LocalTime duration = LocalTime.of(10, 00, 00);
		LocalDateTime startTime = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 10, 00, 00);
		LocalDateTime endTime = LocalDateTime.of(2019, Month.OCTOBER, 10, 10, 00, 00);
		Set<Question> testQuestions = new HashSet<Question>();
		OnlineTest test = new OnlineTest("Programming", duration, testQuestions, new Double(10), new Double(10), startTime, endTime);
		OnlineTest addedTest = service.addTest(test);
		Assertions.assertEquals(addedTest, service.searchTest(addedTest.getTestId()));
	}
	
	@AfterEach
	void deleteReference() {
		service = null;
	}

}