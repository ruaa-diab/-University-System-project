package TheLibrary;

public class Address {

	private String street;
	private String city;
	private String buildingName;
	private String poBox;
	private String Country;
	
	
	
	public Address() {
		
	}

	
	public Address(String street ,String city,String buildingName,String poBox,String country ) {
		this.street=street;
		this.city=city;
		this.buildingName=buildingName;
		this.poBox=poBox;
		this.Country=country;
		
	}
	@Override
	public String toString() {
	    return this.getBuildingName() + "@" + this.getStreet() + "@" + this.getCity() + "@" + this.getPoBox();
	}

	
	
	
	
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getPoBox() {
		return poBox;
	}
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
	
}
