package tui;

import controller.OrderController;
import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.OrderFolder.ItemOrder;

public class OrderTui {
	
	private OrderController oController;
	private KeyboardInput kbInput;
	
	public OrderTui() {
		oController = new OrderController();
		kbInput = new KeyboardInput();
		
	}
	
	public void start() {
		boolean isRunning = true;
		int kbChoice;
		
		while (isRunning) {
			writeOrderMenu();
			kbChoice = kbInput.intInput();
		
		switch(kbChoice) {
		case 1:
			oController.createObj();
			break;
		case 2:
			printItemOrder();
			break;
		case 3:
			printAllOrders();
			break;
		case 4:
			oController.deleteObj();
			break;
		case 0:
			isRunning = false;
			break;
		default:
			break;
			}
		}
	}
	private void writeOrderMenu() {
		System.out.println("****** Manage Orders ******");
        System.out.println(" (1) New order");
        System.out.println(" (2) Show specific order");
        System.out.println(" (3) Show all orders");
        System.out.println(" (4) Delete order");
        System.out.println(" (0) Return to Main Menu");
        System.out.print("\n Choice:");
	}
	
	public void printItemOrder() {
		ItemOrder order = oController.getObj();
		
		if (order != null) {
			printOrderInformation(order);
		}
		else {
			oController = new OrderController();
			oController.printUnavailable();
		}
	}
	
	public void printAllOrders() {
		for (ItemOrder order : OrderContainer.getInstance().getOrderDatabase()) {
			if (order != null) { 
				printOrderInformation(order);
				System.out.println(OrderContainer.getInstance().arraySize());
			}
		}
	}

	private void printOrderInformation(ItemOrder order) {
		DiscountTui dTui = new DiscountTui();
		
		System.out.println("------------------------------------");
		System.out.println("ID: " + order.getID());
		System.out.println("Customer name: " + order.getCustomerName());
		System.out.println("Quantity: " + order.getBasket().getQuantity());
		System.out.println("Applied discount: ");
		dTui.printRequestedDiscounts(order.getBasket().getListOfDiscounts());
		System.out.println("Total: " + order.getBasket().getTotalPrice());
		System.out.println("------------------------------------");	
	}
	
	public void emptyDatabase() {
		System.out.println("Nothing to print.");
	}

}
