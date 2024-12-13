package TheLibrary;
//if the file exists but empty it doesn't exist for the scanner.....




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryDriver {
	public static void main(String[] args) throws ItemNotFoundException , ItemNotFoundException, IOException{
		
		
		
		 String itemFile="Item.txt";
		
		
		 try {
			    File file = new File("Items.txt");
			    PrintWriter output = new PrintWriter(file);
			    output.println("Book,273565,The Great Gatsby,10,F. Scott,Fitzgerald\r\n"
			            + "Book,120084,To Kill a Mockingbird,8,Harper,Lee\r\n"
			            + "Book,524935,1984,12,George,Orwell\r\n"
			            + "Book,9783268,Pride and Prejudice,6,Jane,Austen\r\n"
			            + "Book,6769488,The Catcher in the Rye,9,J.D.,Salinger\r\n"
			            + "CD,0,Abbey Road,5,17,The,Beatles\r\n"
			            + "CD,0,Thriller,8,9,Michael ,Jackson\r\n"
			            + "CD,0,Back in Black,6,10,AC,DC\r\n"
			            +"CD,0,Hotel California,4,9,Eag,les\r\n"
			            + "CD,0,The Dark Side of the Moon,7,10,Pink,Floyd\r\n"
			           
			            + "");
			    output.close();
			    System.out.println(file.exists());
			} catch (Exception e) {
			    System.out.println("File not created.");
			}

		 
		 try {
			    File file = new File("members.txt");
			    PrintWriter output = new PrintWriter(file);
			    output.println("LibraryWorker,12345,John,Doe,123 Main St,City,Building,PO Box,Country,1,January,1990,123-456-7890,john.doe@example.com\r\n"
			    		+ "LibraryWorker,12346,Alice,Smith,456 Elm St,Town,Tower,PO Box,Country,2,February,1991,234-567-8901,alice.smith@example.com\r\n"
			    		+ "LibraryWorker,12347,Bob,Johnson,789 Oak St,Village,Villa,PO Box,Country,3,March,1992,345-678-9012,bob.johnson@example.com\r\n"
			    		+ "LibraryWorker,123458,Emily,Brown,987 Pine St,Hamlet,House,PO Box,Country,4,April,1993,456-789-0123,emily.brown@example.com\r\n"
			    		+ "Student,1001,Alice,Smith,123 Main St,Springfield,Alice's Building,12345,USA,1,January,2000,123456789,alice@example.com\r\n"
			    		+ "Student,1002,Bob,Johnson,456 Elm St,Springfield,Bob's Building,54321,USA,15,February,1999,987654321,bob@example.com\r\n"
			    		+ "Student,1003,Charlie,Brown,789 Oak St,Springfield,Charlie's Building,67890,USA,25,March,2001,456123789,charlie@example.com\r\n"
			    		+ "Student,1004,Diana,Miller,321 Pine St,Springfield,Diana's Building,13579,USA,10,April,2002,789456123,diana@example.com\r\n"
			    		+ "Professor,487951,Alice,Smith,123 Main St,Any,Country,12345,zumaum,1,January,1980,123-456-7890,alice.smith@example.com,60000\r\n"
			    		+ "Professor,562148,Bob,Johnson,456 Elm St,Othertown,Country2,23456,mas,2,February,1975,234-567-8901,bob.johnson@example.com,70000\r\n"
			    		+ "Professor,45851,Carol,Williams,789 Oak St,Somewhere,Country3,34567,today,3,March,1988,345-678-9012,carol.williams@example.com,80000\r\n"
			    		+ "Professor,214789,David,Brown,012 Pine St,Nowhere,Country4,45678,welcome,4,April,1970,456-789-0123,david.brown@example.com,90000"
			            + "");
			    output.close();
			    System.out.println(file.exists());
			} catch (Exception e) {
			    System.out.println("File not created.");
			}

	    // Create a new Library
		
		
		/*
		  try {
		File file=new File("members.txt");
		PrintWriter output=new PrintWriter(file);
		output.print("LibraryWorker,12345,ruaa,diab,almasyous,9,may,2024,51455845844,whiteflower_2002@hotmail.com");
		
		output.close();
		  }catch(FileNotFoundException e) {
			
		System.out.println("file doesn't exist");
		
		}
		*/
		
		LibraryItem book1 = new Book("The Great Gatsby", 10, new Name("F. Scott", "Fitzgerald"), 273565);
		LibraryItem book2 = new Book("To Kill a Mockingbird", 8, new Name("Harper", "Lee"), 120084);
		LibraryItem book3 = new Book("1984", 12, new Name("George", "Orwell"), 524935);

		LibraryItem book4 = new Book("Pride and Prejudice", 6, new Name("Jane", "Austen"), 9783268);

	    LibraryItem book5 = new Book("The Catcher in the Rye", 9, new Name("J.D.", "Salinger"), 6769488);
	    
	    
	    
	    
	    
	    LibraryItem cd1 = new CD("Abbey Road", 5, 17, new Name("The"," Beatles"));
	    LibraryItem cd2 = new CD("Thriller", 8, 9, new Name("Michael ","Jackson"));
	    LibraryItem cd3 = new CD("Back in Black", 6, 10, new Name("AC","DC"));
	    LibraryItem cd4 = new CD("The Dark Side of the Moon", 7, 10, new Name("Pink"," Floyd"));

	    LibraryItem cd5 = new CD("Hotel California", 4, 9, new Name("Eag","les"));
	    
	    
	    
	    ArrayList<LibraryItem> itemList = new ArrayList<>();
	    itemList.add(cd5);
	    itemList.add(cd4);
	    itemList.add(cd3);
	    itemList.add(cd2);
	    itemList.add(cd1);
	    itemList.add(book5);
	    itemList.add(book4);
	    itemList.add(book4);
	    itemList.add(book3);
	    itemList.add(book2);
	    itemList.add(book1);
	    Library library = new Library(itemList, "My Library");
	   
	    Name name1 = new Name("John", "Doe");
        Name name2 = new Name("Alice", "Smith");
        Name name3 = new Name("Bob", "Johnson");
        Name name4 = new Name("Emily", "Brown");

       
        Address address1 = new Address("123 Main St", "City", "Building", "PO Box", "Country");
        Address address2 = new Address("456 Elm St", "Town", "Tower", "PO Box", "Country");
        Address address3 = new Address("789 Oak St", "Village", "Villa", "PO Box", "Country");
        Address address4 = new Address("987 Pine St", "Hamlet", "House", "PO Box", "Country");

       
        LibraryItem[] items = new LibraryItem[0];

        // Creating LibraryWorker objects

       // LibraryMember worker1 = new LibraryWorker(name1, "123-456-7890", "john.doe@example.com", new NewDate(1, "January", 1990), address1, items, 0, 12345);
        LibraryMember worker2 = new LibraryWorker(name2, "234-567-8901", "alice.smith@example.com", new NewDate(2, "February", 1991), address2, items, 0,12345);
        LibraryMember worker3 = new LibraryWorker(name3, "345-678-9012", "bob.johnson@example.com", new NewDate(3, "March", 1992), address3, items, 0, 34567);
        LibraryMember worker4 = new LibraryWorker(name4, "456-789-0123", "emily.brown@example.com", new NewDate(4, "April", 1993), address4, items, 0, 45678);

	    
        ArrayList<LibraryMember> members = new ArrayList<>();
       // members.add(worker1);
        members.add(worker2);
        members.add(worker3);
        members.add(worker4);
        
        
        
       
        
        LibraryMember student1 = new Student(new Name("Alice", "Smith"), "123456789", "alice@example.com", new NewDate(1, "January", 2000), new Address("123 Main St", "Springfield", "Alice's Building", "12345", "USA"),new LibraryItem[0], 0, 1001, 95);
        LibraryMember student2 = new Student(new Name("Bob", "Johnson"), "987654321", "bob@example.com", new NewDate(15, "February", 1999), new Address("456 Elm St", "Springfield", "Bob's Building", "54321", "USA"), new LibraryItem[0], 0, 1002, 88);
        LibraryMember student3 = new Student(new Name("Charlie", "Brown"), "456123789", "charlie@example.com", new NewDate(25, "March", 2001), new Address("789 Oak St", "Springfield", "Charlie's Building", "67890", "USA"), new LibraryItem[0], 0, 1003, 91);
        LibraryMember student4 = new Student(new Name("Diana", "Miller"), "789456123", "diana@example.com", new NewDate(10, "April", 2002), new Address("321 Pine St", "Springfield", "Diana's Building", "13579", "USA"), new LibraryItem[0], 0, 1004, 87);

       
        members.add(student1);
        members.add(student2);
        members.add(student3);
        members.add(student4);

        
        Name professor1Name = new Name("Alice", "Smith");
        String professor1PhoneNumber = "123-456-7890";
        String professor1EmailAddress = "alice.smith@example.com";
        NewDate professor1DateOfBirth = new NewDate(1, "January", 1980);
        Address professor1Address = new Address("123 Main St", "Any", "Country", "12345","zumaum");
        LibraryItem[] professor1ListOfLibraryItems = new LibraryItem[0];
        int professor1NumberOfBorrowedItems = 0;
        int professor1Salary = 60000;
        Name professor2Name = new Name("Bob", "Johnson");
        String professor2PhoneNumber = "234-567-8901";
        String professor2EmailAddress = "bob.johnson@example.com";
        NewDate professor2DateOfBirth = new NewDate(2, "February", 1975);
        Address professor2Address = new Address("456 Elm St", "Othertown", "Country2", "23456","mas");
        LibraryItem[] professor2ListOfLibraryItems = new LibraryItem[0];
        int professor2NumberOfBorrowedItems = 0;
        int professor2Salary = 70000;
        Name professor3Name = new Name("Carol", "Williams");
        String professor3PhoneNumber = "345-678-9012";
        String professor3EmailAddress = "carol.williams@example.com";
        NewDate professor3DateOfBirth = new NewDate(3, "March", 1988);
        Address professor3Address = new Address("789 Oak St", "Somewhere", "Country3", "34567","today");
        LibraryItem[] professor3ListOfLibraryItems = new LibraryItem[0];
        int professor3NumberOfBorrowedItems = 0;
        int professor3Salary = 80000;
        Name professor4Name = new Name("David", "Brown");
        String professor4PhoneNumber = "456-789-0123";
        String professor4EmailAddress = "david.brown@example.com";
        NewDate professor4DateOfBirth = new NewDate(4, "April", 1970);
        Address professor4Address = new Address("012 Pine St", "Nowhere", "Country4", "45678","welcome");
        LibraryItem[] professor4ListOfLibraryItems = new LibraryItem[0];
        int professor4NumberOfBorrowedItems = 0;
        int professor4Salary = 90000;
        LibraryMember professor1 = new Professor(professor1Name, professor1PhoneNumber, professor1EmailAddress,
                professor1DateOfBirth, professor1Address, professor1ListOfLibraryItems,
                professor1NumberOfBorrowedItems, professor1Salary,487951);

        LibraryMember professor2 = new Professor(professor2Name, professor2PhoneNumber, professor2EmailAddress,
                professor2DateOfBirth, professor2Address, professor2ListOfLibraryItems,
                professor2NumberOfBorrowedItems, professor2Salary,562148);

        LibraryMember professor3 = new Professor(professor3Name, professor3PhoneNumber, professor3EmailAddress,
                professor3DateOfBirth, professor3Address, professor3ListOfLibraryItems,
                professor3NumberOfBorrowedItems, professor3Salary,45851);

      //  LibraryMember professor4 = new Professor(professor4Name, professor4PhoneNumber, professor4EmailAddress,
        //        professor4DateOfBirth, professor4Address, professor4ListOfLibraryItems,
          //      professor4NumberOfBorrowedItems, professor4Salary,214789);

        
        
        members.add(professor1);
        members.add(professor2);
        members.add(professor3);
        //members.add(professor4);
        library.setMembers(members);
        library.setList(itemList);
        
       // library.updateCdTitle("abbey road", new Name("the","beatles"),12345,"ruaa");
       // library.deleteBook("The Great Gatsby", new Name("F. Scott","Fitzgerald"), 12345);
        try {
    worker2.borrowItem(library, 12345," Great Gatsby");
        }catch(ItemNotFoundException e) {
        	System.out.println("this book does not exist");
        }

;
      
     //   System.out.println("Current working directory: " + System.getProperty(""));

       	

     //  library.printReport();
       
       
    /* Library cs=new Library();
     try {
		cs.setList(library.cloneItems());
	} catch (CloneNotSupportedException e) {
		System.out.println("this feature is nit supported here");
	}
          cs.printReport();
         */
       
       
      
        
System.out.println("Are you 1. Student 2. Professor 3. Library Worker");
Scanner scanner = new Scanner(System.in);
int ans1 = scanner.nextInt();
scanner.nextLine(); // consume newline

if (ans1 == 1) { // Student
    System.out.println("What is your student ID?");
    int stid = scanner.nextInt();
    scanner.nextLine(); // consume newline
    System.out.println("What do you want to do? 1. Search for item 2. Borrow a book or CD 3. Print report of all books");
    int ans1a = scanner.nextInt();
    scanner.nextLine(); // consume newline

    if (ans1a == 1) {
        System.out.println("Do you want to search for a 1. Book or 2. CD?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.println("Do you want to search by 1. Book title 2. Book ISBN 3. Book and author name?");
            int searchChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (searchChoice) {
                case 1:
                    System.out.println("Please enter the name of the book:");
                    String bookName = scanner.nextLine();
                    try {
                        library.searchBooksByTitle(bookName, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the book ISBN:");
                    int n1 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    try {
                        library.searchBook(n1, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the book:");
                    String bookname = scanner.nextLine();
                    System.out.println("Please enter the author's first name:");
                    String nameOne = scanner.nextLine();
                    System.out.println("Please enter the author's second name:");
                    String nameTwo = scanner.nextLine();
                    Name authName = new Name(nameOne, nameTwo);
                    try {
                        library.searchBooksByTitleAndAuthor(bookname, authName, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        } else if (choice == 2) {
            System.out.println("Do you want to search by 1. CD name 2. Composer name 3. Both?");
            int searchChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (searchChoice) {
                case 1:
                    System.out.println("Please enter the name of the CD:");
                    String cdname = scanner.nextLine();
                    try {
                        library.searchCdsByTitle(cdname, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the composer's first name:");
                    String nameOne = scanner.nextLine();
                    System.out.println("Please enter the composer's second name:");
                    String nameTwo = scanner.nextLine();
                    Name composerName = new Name(nameOne, nameTwo);
                    try {
                        library.searchCdsByComposer(composerName, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the CD:");
                    String cdname1 = scanner.nextLine();
                    System.out.println("Please enter the composer's first name:");
                    String nameOne1 = scanner.nextLine();
                    System.out.println("Please enter the composer's second name:");
                    String nameTwo1 = scanner.nextLine();
                    Name composerName1 = new Name(nameOne1, nameTwo1);
                    try {
                        library.searchBooksByTitleAndAuthor(cdname1, composerName1, stid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        } else {
            System.out.println("Invalid entry");
        }
    } else if (ans1a == 2) {
        Student std = new Student();
        std.setMemberId(stid);
        System.out.println("Please enter the title of the book or CD you want to borrow:");
        String title = scanner.nextLine();
        try {
            std.borrowItem(library, stid, title);
            System.out.println("Item borrowed successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
        } catch (ItemNotFoundException e) {
            System.out.println("The book or CD you want doesn't exist");
        } catch (MaxBorrowLimitException e) {
            System.out.println("You already borrowed five items");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument provided.");
        }
    } else if (ans1a == 3) {
        try {
            library.printReport();
        } catch (FileNotFoundException e) {
            System.out.println("Items file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
        }
    } else {
        System.out.println("Invalid entry");
    }

} else if (ans1 == 2) { // Professor
    System.out.println("Do you want to 1. Search for a book or CD 2. Borrow one 3. Print report of all library items");
    int ans1b = scanner.nextInt();
    System.out.println("What is your ID?");
    int pfid = scanner.nextInt();
    scanner.nextLine(); // consume newline

    if (ans1b == 1) {
        System.out.println("Do you want to search for a 1. Book or 2. CD?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.println("Do you want to search by 1. Book title 2. Book ISBN 3. Book and author name?");
            int searchChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (searchChoice) {
                case 1:
                    System.out.println("Please enter the name of the book:");
                    String bookName = scanner.nextLine();
                    try {
                        library.searchBooksByTitle(bookName, pfid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the book ISBN:");
                    int n1 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    try {
                        library.searchBook(n1, pfid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the book:");
                    String bookname = scanner.nextLine();
                    System.out.println("Please enter the author's first name:");
                    String nameOne = scanner.nextLine();
                   
                   
                    System.out.println("Please enter the author's second name:");
                    String nameTwo = scanner.nextLine();
                    Name authName = new Name(nameOne, nameTwo);
                    try {
                        library.searchBooksByTitleAndAuthor(bookname, authName, pfid);
                    } catch (FileNotFoundException e) {
                        System.out.println("Items file not found.");
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument provided.");
                    }
                    break;
                    default:
                        System.out.println("Invalid entry");
                    break;
                    }
                    } else if (choice == 2) {
                    System.out.println("Do you want to search by 1. CD name 2. Composer name 3. Both?");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    switch (searchChoice) {
                    case 1:
                        System.out.println("Please enter the name of the CD:");
                        String cdname = scanner.nextLine();
                        try {
                            library.searchCdsByTitle(cdname, pfid);
                        } catch (FileNotFoundException e) {
                            System.out.println("Items file not found.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading from the file.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid argument provided.");
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the composer's first name:");
                        String nameOne = scanner.nextLine();
                        System.out.println("Please enter the composer's second name:");
                        String nameTwo = scanner.nextLine();
                        Name composerName = new Name(nameOne, nameTwo);
                        try {
                            library.searchCdsByComposer(composerName, pfid);
                        } catch (FileNotFoundException e) {
                            System.out.println("Items file not found.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading from the file.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid argument provided.");
                        }
                        break;
                    case 3:
                        System.out.println("Please enter the name of the CD:");
                        String cdname1 = scanner.nextLine();
                        System.out.println("Please enter the composer's first name:");
                        String nameOne1 = scanner.nextLine();
                        System.out.println("Please enter the composer's second name:");
                        String nameTwo1 = scanner.nextLine();
                        Name composerName1 = new Name(nameOne1, nameTwo1);
                        try {
                            library.searchBooksByTitleAndAuthor(cdname1, composerName1, pfid);
                        } catch (FileNotFoundException e) {
                            System.out.println("Items file not found.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading from the file.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid argument provided.");
                        }
                        break;
                    default:
                        System.out.println("Invalid entry");
                    break;
                    }
                    } else {
                    System.out.println("Invalid entry");
                    }

                    } else if (ans1b == 2) {
                    System.out.println("Please enter the title of the book or CD you want to borrow:");
                    String title = scanner.nextLine();
                    Professor p = new Professor();
                    p.setMemberId(pfid);
                    try {
                    p.borrowItem(library, pfid, title);
                    System.out.println("Item borrowed successfully.");
                    } catch (FileNotFoundException e) {
                    System.out.println("Members file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (ItemNotFoundException e) {
                    System.out.println("The book or CD you want doesn't exist");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    } else if (ans1b == 3) {
                    try {
                    library.printReport();
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    }
                    } else {
                    System.out.println("Invalid entry");
                    }
                    } else if (ans1 == 3) {
                    System.out.println("Do you want to 1. Search for a book or CD 2. Borrow one 3. Print report of all library items 4. Add a book or CD 5. Update a book or CD 6. Delete library item");
                    int ans1c = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("What is your ID?");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    if (ans1c == 1) {
                    System.out.println("Do you want to search for a 1. Book or 2. CD?");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (choice == 1) {
                    System.out.println("Do you want to search by 1. Book name 2. Book ISBN 3. Book name and author name?");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    switch (searchChoice) {
                    case 1:
                    System.out.println("Please enter the name of the book:");
                    String bookName = scanner.nextLine();
                    try {
                    library.searchBooksByTitle(bookName, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    case 2:
                    System.out.println("Please enter the book ISBN:");
                    int n1 = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    try {
                    library.searchBook(n1, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    case 3:
                    System.out.println("Please enter the name of the book:");
                    String bookname = scanner.nextLine();
                    System.out.println("Please enter the author's first name:");
                    String nameOne = scanner.nextLine();
                    System.out.println("Please enter the author's second name:");
                    String nameTwo = scanner.nextLine();
                    Name authName = new Name(nameOne, nameTwo);
                    try {
                    library.searchBooksByTitleAndAuthor(bookname, authName, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    default:
                    System.out.println("Invalid entry");
                    break;
                    }
                    } else if (choice == 2) {
                    System.out.println("Do you want to search by 1. CD name 2. Composer name 3. Both?");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    switch (searchChoice) {
                    case 1:
                    System.out.println("Please enter the name of the CD:");
                    String cdname = scanner.nextLine();
                    try {
                    library.searchCdsByTitle(cdname, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    case 2:
                    System.out.println("Please enter the composer's first name:");
                    String nameOne = scanner.nextLine();
                    System.out.println("Please enter the composer's second name:");
                    String nameTwo = scanner.nextLine();
                    Name composerName = new Name(nameOne, nameTwo);
                    try {
                    library.searchCdsByComposer(composerName, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    case 3:
                    System.out.println("Please enter the name of the CD:");
                    String cdname1 = scanner.nextLine();
                    System.out.println("Please enter the composer's first name:");
                    String nameOne1 = scanner.nextLine();
                    System.out.println("Please enter the composer's second name:");
                    String nameTwo1 = scanner.nextLine();
                    Name composerName1 = new Name(nameOne1, nameTwo1);
                    try {
                    library.searchBooksByTitleAndAuthor(cdname1, composerName1, id);
                    } catch (FileNotFoundException e) {
                    System.out.println("Items file not found.");
                    } catch (IOException e) {
                    System.out.println("An error occurred while reading from the file.");
                    } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    } catch (IllegalArgumentException e) {
                    System.out.println("Invalid argument provided.");
                    }
                    break;
                    default:
                    System.out.println("Invalid entry");
                    break;
                    }
                    } else {
                    System.out.println("Invalid number");
                    }
                    } else if (ans1c == 2) {
                        System.out.println("Please enter the title of the book or CD you want to borrow:");
                        String title = scanner.nextLine();
                        LibraryWorker l = new LibraryWorker();
                        l.setMemberId(id);
                        try {
                            l.borrowItem(library, id, title);
                            System.out.println("Item borrowed successfully.");
                        } catch (FileNotFoundException e) {
                            System.out.println("Members file not found.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading from the file.");
                        } catch (ItemNotFoundException e) {
                            System.out.println("The book or CD you want doesn't exist.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input type.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid argument provided.");
                        }
                    } else if (ans1c == 3) {
                        try {
                            library.printReport();
                        } catch (FileNotFoundException e) {
                            System.out.println("Items file not found.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading from the file.");
                        }
                    } else if (ans1c == 4) {
                        System.out.println("Do you want to add a 1. Book or 2. CD?");
                        int choice1 = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (choice1) {
                            case 1:
                                System.out.println("Please enter the book ISBN:");
                                int isbn = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                try {
                                    library.addBook(isbn, id);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input type.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid argument provided.");
                                }
                                break;
                            case 2:
                                System.out.println("Please enter the name of the CD:");
                                String cdname = scanner.nextLine();
                                System.out.println("Please enter the composer's first name:");
                                String nameOne1 = scanner.nextLine();
                                System.out.println("Please enter the composer's second name:");
                                String nameTwo1 = scanner.nextLine();
                                Name composerName1 = new Name(nameOne1, nameTwo1);
                                try {
                                    library.addCd(cdname, composerName1, id);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input type.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid argument provided.");
                                }
                                break;
                            default:
                                System.out.println("Invalid entry");
                                break;
                        }
                    } else if (ans1c == 5) {
                        System.out.println("Do you want to update a 1. CD or 2. Book?");
                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        if (choice2 == 1) {
                            System.out.println("Do you want to update 1. CD name, 2. Composer name, or 3. Number of tracks?");
                            int choice3 = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            switch (choice3) {
                                case 1:
                                    System.out.println("Please enter the name of the CD:");
                                    String cdname = scanner.nextLine();
                                    System.out.println("Please enter the composer's first name:");
                                    String nameOne1 = scanner.nextLine();
                                    System.out.println("Please enter the composer's second name:");
                                    String nameTwo1 = scanner.nextLine();
                                    Name composerName1 = new Name(nameOne1, nameTwo1);
                                    System.out.println("Enter the new name:");
                                    String newName = scanner.nextLine();
                                    try {
                                        library.updateCdTitle(cdname, composerName1, id, newName);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input type.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid argument provided.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Please enter the name of the CD:");
                                    String cdname2 = scanner.nextLine();
                                    System.out.println("Please enter the composer's first name:");
                                    String nameOne2 = scanner.nextLine();
                                    System.out.println("Please enter the composer's second name:");
                                    String nameTwo2 = scanner.nextLine();
                                    Name composerNameOld = new Name(nameOne2, nameTwo2);
                                    System.out.println("Please enter the new composer's first name:");
                                    String newFirstName = scanner.nextLine();
                                    System.out.println("Please enter the new composer's second name:");
                                    String newLastName = scanner.nextLine();
                                    Name composerNameNew = new Name(newFirstName, newLastName);
                                    try {
                                        library.updateCdComposer(cdname2, composerNameOld, id, composerNameNew);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input type.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid argument provided.");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Please enter the name of the CD:");
                                    String cdname3 = scanner.nextLine();
                                    System.out.println("Please enter the composer's first name:");
                                    String nameOne3 = scanner.nextLine();
                                    System.out.println("Please enter the composer's second name:");
                                    String nameTwo3 = scanner.nextLine();
                                    Name composerName3 = new Name(nameOne3, nameTwo3);
                                    System.out.println("Enter the new track number:");
                                    int trackno = scanner.nextInt();
                                    scanner.nextLine(); // consume newline
                                    try {
                                        library.updateCdTrackNumber(cdname3, composerName3, id, trackno);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input type.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid argument provided.");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid entry");
                                    break;
                            }
                        } else if (choice2 == 2) {
                            System.out.println("Please enter the book ISBN:");
                            int isbn = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            System.out.println("Do you want to update 1. Title or 2. Author?");
                            int pick = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            switch (pick) {
                                case 1:
                                    System.out.println("Please enter the new title of the book:");
                                    String newBookName = scanner.nextLine();
                                    try {
                                        library.updateBookTitle(isbn, id, newBookName);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input type.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid argument provided.");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Please enter the author's first name:");
                                    String nameOne = scanner.nextLine();
                                    System.out.println("Please enter the author's second name:");
                                    String nameTwo = scanner.nextLine();
                                    Name authName = new Name(nameOne, nameTwo);
                                    try {
                                        library.updateBookAuthor(isbn, id, authName);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input type.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid argument provided.");
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid entry");
                                    break;
                            }
                        } else {
                            System.out.println("Invalid entry");
                        }
                    } else if (ans1c == 6) {
                        System.out.println("Do you want to delete 1. Book or 2. CD?");
                        int pick = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.println("What is your ID?");
                        int id1 = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        switch (pick) {
                            case 1:
                                System.out.println("Please enter the name of the book:");
                                String bookname = scanner.nextLine();
                                System.out.println("Please enter the author's first name:");
                                String nameOne = scanner.nextLine();
                                System.out.println("Please enter the author's second name:");
                                String nameTwo = scanner.nextLine();
                                Name authName = new Name(nameOne, nameTwo);
                                try {
                                    library.deleteBook(bookname, authName, id1);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input type.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid argument provided.");
                                }
                                break;
                            case 2:
                                System.out.println("Please enter the name of the CD:");
                                String cdname3 = scanner.nextLine();
                                System.out.println("Please enter the composer's first name:");
                                String nameOne3 = scanner.nextLine();
                                System.out.println("Please enter the composer's second name:");
                                String nameTwo3 = scanner.nextLine();
                                Name composerName = new Name(nameOne3, nameTwo3);
                                try {
                                    library.deleteCd(cdname3, composerName, id1);
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input type.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid argument provided.");
                                }
                                break;
                            default:
                                System.out.println("Invalid entry");
                                break;
                        }
                    } else {
                        System.out.println("Invalid entry");
                    }
                    } else {
                    System.out.println("Invalid entry");
                    }
                    }
}                    
                    
                    
                    
                    