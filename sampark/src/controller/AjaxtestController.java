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
import dao.DepartmentsDAO;
import mypack.cfusers;
import mypack.languages;


@Controller
@RequestMapping("/result")
public class AjaxtestController {

	@Autowired
	public CfuserDAO cfuserdao;
	
	@Autowired
	public DepartmentsDAO departdao;
	
	 @RequestMapping(value = "/ajaxtest",method = RequestMethod.POST)
	 @ResponseBody    
	 public String getTime(HttpSession session) {
		 System.out.println("inside ajax");
		 String result="";
		 String state=(String)session.getAttribute("state");
		 System.out.println(state);
		 List <cfusers> reviewerlist=cfuserdao.getrevlist(state);
		 Iterator<cfusers> CrunchifyIterator = reviewerlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
				cfusers cf=CrunchifyIterator.next();
				result+="<option value='ss'>ss</option>";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 result="gw";
		 System.out.println(result);
		 System.out.println("after result");
	        return result;
	    }
	 
	 @RequestMapping(value = "/lang",method = RequestMethod.POST)
	 @ResponseBody    
	 public String getlang(HttpSession session) {
		 String result="";
		 String state=(String)session.getAttribute("state");
		 List <languages> langlist=departdao.getlang(state);
		 Iterator<languages> CrunchifyIterator = langlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
				languages cf=CrunchifyIterator.next();
				result+=cf.getLang_name()+"*";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 return result;
		 
	 }

}
