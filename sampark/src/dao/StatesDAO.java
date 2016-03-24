package dao;

import java.util.List;

import mypack.m_states;

public interface StatesDAO {

	public List<m_states> getalllist();
	public m_states getstate(String id);
}
