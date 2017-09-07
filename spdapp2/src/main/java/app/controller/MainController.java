package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.repository.SPDRepository;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(SPDController.class);
	
	@Autowired(required = true)
	private SPDRepository spdRepository;
	
	@RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
	public String goMain(Model model) {
		logger.info("<== Entering to the getAllSPD() method ==>");
		model.addAttribute("spds", spdRepository.findAll());
		return "main";
	}

}
