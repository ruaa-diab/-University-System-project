package TheLibrary;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

 public class Professor extends LibraryMember {
	private int salary;
	private int professorId;
	public Professor() {
		
	}
	public Professor(Name name,
	 String phoneNumber,
	 String emailAddress,
	 NewDate dateOfBirth,
	 Address address,
	 LibraryItem[] listOfLibraryItems,int numberOfBorrowedItems,int salary, int professorId) {
		
		
		super( name,
 phoneNumber,
	  emailAddress,
	  dateOfBirth,
	  address,
	  listOfLibraryItems, numberOfBorrowedItems);
		this.salary=salary;
		this.professorId=professorId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int getMemberId() {
		return professorId;
	}
	@Override
	public void setMemberId(int professorId) {
		this.professorId = professorId;
	}

	
	public String toString() {
	    String result = "Name: " + this.getName().getFirstName() + " " + this.getName().getLastName() + "\n";
	    result += "Member ID: " + this.getMemberId() + "\n";
	    result += "Phone Number: " + this.getPhoneNumber() + "\n";
	    result += "Email Address: " + this.getEmailAddress() + "\n";
	    result += "Borrowed Items:\n";

	    for (LibraryItem item : this.getListOfLibraryItems()) {
	        result += "- " + item.toString() + "\n";
	    }

	    return result;
	}


@Override


public void borrowItem(Library library, int professorId, String title) throws ItemNotFoundException, IOException {  //now this when anyone borrows sth it upates the file
    Scanner scanner = new Scanner(System.in);

    try {
        // Find the professor with the given professor ID in the members file
        boolean professorFound = false;
        Professor professor = null;
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && Integer.parseInt(data[1]) == professorId && data[0].equals("Professor")) {
                    professor = new Professor(); // Assuming a constructor for Professor
                    professorFound = true;
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

        if (!professorFound) {
            System.out.println("Professor not found.");
            return;
        }

        // Search for items with the given title in the items file
        ArrayList<String> updatedLines = new ArrayList<>();
        boolean itemFound = false;
        LibraryItem chosenItem = null;
        try (Scanner itemScanner = new Scanner(new File("Items.txt"))) {
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 4 && data[2].trim().equalsIgnoreCase(title)) {
                    if ((data[0].equals("Book") || data[0].equals("CD")) && Integer.parseInt(data[3].trim()) > 0) {
                        // Decrement the number of copies
                        int numberOfCopies = Integer.parseInt(data[3].trim()) - 1;
                        data[3] = String.valueOf(numberOfCopies); // Update the number of copies
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3];
                        if (data.length > 4) {
                            for (int i = 4; i < data.length; i++) {
                                line += "," + data[i];
                            }
                        }
                        itemFound = true;

                        // Create the chosen item object based on the type
                        if (data[0].equals("Book")) {
                            chosenItem = new Book(data[2], numberOfCopies, new Name(data[4], data[5]), Integer.parseInt(data[1]));
                        } else {
                            chosenItem = new CD(data[2], numberOfCopies, Integer.parseInt(data[3]), new Name(data[4], data[5]));
                        }
                    }
                }
                updatedLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Items file not found.");
            throw e;
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            throw e;
        }

        if (!itemFound) {
            throw new ItemNotFoundException("No items found with the title: " + title);
        }

        // Update the items file with the updated lines
        try (PrintWriter writer = new PrintWriter(new FileWriter("Items.txt"))) {
            for (String line : updatedLines) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file.");
            throw e;
        }

        // Ask the user for the acquisition and due dates
        System.out.println("Enter the acquisition date (day month year): ");
        int acquisitionDay = scanner.nextInt();
        String acquisitionMonth = scanner.next();
        int acquisitionYear = scanner.nextInt();
        NewDate acquisitionDate = new NewDate(acquisitionDay, acquisitionMonth, acquisitionYear);

        System.out.println("Enter the due date (day month year): ");
        int dueDay = scanner.nextInt();
        String dueMonth = scanner.next();
        int dueYear = scanner.nextInt();
        NewDate dueDate = new NewDate(dueDay, dueMonth, dueYear);

        // Create a Borrow object
        Borrow borrow = new Borrow(acquisitionDate, dueDate, professor);

        // Add the borrowed item to the professor's list of library items
        ArrayList<LibraryItem> itemList = new ArrayList<>(Arrays.asList(professor.getListOfLibraryItems()));
        itemList.add(chosenItem);
        professor.setListOfLibraryItems(itemList.toArray(new LibraryItem[0]));

        System.out.println("Item borrowed successfully.");
    } catch (InputMismatchException e) {
        throw e;
    } catch (IllegalArgumentException e) {
        throw e;
    }
}}