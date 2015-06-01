package service;

import model.User;
import exceptions.CreateAccountException;
import exceptions.WrongLoginOrPassword;
import exceptions.accountcreateexcpetions.EmailAlreadyInUse;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;

public abstract class UserManager {

	public abstract User getUserByLogin(String login) throws LoginAlreadyInUse;

	public abstract void getUserByEmail(String email) throws EmailAlreadyInUse;

	public abstract void saveUser(User user) throws CreateAccountException;

	public abstract void loginUser(String login, String password)
			throws WrongLoginOrPassword;
	
	public abstract User findUserByLogin(String login);

	public void testService() {
		System.out.println("service works");
	}
}
