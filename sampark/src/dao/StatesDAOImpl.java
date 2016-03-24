package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import mypack.m_states;
@Component
public class StatesDAOImpl implements StatesDAO{

	@Autowired
	private HibernateTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<m_states> getalllist() {
		// TODO Auto-generated method stub
		List<m_states> list=new ArrayList<m_states>();  
		list=template.find("from m_states m");
		return list; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public m_states getstate(String state_name) {
		// TODO Auto-generated method stub
		List<m_states> list=new ArrayList<m_states>(); 
	    System.out.println(state_name);
		list=template.find("from m_states k where k.state_name=?","Chhattisgarh");
		m_states ref=list.get(0);
		return ref;
	}

}
