package com.placefinderserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "goals")
public class Goal {
	
	@Id
	@GeneratedValue
	private long id;

	@Range(min = 1, max = 120)
	private int minutes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
