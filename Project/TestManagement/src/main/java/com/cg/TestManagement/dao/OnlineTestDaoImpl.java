package com.cg.TestManagement.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.usertype.UserCollectionType;

import com.cg.TestManagement.dto.Question;
import com.cg.TestManagement.dto.OnlineTest;
import com.cg.TestManagement.dto.User;
import com.cg.TestManagement.exception.UserException;
import com.cg.TestManagement.util.DbUtil;

public class OnlineTestDaoImpl implements OnlineTestDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction transaction;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("testmanagement");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
	}
	public OnlineTestDaoImpl() {
		super();
	}



	public OnlineTest saveTest(OnlineTest onlineTest) throws UserException {
		// TODO Auto-generated method stub
		transaction.begin();
	    entityManager.persist(onlineTest);
		transaction.commit();
		return onlineTest;
	}

		
		
		
	public OnlineTest searchTest(BigInteger testId) throws UserException {
		// TODO Auto-generated method stub
	}

	public OnlineTest removeTest(BigInteger testId) throws UserException {
		
		OnlineTest onlineTest=entityManager.find(OnlineTest.class, testId);
		if(onlineTest!=null) {
		transaction.begin();
		onlineTest.setIsdeleted(true);
		transaction.commit();
		}
	}
		
	@Override
	public OnlineTest updateTest(OnlineTest test) throws UserException {
		// TODO Auto-generated method stub
		
	}
	
	public Question saveQuestion(Question question) throws UserException {
		// TODO Auto-generated method stub
		transaction.begin();
	    entityManager.persist(question);
		transaction.commit();
		return question;
		
	}

	public Question searchQuestion(BigInteger questId) throws UserException {
		// TODO Auto-generated method stub
		
	}

	public Question removeQuestion(BigInteger questId) throws UserException {
		 
		Question question=entityManager.find(Question.class, questId);
		if(question!=null)
		{
			transaction.begin();
			question.setIsDeleted(true);
			transaction.commit();
		}
		
	}
		

	
	@Override
	public Question updateQuestion(Question question) throws UserException {
		Book bookToBeUpdated
	}
		
	}

	public User saveUser(User user) throws UserException {
		
		transaction.begin();
	    entityManager.persist(user);
		transaction.commit();
		return user;
	}
		
	

	public User searchUser(BigInteger userId) throws UserException {
		// TODO Auto-generated method stub
		
		User user =entityManager.find(User.class, userId);
		if(user!=null)
			return user;
		else 
			return null;
		
		
	}

	public User removeUser(BigInteger userId) throws UserException {
		// TODO Auto-generated method stub
		User user=entityManager.find(User.class,userId);
		if(user!=null)
		{
			transaction.begin();
			user.setIsDeleted(true);
			transaction.commit();
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		// TODO Auto-generated method stub
		User user=entityManager.find(User.class, user.getUserId());
		
		
		
		
		

}
