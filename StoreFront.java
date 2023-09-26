package app;
import java.util.Scanner;

public class StoreFront{ 

private static Inventory list = new Inventory();
private static Cart cart = new Cart();
//purchase moves item to cart and updates quantity of item
	//cancel removes item from cart and updates quantity
	public static void purchase(Product item) {
		Inventory.addCart(item); // affects inventory quantity
		cart.addList(item); // adds item to cart arrayList
		cart.addCart(item);
	}
	public static void cancel(Product item) {
		Inventory.removeCart(item); //inventory quantity
		cart.removeList(item); // cart 
		cart.removeCart(item);
	}
	
	public static void updateDisplay() {
		Inventory.displayInventory();
	}
	public static void updateCart() {
		cart.displayCart();
	}
	public static void emptyCart() {
		cart.emptyCart();
	}
	public static void main (String[]args) {
		System.out.println("Welcome to Axe's Bargain Bin! The one stop shop for cheap gladiator gear!");
		//list = new Inventory(); // initialize a new Inventory object
		Inventory.displayInventory(); // displays content of inventory
		Scanner input = new Scanner(System.in);
		String selected = "m";
		
		while (selected.equals("x") != true) { // while the user has not exited the shop
		System.out.println("To view an item in more detail, press v. To purchase an item, press p. To view your cart, press t.");
		System.out.println("To cancel an item in your cart, press c. To sort your inventory, press s. To sort your cart, press y. To exit the shop, press x");
		selected = input.next();
		// view
		if (selected.equals("v")) {
			System.out.println("Type in the name of the item you wish to view, as displayed in the console.");
			selected = input.next();
			Product view = Inventory.matchItem(selected); // checks if the user input matches any item and assigns that to a Product variable
			Inventory.getItem(view); // prints full item string to console. 
			continue; // sends us to the top of the while loop
			}
		//view cart
		if (selected.equals("t")) {
			updateCart(); // displays current cart items
			if (cart.size() == 0) { // if there is nothing in the cart arraylist 
				System.out.println("Nothing here");
				continue;
			}
			continue;
		}
		// purchase
		if (selected.equals("p")) {
			System.out.println("Type in the name of the item you wish to purchase, as displayed in the console.");
			selected = input.next();
			//list.matchItem(selected);
			Product tobuy = Inventory.matchItem(selected); // checks to see if there is a match, then assigns it to Product tobuy
			if (tobuy != null) { // if tobuy has a match
			System.out.println("Buy this item? y/n");
			selected = input.next();
			if (selected.equals("y") && tobuy.getQuantity() != 0) { // if the user wants to buy and its in stock
				System.out.println("Purchased " + tobuy.getName());
				purchase(tobuy);
				continue;
			}
			else if (selected.equals("y") && tobuy.getQuantity() == 0) { // if the user wants to buy but its out of stock
				System.out.println("Sorry, item is out of stock!");
				continue;
			}
			else if (selected.equals("n")) { //user does not buy
				continue;
			}
			else // if the user does not enter y or n
				continue;
		}
		}
		// cancel/ remove from cart
		if (selected.equals("c")) {
			System.out.println("Type out the name of the item in your cart you wish to cancel, or press z to empty your cart.");
			selected = input.next();
			//cart.matchItem(selected);
			if (selected.equals("z")) {
				emptyCart();
				System.out.println("Cart has been emptied");
				continue;}
			Product toReturn = cart.matchItem(selected);
			if (toReturn != null) {
			System.out.println("Return this item? y/n");
			selected = input.next();
			if (selected.equals("y")) {
				System.out.println("Item removed from cart");
				cancel(toReturn);
				continue;
			}
			else if (selected.equals("n")) {
				continue;
			}
			}
		}
		//sort inventory
		if(selected.equals("s")) {
			System.out.println("To sort by name ascending, press n. To sort by name descending, press a.");
			System.out.println("To sort by price ascending, press r. To sort by price descending, press b.");
			selected= input.next();
			if (selected.equals("n")) {
				Inventory.sortName();
				Inventory.displayInventory();
				continue;
			}
			else if (selected.equals("a")) {
				Inventory.reverseSortName();
				Inventory.displayInventory();
				continue;
			}
			else if (selected.equals("r")) {
				Inventory.sortPrice();
				Inventory.displayInventory();
				continue;
			}
			else if (selected.equals("b")) {
				Inventory.reverseSortPrice();
				Inventory.displayInventory();
				continue;
				}
			else {
				System.out.println("Inventory not sorted, returning to menu.");
			}
		}
		//sort cart
				if(selected.equals("y")) {
					System.out.println("To sort by name ascending, press n. To sort by name descending, press a.");
					System.out.println("To sort by price ascending, press r. To sort by price descending, press b.");
					selected= input.next();
					if (selected.equals("n")) {
						cart.sortName();
						updateCart();
						continue;
					}
					else if (selected.equals("a")) {
						cart.reverseSortName();
						updateCart();
						continue;
					}
					else if (selected.equals("r")) {
						cart.sortPrice();
						updateCart();
						continue;
					}
					else if (selected.equals("b")) {
						cart.reverseSortPrice();
						updateCart(); 
						continue;
						}
					else {
						System.out.println("Inventory not sorted, returning to menu.");
					}
				}
		else if (selected.equals("x")) {
			continue; }
		else {
			System.out.println("Please be careful with your typing");
			continue; }
		}
		System.out.println("Goodbye!");
		}
		
}

		
	

