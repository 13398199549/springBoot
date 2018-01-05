package org.springstudy.springBoot.pojos;

public class WiselyResponse {

	private String responseMessage;
	
	public WiselyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WiselyResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "WiselyResponse [responseMessage=" + responseMessage + "]";
	}
}
