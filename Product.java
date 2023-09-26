package app;
import java.lang.Comparable;


public class Product implements Comparable<Product> {
	
protected String name;
protected String description;
protected int quantity; // quantity for inventory
protected int cartQuant; // quantity for cart
protected Double price;

public Product() {
	
}

public Product(String name, String description, int quantity, int cartQuant, double price) {
	this.name = name;
	this.description = description;
	this.quantity = quantity;
	this.cartQuant = cartQuant;
	this.price = price;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getCartQuant() {
	return cartQuant;
}

public void setCartQuant(int cartQuant) {
	this.cartQuant = cartQuant;
}
public Double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}
public void displayProduct() {
	System.out.println(name + ", " + description + ", " + quantity + ", " + price);
}
@Override
public String toString() {
	return (name + ", " + description + ". Currently "+ quantity + " in stock. " + "Costs " + price + " gold.");
}

public void displayInCart() {
	// TODO Auto-generated method stub
	
}

public int compareTo(String o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int compareTo(Product o) {
	// TODO Auto-generated method stub
	return 0;
}

	
}


