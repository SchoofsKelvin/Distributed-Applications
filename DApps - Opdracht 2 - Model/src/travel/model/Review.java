package travel.model;

public class Review {

	private String	location;
	private String	description;

	public Review() {}

	public Review(String loc, String desc) {
		location = loc;
		description = desc;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}
}
