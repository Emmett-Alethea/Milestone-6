package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
	private ArrayList<Product> cartList;

	public Cart() {
		cartList = new ArrayList<Product>();
	}
	public void addList(Product item) {
	     cartList.add(item);
	     // still need to account for a separate in cart quantity
	}
	public void removeList(Product item) {
		cartList.remove(item);
	}
	public void displayCart() {
		for (Product item: cartList) {
			item.displayInCart();
		}
		}
	
	public int size() {
		return cartList.size();
	}
	/*public Product matchItem(String name) {
		for (Product item: cartList) {
			if (name.equals(item.getName())) {
				getItem(item);
				return item;
			}
		}
		System.out.println("This item is not in your cart.");
		return null;

	} */
	public Product matchItem(String name) {
		for (Product item: cartList) {
			int m = item.compareTo(name);
			if (m == 0) {
				//getItem(item);
				return item;
			}
		}
		System.out.println("Please select an item in stock");
		return null;

	}
	public void getItem(Product item) {
		//System.out.println(item.getName());
		System.out.println(item.toString());
	}
	public void changeCart(Product item, int change) { // decreases quantity by one
		int newQuantity = item.getCartQuant() + change;
		item.setCartQuant(newQuantity);
	}
	public void addCart(Product item) {
		changeCart(item, 1);
	}
	public void removeCart(Product item) {
		changeCart(item, -1);
	}
	public void emptyCart() {
		for (Product item: cartList) {
			int change = item.cartQuant;
			Inventory.changeQuantity(item, change);
			item.setCartQuant(0);
		}
		cartList.clear();
	}
	public void sortName() {
		Collections.sort(cartList, Comparator.comparing(Product::getName));
	}
	public void reverseSortName() {
		Comparator<Product>nameCompare
		= (c1,c2) -> c1.getName().compareTo(c2.getName());
		Collections.sort(cartList, Collections.reverseOrder(nameCompare));
	}
	public void sortPrice() {
		Collections.sort(cartList, Comparator.comparing(Product::getPrice));
	}
	public void reverseSortPrice() {
		Comparator<Product>priceCompare
		= (c1,c2) -> c1.getPrice().compareTo(c2.getPrice());
		Collections.sort(cartList, Collections.reverseOrder(priceCompare));
	}
}
