package service;

import model.Event;
import model.EventFormObject;
import model.Ticket;
import exceptions.CreateEventException;
import exceptions.WrongBackgroundFileExtension;
import exceptions.WrongPictureFileExtension;

public class EventFormObjectManager {
	private EventManager eventManager;
	private TicketManager ticketManager;

	public int saveEventFormObject(EventFormObject eventFormObject)
			throws CreateEventException, WrongPictureFileExtension, WrongBackgroundFileExtension {
		this.eventManager = new EventManager();
		this.ticketManager = new TicketManager();
		String picturePath = checkPictureFile(eventFormObject);
		String backgroundPath = checkBackgroundFile(eventFormObject);
		eventFormObject.setPictureNewPath(picturePath);
		eventFormObject.setBackgroundNewPath(backgroundPath);
		Event event = eventFormObject.getEvent();
		event.setPicture(picturePath);
		event.setBackgroundFile(backgroundPath);
		int maxId = eventManager.getMaxEventId();
		maxId++;
		event.setId(maxId);
		eventManager.saveEvent(event);
		if (eventFormObject.getTicket1Quantity() > 0) {
			Ticket ticket1 = new Ticket(maxId,
					eventFormObject.getTicket1Quantity(),
					eventFormObject.getTicket1Cost());
			ticketManager.saveTicket(ticket1);
		}
		if (eventFormObject.getTicket2Quantity() > 0) {
			Ticket ticket2 = new Ticket(maxId,
					eventFormObject.getTicket2Quantity(),
					eventFormObject.getTicket2Cost());
			ticketManager.saveTicket(ticket2);
		}
		if (eventFormObject.getTicket3Quantity() > 0) {
			Ticket ticket3 = new Ticket(maxId,
					eventFormObject.getTicket3Quantity(),
					eventFormObject.getTicket3Cost());
			ticketManager.saveTicket(ticket3);
		}
		return maxId;
	}

	private String checkPictureFile(EventFormObject eventFormObject)
			throws WrongPictureFileExtension {
		String picturePath = eventFormObject.getPicture(); //.getOriginalFilename();
		if (picturePath.length() > 0) {
			String pictureExtension = picturePath.substring(
					picturePath.lastIndexOf('.') + 1, picturePath.length());
			if (pictureExtension.equals("jpg")
					|| pictureExtension.equals("jpeg")
					|| pictureExtension.equals("png")
					|| pictureExtension.equals("gif")) {
				picturePath = picturePath.substring(
						picturePath.lastIndexOf('/') + 1, picturePath.length());
			picturePath = "/resources/img/events/" + picturePath;
			}
			else throw new WrongPictureFileExtension("Picture file has wrong extension. Should be jpg, jpeg, png or gif");
		}
		return picturePath;
	}
	
	private String checkBackgroundFile(EventFormObject eventFormObject)
			throws WrongBackgroundFileExtension {
		String backgroundPath = eventFormObject.getBackgroundFile(); //.getOriginalFilename();
		if (backgroundPath.length() > 0) {
			String backgroundExtension = backgroundPath.substring(
					backgroundPath.lastIndexOf('.') + 1, backgroundPath.length());
			if (backgroundExtension.equals("pdf")) {
				backgroundPath = backgroundPath.substring(
						backgroundPath.lastIndexOf('/') + 1, backgroundPath.length());
			backgroundPath = "/resources/files/lists/" + backgroundPath;
			}
			else throw new WrongBackgroundFileExtension("Background file has wrong extension. Should be pdf");
		}
		return backgroundPath;
	}
}
