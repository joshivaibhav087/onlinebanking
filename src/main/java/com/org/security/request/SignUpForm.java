package com.org.security.request;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.org.security.model.SavingsAccount;

public class SignUpForm {
  
    private String name;

    private String emailId;

    private String password;
    
    private String adhar_number;
    
    private String pan;
    
    private String mobile;
    
    private String gender;
    
 
    private int savings_id;
    
    

	public SignUpForm() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public SignUpForm(String name, String emailId, String password, int savings_id) {
//		super();
//		this.name = name;
//		this.emailId = emailId;
//		this.password = password;
//		this.savings_id = savings_id;
//	}


	public int getSavings_id() {
		return savings_id;
	}


	public void setSavings_id(int savings_id) {
		this.savings_id = savings_id;
	}


//	public SignUpForm(String name, String emailId, String password) {
//		super();
//		this.name = name;
//		this.emailId = emailId;
//		this.password = password;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdhar_number() {
		return adhar_number;
	}


	public void setAdhar_number(String adhar_number) {
		this.adhar_number = adhar_number;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public SignUpForm(String name, String emailId, String mobile,String gender, String password, String adhar_number, String pan) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.gender = gender;
		this.password = password;
		this.adhar_number = adhar_number;
		this.pan = pan;
//		this.savings_id = savings_id;
	}


	@Override
	public String toString() {
		return "SignUpForm [name=" + name + ", emailId=" + emailId + ", password=" + password + ", adhar_number="
				+ adhar_number + ", pan=" + pan + ", mobile=" + mobile + ", gender=" + gender + ", savings_id="
				+ savings_id + "]";
	}


    
  
}