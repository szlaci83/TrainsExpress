package playground;

/**
 * Class representing a station in the model.
 * Fields creaated according to: https://en.wikipedia.org/wiki/UK_railway_stations
 * 
 * @author Laszlo Szoboszlai
 * 
 */
public class Station{
	private String code;  
	private String stationName;
	private String postCode;
	
		
	public Station(String stationName) {
		super();
		this.stationName = stationName;
	}
	
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
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
		int result = 1;
		result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
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
		if (stationName == null) {
			if (other.stationName != null)
				return false;
		} else if (!stationName.equals(other.stationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.stationName;
	}	
	
	
}