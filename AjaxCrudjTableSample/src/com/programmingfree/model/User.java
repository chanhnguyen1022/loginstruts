package com.programmingfree.model;

	public class User {

		private int userid;
		private String customerName;
		private String sex;	
		private String birthDay;
		private String address;
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBirthDay() {
			return birthDay;
		}
		public void setBirthDay(String birthDay) {
			this.birthDay = birthDay;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "User [userid=" + userid + ", CustomerName=" + customerName
					+ ", Sex=" + sex + ", birthDay="
					+ birthDay + ", Address="+address+"]";
		}		
		
}