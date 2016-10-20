package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mypack.cfusers;




@Controller
@RequestMapping("/All_operator1")
public class AlluserController {

	private static final Logger logger = Logger.getLogger(AlluserController.class);
	
	
@RequestMapping(method = RequestMethod.GET)
public ModelAndView pro()
	{
	  if(logger.isDebugEnabled()){  
		   logger.debug("Start debug");  
		  }  
		  logger.info("Going to run HelloLoggingController class GET");  
return new ModelAndView("All_operator1");	
	}

}
