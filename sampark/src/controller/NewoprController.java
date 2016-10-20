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
import dao.ServiceDAO;
import mypack.cfusers;
import mypack.service_status;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

@Controller
@RequestMapping("/New_operator")
public class NewoprController {

	static int i=0;
	
	@Autowired
	public CfuserDAO cfuserdao;
	
	List <service_status>mylist;
	
	@Autowired
	public ServiceDAO servicedao;
	
	public List<service_status> getMylist() {
		return mylist;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView beforecre()
		{
	cfusers cf=new cfusers();
	System.out.println("inside GET");
	return new ModelAndView("New_operator","register",cf);	
		}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView aftercre(@Valid @ModelAttribute("register") cfusers cfuser,HttpSession session)
	{
		String state_id=(String) session.getAttribute("state_id");
        //System.out.println("inside post");
		/*BindingResult result
		 * if (result.hasErrors()) {
			return new ModelAndView("New_operator");
		}*/
        String role=cfuser.getAuthority();
        String con=state_id+"_"+role+"_%";
        System.out.println(con);
        int getcount=cfuserdao.getcount(con);
        System.out.println(getcount);
        cfuser.setUser_name(state_id+"_"+role+"_"+getcount);
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
		String email=cfuser.getEmail();
		//***********emailfunction(email,cfuser.getUser_name());
		//cfuser.setAuthority((String) session.getAttribute("userid"));
		cfuserdao.saveuser(cfuser);
		mylist=servicedao.getalllist();
		return new ModelAndView("All_service","mylist",mylist);
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
	 
	 public void emailfunction(String email,String username)
	 {
		 System.out.println("inside email1");
			
			Properties prop =new Properties();
			  prop.put("mail.smtp.host", "smtp.gmail.com");  
			  prop.put("mail.smtp.socketFactory.port", "465");  
			  prop.put("mail.smtp.socketFactory.class",  
			            "javax.net.ssl.SSLSocketFactory");  
			  prop.put("mail.smtp.auth", "true");  
			  prop.put("mail.smtp.port", "587"); 
			  
			  Session session = Session.getDefaultInstance(prop,  
					   new Authenticator(){  
					   protected PasswordAuthentication getPasswordAuthentication() {  
					   return new PasswordAuthentication("adityabane321@gmail.com","adi100103108");//change accordingly  
					   }  
					  });
			  System.out.println("inside email2");
			  
			  try {  
				   MimeMessage message = new MimeMessage(session);  
				   message.setFrom(new InternetAddress("adityabane321@gmail.com"));//change accordingly  
				   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
				   message.setSubject("User Details");  
				   message.setText("Your Username is"+username+" and password is Welcome123");  
				     
				   
				   /*
				    * Always remember to go 
				    * https://www.google.com/settings/security/lesssecureapps
				    * and turn on that
				    * 
				    * 
				    */
				   //send message  
				   Transport.send(message);  
				  
				   System.out.println("message sent successfully");  
				   
				  } catch (MessagingException e) {throw new RuntimeException(e);}  
		}
		 
	 }

