package dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import mypack.service_status;
@Component
public class ServiceDAOImpl implements ServiceDAO{


	@Autowired
	private HibernateTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<service_status> getalllist() {
		// TODO Auto-generated method stub
		List<service_status> list=new ArrayList<service_status>();  
		list=template.find("from service_status m");
		return list; 
	}

	@SuppressWarnings("unchecked")
	public service_status getservice(String id) {
		List<service_status> list=new ArrayList<service_status>();  
		list=template.find("from service_status k where k.service_id=?",id);
		service_status ref=list.get(0);
		return ref;
}
}
