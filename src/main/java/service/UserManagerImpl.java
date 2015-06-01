package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;
import exceptions.CreateAccountException;
import exceptions.WrongLoginOrPassword;
import exceptions.accountcreateexcpetions.EmailAlreadyInUse;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;

public class UserManagerImpl extends UserManager {

	private Session session;

	public User getUserByLogin(final String login) throws LoginAlreadyInUse {
		User user = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			user = (User) session.createQuery("from User" + " where login = ?").setString(0, login).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (user != null) {
			throw new LoginAlreadyInUse("Given login is already in use!");
		}
		return user;
	}

	public void getUserByEmail(final String email) throws EmailAlreadyInUse {
		User user = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			user = (User) session.createQuery("from User" + " where email = ?").setString(0, email).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (user != null) {
			throw new EmailAlreadyInUse("Given email is already in use!");
		}
	}

	public void saveUser(final User user) throws CreateAccountException {

		 getUserByEmail(user.getEmail());
		 getUserByLogin(user.getLogin());
		 try {
		 Session session = HibernateUtil.getSessionFactory()
		 .getCurrentSession();
		 session.beginTransaction();
		
		 session.saveOrUpdate(user);
		 session.getTransaction().commit();
		 // } catch (LoginAlreadyInUse e) {
		 // throw new
		 // CreateAccountException("This login is already in use. You have to choose another one.");
		 // } catch (EmailAlreadyInUse e) {
		 // throw new
		 // CreateAccountException("This email is already in use. You have to choose another one.");
		 } catch (HibernateException e) {
		 session.getTransaction().rollback();
		 throw new CreateAccountException("HibernateException");
		 }

	}

	public void loginUser(final String login, final String password) throws WrongLoginOrPassword {
		User user = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			user = (User) session.createQuery("from User" + " where login = ?" + " and password = ?")
					.setString(0, login).setString(1, password).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		if (user == null) {
			throw new WrongLoginOrPassword("Wrong login or password");
		}
	}
	
	@SuppressWarnings("unchecked")
	public User findUserByLogin(String login) {
		List<User> users = new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			users = session.createQuery("from User" + " where login = ?").setString(0, login).list();
			session.getTransaction().commit();
			if (users.size() > 0) {
				return users.get(0);
			} 
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}
		return null;
	}

}
