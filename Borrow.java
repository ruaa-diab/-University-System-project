package TheLibrary;

public class Borrow {
private NewDate acquisitionTime;
private NewDate dueDate;
private LibraryMember who;


public Borrow() {
	
}

public Borrow(LibraryMember who) {
	this.who=who;
}
public Borrow(NewDate acquisitionTime, NewDate dueDate,LibraryMember who) {
	this.acquisitionTime=acquisitionTime;
	this.dueDate=dueDate;
	this.who=who;
}
public NewDate getAcquisitiobTime() {
	return acquisitionTime;
}
public void setAcquisitiobTime(NewDate acquisitiobTime) {
	this.acquisitionTime = acquisitiobTime;
}
public NewDate getDueDate() {
	return dueDate;
}
public void setDueDate(NewDate dueDate) {
	this.dueDate = dueDate;
}
public LibraryMember getWho() {
	return who;
}
public void setWho(LibraryMember who) {
	this.who = who;
}




	
	
	
}
