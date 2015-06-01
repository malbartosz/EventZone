package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Zu
 *
 */

public class Event {

	public Event() {
	};

	public Event(String name, String dateOfEvent, String dateOfCreation, String subtitle,
			String organizer, String place, String description, String picture,
			String backgroundFile, String timeOfEvent) {
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.dateOfEvent = dateOfEvent;
		this.place = place;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
		this.timeOfEvent = timeOfEvent;
		this.dateOfCreation = dateOfCreation;
	}
	
	public Event(String name, String dateOfEvent, String subtitle,
			String organizer, String place, String description, String picture,
			String backgroundFile, String timeOfEvent) {
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.dateOfEvent = dateOfEvent;
		this.place = place;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
		this.timeOfEvent = timeOfEvent;
	}

	public Event(int id, String name, String dateOfEvent, String subtitle,
			String organizer, String place, String description, String picture,
			String backgroundFile, String timeOfEvent) {
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.dateOfEvent = dateOfEvent;
		this.place = place;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
		this.timeOfEvent = timeOfEvent;
	}

	public Event(int id, String name, String subtitle, String organizer,
			String place, String dateOfEvent, String dateOfCreation,
			String description, String picture, String backgroundFile,
			Set<Ticket> tickets, Set<Participant> participants,
			String timeOfEvent) {
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
		this.timeOfEvent = timeOfEvent;
	}

	@Id
	@SequenceGenerator(name = "EVENTZONE.EVENTS_SEQ", sequenceName = "EVENTZONE.EVENTS_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "EVENTZONE.EVENTS_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String subtitle;
	private String organizer;
	private String place;
	private String dateOfEvent;
	private String dateOfCreation;
	private String description;
	private String picture;
	private String backgroundFile;
	private String timeOfEvent;

	private Set<Ticket> tickets = new HashSet<Ticket>(0);
	private Set<Participant> participants = new HashSet<Participant>(0);

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getDateOfEvent() {
		return dateOfEvent;
	}

	public void setDateOfEvent(String dateOfEvent) {
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

	public String getTimeOfEvent() {
		return timeOfEvent;
	}

	public void setTimeOfEvent(String timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}
}
