package com.mailSender.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainCotroller {
	
	private final MailService mailService;
	
	@Autowired
	public MainCotroller(MailService mailService) {
		this.mailService = mailService;
	}
	
	@GetMapping("/")
	public String emailForm(Model model) {
		model.addAttribute("toEmail", "");
	    model.addAttribute("subject", "");
	    model.addAttribute("message", "");
	    return "emailForm";
	} 
	
	@PostMapping("/sendEmail")
	public String sendEmail(@RequestParam("toEmail") String toEmail,
	                        @RequestParam("subject") String subject,
	                        @RequestParam("message") String message) {

		mailService.sendEmail(toEmail, subject, message);
	    
	    return "success"; 
	}
}
