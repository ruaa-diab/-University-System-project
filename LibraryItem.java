package TheLibrary;

public abstract class  LibraryItem implements Comparable<LibraryItem>,Cloneable {
	
	
	
	
	
	
	
	public LibraryItem() {
		
	}

	
	private String title;
	private int numberOfCopies;
	private int itemNumber;//i added this data field so i can override the getter and setter and be able to use it.
	private Name writer;
	
	public LibraryItem(String title,int numberOfCopies) {
		this.title=title;
		this.numberOfCopies=numberOfCopies;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}


	public int getItemNumber() {
		return itemNumber;
	}


	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}


	public Name getWriter() {
		return writer;
	}


	public void setWriter(Name writer) {
		this.writer = writer;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(LibraryItem o) {
		return this.title.compareTo(o.getTitle()) ;
			
		
	}
	
	
	@Override
	public LibraryItem clone() throws CloneNotSupportedException {
		try {
			
		
		LibraryItem itemCloned=(LibraryItem) super.clone();  //here it already  copies all the non object fields so objects are left.
		 if (this.writer != null) {
	            itemCloned.writer = (Name) this.writer.clone();
	       }
		 return itemCloned;
		}catch(CloneNotSupportedException e) {
			throw e;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
