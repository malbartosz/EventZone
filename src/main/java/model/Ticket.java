package model;

import java.util.HashSet;
import java.util.Set;

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
public class Ticket {

	public Ticket() {
	};

	public Ticket(int eventId, int quantity, float cost, int id,
			Set<Participant> participants, Event event) {
		super();
		this.eventId = eventId;
		this.quantity = quantity;
		this.cost = cost;
		this.id = id;
		this.participants = participants;
		this.event = event;
	}

	public Ticket(int eventId, int quantitu, float cost) {
		super();
		this.eventId = eventId;
		this.quantity = quantitu;
		this.cost = cost;
	}

	private int eventId;
	private int quantity;
	private float cost;
	@Id
	@SequenceGenerator(name = "EVENTZONE.TICKETS_SEQ1", sequenceName = "EVENTZONE.TICKETS_SEQ1", allocationSize = 1)
	@GeneratedValue(generator = "EVENTZONE.TICKETS_SEQ1", strategy = GenerationType.SEQUENCE)
	private int id;
	private Set<Participant> participants = new HashSet<Participant>(0);

	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "id")
	private Event event;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
