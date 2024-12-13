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

 public class Student extends LibraryMember  {
private int studentNumber;
private int avarageNumber;
public Student() {
	
}

public Student(Name name,
	 String phoneNumber,
	 String emailAddress,
	 NewDate dateOfBirth,
	 Address address,
	 LibraryItem[] listOfLibraryItems,int numberOfBorrowedItems,int studentNumber,int avarageNumber) {
	
	
	
	super( name,
	  phoneNumber,
	  emailAddress,
	  dateOfBirth,
	 address,
	  listOfLibraryItems, numberOfBorrowedItems);
	this.studentNumber=studentNumber;
	this.avarageNumber=avarageNumber;
}



@Override
public int getMemberId() {
	return studentNumber;
}
@Override
 public void setMemberId(int studentNumber) {
	this.studentNumber = studentNumber;
}
public int getAvarageNumber() {
	return avarageNumber;
}
public void setAvarageNumber(int avarageNumber) {
	this.avarageNumber = avarageNumber;
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

	




public boolean isEligibleToEnroll(int studentNumber, Library library) {
    for (int i = 0; i < library.getMembers().size(); i++) {
        if (!(library.getMembers().get(i) instanceof Student)) {
            return false;
        }
    }
    return true;
}







@Override
//here when we actually borrow it updates the file

public void borrowItem(Library library, int studentId, String title) throws ItemNotFoundException, IOException, MaxBorrowLimitException {
    Scanner scanner = new Scanner(System.in);

    try {
        // Find the student with the given student ID in the members file
        boolean studentFound = false;
        Student student = null;
        try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
            while (memberScanner.hasNextLine()) {
                String line = memberScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2 && Integer.parseInt(data[1]) == studentId && data[0].equals("Student")) {
                    student = new Student(); // Assuming a constructor for Student
                    studentFound = true;
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

        if (!studentFound) {
            System.out.println("Student not found.");
            return;
        }

        // Check if the student has reached the maximum borrowing limit
        if (student.getNumberOfBorrowedItems() >= 5) {
            throw new MaxBorrowLimitException("Student has reached the maximum borrowing limit.");
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
                        data[3] = Integer.toString(numberOfCopies); // Update the number of copies
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
        Borrow borrow = new Borrow(acquisitionDate, dueDate, student);

        // Add the borrowed item to the student's list of library items
        ArrayList<LibraryItem> itemList = new ArrayList<>(Arrays.asList(student.getListOfLibraryItems()));
        itemList.add(chosenItem);
        student.setListOfLibraryItems(itemList.toArray(new LibraryItem[0]));

        System.out.println("Item borrowed successfully.");
    } catch (InputMismatchException e) {
        throw e;
    } catch (IllegalArgumentException e) {
        throw e;
    }
}}

