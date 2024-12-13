package TheLibrary;

import java.io.IOException;
import java.util.ArrayList;

public abstract class  LibraryMember {
	private Name name;
	private String phoneNumber;
	private String emailAddress;
	private NewDate dateOfBirth;
	private Address address;
	private LibraryItem[] listOfLibraryItems=new LibraryItem[0]; //all the things the person borrowed
	private int numberOfBorrowedItems;// the number of them
	private int memberId;
	
	public LibraryMember() {
		
	}
	public LibraryMember(Name name,
	 String phoneNumber,
	 String emailAddress,
	 NewDate dateOfBirth,
	 Address address,
	 LibraryItem[] listOfLibraryItems,int numberOfBorrowedItems) {
		this.name= new Name ();
		this.phoneNumber=phoneNumber;
		this.emailAddress=emailAddress;
		this.dateOfBirth=dateOfBirth;
		this.address=address;
		this.listOfLibraryItems=listOfLibraryItems;
		this.numberOfBorrowedItems=numberOfBorrowedItems;
		
		
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public NewDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(NewDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LibraryItem[] getListOfLibraryItems() {
		return listOfLibraryItems;
	}
	public void setListOfLibraryItems(LibraryItem[] listOfLibraryItems) {
		this.listOfLibraryItems = listOfLibraryItems;
	}
	public int getNumberOfBorrowedItems() {
		return numberOfBorrowedItems;
	}
	public void setNumberOfBorrowedItems(int numberOfBorrowedItems) {
		this.numberOfBorrowedItems = numberOfBorrowedItems;
	}
	
	
	
	
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public abstract void borrowItem(Library library,int memberId, String title) throws ItemNotFoundException, IOException ;
	
	

}
