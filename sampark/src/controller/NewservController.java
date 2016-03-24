package controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dao.DepartmentsDAO;

import dao.StatesDAO;
import mypack.FileUpload;
import mypack.cfusers;
import mypack.departments;
import mypack.m_states;
import mypack.service_status;



@Controller
@RequestMapping("/New_service")
public class NewservController {

	private String saveDirectory = "E:\\";

	@Autowired
	public DepartmentsDAO deptdao;
	
	@Autowired
	public StatesDAO statedao;
	
	
@RequestMapping(method = RequestMethod.GET)
public ModelAndView beforesubmit(HttpSession session)
{
String userstate=(String) session.getAttribute("state");
m_states sta=statedao.getstate(userstate);
String statid=sta.getState_id();
//System.out.println(statid);
List <departments> depilist= deptdao.getdeptalllist(statid);
List <String> manda= new ArrayList<String>();
Iterator<departments> CrunchifyIterator = depilist.iterator();
Map<String,String> depa=new HashMap<String,String>();
while (CrunchifyIterator.hasNext()) {
	departments dept=CrunchifyIterator.next();
	depa.put(dept.getDept_id(),dept.getDept_name());
}
System.out.println(depa);
service_status st=new service_status();
FileUpload fl=new FileUpload();
manda.add("Yes");manda.add("No");
ModelAndView mav = new ModelAndView("New_service");
return mav;  
}


@RequestMapping(method = RequestMethod.POST)
public ModelAndView aftersubmit(@ModelAttribute("newserv") service_status st,HttpSession session,HttpServletRequest req,@RequestParam CommonsMultipartFile[] fileUpload)
{
//Object file=req.getAttribute("file");
	if (fileUpload != null && fileUpload.length > 0) {
		for (CommonsMultipartFile aFile : fileUpload){
			
			System.out.println("Saving file: " + aFile.getOriginalFilename());
			
			if (!aFile.getOriginalFilename().equals("")) {
				try {
					aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
System.out.println("inside newserv");
DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder icBuilder;
try {
    icBuilder = icFactory.newDocumentBuilder();
    Document doc = icBuilder.newDocument();
    Element mainRootElement = doc.createElement("document");
    doc.appendChild(mainRootElement);
    
    Element supercar = doc.createElement("document_info");
    mainRootElement.appendChild(supercar);
    // append child elements to root element
    Element carname = doc.createElement("application_document");
    carname.appendChild(
    doc.createTextNode("Ferrari 101"));
    supercar.appendChild(carname);
    
    // output DOM XML to console
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    DOMSource source = new DOMSource(doc);
    StreamResult result =
            new StreamResult(new File("D:\\cars.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult =
            new StreamResult(System.out);
            transformer.transform(source, consoleResult);

    System.out.println("\nXML DOM Created Successfully..");
        //write the content into xml file
        /*TransformerFactory transformerFactory =
        TransformerFactory.newInstance();
        Transformer transformer =
        transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result =
        new StreamResult(new File("C:\\cars.xml"));
        transformer.transform(source, result);
        // Output to console for testing
        StreamResult consoleResult =
        new StreamResult(System.out);
        transformer.transform(source, consoleResult);*/
     } catch (Exception e) {
        e.printStackTrace();
     }
cfusers cf=new cfusers();
return new ModelAndView("index","login",cf);

}	
}
