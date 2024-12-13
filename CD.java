package TheLibrary;

public class CD extends LibraryItem {
	public CD() {
		
	}
	
	private int trackNo;
	private Name composer;
	public CD(String title,int numberOfCopies,int trackNo,Name composer){
		super(title,numberOfCopies);
		this.trackNo=trackNo;
		this.composer=composer;
		
	}
	
	
	

	/*public int getTrackNo() {
		return trackNo;
	}
	
	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}*/
	
	
	@Override
	public int getItemNumber() {
		

		return trackNo;
	}

	@Override
	public void setItemNumber(int trackNo) {
		this.trackNo = trackNo;
	}
	@Override
	public Name getWriter() {
		return composer;
	}
	@Override
	public void setWriter(Name composer) {
		this.composer = composer;
	}
	public String toString() {
		return "the title of this cd : "+this.getTitle()+" and the name of the composer "+this.getWriter().getFirstName()+" "
	+this.getWriter().getLastName()+" the trackno is : "+
	this.getItemNumber()+"and the number of copies for this cd: "+this.getNumberOfCopies();
	}
	


}
