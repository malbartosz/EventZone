package controller;

import model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("event/create")
	public ModelAndView getSingleEventPage(){
		ModelAndView model = new ModelAndView("event/createEvent");		
		
		String username = 
				SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addObject("username", username);
		return model; 
	}
}
