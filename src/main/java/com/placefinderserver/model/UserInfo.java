package com.placefinderserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Class User for storing User details
 * 
 * @author khalidsaif
 *
 */
@Entity
@Table(name="userinfo")
public class UserInfo implements Serializable {
	/**
	 * Generated serial version ID.
	 */
	private static final long serialVersionUID = 8736666836343162975L;

	/**
	 * Auto generated user ID
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * First name of user
	 */
	@Column(name="firstname")
	private String firstName;
	
	/**
	 * Last name of user
	 */
	@Column(name="lastname")
	private String lastName;
	
	/**
	 * Username of user
	 */
	@Column(name="email", unique=true)
	@NotEmpty
	private String email;
	
	/**
	 * Mobile number of user
	 */
	@Column(name="mobile")
	@NotEmpty
	private String mobile;

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
