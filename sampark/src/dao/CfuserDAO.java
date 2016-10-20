package dao;


import java.util.List;

import mypack.cfusers;

public interface CfuserDAO 
{
	public cfusers checklogin(cfusers cfuser);
	public void saveuser(cfusers cfuser);
	public List<cfusers> getrevlist(String state);
	public String getstateid(String state);
	public int getcount(String con);
	public List<cfusers> getalllist(String state);
}
