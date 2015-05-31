package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Zu
 *
 */
public class Participant {
	
	public Participant(){};
	
	public Participant(int eventId, String personId, int ifPaid,
			int ticketId, Ticket ticket, Event event, User person) {
		super();
		this.eventId = eventId;
		this.personId = personId;
		this.ifPaid = ifPaid;
		this.ticketId = ticketId;
		this.ticket = ticket;
		this.event = event;
		this.person = person;
	}
	 @Id
	   @SequenceGenerator(name = "EVENTZONE.PARTICIPANTS_SEQ1", sequenceName = "EVENTZONE.PARTICIPANTS_SEQ1", allocationSize = 1)
	   @GeneratedValue(generator = "EVENTZONE.PARTICIPANTS_SEQ1", strategy = GenerationType.SEQUENCE)
	private int id;
	private int eventId;
	private String personId;
	private int ifPaid;
	private int ticketId;

	@ManyToOne
	@JoinColumn(name = "ticketId", referencedColumnName = "id")
	private Ticket ticket;
	
	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "personId", referencedColumnName = "login")
	private User person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public int getIfPaid() {
		return ifPaid;
	}

	public void setIfPaid(int ifPaid) {
		this.ifPaid = ifPaid;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
	}
}
