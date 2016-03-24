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
	@Id @GeneratedValue
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String operator_id;
	private String service_name;
	private String Status;
	private Blob Submitted_services;
	private String Officer_id;
	private String Submitted_date;
	private Date Approved_date;
	private String Remark;
	private Date Rejected_date;
	private String service_id;
	private String procedure_doc;
	private String reviewer_id;
	private String department_name;
	private String eligibility;
	private String fee;
	private String language;
	private String expected_delivery_date;
	public String getOperator_id() {
		return operator_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getExpected_delivery_date() {
		return expected_delivery_date;
	}
	public void setExpected_delivery_date(String expected_delivery_date) {
		this.expected_delivery_date = expected_delivery_date;
	}
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getOfficer_id() {
		return Officer_id;
	}
	public void setOfficer_id(String officer_id) {
		Officer_id = officer_id;
	}
	public String getSubmitted_date() {
		return Submitted_date;
	}
	public void setSubmitted_date(String submitted_date) {
		Submitted_date = submitted_date;
	}
	public Date getApproved_date() {
		return Approved_date;
	}
	public void setApproved_date(Date approved_date) {
		Approved_date = approved_date;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Date getRejected_date() {
		return Rejected_date;
	}
	public void setRejected_date(Date rejected_date) {
		Rejected_date = rejected_date;
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
	@Override
	public String toString() {
		return "service_status [id=" + id + ", operator_id=" + operator_id + ", service_name=" + service_name
				+ ", Status=" + Status + ", Submitted_services=" + Submitted_services + ", Officer_id=" + Officer_id
				+ ", Submitted_date=" + Submitted_date + ", Approved_date=" + Approved_date + ", Remark=" + Remark
				+ ", Rejected_date=" + Rejected_date + ", service_id=" + service_id + ", procedure_doc=" + procedure_doc
				+ ", reviewer_id=" + reviewer_id + ", department_name=" + department_name + ", eligibility="
				+ eligibility + ", fee=" + fee + ", language=" + language + ", expected_delivery_date="
				+ expected_delivery_date + "]";
	}
	public String getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(String reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	public Blob getSubmitted_services() {
		return Submitted_services;
	}
	public void setSubmitted_services(Blob submitted_services) {
		Submitted_services = submitted_services;
	}
	


}
