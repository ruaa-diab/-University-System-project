package TheLibrary;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
	public Library() {
		
	}
	
	
	
	
	  String membersFile = "members.txt";
	 
	
	private ArrayList<LibraryItem> list=new ArrayList<>(0);
	
	private String libraryName;
	
	
	
	
private ArrayList<LibraryMember> members = new ArrayList<>();
	
	
	public Library(ArrayList<LibraryItem> list,String libraryName) {
		this.list=list;
		this.libraryName=libraryName;
	}
	
	
	public ArrayList<LibraryItem> getList() {
		return list;
	}
	public void setList(ArrayList<LibraryItem> list) {
		this.list = list;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	
	
	
	
	
	


	public ArrayList<LibraryMember> getMembers() {
		return members;
	}


	public void setMembers(ArrayList<LibraryMember> members) {
		this.members = members;
	}
	Scanner scanner=new Scanner(System.in);
	
	
	
	
	
	
	
	
	
	
	public void addBook(int ISBN, int staffId) throws IOException {
	    try {
	        boolean staffFound = false;
	        boolean bookFound = false;

	        // Check if the staffId exists and is a LibraryWorker
	        
	        try (Scanner scanner = new Scanner(new File("members.txt"))) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                if (line.startsWith("LibraryWorker")) {
	                    String[] data = line.split(",");
	                    int existingStaffId = Integer.parseInt(data[1]);
	                    if (existingStaffId == staffId) {
	                        staffFound = true;
	                        break;
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!staffFound) {
	            System.out.println("Access denied. You don't work here.");
	            return;
	        }

	        ArrayList<String> fileContent = new ArrayList<>();
	        int numberOfCopies = 0;

	        // Check if the book already exists in the file
	    
	        try (Scanner scanner = new Scanner(new File("Items.txt"))) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                fileContent.add(line);
	                String[] data = line.split(",");
	                if (data[0].equals("Book") && Integer.parseInt(data[1]) == ISBN) {
	                    bookFound = true;
	                    numberOfCopies = Integer.parseInt(data[3]); // Assuming the number of copies is at index 3
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Books file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (bookFound) {
	            System.out.println("The book already exists. How many more copies do you want to add?");
	            int howMany = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            numberOfCopies += howMany;

	            // Update the number of copies in the file
	            try (PrintWriter writer = new PrintWriter(new File("Item.txt"))) {
	                for (String line : fileContent) {
	                    String[] data = line.split(",");
	                    if (data[0].equals("Book") && Integer.parseInt(data[1]) == ISBN) {
	                        writer.println("Book," + ISBN + "," + data[2] + "," + numberOfCopies); // Assuming the title is at index 2
	                    } else {
	                        writer.println(line);
	                    }
	                }
	            } catch (IOException e) {
	                System.out.println("An error occurred while writing to the file.");
	                throw e;
	            }

	            System.out.println("Number of copies updated successfully.");
	        } else {
	            // Add a new book
	            System.out.println("This is a new book. Please enter the name of the book:");
	            String title = scanner.nextLine();
	            System.out.println("Enter the first name of the author:");
	            String authorFirstName = scanner.nextLine();
	            System.out.println("Enter the last name of the author:");
	            String authorLastName = scanner.nextLine();
	            System.out.println("Please enter the number of copies:");
	            int numOfCopies = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            // Create the new book
	            Name authName = new Name(authorFirstName, authorLastName);
	            LibraryItem book = new Book(title, numOfCopies, authName, ISBN);
	            list.add(book);  //but there is no need since we update it on the file
	            
	            

	            // Write the new book's info to the file
	            try (PrintWriter writer = new PrintWriter(new FileWriter("Items.txt", true))) {
	                writer.println("Book," + ISBN + "," + title + "," + numOfCopies + "," + authorFirstName + "," + authorLastName);
	            } catch (IOException e) {
	                System.out.println("An error occurred while writing to the file.");
	                throw e;
	            }

	            System.out.println("The book " + title + " by " + authorFirstName + " " + authorLastName + " has been added successfully.");
	        }
	    } catch (InputMismatchException e) {
	        throw e;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}





	public void addCd(String title, Name composer, int staffId) throws IOException {
	    try {
	        boolean staffFound = false;
	        boolean cdFound = false;
	        Scanner scanner = new Scanner(System.in);

	        // Check if the staffId exists and is a LibraryWorker
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                if (line.startsWith("LibraryWorker")) {
	                    String[] data = line.split(",");
	                    int existingStaffId = Integer.parseInt(data[1]);
	                    if (existingStaffId == staffId) {
	                        staffFound = true;
	                        break;
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!staffFound) {
	            System.out.println("Access denied. You don't work here.");
	            return;
	        }

	        ArrayList<String> fileContent = new ArrayList<>();
	        int numberOfCopies = 0;

	        // Check if the CD already exists in the file
	        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                fileContent.add(line);
	                String[] data = line.split(",");
	                if (data[0].equals("CD") && data[1].equalsIgnoreCase(title) && data[4].equalsIgnoreCase(composer.getFirstName()) && data[5].equalsIgnoreCase(composer.getLastName())) {
	                    cdFound = true;
	                    numberOfCopies = Integer.parseInt(data[2]); // Assuming the number of copies is at index 2
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Items file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (cdFound) {
	            System.out.println("The CD already exists. How many more copies do you want to add?");
	            int howMany = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            numberOfCopies += howMany;

	            // Update the number of copies in the file
	            try (PrintWriter writer = new PrintWriter(new File("Items.txt"))) {
	                for (String line : fileContent) {
	                    String[] data = line.split(",");
	                    if (data[0].equals("CD") && data[1].equalsIgnoreCase(title) && data[4].equalsIgnoreCase(composer.getFirstName()) && data[5].equalsIgnoreCase(composer.getLastName())) {
	                        writer.println("CD," + title + "," + numberOfCopies + "," + data[3] + "," + composer.getFirstName() + "," + composer.getLastName()); // Assuming the tracks number is at index 3
	                    } else {
	                        writer.println(line);
	                    }
	                }
	            } catch (IOException e) {
	                System.out.println("An error occurred while writing to the file.");
	                throw e;
	            }

	            System.out.println("Number of copies updated successfully.");
	        } else {
	            // Add a new CD
	            System.out.println("This is a new CD. Please enter the number of copies:");
	            int numOfCopies = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            System.out.println("Please enter the number of tracks:");
	            int tracksNo = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            // Create the new CD
	            LibraryItem cdNew = new CD(title, numOfCopies, tracksNo, composer);
	            list.add(cdNew);

	            // Write the new CD's info to the file
	            try (PrintWriter writer = new PrintWriter(new FileWriter("Items.txt", true))) {
	                writer.println("CD," + title + "," + numOfCopies + "," + tracksNo + "," + composer.getFirstName() + "," + composer.getLastName());
	            } catch (IOException e) {
	                System.out.println("An error occurred while writing to the file.");
	                throw e;
	            }

	            System.out.println("The CD " + title + " by " + composer.getFirstName() + " " + composer.getLastName() + " has been added successfully.");
	        }
	    } catch (InputMismatchException e) {
	        throw e;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}

	
	
	
	
	
	
	public void searchBook(int ISBN, int memberId) throws IOException {
	    try {
	        boolean memberFound = false;

	        // Check if the memberId exists in the members file
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                String[] data = line.split(",");
	                int existingMemberId = Integer.parseInt(data[1]);
	                if (existingMemberId == memberId) {
	                    memberFound = true;
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!memberFound) {
	            System.out.println("Access denied. Member ID not found.");
	            return;
	        }

	        boolean bookFound = false;
	        int numberOfCopies = 0;
	        String bookTitle = "";

	        // Search for the book in the items file
	        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                String[] data = line.split(",");
	                if (data[0].equals("Book") && Integer.parseInt(data[1]) == ISBN) {
	                    bookFound = true;
	                    bookTitle = data[2];
	                    numberOfCopies = Integer.parseInt(data[3]); // Assuming the number of copies is at index 3
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Items file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (bookFound) {
	            System.out.println("The book " + bookTitle + " is available with " + numberOfCopies + " copies.");
	        } else {
	            System.out.println("The book with ISBN " + ISBN + " was not found.");
	        }
	    } catch (InputMismatchException e) {
	        throw e;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}


	public void searchBooksByTitle(String title, int memberId) throws IOException {
	    try {
	        boolean memberFound = false;

	        // Check if the memberId exists in the members file
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                String[] data = line.split(",");
	                int existingMemberId = Integer.parseInt(data[1]);
	                if (existingMemberId == memberId) {
	                    memberFound = true;
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!memberFound) {
	            System.out.println("You are not registered here.");
	            return;
	        }

	        boolean found = false;

	        // Search for the book by title in the items file
	        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                String[] data = line.split(",");
	                if (data[0].equals("Book") && data[2].equalsIgnoreCase(title)) {
	                    System.out.println("Book found: " + data[2] + " by " + data[4] + " " + data[5]); // Assuming author's first name is at index 4 and last name is at index 5
	                    found = true;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Items file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!found) {
	            System.out.println("No books found with this title.");
	        }
	    } catch (InputMismatchException e) {
	        throw e;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}


	public void searchBooksByTitleAndAuthor(String title, Name author, int memberId) throws IOException {
	    try {
	        boolean memberFound = false;

	        // Check if the memberId exists in the members file
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                String[] data = line.split(",");
	                if (data.length >= 2) {
	                    int existingMemberId = Integer.parseInt(data[1].trim());
	                    if (existingMemberId == memberId) {
	                        memberFound = true;
	                        break;
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!memberFound) {
	            System.out.println("You are not registered here.");
	            return;
	        }

	        boolean found = false;

	        // Search for the book by title and author in the items file
	        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                String[] data = line.split(",");
	                if (data.length >= 6) {
	                    String itemType = data[0].trim();
	                    String bookTitle = data[2].trim();
	                    String authorFirstName = data[4].trim();
	                    String authorLastName = data[5].trim();

	                    if (itemType.equalsIgnoreCase("Book") &&
	                        bookTitle.equalsIgnoreCase(title) &&
	                        authorFirstName.equalsIgnoreCase(author.getFirstName().trim()) &&
	                        authorLastName.equalsIgnoreCase(author.getLastName().trim())) {
	                        System.out.println("Book found: " + bookTitle + " by " + authorFirstName + " " + authorLastName);
	                        found = true;
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Items file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!found) {
	            System.out.println("No book found with the title '" + title + "' by " + author.getFirstName() + " " + author.getLastName());
	        }
	    } catch (InputMismatchException e) {
	        
	        throw e;
	    } catch (IllegalArgumentException e) {
	        
	        throw e;
	    }
	}



	public void searchCdsByComposer(Name composer, int memberId) throws IOException {
	    boolean memberFound = false;

	    // Check if the memberId exists in the members file
	    try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	        while (memberScanner.hasNextLine()) {
	            String line = memberScanner.nextLine();
	            String[] data = line.split(",");
	            if (data.length >= 2) {
	                int existingMemberId = Integer.parseInt(data[1].trim());
	                if (existingMemberId == memberId) {
	                    memberFound = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Members file not found.");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        throw e;
	    }

	    if (!memberFound) {
	        System.out.println("You are not registered here.");
	        return;
	    }

	    boolean found = false;

	    // Search for the CD by composer in the items file
	    try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	        while (itemScanner.hasNextLine()) {
	            String line = itemScanner.nextLine();
	            String[] data = line.split(",");
	            if (data.length >= 7) { // Adjusted length check
	                String itemType = data[0].trim();
	                String composerFirstName = data[5].trim();
	                String composerLastName = data[6].trim();

	                if (itemType.equalsIgnoreCase("CD") &&
	                    composerFirstName.equalsIgnoreCase(composer.getFirstName().trim()) &&
	                    composerLastName.equalsIgnoreCase(composer.getLastName().trim())) {
	                    System.out.println("CD found: " + data[2].trim() + " by " + composerFirstName + " " + composerLastName);
	                    found = true;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Items file not found.");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        throw e;
	    }

	    if (!found) {
	        System.out.println("No CD found by composer " + composer.getFirstName().trim() + " " + composer.getLastName().trim());
	    }
	}


	
	public void searchCdsByTitle(String title, int memberId) throws IOException {
	    try {
	        boolean memberFound = false;

	        // Check if the memberId exists in the members file
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                String[] data = line.split(",");
	                int existingMemberId = Integer.parseInt(data[1]);
	                if (existingMemberId == memberId) {
	                    memberFound = true;
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!memberFound) {
	            System.out.println("You are not registered here.");
	            return;
	        }

	        boolean found = false;

	        // Search for the CD by title in the items file
	        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                String[] data = line.split(",");
	                if (data[0].equals("CD") && data[2].equalsIgnoreCase(title)) {
	                    System.out.println("CD found: " + data[2] + " by " + data[5] + " " + data[6]);
	                    found = true;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Items file not found.");
	            throw e;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the file.");
	            throw e;
	        }

	        if (!found) {
	            System.out.println("No CD found with the title '" + title + "'");
	        }
	    } catch (InputMismatchException e) {
	        throw e;
	    } catch (IllegalArgumentException e) {
	        throw e;
	    }
	}

	
	
	
	public void searchCdsByTitleAndComposer(String title, Name composer, int memberId) throws IOException {
	    boolean memberFound = false;

	    // Check if the memberId exists in the members file
	    try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	        while (memberScanner.hasNextLine()) {
	            String line = memberScanner.nextLine();
	            String[] data = line.split(",");
	            if (data.length >= 2) {
	                int existingMemberId = Integer.parseInt(data[1].trim());
	                if (existingMemberId == memberId) {
	                    memberFound = true;
	                    break;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Members file not found.");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        throw e;
	    }

	    if (!memberFound) {
	        System.out.println("You are not registered here.");
	        return;
	    }

	    boolean found = false;

	    // Search for the CD by title and composer in the items file
	    try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	        while (itemScanner.hasNextLine()) {
	            String line = itemScanner.nextLine();
	            String[] data = line.split(",");
	            if (data.length >= 7) {
	                String itemType = data[0].trim();
	                String cdTitle = data[2].trim();
	                String composerFirstName = data[5].trim();
	                String composerLastName = data[6].trim();

	                if (itemType.equalsIgnoreCase("CD") &&
	                    cdTitle.equalsIgnoreCase(title.trim()) &&
	                    composerFirstName.equalsIgnoreCase(composer.getFirstName().trim()) &&
	                    composerLastName.equalsIgnoreCase(composer.getLastName().trim())) {
	                    System.out.println("CD found: " + cdTitle + " by " + composerFirstName + " " + composerLastName);
	                    found = true;
	                }
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Items file not found.");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        throw e;
	    }

	    if (!found) {
	        System.out.println("No CD found with the title '" + title + "' by " + composer.getFirstName() + " " + composer.getLastName());
	    }
	}





	public void printReport() throws IOException {
	    ArrayList<LibraryItem> itemList = new ArrayList<>();

	    // Read items from Items.txt
	    try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
	        while (itemScanner.hasNextLine()) {
	            String line = itemScanner.nextLine();
	            String[] data = line.split(",");
	            if (data[0].equals("Book")) {
	                String title = data[2];
	                int numberOfCopies = Integer.parseInt(data[3]);
	                String authorFirstName = data[4];
	                String authorLastName = data[5];
	                int ISBN = Integer.parseInt(data[1]);
	                Name author = new Name(authorFirstName, authorLastName);
	                itemList.add(new Book(title, numberOfCopies, author, ISBN));
	            } else if (data[0].equals("CD")) {
	                String title = data[2];
	                int numberOfCopies = Integer.parseInt(data[3]);
	                String composerFirstName = data[4];
	                String composerLastName = data[5];
	                Name composer = new Name(composerFirstName, composerLastName);
	                // Assuming a default number of tracks, if tracks information is not in the file
	                itemList.add(new CD(title, numberOfCopies, 0, composer));
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Items file not found.");
	        throw e;
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        throw e;
	    }

	    if (itemList.isEmpty()) {
	        System.out.println("The library has no items.");
	        return;
	    }

	    // Convert the list to an array and sort it
	    LibraryItem[] listArray = itemList.toArray(new LibraryItem[0]);
	    Arrays.sort(listArray);

	    // Print the sorted items
	    for (LibraryItem item : listArray) {
	        System.out.println(item.getTitle());
	    }
	    
	    
	    
	    
	    
	    
	}













	public ArrayList<LibraryItem> cloneItems() throws CloneNotSupportedException {
	    ArrayList<LibraryItem> allClonedItems = new ArrayList<>();

	    try (Scanner scanner = new Scanner(new File("Items.txt"))) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] data = line.split(",");

	            // Trim to remove any leading or trailing spaces
	            String itemType = data[0].trim();

	            // Check item type and create the corresponding object
	            LibraryItem item;
	            if (itemType.equals("Book")) {
	                String title = data[2].trim();
	                int numberOfCopies = Integer.parseInt(data[3].trim());
	                String authorFirstName = data[4].trim();
	                String authorLastName = data[5].trim();
	                int ISBN = Integer.parseInt(data[1].trim());
	                item = new Book(title, numberOfCopies, new Name(authorFirstName, authorLastName), ISBN);
	                allClonedItems.add(item.clone());
	            } else if (itemType.equals("CD")) {
	                String title = data[2].trim();
	                int numberOfCopies = Integer.parseInt(data[3].trim());
	                int trackNo = Integer.parseInt(data[4].trim());
	                String composerFirstName = data[5].trim();
	                String composerLastName = data[6].trim();
	                item = new CD(title, numberOfCopies, trackNo, new Name(composerFirstName, composerLastName));
	                allClonedItems.add(item.clone());
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: Items.txt");
	    } catch (IOException e) {
	        System.out.println("Error reading from file: Items.txt");
	    }

	    return allClonedItems;
	}









	public boolean updateCdTitle(String title, Name composer, int staffId, String newTitle) {
	    try {
	        boolean staffFound = false;

	        // Check if the staffId exists and is a LibraryWorker
	        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
	            while (memberScanner.hasNextLine()) {
	                String line = memberScanner.nextLine();
	                String[] data = line.split(",");
	                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
	                    staffFound = true;
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Members file not found.");
	            return false;
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading from the members file.");
	            return false;
	        }

	        if (!staffFound) {
	            System.out.println("You don't have access. Please check your ID.");
	            return false;
	        }

	        // Read items from Items.txt, update CD title, and rewrite the file
	        File inputFile = new File("Items.txt");
	        ArrayList<String> updatedLines = new ArrayList<>();
	        boolean cdFound = false;

	        try (Scanner itemScanner = new Scanner(inputFile)) {

	            while (itemScanner.hasNextLine()) {
	                String line = itemScanner.nextLine();
	                String[] data = line.split(",");
	                if (data[0].equals("CD") && data[2].equalsIgnoreCase(title)
	                        && data[5].equalsIgnoreCase(composer.getFirstName())
	                        && data[6].equalsIgnoreCase(composer.getLastName())) {
	                    line = "CD," + data[1] + "," + newTitle + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6];
	                    cdFound = true;
	                    System.out.println("CD title updated successfully.");
	                }
	                updatedLines.add(line);
	            }

	            if (!cdFound) {
	                System.out.println("CD not found.");
	                return false;
	            }

	        } catch (IOException e) {
	            System.out.println("An error occurred while reading or writing to the items file.");
	            return false;
	        }

	        // Rewrite the original file with the updated data
	        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
	            for (String line : updatedLines) {
	                writer.println(line);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while writing to the file.");
	            return false;
	        }

	        return true;
	    } catch (InputMismatchException | IllegalArgumentException e) {
	        throw e;
	    }
	}


public boolean updateCdComposer(String title, Name composer, int staffId, Name newname) {
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return false;
        }

        if (!staffFound) {
            System.out.println("You don't have access. Please check your ID.");
            return false;
        }

        // Read items from Items.txt, update CD composer's last name, and rewrite the file
        File inputFile = new File("Items.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (Scanner itemScanner = new Scanner(inputFile)) {

            boolean cdFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("CD") && data[2].equalsIgnoreCase(title)
                        && data[5].equalsIgnoreCase(composer.getFirstName())
                        && data[6].equalsIgnoreCase(composer.getLastName())) {
                    line = "CD," + data[1] + "," + data[2] + "," + data[3] + "," + newname.getFirstName() + "," + newname.getLastName();
                    cdFound = true;
                    System.out.println("CD composer's last name updated successfully.");
                }
                updatedLines.add(line);
            }

            if (!cdFound) {
                System.out.println("CD not found.");
                return false;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return false;
        }

        // Rewrite the original file with the updated data
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            for (String line : updatedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            return false;
        }

        return true;
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}






public boolean updateCdTrackNumber(String title, Name composer, int staffId, int newTrackNumber) {
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return false;
        }

        if (!staffFound) {
            System.out.println("You don't have access. Please check your ID.");
            return false;
        }

        // Read items from Items.txt, update CD track number, and rewrite the file
        File inputFile = new File("Items.txt");
        File tempFile = new File("TempItems.txt");

        try (Scanner itemScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            boolean cdFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("CD") && data[2].equalsIgnoreCase(title)
                        && data[5].equalsIgnoreCase(composer.getFirstName())
                        && data[6].equalsIgnoreCase(composer.getLastName())) {
                    data[4] = "" + newTrackNumber; // Update track number
                    String updatedLine = data[0] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6];
                    line = updatedLine;
                    cdFound = true;
                    System.out.println("CD track number updated successfully.");
                }
                writer.println(line);
            }

            if (!cdFound) {
                System.out.println("CD not found.");
                return false;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return false;
        }

        // Replace the original file with the modified one
        if (!inputFile.delete()) {
            System.out.println("Could not delete the original file.");
            return false;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename the temp file.");
            return false;
        }

        return true;
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}



public boolean updateBookTitle(int ISBN, int staffId, String newTitle) {
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return false;
        }

        if (!staffFound) {
            System.out.println("You don't have access. Please check your ID.");
            return false;
        }

        // Read items from Items.txt, update book title, and rewrite the file
        File inputFile = new File("Items.txt");
        File tempFile = new File("TempItems.txt");

        try (Scanner itemScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            boolean bookFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("Book") && Integer.parseInt(data[1]) == ISBN) {
                    data[2] = newTitle; // Update book title
                    String updatedLine = "";
                    for (int i = 0; i < data.length; i++) {
                        updatedLine += data[i];
                        if (i != data.length - 1) {
                            updatedLine += ",";
                        }
                    }
                    line = updatedLine;
                    bookFound = true;
                    System.out.println("Book title updated successfully.");
                }
                writer.println(line);
            }

            if (!bookFound) {
                System.out.println("Book not found.");
                return false;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return false;
        }

        // Replace the original file with the modified one
        if (!inputFile.delete()) {
            System.out.println("Could not delete the original file.");
            return false;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename the temp file.");
            return false;
        }

        return true;
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}


public boolean updateBookAuthor(int ISBN, int staffId, Name newAuthor) {
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return false;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return false;
        }

        if (!staffFound) {
            System.out.println("You don't have access. Please check your ID.");
            return false;
        }

        // Read items from Items.txt and update book author
        File inputFile = new File("Items.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (Scanner itemScanner = new Scanner(inputFile)) {

            boolean bookFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("Book") && Integer.parseInt(data[1]) == ISBN) {
                    data[3] = newAuthor.getFirstName(); // Update author's first name
                    data[4] = newAuthor.getLastName(); // Update author's last name
                    line = String.join(",", data);
                    bookFound = true;
                    System.out.println("Book author updated successfully.");
                }
                updatedLines.add(line);
            }

            if (!bookFound) {
                System.out.println("Book not found.");
                return false;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return false;
        }

        // Rewrite the original file with the updated data
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            for (String line : updatedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            return false;
        }

        return true;
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}




public void deleteCd(String title, Name composer, int staffId) {  //here if we deleted number of copies it will be updated on the file
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return;
        }

        if (!staffFound) {
            System.out.println("Access denied. Only library workers can delete CDs.");
            return;
        }

        // Read items from Items.txt, delete CD, and rewrite the file
        File inputFile = new File("Items.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (Scanner itemScanner = new Scanner(inputFile)) {
            boolean cdFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("CD") && data[2].equalsIgnoreCase(title)
                        && data[5].equalsIgnoreCase(composer.getFirstName())
                        && data[6].equalsIgnoreCase(composer.getLastName())) {
                    cdFound = true;
                    int copies = Integer.parseInt(data[3].trim()); // Number of copies is at index 3
                    int tracks = Integer.parseInt(data[4].trim()); // Number of tracks is at index 4

                    if (copies > 0) {
                        System.out.println("How many copies of the CD '" + title + "' by " + composer.getFirstName() + " " + composer.getLastName() + " would you like to delete?");
                        Scanner scanner = new Scanner(System.in);
                        int deleteCopies = scanner.nextInt();
                        scanner.nextLine(); // Consume newline after nextInt()

                        if (deleteCopies > copies) {
                            System.out.println("Invalid number of copies. Please enter a number less than or equal to " + copies);
                            continue;
                        }

                        // Update the number of copies and tracks
                        copies -= deleteCopies;
                        data[3] = String.valueOf(copies);

                        if (copies == 0) {
                            // Optionally, delete the entire line if no copies left
                            continue; // Skip adding this line to updatedLines
                        }

                        System.out.println(deleteCopies + " copies of the CD '" + title + "' by " + composer.getFirstName() + " " + composer.getLastName() + " deleted successfully.");
                    }
                }
                updatedLines.add(String.join(",", data));
            }

            if (!cdFound) {
                System.out.println("CD not found with title '" + title + "' by " + composer.getFirstName() + " " + composer.getLastName());
                return;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return;
        }

        // Rewrite the original file with the updated data
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            for (String line : updatedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            return;
        }

    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }}

    


public void deleteBook(String title, Name author, int staffId) {
    try {
        boolean staffFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals("LibraryWorker") && Integer.parseInt(data[1]) == staffId) {
                    staffFound = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            return;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the members file.");
            return;
        }

        if (!staffFound) {
            System.out.println("Access denied. Only library workers can delete books.");
            return;
        }

        // Read items from Items.txt, delete book, and rewrite the file
        File inputFile = new File("Items.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (Scanner itemScanner = new Scanner(inputFile)) {
            boolean bookFound = false;
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data[0].equals("Book") && data[2].trim().equalsIgnoreCase(title)
                        && data[4].trim().equalsIgnoreCase(author.getFirstName())
                        && data[5].trim().equalsIgnoreCase(author.getLastName())) {
                    bookFound = true;
                    int copies = Integer.parseInt(data[3].trim()); // Number of copies is at index 3

                    if (copies > 0) {
                        System.out.println("How many copies of the book '" + title + "' by " + author.getFirstName() + " " + author.getLastName() + " would you like to delete?");
                        Scanner scanner = new Scanner(System.in);
                        int deleteCopies = scanner.nextInt();
                        scanner.nextLine(); // Consume newline after nextInt()

                        if (deleteCopies > copies) {
                            System.out.println("Invalid number of copies. Please enter a number less than or equal to " + copies);
                            continue;
                        }

                        // Update the number of copies
                        copies -= deleteCopies;
                        data[3] = copies + ""; // Convert int to String using direct concatenation

                        if (copies == 0) {
                            // Optionally, delete the entire line if no copies left
                            continue; // Skip adding this line to updatedLines
                        }

                        System.out.println(deleteCopies + " copies of the book '" + title + "' by " + author.getFirstName() + " " + author.getLastName() + " deleted successfully.");
                    }
                }
                updatedLines.add(arrayToString(data));
            }

            if (!bookFound) {
                System.out.println("Book not found with title '" + title + "' by " + author.getFirstName() + " " + author.getLastName());
                return;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the items file.");
            return;
        }

        // Rewrite the original file with the updated data
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            for (String line : updatedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            return;
        }

    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}

// Helper method to convert String array to comma-separated String
private String arrayToString(String[] array) {
    String result = "";
    for (int i = 0; i < array.length; i++) {
        if (i > 0) {
            result += ",";
        }
        result += array[i];
    }
    return result;
}

//we can update number of copies from add method.

//if we want to add new student and only workers can do that.

public void addStudent(int staffId, Name name, Address address, NewDate dob, String mobileNumber, String emailAddress) throws IOException {
    try {
        boolean staffFound = false;
        boolean studentFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner scanner = new Scanner(new File("members.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("LibraryWorker")) {
                    String[] data = line.split(",");
                    int existingStaffId = Integer.parseInt(data[1]);
                    if (existingStaffId == staffId) {
                        staffFound = true;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            throw e;
        }

        if (!staffFound) {
            System.out.println("Access denied. Only library workers can add students.");
            return;
        }

        // Check if the student already exists based on student ID
        try (Scanner scanner = new Scanner(new File("members.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Student")) {
                    String[] data = line.split(",");
                    int existingStudentId = Integer.parseInt(data[1]);
                    if (existingStudentId == staffId) {
                        studentFound = true;
                        System.out.println("Student already exists with student ID: " + existingStudentId);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            throw e;
        }

        // If the student is not found, add a new student
        if (!studentFound) {
            int studentId = members.size() + 1; // Assuming student IDs are unique among all members
            Student newStudent = new Student();
            newStudent.setName(name);
            newStudent.setPhoneNumber(mobileNumber);
            newStudent.setEmailAddress(emailAddress);
            newStudent.setDateOfBirth(dob);
            newStudent.setAddress(address);
            newStudent.setMemberId(studentId);

            members.add(newStudent);
            System.out.println("New student added with student ID: " + studentId);

            // Write the new student's info to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter("members.txt", true))) {
                writer.println("Student," + studentId + "," +
                    name.getFirstName() + "," + name.getSecondName() + "," + name.getLastName() + "," +
                    address.getBuildingName() + "," + address.getStreet() + "," + address.getCity() + "," +
                    dob.getDay() + "," + dob.getMonth() + "," + dob.getYear() + "," +
                    mobileNumber + "," + emailAddress);
            } catch (FileNotFoundException e) {
                System.out.println("Members file not found.");
                throw e;
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                throw e;
            }
        }
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}



public void addProfessor(int staffId, Name name, Address address, NewDate dob, String mobileNumber, String emailAddress, int salary) throws IOException {
    try {
        boolean staffFound = false;
        boolean professorFound = false;

        // Check if the staffId exists and is a LibraryWorker
        try (Scanner scanner = new Scanner(new File("members.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("LibraryWorker")) {
                    String[] data = line.split(",");
                    int existingStaffId = Integer.parseInt(data[1]);
                    if (existingStaffId == staffId) {
                        staffFound = true;
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            throw e;
        }

        if (!staffFound) {
            System.out.println("Access denied. Only library workers can add professors.");
            return;
        }

        // Check if the professor already exists based on staff ID
        try (Scanner scanner = new Scanner(new File("members.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Professor")) {
                    String[] data = line.split(",");
                    int existingProfessorId = Integer.parseInt(data[1]);
                    if (existingProfessorId == staffId) {
                        professorFound = true;
                        System.out.println("Professor already exists with staff ID: " + existingProfessorId);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Members file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            throw e;
        }

        // If the professor is not found, add a new professor
        if (!professorFound) {
            int professorId = members.size() + 1; // Assuming professor IDs are unique among all members
            Professor newProfessor = new Professor();
            newProfessor.setName(name);
            newProfessor.setPhoneNumber(mobileNumber);
            newProfessor.setEmailAddress(emailAddress);
            newProfessor.setDateOfBirth(dob);
            newProfessor.setAddress(address);
            newProfessor.setMemberId(professorId);
            newProfessor.setSalary(salary);

            members.add(newProfessor);
            System.out.println("New professor added with staff ID: " + professorId);

            // Write the new professor's info to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter("members.txt", true))) {
                writer.println("Professor," + professorId + "," +
                    name.getFirstName() + "," + name.getLastName() + "," +
                    address.getBuildingName() + "," + address.getStreet() + "," + address.getCity() + "," +
                    dob.getDay() + "," + dob.getMonth() + "," + dob.getYear() + "," +
                    mobileNumber + "," + emailAddress + "," + salary);
            } catch (FileNotFoundException e) {
                System.out.println("Members file not found.");
                throw e;
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                throw e;
            }
        }
    } catch (InputMismatchException | IllegalArgumentException e) {
        throw e;
    }
}



//now if we want to add worker
    public void addLibraryWorker(int staffId, Name name, Address address, NewDate dob, String mobileNumber, String emailAddress) throws IOException {
        try {
            boolean staffFound = false;

            for (LibraryMember member : members) {
                if (member instanceof LibraryWorker && member.getMemberId() == staffId) {
                    staffFound = true;
                    break;
                }
            }

            if (!staffFound) {
                System.out.println("Access denied. Only library workers can add other workers.");
                return;
            }

            boolean workerFound = false;

            // Check in the file if the worker already exists
            try (Scanner scanner = new Scanner(new File("members.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.startsWith("LibraryWorker")) {
                        String[] data = line.split(",");
                        int existingStaffId = Integer.parseInt(data[1]);

                        if (existingStaffId == staffId) {
                            workerFound = true;
                            System.out.println("Worker already exists with worker ID: " + existingStaffId);
                            break;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Members file not found.");
                throw e;
            } catch (IOException e) {
                System.out.println("An error occurred while reading from the file.");
                throw e;
            }

            // If the worker is not found, add a new worker
            if (!workerFound) {
                int workerId = members.size(); // Assuming worker IDs are unique among all members
                LibraryWorker newWorker = new LibraryWorker();
                newWorker.setName(name);
                newWorker.setPhoneNumber(mobileNumber);
                newWorker.setEmailAddress(emailAddress);
                newWorker.setDateOfBirth(dob);
                newWorker.setAddress(address);
                newWorker.setMemberId(workerId);

                members.add(newWorker);
                System.out.println("New worker added with worker ID: " + workerId);

                // Write the new worker's info to the file
                try (PrintWriter writer = new PrintWriter(new FileWriter("members.txt", true))) {
                    writer.println("LibraryWorker," + workerId + "," +
                        name.getFirstName() + "," + name.getLastName() + "," +
                        address.getBuildingName() + "," + address.getStreet() + "," + address.getCity() + "," +
                        dob.getDay() + "," + dob.getMonth() + "," + dob.getYear() + "," +
                        mobileNumber + "," + emailAddress);
                } catch (FileNotFoundException e) {
                    System.out.println("Members file not found.");
                    throw e;
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    throw e;
                }
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            throw e;
        }
    }


}







	







						
						
						
						
						
						
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				
				
				
				
				
				
		
		
	
	
		
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
