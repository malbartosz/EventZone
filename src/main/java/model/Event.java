package model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zu
 *
 */

public class Event {

	public Event() {
	};
	
	public Event(String name, Date dateOfEvent, String subtitle, String organizer, String place, String description, String picture,  String backgroundFile) {
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.dateOfEvent = dateOfEvent;
		this.place = place;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
	}
	
	public Event(int id, String name, Date dateOfEvent, String subtitle, String organizer, String place, String description, String picture,  String backgroundFile) {
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.dateOfEvent = dateOfEvent;
		this.place = place;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
	}
	
	public Event(int id, String name, String subtitle, String organizer,
			String place, Date dateOfEvent, Date dateOfCreation,
			String description, String picture, String backgroundFile, Set<Ticket> tickets,
			Set<Participant> participants) {
		super();
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.place = place;
		this.dateOfEvent = dateOfEvent;
		this.dateOfCreation = dateOfCreation;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
		this.tickets = tickets;
		this.participants = participants;
	}

	private int id;
	private String name;
	private String subtitle;
	private String organizer;
	private String place;
	private Date dateOfEvent;
	private Date dateOfCreation;
	private String description;
	private String picture;
	private String backgroundFile;

	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	private Set<Participant> participants = new HashSet<Participant>(0);

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfEvent() {
		return dateOfEvent;
	}

	public void setDateOfEvent(Date dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getBackgroundFile() {
		return backgroundFile;
	}

	public void setBackgroundFile(String backgroundFile) {
		this.backgroundFile = backgroundFile;
	}
}
