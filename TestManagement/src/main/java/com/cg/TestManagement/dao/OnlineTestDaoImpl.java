package com.cg.TestManagement.dao;

import java.util.Properties;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.TestManagement.dto.Question;
import com.cg.TestManagement.dto.OnlineTest;
import com.cg.TestManagement.dto.User;
import com.cg.TestManagement.exception.ExceptionMessage;
import com.cg.TestManagement.exception.UserException;

public class OnlineTestDaoImpl implements OnlineTestDao {

	private static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("OnlineTestManagement");
	private static EntityManager entitymanager = entityFactory.createEntityManager();
//	private PreparedStatement preparedStatement;
//	private ResultSet resultSet;
	private static Logger myLogger;

	static {

		Properties props = System.getProperties();
		String userDir = props.getProperty("user.dir") + "/src/main/resources/";
		PropertyConfigurator.configure(userDir + "log4j.properties");
		myLogger = Logger.getLogger("OnlineTestDaoImpl.class");
	}

//	public void closePreparedStatement() {
//		if (preparedStatement != null) {
//			try {
//				preparedStatement.close();
//			} catch (SQLException e) {
//				myLogger.error(e);
//			}
//		}
//	}
	
	public Set<Question> getQuestionSet(Long testId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		OnlineTest test = entitymanager.find(OnlineTest.class, testId);
		if(test != null) {
			return test.getTestQuestions();
		}
		else {
			throw new UserException(ExceptionMessage.TESTNOTFOUNDMESSAGE);
		}
	}

	@Override
	public OnlineTest saveTest(OnlineTest onlineTest) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		entitymanager.persist(onlineTest);
		transaction.commit();
		return onlineTest;
	}

	@Override
	public OnlineTest searchTest(Long testId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		OnlineTest test = entitymanager.find(OnlineTest.class, testId);
		if(test != null) {
			return test;
		}
		else {
			throw new UserException(ExceptionMessage.TESTNOTFOUNDMESSAGE);
		}
	}

	@Override
	public OnlineTest removeTest(Long testId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		OnlineTest test = entitymanager.find(OnlineTest.class, testId);
		if(test != null) {
			test.setIsdeleted(true);;
			transaction.commit();
			return test;
		}
		else {
			throw new UserException(ExceptionMessage.TESTNOTFOUNDMESSAGE);
		}
	}

	@Override
	public OnlineTest updateTest(OnlineTest test) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		OnlineTest foundTest = entitymanager.find(OnlineTest.class, test.getTestId());
		if(foundTest != null) {
			foundTest.setTestId(test.getTestId());
			foundTest.setTestName(test.getTestName());
			foundTest.setTestTotalMarks(test.getTestTotalMarks());
			foundTest.setTestQuestions(test.getTestQuestions());
			foundTest.setTestDuration(test.getTestDuration());
			foundTest.setStartTime(test.getStartTime());
			foundTest.setEndTime(test.getEndTime());
			foundTest.setIsTestAssigned(test.getIsTestAssigned());
			foundTest.setIsdeleted(test.getIsdeleted());
			foundTest.setTestMarksScored(test.getTestMarksScored());
			transaction.commit();
			return foundTest;
		}
		else {
			throw new UserException(ExceptionMessage.TESTNOTFOUNDMESSAGE);
		}
	}

	@Override
	public Question saveQuestion(Question question) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		entitymanager.persist(question);
		transaction.commit();
		return question;
	}

	@Override
	public Question searchQuestion(Long questId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		Question question = entitymanager.find(Question.class, questId);
		if(question != null) {
			return question;
		}
		else {
			throw new UserException(ExceptionMessage.QUESTIONMESSAGE);
		}
	}

	@Override
	public Question removeQuestion(Long questId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		Question question = entitymanager.find(Question.class, questId);
		if(question != null) {
			question.setIsDeleted(true);
			transaction.commit();
			return question;
		}
		else {
			throw new UserException(ExceptionMessage.QUESTIONMESSAGE);
		}
	}

	@Override
	public Question updateQuestion(Question question) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		Question foundQuestion = entitymanager.find(Question.class, question.getQuestionId());
		if(foundQuestion != null) {
			foundQuestion.setQuestionId(question.getQuestionId());
			foundQuestion.setQuestionTitle(question.getQuestionTitle());
			foundQuestion.setQuestionOptions(question.getQuestionOptions());
			foundQuestion.setQuestionMarks(question.getQuestionMarks());
			foundQuestion.setChosenAnswer(question.getChosenAnswer());
			foundQuestion.setIsDeleted(question.getIsDeleted());
			foundQuestion.setMarksScored(question.getMarksScored());
			foundQuestion.setQuestionAnswer(question.getQuestionAnswer());
			transaction.commit();
			return foundQuestion;
		}
		else {
			throw new UserException(ExceptionMessage.QUESTIONMESSAGE);
		}
	}

	@Override
	public User saveUser(User user) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
	    entitymanager.persist(user);
		transaction.commit();
		return user;
	}

	@Override
	public User searchUser(Long userId) throws UserException {
		//EntityTransaction transaction = entitymanager.getTransaction();
		User user = entitymanager.find(User.class, userId);
		if(user!=null) {
			return user;
		}
		else {
			throw new UserException(ExceptionMessage.USERMESSAGE);
		}
	}

	@Override
	public User removeUser(Long userId) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		User user = entitymanager.find(User.class,userId);
		if(user!=null)
		{
			transaction.begin();
			user.setIsDeleted(true);
			transaction.commit();
			return user;
		}
		else {
			throw new UserException(ExceptionMessage.USERMESSAGE);
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		EntityTransaction transaction = entitymanager.getTransaction();
		User foundUser = entitymanager.find(User.class, user.getUserId());
		if(foundUser != null) {
			transaction.begin();
			foundUser.setUserId(user.getUserId());
			foundUser.setUserName(user.getUserName());
			foundUser.setUserPassword(user.getUserPassword());
			foundUser.setUserTest(user.getUserTest());
			foundUser.setIsAdmin(user.getIsAdmin());
			foundUser.setIsDeleted(user.getIsDeleted());
			transaction.commit();
			return foundUser;
		}
		else {
			throw new UserException(ExceptionMessage.USERMESSAGE);
		}
	}

}