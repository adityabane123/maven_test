package controller;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.DepartmentsDAO;
import dao.ServiceDAO;
import dao.StatesDAO;
import mypack.departments;
import mypack.m_states;
import mypack.service_status;


@Controller
public class InfoController {
	private static final int BUFFER_SIZE = 4096;
	@Autowired
	public ServiceDAO servicedao;

	@Autowired
	public DepartmentsDAO deptdao;
	
	@Autowired
	public StatesDAO statedao;

@RequestMapping(value="/Viewserviceinfo",method = RequestMethod.POST)
public ModelAndView beforeshow(HttpServletRequest req,HttpSession session)
	{
Map<String,String> docsmap=new HashMap<String,String>();
Map<String,String> otherinfo=new HashMap<String,String>();
String service_id=req.getParameter("id");
String filePath = "D:/"+service_id+".xml";
service_status st=servicedao.getservice(service_id);
String dept_id="";
String eli="";
String fee="";
String sum="";
String edd="";
Blob xml=st.getSubmitted_services();
try {
	InputStream inputStream = xml.getBinaryStream();
    OutputStream outputStream = new FileOutputStream(filePath);
    
    int bytesRead = -1;
    byte[] buffer = new byte[BUFFER_SIZE];
    while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
    }
    outputStream.close();
    System.out.println("File saved");
} catch (SQLException | IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {	
    File inputFile = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();
    
    NodeList nList2 = doc.getElementsByTagName("Department");
    Node nNode2 = nList2.item(0);
    Element eElement2 = (Element) nNode2;
    dept_id=eElement2.getAttribute("name");
    
    NodeList nList1 = doc.getElementsByTagName("category");
	
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList1.getLength(); temp++) {

		Node nNode = nList1.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			 eli=eElement.getElementsByTagName("eligibility").item(0).getTextContent();
			 fee=eElement.getElementsByTagName("fee").item(0).getTextContent();
			 sum=eElement.getElementsByTagName("Summary").item(0).getTextContent();
			 edd=eElement.getElementsByTagName("expected_delivery_date").item(0).getTextContent();

		}
	}
    
  
    //System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("document_info");
    printNote1(nList,docsmap);
    System.out.println("----------------------------");
 } catch (Exception e) {
    e.printStackTrace();
 }
//System.out.println(statid);
departments dep=deptdao.getdept(dept_id);
String dept_name=dep.getDept_name();
ModelAndView mav = new ModelAndView("Viewserviceinfo");
mav.addObject("myserv",docsmap);
mav.addObject("other", otherinfo);
mav.addObject("serv", st);
mav.addObject("dept_name", dept_name);
mav.addObject("eli", eli);
mav.addObject("fee", fee);
mav.addObject("sum", sum);
mav.addObject("edd", edd);
return mav;  
}

@RequestMapping(method = RequestMethod.POST)
public ModelAndView aftershow(HttpServletRequest req)
{
	//String valueOne=request.getParameter("id");
	String service_id=req.getParameter("service_id");
	System.out.println(service_id);
	return new ModelAndView("Viewserviceinfo","myserv","post");	
}


private static void printNote1(NodeList nList,Map<String,String> docsmap){
for (int temp = 0; temp < nList.getLength(); temp++) {

	Node nNode = nList.item(temp);
			
	//System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
	if (nNode.getNodeType() == Node.ELEMENT_NODE) {

		Element eElement = (Element) nNode;
		docsmap.put(eElement.getElementsByTagName("applicable_document").item(0).getTextContent(),eElement.getElementsByTagName("mandatory").item(0).getTextContent());
	}
}
}

}
