package controller;

import model.Event;
import model.EventFormObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exceptions.CreateEventException;
import service.EventFormObjectManager;
import service.EventManager;


@Controller
@RequestMapping("/main")
public class EventController {
	
	@Autowired
	private EventManager eventManager;
	
	@RequestMapping("event/{id}")
	public ModelAndView getSingleEventPage(@PathVariable String id){
		ModelAndView model = new ModelAndView("event/singleEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		Event event = eventManager.getEventById(id);
		
		model.addObject("event", event);
		model.addObject("username", username);
		return model; 
	}
	
	@RequestMapping("event/subscribe/{id}")
	public void subscribeToAnEvent(@PathVariable String id){
		ModelAndView model = new ModelAndView("event/singleEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		Event event = eventManager.getEventById(id);
		
		model.addObject("event", event);
		model.addObject("username", username);
		//return model; 
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createEventForm(@ModelAttribute("eventForm") final EventFormObject event) {

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
