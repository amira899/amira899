package com.springboot.app.monitoring.model;

public class ResultTraceMail {
	private String adressMail;
	private String receiver;
	private String send_date;
	public String getAdressMail() {
		return adressMail;
	}
	public void setAdressMail(String adressMail) {
		this.adressMail = adressMail;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	@Override
	public String toString() {
		return "ResultTraceMail [adressMail=" + adressMail + ", receiver=" + receiver + ", send_date=" + send_date
				+ "]";
	}
}