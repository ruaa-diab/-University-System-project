package TheLibrary;

public class Book  extends LibraryItem{
private Name author;
private int ISBN;


public Book() {
	
	
}


public Book(String title,int numberOfCopies,Name author,int ISBN) {
	super(title,numberOfCopies);
	this.author=author;
	this.ISBN=ISBN;
}







public Name getWriter() {
	return author;
}


public void setWriter(Name writer) {
	this.author = writer;
}

@Override
public int getItemNumber() {
	

	return ISBN;
}

@Override
public void setItemNumber(int iSBN) {
	ISBN = iSBN;
}



public String toString() {
	return "the title of this book : "+this.getTitle()+" and the name of the author "+this.getWriter().getFirstName()+" "
+this.getWriter().getLastName()+" the ISBN IS : "+
this.getItemNumber()+"and the number of copies for this CD: "+this.getNumberOfCopies();
}

















}
