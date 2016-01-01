package com.placefinderserver.compositekey;

import java.io.Serializable;

public class AuthorityId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1498932313703289852L;

	private String username;
	
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
	
	public boolean equals(Object o) {

        if(o == null)
            return false;

        if(!(o instanceof AuthorityId))
            return false;

        AuthorityId id = (AuthorityId) o;
        if(!(getUsername().equals(id.getUsername()))) {
        	return false;
        }

        if(!(getAuthority().equals(id.getAuthority()))) {
        	return false;
        }

        return true;
    }
	
	public int hashCode() {
		int hash = 3;

	    hash = 47 * hash + ((getUsername() != null) ? getUsername().hashCode() : 0);
	    hash = 47 * hash + ((getAuthority() != null) ? getAuthority().hashCode() : 0);

	    return hash;
	}
}
