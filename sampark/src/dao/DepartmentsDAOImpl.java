package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import mypack.common_doc;
import mypack.departments;
import mypack.languages;
@Component
public class DepartmentsDAOImpl implements DepartmentsDAO{

	@Autowired
	private HibernateTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<departments> getalllist(String state) {
		// TODO Auto-generated method stub
		List<departments> list=new ArrayList<departments>();  
		list=template.find("from departments k where k.state_id=? and k.is_active=1",state);
		return list; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public departments getdept(String id) {
		// TODO Auto-generated method stub
		List<departments> list=new ArrayList<departments>();  
		list=template.find("from departments k where k.dept_id=?",id);
		departments ref=list.get(0);
		return ref;
	}
	
	@SuppressWarnings("unchecked")
	public List<departments> getdeptalllist(String id) {
		// TODO Auto-generated method stub
		List<departments> list=new ArrayList<departments>();  
		list=template.find("from departments m where m.state_id=?",id);
		return list; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<languages> getlang(String state) {
		// TODO Auto-generated method stub
		List<languages> list=new ArrayList<languages>();  
		list=template.find("from languages m where m.state_id=?",state);
		return list; 
	}

	@Override
	public List<common_doc> getdocs() {
		// TODO Auto-generated method stub
		List<common_doc> list=new ArrayList<common_doc>();  
		list=template.find("from common_doc m");
		return list;
	}

}
