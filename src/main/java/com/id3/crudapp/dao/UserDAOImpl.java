package com.id3.crudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.id3.crudapp.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<User> findAll() {
		//get the current hibernate session
			Session currentSession=entityManager.unwrap(Session.class);
			
		//create query
			Query<User> theQuery=currentSession.createQuery("from User",User.class);
			
		//execute query and get the result list
			List<User> users=theQuery.getResultList();
			
		//return the results
			return users;
	}

	@Override
	public User findById(int theId) {
		//get the current hibernate session
			Session currentSession=entityManager.unwrap(Session.class);
			
		//get required user from database based on id
			User theUser = currentSession.get(User.class, theId);	
			
		//return user
			return theUser;
	}

	@Override
	public void save(User theUser) {
		//get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//save or update user. if id = 0 ==> creates new user else updates user matched by id.
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from User where id=:userid");
		
		theQuery.setParameter("userid", theId);
		
		theQuery.executeUpdate();
	}

}
