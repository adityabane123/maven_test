package dao;

import java.util.List;
import java.util.Map;

import mypack.common_doc;
import mypack.departments;
import mypack.languages;


public interface DepartmentsDAO {
	public List<departments> getalllist(String state);
	public departments getdept(String id);
	public List<departments> getdeptalllist(String id);
	public List<languages> getlang(String state);
	public List<common_doc> getdocs();
}
