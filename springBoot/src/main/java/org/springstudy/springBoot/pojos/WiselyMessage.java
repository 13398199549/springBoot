package org.springstudy.springBoot.pojos;
/**
 * 从浏览器接收消息类
 * @author Administrator
 *
 */
public class WiselyMessage {

	private String information;
	
	public WiselyMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "WiselyMessage [information=" + information + "]";
	}
}
