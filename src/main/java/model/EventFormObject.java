package model;

public class EventFormObject {
	public EventFormObject() {
	};
	
	public EventFormObject(String name, String dateOfEvent, String subtitle, String organizer, String place, String description, String picture,  String backgroundFile, String timeOfEvent) {
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
	
	public EventFormObject(int id, String name, String subtitle, String organizer,
			String place, String dateOfEvent, String dateOfCreation,
			String description, String picture, String backgroundFile, String timeOfEvent) {
		super();
	//	this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.organizer = organizer;
		this.place = place;
		this.dateOfEvent = dateOfEvent;
		this.dateOfCreation = dateOfCreation;
		this.description = description;
		this.picture = picture;
		this.backgroundFile = backgroundFile;
		this.timeOfEvent = timeOfEvent;
	}

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
	private int ticket1Quantity;
	private float ticket1Cost;
	private int ticket2Quantity;
	private float ticket2Cost;
	private int ticket3Quantity;
	private float ticket3Cost;
	
	public Event getEvent() {
		return new Event(name, dateOfEvent, dateOfCreation, subtitle, organizer, place, description, picture, backgroundFile, timeOfEvent);
	}
		
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

	public String getBackgroundFile() {
		return backgroundFile;
	}

	public void setBackgroundFile(String backgroundFile) {
		this.backgroundFile = backgroundFile;
	}

	public int getTicket1Quantity() {
		return ticket1Quantity;
	}

	public void setTicket1Quantity(String ticket1Quantity) {
		this.ticket1Quantity = Integer.valueOf(ticket1Quantity);
	}

	public float getTicket1Cost() {
		return ticket1Cost;
	}

	public void setTicket1Cost(String ticket1Cost) {
		this.ticket1Cost = Float.valueOf(ticket1Cost);
	}

	public int getTicket2Quantity() {
		return ticket2Quantity;
	}

	public void setTicket2Quantity(String ticket2Quantity) {
		this.ticket2Quantity = Integer.valueOf(ticket2Quantity);
	}

	public float getTicket2Cost() {
		return ticket2Cost;
	}

	public void setTicket2Cost(String ticket2Cost) {
		this.ticket2Cost = Float.valueOf(ticket2Cost);
	}

	public int getTicket3Quantity() {
		return ticket3Quantity;
	}

	public void setTicket3Quantity(String ticket3Quantity) {
		this.ticket3Quantity = Integer.valueOf(ticket3Quantity);
	}

	public float getTicket3Cost() {
		return ticket3Cost;
	}

	public void setTicket3Cost(String ticket3Cost) {
		this.ticket3Cost = Float.valueOf(ticket3Cost);
	}

	public String getTimeOfEvent() {
		return timeOfEvent;
	}

	public void setTimeOfEvent(String timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}
}
