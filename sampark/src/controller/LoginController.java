package controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.CfuserDAO;
import dao.ServiceDAO;
import mypack.cfusers;
import mypack.service_status;


@Controller
@RequestMapping("/index")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	List <service_status>mylist;

	@Autowired
	public CfuserDAO cfuserdao;
	
	@Autowired
	public ServiceDAO servicedao;
	
	public List<service_status> getMylist() {
		return mylist;
	}

	public void setMylist(List<service_status> mylist) {
		this.mylist = mylist;
	}
	
@RequestMapping(method = RequestMethod.GET)
public ModelAndView pro()
	{
	  if(logger.isDebugEnabled()){  
		   logger.debug("Start debug");  
		  }  
		  logger.info("Going to run HelloLoggingController class GET");  
cfusers cf=new cfusers();
return new ModelAndView("index","login",cf);	
	}

@RequestMapping(method = RequestMethod.POST)
public ModelAndView confvoter(@Valid @ModelAttribute("login") cfusers cfuser, BindingResult result,HttpSession session)
{

	if (result.hasErrors()) { 
		return new ModelAndView("index");
	}
	
	if (cfuser.getUser_name()==null || cfuser.getUser_name().equals(""))
	{
		cfuser.setCaptcha("");
    	return new ModelAndView("index","nousr","Username or Password do not match");
	}


if (cfuser.getPass()==null || cfuser.getPass().equals(""))
{
	cfuser.setCaptcha("");
	return new ModelAndView("index","nousr","Username or Password do not match");
}	

 String captcha=(String)session.getAttribute("CAPTCHA");
    if(captcha==null || (captcha!=null && !captcha.equals(cfuser.getCaptcha()))){
    	cfuser.setCaptcha("");
    	return new ModelAndView("index","nousr","Captcha do not match");
    }
	
	cfusers ref=cfuserdao.checklogin(cfuser);
	if(ref.getUser_name() == "wrong")
	{
		return new ModelAndView("index","nousr","Username or Password do not match");
	}
	session.setAttribute("username",ref.getUser_name());
	session.setAttribute("state",ref.getState());
	String state_id=cfuserdao.getstateid(ref.getState());
	System.out.println(state_id);
	session.setAttribute("authority",ref.getAuthority());
	session.setAttribute("state_id", state_id);
	
	//mylist=servicedao.getalllist();
	
		  logger.info("Going to run HelloLoggingController class POST");  
		//return new ModelAndView("All_service","mylist",mylist);
		return new ModelAndView("All_service");
	//int id=Integer.parseInt(ref);
	//List<Candidate>list=candao.can(id);
	//return new ModelAndView("voting","mycan",list);

}	
}
