package controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;
import model.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Participant;
import model.Ticket;
import model.User;
import model.EventFormObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import output.ParticipantForOrganizer;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;
import exceptions.CreateEventException;
import exceptions.WrongBackgroundFileExtension;
import exceptions.WrongPictureFileExtension;
import service.EventFormObjectManager;
import service.EventManager;
import service.ParticipantManager;
import service.TicketManager;
import service.UserManagerImpl;

@Controller
@RequestMapping("/main")
public class EventController {

	@Autowired
	private EventManager eventManager;

	@Autowired
	private ParticipantManager participantManager;

	// @Autowired
	private TicketManager ticketManager = new TicketManager();
	
	//@Autowired
	private UserManagerImpl userManager =  new UserManagerImpl();
	
	@RequestMapping(value="event/getEvent/{id}",  method=RequestMethod.GET)
	public ModelAndView getSingleEventPage(@PathVariable String id){
		ModelAndView model = new ModelAndView("event/singleEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		Event event = eventManager.getEventById(Integer.parseInt(id));
		boolean isUserSubscribed = participantManager.checkIfSubscribed(username,id);
		
		List<ParticipantForOrganizer> participants = 
				participantManager.getAllParticipantsByEventId(Integer.parseInt(id));
		if(eventManager.isUserTheOrganizer(username,id) && !participants.isEmpty()){
			model.addObject("isOrganizer", true);
			model.addObject("participants", participants);
		}else
			model.addObject("isOrganizer", false);
		model.addObject("event", event);
		model.addObject("subscribed", isUserSubscribed);
		return model;
	}
	
	@RequestMapping(value = "event/subscribe/", method=RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> subscribeToAnEvent(String eventId, int ifPaid){		

		System.out.println("hehe in subscribeevent");
		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Ticket ticket = ticketManager.getTicketByEventId(Integer
				.parseInt(eventId));
		System.out.println("after Ticket");

		User user = userManager.findUserByLogin(username);
		

		System.out.println("after user");

		Event event = eventManager.getEventById(Integer.parseInt(eventId));
		System.out.println("after event");

		Participant participant = new Participant(ifPaid, ticket, event, user);
		System.out.println("after parti");

		final boolean subsribed = participantManager.saveParticipant(participant);
		//redirectAttrs.addFlashAttribute("subscribed", justSubs);
		
		return  new HashMap<String, Boolean>(1){{put("result", subsribed);}};


	}

	@RequestMapping("event/create")
	public ModelAndView createAnEvent() {
		ModelAndView model = new ModelAndView("event/createEvent");

		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		model.addObject("username", username);
		model.addObject("eventForm", new EventFormObject());
		return model;
	}

	@RequestMapping(value = "event/createEvent", method = RequestMethod.POST)
	public ModelAndView createEventForm(
			@ModelAttribute("eventForm") final EventFormObject event) {
		ModelAndView model = null;
		EventFormObject newEvent = event;
		newEvent.setOrganizer(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();

		newEvent.setDateOfCreation(String.valueOf(dateFormat.format(date)));
		EventFormObjectManager eventFormManager = new EventFormObjectManager();
		int id;
		try {
			id = eventFormManager.saveEventFormObject(newEvent);
		} catch (CreateEventException e) {
			model.addObject("error", e);
			return model;
		} catch (WrongPictureFileExtension e) {
			model.addObject("error", e);
			return model;
		} catch (WrongBackgroundFileExtension e) {
			model.addObject("error", e);
			return model;
		}
//		try {
//			this.upload(newEvent.getPicture(), newEvent.getPictureNewPath());
//		} catch (Exception e1) {
//			model.addObject("error", e1);
//			return model;
//		}
//		try {
//			this.upload(newEvent.getBackgroundFile(), newEvent.getBackgroundNewPath());
//		} catch (Exception e) {
//			model.addObject("error", e);
//			return model;
//		}
		model = new ModelAndView("redirect:/main/event/getEvent/" + String.valueOf(id));
		
		return model;

	}
	
//    /**
//     * upload
//     */
//    public void upload( MultipartFile file, String name) throws Exception {
//    	 if (!file.isEmpty()) {
//            
//                 byte[] bytes = file.getBytes();
//                 BufferedOutputStream stream =
//                         new BufferedOutputStream(new FileOutputStream(new File(name)));
//                 stream.write(bytes);
//                 stream.close();
//         } else {
//             throw new Exception( "You failed to upload " + name + " because the file was empty.");
//         }
//    }
}
