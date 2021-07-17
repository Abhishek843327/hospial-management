package com.company.varnaa.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.varnaa.model.Event;
import com.company.varnaa.model.Appointment;
import com.company.varnaa.model.Invoice;
import com.company.varnaa.repository.EventJpaRepository;
import com.company.varnaa.service.AppointmentService;

@Controller
@RequestMapping("/receptionist")
public class ReceptionistController {

	
	@Autowired
	private EventJpaRepository repository;
	
	@Autowired
	private AppointmentService service = new AppointmentService();
	
	@GetMapping("/receptionistAppointments")
	public String showReceptionistAppointments(Model model) {
		List<Appointment> listAppointments = service.listAll();
		model.addAttribute("listAppointments",listAppointments);
		
		String confirmed = "confirmed";
		model.addAttribute("confirmed",confirmed);
		return "receptionistAppointments";
		
	}
	
	@GetMapping("/confirmm")
	public String showConfirmm(Model model) {
		Appointment confirmation = new Appointment();
		model.addAttribute("confirmation",confirmation);
		return "confirm";
	}
	
	
	
	@RequestMapping(value="/receptionistSchedule", method=RequestMethod.GET)
	public String receptionistSchedule(Model model) {
		List<Event> events = repository.findAll();
		model.addAttribute("events",events);
		return "receptionistSchedule";
	}
	
	@RequestMapping("/findbystart")
	public String showBydate(Model model) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now);
		List<Event> event = repository.findByStart(now);
		model.addAttribute("event",event);
		return "scheduleFindByName";
	}
	
	
	@RequestMapping("/createInvoice")
	public String createInvoice(Model model) {
		Invoice i = new Invoice();
		model.addAttribute("invoice",i);
		return "invoice";
	}
	
	
	
}
