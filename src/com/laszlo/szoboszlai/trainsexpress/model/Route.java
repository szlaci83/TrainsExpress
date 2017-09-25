package com.laszlo.szoboszlai.trainsexpress.model;

import java.io.Serializable;

/**
 * Bean representing a weighted directed route in the graph.
 * @author Laszlo Szoboszlai
 *
 */
public class Route implements Serializable{
	private static final long serialVersionUID = -6126673185746284730L;
	private Station fromStation;
	private Station toStation;
	private double time;
	
	public Route(){
	}
	
	public Route(Station fromStation, Station toStation, double time ){
        this.fromStation = fromStation;
	    this.toStation = toStation;
	    this.time = time;
	}
	
	public Route(String from, String to, double time){
		this.fromStation = new Station(from);
		this.toStation = new Station(to);
		this.time = time;
	}
	
	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromStation == null) ? 0 : fromStation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(time);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((toStation == null) ? 0 : toStation.hashCode());
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
		Route other = (Route) obj;
		if (fromStation == null) {
			if (other.fromStation != null)
				return false;
		} else if (!fromStation.equals(other.fromStation))
			return false;
		if (Double.doubleToLongBits(time) != Double.doubleToLongBits(other.time))
			return false;
		if (toStation == null) {
			if (other.toStation != null)
				return false;
		} else if (!toStation.equals(other.toStation))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return this.fromStation + " -> " + this.toStation;
	}
		
}
