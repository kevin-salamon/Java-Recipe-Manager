import java.util.Scanner;

public class App {

	public static void start() {
	    System.out.println("-----------------------");
	    System.out.println("Welcome to the Recipe Book! To begin, choose whether you would like to view, add, or delete recipes.");
	    Scanner key = new Scanner(System.in);
	    String choice;
	    boolean correct = false;

	    do {
		    System.out.println("Choose VIEW, ADD, or DELETE.");
	    	choice = key.nextLine();
	    	if (choice.equals("ADD") || choice.equals("DELETE") || choice.equals("VIEW")) {
	    		correct = true;
	    	} else {
	    		System.out.println("Incorrect choice.");
	    	}
	    } while (correct == false);
	    
	    key.close();
	    if (choice.equals("ADD")) {
	    	return;
	    } else if (choice.equals("VIEW")) {
	    	return;
	    } else if (choice.equals("DELETE")) {
	    	return;
	    }
	}
	
	public static void main(String[] args) {
		start();
	}

}
