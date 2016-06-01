package mypack;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "service_status")
public class service_status {

	private String operator_id;
	private String service_name;
	private String status;
	private Blob submitted_services;
	private String officer_id;
	private String submitted_date;
	private Date approved_date;
	private String remark;
	private Date rejected_date;
	@Id 
	private String service_id;
	private String procedure_doc;
	private String reviewer_id;
	private String contact;

	public String getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Blob getSubmitted_services() {
		return submitted_services;
	}
	public void setSubmitted_services(Blob submitted_services) {
		this.submitted_services = submitted_services;
	}
	public String getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(String officer_id) {
		this.officer_id = officer_id;
	}
	public String getSubmitted_date() {
		return submitted_date;
	}
	public void setSubmitted_date(String submitted_date) {
		this.submitted_date = submitted_date;
	}
	public Date getApproved_date() {
		return approved_date;
	}
	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getRejected_date() {
		return rejected_date;
	}
	public void setRejected_date(Date rejected_date) {
		this.rejected_date = rejected_date;
	}
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public String getProcedure_doc() {
		return procedure_doc;
	}
	public void setProcedure_doc(String procedure_doc) {
		this.procedure_doc = procedure_doc;
	}
	public String getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(String reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "service_status [operator_id=" + operator_id + ", service_name=" + service_name
				+ ", status=" + status + ", submitted_services=" + submitted_services + ", officer_id=" + officer_id
				+ ", submitted_date=" + submitted_date + ", approved_date=" + approved_date + ", remark=" + remark
				+ ", rejected_date=" + rejected_date + ", service_id=" + service_id + ", procedure_doc=" + procedure_doc
				+ ", reviewer_id=" + reviewer_id + ", contact=" + contact + "]";
	}


}