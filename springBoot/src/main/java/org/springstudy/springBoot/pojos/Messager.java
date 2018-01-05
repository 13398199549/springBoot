package org.springstudy.springBoot.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messager {

	private boolean status;
	private String information;
	public Messager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messager(boolean status, String information) {
		super();
		this.status = status;
		this.information = information;
	}
	@XmlElement
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@XmlElement
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Messager [status=" + status + ", information=" + information + "]";
	}
	
}
