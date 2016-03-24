package controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.CfuserDAO;
import mypack.cfusers;


@Controller
@RequestMapping("/New_operator")
public class NewoprController {

	@Autowired
	public CfuserDAO cfuserdao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView beforecre()
		{
	cfusers cf=new cfusers();
	System.out.println("inside post");
	return new ModelAndView("New_operator","register",cf);	
		}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView aftercre(@Valid @ModelAttribute("register") cfusers cfuser,HttpSession session)
	{
        System.out.println("inside post");
		/*BindingResult result
		 * if (result.hasErrors()) {
			return new ModelAndView("New_operator");
		}*/
		if(cfuser.getAssigned_officer_id()=="")
		{
			cfuser.setAssigned_officer_id(((String) session.getAttribute("username")));
		}
		cfuser.setState((String) session.getAttribute("state"));
		cfuser.setPass("Welcome123");
		cfuser.setUser_id(cfuser.getFname()+cfuser.getLname());
		cfuser.setActive_flag(true);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String created_on=dateFormat.format(date); //2014/08/06 15:59:48
		cfuser.setCreated_on(created_on);
		//cfuser.setAuthority((String) session.getAttribute("userid"));
		cfuserdao.saveuser(cfuser);	
		return new ModelAndView("All_service");
		//int id=Integer.parseInt(ref);
		//List<Candidate>list=candao.can(id);
		//return new ModelAndView("voting","mycan",list);

	}
	
	 @RequestMapping(value = "/ajaxtest",method = RequestMethod.GET)
	    public @ResponseBody String getTime(HttpSession session) {
		 //System.out.println("inside ajax");
		 String result="";
		 String state=(String)session.getAttribute("state");
		 //System.out.println(state);
		 List <cfusers> reviewerlist=cfuserdao.getrevlist(state);
		 Iterator<cfusers> CrunchifyIterator = reviewerlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
				cfusers cf=CrunchifyIterator.next();
				result+="<option value="+cf.getUser_name()+">"+cf.getUser_name()+"</option>";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 //System.out.println(result);
		 //System.out.println("after result");
	        return result;
	    }

}
