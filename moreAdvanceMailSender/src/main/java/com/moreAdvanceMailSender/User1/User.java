package com.moreAdvanceMailSender.User1;


import jakarta.persistence.*;



@Entity
public class User {

	@Id
	@SequenceGenerator(name = "User_Sequence", sequenceName = "User_Sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Sequence")
	private Long idLong;
	
	@Column(name = "userName")
	private String userNameString;
	

	private String pin;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public User() {
	}

	public User(String userNameString) {
		this.userNameString = userNameString;

	}

	public User(String userNameString, String pin) {
		super();
		this.userNameString = userNameString;

		this.pin = pin;
	}

	public Long getIdLong() {
		return idLong;
	}

	public void setIdLong(Long idLong) {
		this.idLong = idLong;
	}

	public String getUserNameString() {
		return userNameString;
	}

	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}


	
	
}
