package controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import dao.CfuserDAO;
import dao.DepartmentsDAO;
import dao.ServiceDAO;
import mypack.Person;
import mypack.cfusers;
import mypack.common_doc;
import mypack.departments;
import mypack.languages;
import mypack.service_status;


@Controller
@RequestMapping("/result")
public class AjaxtestController {

	@Autowired
	public CfuserDAO cfuserdao;
	
	@Autowired
	public DepartmentsDAO departdao;
	
	List <service_status>mylist;
	
	List <cfusers>mylist1;
	
	public List<cfusers> getMylist1() {
		return mylist1;
	}

	public void setMylist1(List<cfusers> mylist1) {
		this.mylist1 = mylist1;
	}

	public void setMylist(List<service_status> mylist) {
		this.mylist = mylist;
	}

	@Autowired
	public ServiceDAO servicedao;
	
	public List<service_status> getMylist() {
		return mylist;
	}
	
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
				result+="<option value='"+cf.getUser_name()+"'>"+cf.getUser_name()+"</option>";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);
		 System.out.println("after result");
	        return result;
	    }
	 
	 @RequestMapping(value = "/lang",method = RequestMethod.POST)
	 @ResponseBody    
	 public String getlang(HttpSession session) {
		 String result="";
		 String state=(String)session.getAttribute("state_id");
		 List <languages> langlist=departdao.getlang(state);
		 Iterator<languages> CrunchifyIterator = langlist.iterator();
		 result="<option value='select_lang'>Select Language </option>";
		 while (CrunchifyIterator.hasNext()) {
				languages cf=CrunchifyIterator.next();
				result+="<option value='"+cf.getLang_id()+"'>"+cf.getLanguage()+"</option>";
				//result+=cf.getLanguage()+"*";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);
		 System.out.println("------------------------");
		 return result;
		 
	 }
	 
	 @RequestMapping(value = "/depart",method = RequestMethod.POST)
	 @ResponseBody    
	 public String getdepart(HttpSession session) {
		 String result="";
		 String state=(String)session.getAttribute("state_id");
		 List <departments> deptlist=departdao.getalllist(state);
		 Iterator<departments> CrunchifyIterator = deptlist.iterator();
		 result="<option value='select_depa'>Select Department</option>  ";
		 while (CrunchifyIterator.hasNext()) {
				departments cf=CrunchifyIterator.next();
				result+="<option value='"+cf.getDept_id()+"'>"+cf.getDept_name()+"</option>";
				//result+=cf.getDept_name()+"*";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);
		 System.out.println("------------------------");
		 return result;
		 
	 }
	 
	 @RequestMapping(value = "/common",method = RequestMethod.POST)
	 @ResponseBody    
	 public String getdocs() {
		 String result="";
		 List <common_doc> deptlist=departdao.getdocs();
		 Iterator<common_doc> CrunchifyIterator = deptlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
			 common_doc cf=CrunchifyIterator.next();
				result+=cf.getDoc_name()+",";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);
		 System.out.println("------------------------");
		 return result;
		 
	 }
	 
	 @RequestMapping(value = "/deptcheck",method = RequestMethod.POST)
	 @ResponseBody    
	 public String deptcheck() {
		 String result="0";
		 /*List <common_doc> deptlist=departdao.getdocs();
		 Iterator<common_doc> CrunchifyIterator = deptlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
			 common_doc cf=CrunchifyIterator.next();
				result+=cf.getDoc_name()+",";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);*/
		 return result;
		 
	 }

	 @RequestMapping(value = "/Newserv",method = RequestMethod.POST)
	 @ResponseBody    
	 public String saveserv() {
		 String result="0";
		 /*List <common_doc> deptlist=departdao.getdocs();
		 Iterator<common_doc> CrunchifyIterator = deptlist.iterator();
		 while (CrunchifyIterator.hasNext()) {
			 common_doc cf=CrunchifyIterator.next();
				result+=cf.getDoc_name()+",";
				//System.out.println(cf.getUser_name()+cf.getUser_name());
			}
		 System.out.println(result);*/
		 return result;
		 
	 }
	 
	 /*@RequestMapping(value = "/angu",method = RequestMethod.POST)    
	 public @ResponseBody Person angu(@RequestBody Person company) {
		 System.out.println("inside angu");
		 System.out.println(company.toString());
			return company;
	 }*/
	 
	 @RequestMapping(value = "/angu",method = RequestMethod.GET)    
	 public @ResponseBody String angu() {	 
		 mylist=servicedao.getalllist();
		 Gson gson = new Gson();
		 // convert your list to json
		 String jsonCartList = gson.toJson(mylist);
		 System.out.println(jsonCartList);
		 return jsonCartList;
	 }
	 
	 @RequestMapping(value = "/angu_opr",method = RequestMethod.GET)    
	 public @ResponseBody String angu_opr(HttpSession session) {
		 String state=(String) session.getAttribute("state");
		 mylist1=cfuserdao.getalllist(state);
		 Gson gson = new Gson();
		 // convert your list to json
		 String jsonCartList = gson.toJson(mylist1);
		 System.out.println(jsonCartList);
		 return jsonCartList;
	 }
}
