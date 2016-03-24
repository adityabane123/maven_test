package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "serv")
public class serv {
	@Id @GeneratedValue
	private int id;
	private String depa;
	private String service;
	private String doc;
	private String Eligibility;
	private String fee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDepa() {
		return depa;
	}
	public void setDepa(String depa) {
		this.depa = depa;
	}
	@NotEmpty(message="Username can not be empty")
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getEligibility() {
		return Eligibility;
	}
	public void setEligibility(String eligibility) {
		Eligibility = eligibility;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "serv [id=" + id + ", depa=" + depa + ", service=" + service + ", doc=" + doc + ", Eligibility="
				+ Eligibility + ", fee=" + fee + "]";
	}
	
}
