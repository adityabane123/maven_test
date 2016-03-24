package controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
cfusers cf=new cfusers();
return new ModelAndView("index","login",cf);	
	}

@RequestMapping(method = RequestMethod.POST)
public ModelAndView confvoter(@Valid @ModelAttribute("login") cfusers cfuser, BindingResult result,HttpSession session)
{

	if (result.hasErrors()) {
		return new ModelAndView("index");
	}
	cfusers ref=cfuserdao.checklogin(cfuser);
	session.setAttribute("username",ref.getUser_name());
	session.setAttribute("state",ref.getState());
	session.setAttribute("authority",ref.getAuthority());
	
	mylist=servicedao.getalllist();
		return new ModelAndView("All_service","mylist",mylist);
	//int id=Integer.parseInt(ref);
	//List<Candidate>list=candao.can(id);
	//return new ModelAndView("voting","mycan",list);

}	
}
