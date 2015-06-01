package controller;

import java.util.List;

import model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import output.EventInfoForParticipant;
import service.EventManager;
import service.ParticipantManager;

@Controller
@RequestMapping("/main")
@SessionAttributes
public class LoginPage {

	@Autowired
	private ParticipantManager participantManager;

	@Autowired
	private EventManager eventManager;

	@RequestMapping(value = "listForParticipant", method = RequestMethod.GET)
	public ModelAndView listEventsForParticipant() {
		ModelAndView model = new ModelAndView("myEvents");
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userP: "+username);
		List<EventInfoForParticipant> listEventsForParticipant = 
				participantManager.getEventsForParticipant(username);
		model.addObject("username", username);
		model.addObject("listEventsForParticipant", listEventsForParticipant);
		return model;
	}

	@RequestMapping(value = "listForOrganizer", method = RequestMethod.GET)
	public ModelAndView listEventsForOrganizer() {
		ModelAndView model = new ModelAndView("myEvents");

		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		List<Event> listEventsForOrganizer = this.eventManager
				.getAllEventsByOrganizer(username);
		model.addObject("username", username);
		model.addObject("listEventsForOrganizer", listEventsForOrganizer);
		return model;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {

		ModelAndView model = new ModelAndView("main_page");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("user: "+username);
		
		List<Event> allEvents = 
				eventManager.getAllEventsInDataBase();
		model.addObject("events",  allEvents);
		model.addObject("username", username);
		return model;

	}

	
}
