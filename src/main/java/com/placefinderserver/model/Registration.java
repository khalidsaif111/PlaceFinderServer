package com.placefinderserver.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Class Registration for storing new User registration details
 * 
 * @author khalidsaif
 *
 */
public class Registration {
	/**
	 * First name of user
	 */
	@Size(min = 1, max = 50)
	private String newUserFirstName;

	/**
	 * Last name of user
	 */
	@Size(min = 0, max = 50)
	private String newUserLastName;

	/**
	 * Username of user
	 */
	@Size(min = 4, max = 100)
	private String newUserEmail;

	/**
	 * Password of user
	 */
	@Size(min = 8, max = 25)
	private String newUserPassword;

	/**
	 * Confirm password of user
	 */
	@NotEmpty
	private String newUserConfirmPassword;
	
	/**
	 * Mobile number of user
	 */
	@Size.List ({
	    @Size(min=10, message="must be 10 digit number"),
	    @Size(max=10, message="must be 10 digit number")
	})
	private String mobile;
	
	/**
	 * Role of user
	 */
	@NotEmpty
	private String role;

	/**
	 * @return the newUserFirstName
	 */
	public String getNewUserFirstName() {
		return this.newUserFirstName;
	}

	/**
	 * @param newUserFirstName
	 *            the newUserFirstName to set
	 */

	public void setNewUserFirstName(String newUserFirstName) {
		this.newUserFirstName = newUserFirstName;
	}

	/**
	 * @return the newUserLastName
	 */
	public String getNewUserLastName() {
		return this.newUserLastName;
	}

	/**
	 * @param newUserLastName
	 *            the newUserLastName to set
	 */
	public void setNewUserLastName(String newUserLastName) {
		this.newUserLastName = newUserLastName;
	}

	
	public String getNewUserEmail() {
		return newUserEmail;
	}

	public void setNewUserEmail(String newUserEmail) {
		this.newUserEmail = newUserEmail;
	}

	/**
	 * @return the newUserPassword
	 */
	public String getNewUserPassword() {
		return this.newUserPassword;
	}

	/**
	 * @param newUserPassword
	 *            the newUserPassword to set
	 */
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}

	/**
	 * @return the newUserConfirmPassword
	 */
	public String getNewUserConfirmPassword() {
		return this.newUserConfirmPassword;
	}

	/**
	 * @param newUserConfirmPassword
	 *            the newUserConfirmPassword to set
	 */
	public void setNewUserConfirmPassword(String newUserConfirmPassword) {
		this.newUserConfirmPassword = newUserConfirmPassword;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
