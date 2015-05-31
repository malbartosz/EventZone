package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Entity;

/**
 * @author Zu
 *
 */
@Entity
public class User {
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;

	private List<Event> events = new ArrayList<Event>(0);

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public String toString() {
		return "p: " + password + " " + "l: " + login + " " + "n: " + name
				+ " " + "s: " + surname + " " + "e: " + email;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
