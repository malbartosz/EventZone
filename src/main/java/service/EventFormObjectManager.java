package service;

import model.Event;
import model.EventFormObject;
import model.Ticket;
import exceptions.CreateEventException;

public class EventFormObjectManager {
	private EventManager eventManager;
	private TicketManager ticketManager;
	
	public void saveEventFormObject(EventFormObject eventFormObject) throws CreateEventException {
		Event event = eventFormObject.getEvent();
		eventManager.saveEvent(event);
		int maxId = eventManager.getMaxEventId();
//		Ticket ticket1 = new Ticket(maxId, eventFormObject.getTicket1Quantity(), eventFormObject.getTicket1Cost());
//		ticketManager.saveTicket(ticket1);
//		
//		Ticket ticket2 = new Ticket(maxId, eventFormObject.getTicket2Quantity(), eventFormObject.getTicket2Cost());
//		ticketManager.saveTicket(ticket2);
//		
//		Ticket ticket3 = new Ticket(maxId, eventFormObject.getTicket3Quantity(), eventFormObject.getTicket3Cost());
//		ticketManager.saveTicket(ticket3);
	}
}
