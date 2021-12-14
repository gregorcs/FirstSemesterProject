package tui;

import controller.OrderController;
import input.KeyboardInput;
import model.OrderFolder.OrderContainer;
import model.OrderFolder.ItemOrder;

public class OrderTui {
	
	private OrderController oController;
	private KeyboardInput keyboard;
	private PrintOuts po;
	
	public OrderTui() {
		oController = new OrderController();
		keyboard = new KeyboardInput();
		po = new PrintOuts();
	}
	
	public void start() {
		boolean isRunning = true;
		int input;
		
		while (isRunning) {
			po.printOrderMenu();
			input = keyboard.intInput();
		
		switch(input) {
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
	
	public void printItemOrder() {
		ItemOrder order = oController.getObj();
		
		if (order != null) {
			printOrderInformation(order);
		}
		else {
			po.printUnavailable();
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

	public void printOrderInformation(ItemOrder order) {
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
}