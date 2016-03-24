package mypack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_doc")
public class common_doc {
@Id @GeneratedValue
	private int doc_id;
	private String doc_name;
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	@Override
	public String toString() {
		return "common_doc [doc_id=" + doc_id + ", doc_name=" + doc_name + "]";
	}
	
}
