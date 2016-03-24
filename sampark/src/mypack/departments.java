package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class departments {
	@Id @GeneratedValue
	private  int id;
	private String dept_id;
	private String dept_name;
	private String state_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	@Override
	public String toString() {
		return "departments [id=" + id + ", dept_id=" + dept_id + ", dept_name=" + dept_name + ", state_id=" + state_id
				+ "]";
	}
}
