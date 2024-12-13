package TheLibrary;

 public class Name implements Cloneable {

	
	private String firstName;
	private String secondName;
	private String lastName;
	
	
	
	public Name() {
		
	}
	public Name(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public Name(String firstName,String secondName,String lastName) {
		this.firstName=firstName;
		this.secondName=secondName;
		this.lastName=lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
		
		@Override
		public Name clone() throws CloneNotSupportedException  {
			try {
				
				
				Name n=(Name)super.clone();
				return n;
			}catch(CloneNotSupportedException c) {
				throw c;
			}
		}
	
	
	
}
