package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "languages")
public class languages {
	@Id @GeneratedValue
	private int id;
	private String lang_id;
	private String lang_name;
	private String state_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLang_id() {
		return lang_id;
	}
	public void setLang_id(String lang_id) {
		this.lang_id = lang_id;
	}
	public String getLang_name() {
		return lang_name;
	}
	public void setLang_name(String lang_name) {
		this.lang_name = lang_name;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	@Override
	public String toString() {
		return "languages [id=" + id + ", lang_id=" + lang_id + ", lang_name=" + lang_name + ", state_id=" + state_id
				+ "]";
	}
	

}
