package com.springboot.app.monitoring.model;

import springfox.documentation.spring.web.json.Json;

public class TraceMail {
		 private Long id;
		private String adressMail;
		private String receiver;
		private String end_date;
		private String send_date;
		private Json listprocess;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
		public String getEnd_date() {
			return end_date;
		}
		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}
		public String getSend_date() {
			return send_date;
		}
		public void setSend_date(String send_date) {
			this.send_date = send_date;
		}
		
		public Json getListprocess() {
			return listprocess;
		}
		public void setListprocess(Json listprocess) {
			this.listprocess = listprocess;
		}
		@Override
		public String toString() {
			return "TraceMail [id=" + id + ", adressMail=" + adressMail + ", receiver=" + receiver + ", end_date="
					+ end_date + ", send_date=" + send_date + ", listprocess=" + listprocess + "]";
		}
		
}