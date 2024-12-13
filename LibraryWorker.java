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

 public class LibraryWorker extends LibraryMember {
	
	private int staffId;
	
	
	public LibraryWorker() {
		
	}
	public LibraryWorker(Name name,
			 String phoneNumber,
			 String emailAddress,
			 NewDate dateOfBirth,
			 Address address,
			 LibraryItem[] listOfLibraryItems,int numberOfBorrowedItems,int staffId) {
		super( name,
				 phoneNumber,
					  emailAddress,
					  dateOfBirth,
					  address,
					  listOfLibraryItems, numberOfBorrowedItems);
				
						this.staffId=staffId;
	}
	
	
	

	
	
	@Override
	public int getMemberId() {
		return staffId;
	}
	@Override
	public void setMemberId(int staffId) {
		this.staffId = staffId;
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
	//THIS method too will update the number of copies
	
	public void borrowItem(Library library, int workerId, String title) throws ItemNotFoundException, IOException, MaxBorrowLimitException {
        Scanner scanner = new Scanner(System.in);

        try {
            // Find the library worker with the given worker ID in the members file
            boolean workerFound = false;
            LibraryWorker worker = null;
            try (Scanner memberScanner = new Scanner(new File("members.txt"))) {
                while (memberScanner.hasNextLine()) {
                    String line = memberScanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length >= 2 && Integer.parseInt(data[1]) == workerId && data[0].equals("LibraryWorker")) {
                        worker = new LibraryWorker(); // Assuming a constructor for LibraryWorker
                        System.out.println("You are an existing library worker."); // Informing worker
                        workerFound = true;
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

            if (!workerFound) {
                System.out.println("Library worker not found.");
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
            Borrow borrow = new Borrow(acquisitionDate, dueDate, worker);

            // Add the borrowed item to the library worker's list of library items
            ArrayList<LibraryItem> itemList = new ArrayList<>(Arrays.asList(worker.getListOfLibraryItems()));
            itemList.add(chosenItem);
            worker.setListOfLibraryItems(itemList.toArray(new LibraryItem[0]));

            System.out.println("Item borrowed successfully.");
        } catch (InputMismatchException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

	}
