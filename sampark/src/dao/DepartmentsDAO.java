package dao;

import java.util.List;
import java.util.Map;

import mypack.departments;
import mypack.languages;


public interface DepartmentsDAO {
	public List<departments> getalllist();
	public departments getdept(String id);
	public List<departments> getdeptalllist(String id);
	public List<languages> getlang(String state);
}
