package com.company.varnaa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.company.varnaa.model.Event;
import com.company.varnaa.repository.EventJpaRepository;



@Controller
public class CalendarApplication {
	
	@Autowired
	private EventJpaRepository eventRepository; 
	
//	@RequestMapping(value="/", method=RequestMethod.GET) 
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping(value="/staticcalendar", method=RequestMethod.GET) 
	public ModelAndView staticcalendar() {
		return new ModelAndView("staticcalendar");
	}
	
	@RequestMapping(value="/calendar", method=RequestMethod.GET) 
	public ModelAndView calendar() {
		return new ModelAndView("calendar");
	}
	
	@RequestMapping(value="/jsoncalendar", method=RequestMethod.GET) 
	public ModelAndView jsoncalendar() {
		return new ModelAndView("jsoncalendar");
	}
	
	@RequestMapping(value="/eventlist", method=RequestMethod.GET) 
	public String events(HttpServletRequest request, Model model) {
		List<Event> event = eventRepository.findAll();
		model.addAttribute("events",event);
		return "allevents";
	}
}


@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadDateFormatException extends RuntimeException {
  private static final long serialVersionUID = 1L;

	public BadDateFormatException(String dateString) {
        super(dateString);
    }
}

