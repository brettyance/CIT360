package view;

import java.util.Scanner;

/**
 * Operates as the View portion in the MVC model.
 * @author bayace92
 *
 */
public class ConsoleView {
	//creates a Scanner object which will be used
	//	to communicate to the controller
	Scanner scanner = new Scanner(System.in);
	
	//Empty constructor for the controller to make use of methods
	public ConsoleView() {
	}
	
	//Used to print messages from the controller to the console
	public void print(String toPrint) {
		System.out.print(toPrint);
	}
	
	//Used to receive a message from the user and send to controller
	//Alternative to "print" when a response is expected
	public String getAnswer(String toPrint) {
		System.out.print(toPrint);
		return scanner.nextLine();
	}
	
	//Used to close the Scanner object once the Controller is done
	//with this object
	public void close() {
		scanner.close();
	}
}
