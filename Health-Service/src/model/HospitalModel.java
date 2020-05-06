package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HospitalModel {

	
	
	public Integer hid;
	public String hname;
	public String haddress;
	public String hphone;
	public String hemail;
	
	
	
	public Integer getHos_id() {
		//System.out.println("Get h_id");
		return hid;
	}
	public void setHos_id(Integer hos_id) {
		//System.out.println("Get s_id");
		this.hid = hos_id;
	}
	public String getHos_name() {
		return hname;
	}
	public void setHos_name(String hos_name) {
		this.hname = hos_name;
	}
	public String getHos_address() {
		return haddress;
	}
	public void setHos_address(String hos_address) {
		this.haddress = hos_address;
	}
	public String getHos_phone() {
		return hphone;
	}
	public void setHos_phone(String hos_phone) {
		this.hphone = hos_phone;
	}
	public String getHos_email() {
		return hemail;
	}
	public void setHos_email(String hos_email) {
		this.hemail = hos_email;
	}
	@Override
	public String toString() {
		return "HospitalModel [hos_id=" + hid + ", hos_name=" + hname + ", hos_address=" + haddress
				+ ", hos_phone=" + hphone + ", hos_email=" + hemail + "]";
	}
	
	
	
}