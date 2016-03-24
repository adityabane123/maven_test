package dao;

import java.util.List;

import mypack.service_status;

public interface ServiceDAO {

	public List<service_status> getalllist();
	public service_status getservice(String id);
}
