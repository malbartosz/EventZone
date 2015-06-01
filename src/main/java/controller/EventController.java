package controller;

import model.Event;
import model.Participant;
import model.Ticket;
import model.User;
import model.EventFormObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;
import exceptions.CreateEventException;
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
	
	//@Autowired
	private TicketManager ticketManager = new TicketManager();
	
	//@Autowired
	private UserManagerImpl userManager;
	
	@RequestMapping("event/{id}")
	public ModelAndView getSingleEventPage(@PathVariable String id/*, @ModelAttribute boolean justSubs*/){
		ModelAndView model = new ModelAndView("event/singleEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		Event event = eventManager.getEventById(id);
		boolean isUserSubscribed = participantManager.checkIfSubscribed(username,id);
		
		
		model.addObject("event", event);
		model.addObject("subscribed", isUserSubscribed);
		return model; 
	}
	
	@RequestMapping(value = "event/subscribe/{eventId}", method=RequestMethod.GET)
	public String subscribeToAnEvent(@PathVariable String eventId, int ifPaid, final RedirectAttributes redirectAttrs){		
		System.out.println("hehe in subscribeevent");
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		
		Ticket ticket = ticketManager.getTicketByEventId(Integer.parseInt(eventId));
		System.out.println("after Ticket");
		User user = null;
		try {
			user = userManager.getUserByLogin(username);
		} catch (LoginAlreadyInUse e) { }
		System.out.println("after user");

		Event event = eventManager.getEventById(eventId);
		System.out.println("after event");

		Participant participant = new Participant(ifPaid, ticket, event, user);
		System.out.println("after parti");

		boolean justSubs = participantManager.saveParticipant(participant);
		redirectAttrs.addFlashAttribute("justSubs", justSubs);
		
		return "redirect:/main/event/" + eventId;
	}
	
	@RequestMapping("event/create")
	public ModelAndView createAnEvent(){
		ModelAndView model = new ModelAndView("event/createEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addObject("username", username);
		model.addObject("eventForm", new EventFormObject());
		return model; 
	}
	
	@RequestMapping(value = "event/createEvent", method = RequestMethod.POST)
	public ModelAndView createEventForm(@ModelAttribute("eventForm") final EventFormObject event) {
		System.out.println("in create event!!");
		ModelAndView model = null;
		EventFormObject newEvent = event;
		EventFormObjectManager eventFormManager = new EventFormObjectManager();
		try {
			eventFormManager.saveEventFormObject(newEvent);
		} catch (CreateEventException e) {
//			model = new ModelAndView("redirect:/main/event/create?fail=true");
//			redir.addFlashAttribute("createEventFailureMsg", e.getMessage());
//			System.out.println("Ex msg: " + e.getMessage());
			return model;
		}
//		model = new ModelAndView("redirect:/listForOrganizer/");
//		redir.addFlashAttribute("successMsg", "Your event has been created!");
		return model;

	}
}
