package com.laszlo.szoboszlai.trainsexpress.model;

import java.io.Serializable;

/**
 * Bean to represent train stations in the UK.
 * Subclass of the Station class, created according to:
 * https://en.wikipedia.org/wiki/UK_railway_stations
 * 
 * @author Laszlo Szoboszlai
 */
public class TrainStation extends Station implements Serializable{
	private static final long serialVersionUID = -1929697352825161408L;
	private String code;  
	private String postCode;
	
	public TrainStation(){
	}
	
	public TrainStation(String code, String postCode){
		this.code = code;
		this.postCode = postCode;
	}
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainStation other = (TrainStation) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}	
	
}
