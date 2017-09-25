package com.laszlo.szoboszlai.trainsexpress.model;

import java.io.Serializable;

/**
 * Simple bean to represent a station in the model.
 * @author Laszlo Szoboszlai
 *
 */
public class Station implements Serializable{
	private static final long serialVersionUID = 6844629977154492105L;
	private String name;
	
	public Station(){
	}
	
	public Station(String name){
		this.name = name;
	}
	
	public String getStationName() {
		return name;
	}
	public void setStationName(String stationName) {
		this.name = stationName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
