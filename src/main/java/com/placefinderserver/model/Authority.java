package com.placefinderserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.placefinderserver.compositekey.AuthorityId;

@Entity
@IdClass(AuthorityId.class)
@Table(name = "authorities")
public class Authority {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "authority")
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
