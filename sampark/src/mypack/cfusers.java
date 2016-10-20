package mypack;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cfusers")
public class cfusers {
	private String user_name;
	private String pass;
	private String authority;
	private String state;
	@Id
	private String user_id;
	private String assigned_officer_id;
	private String fname;
	private String lname;
	private String email;
	private String contact;
	private String created_on;
	private boolean active_flag;
	private String captcha;
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@NotEmpty(message="Username can not be empty")
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@NotEmpty(message="Password can not be empty")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAssigned_officer_id() {
		return assigned_officer_id;
	}
	public void setAssigned_officer_id(String assigned_officer_id) {
		this.assigned_officer_id = assigned_officer_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public boolean isActive_flag() {
		return active_flag;
	}
	public void setActive_flag(boolean active_flag) {
		this.active_flag = active_flag;
	}
	@Override
	public String toString() {
		return "cfusers [user_name=" + user_name + ", pass=" + pass + ", authority=" + authority
				+ ", state=" + state + ", user_id=" + user_id + ", assigned_officer_id=" + assigned_officer_id
				+ ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", contact=" + contact
				+ ", created_on=" + created_on + ", active_flag=" + active_flag + "]";
	}

}
