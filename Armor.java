package app;

public class Armor extends Product {
	private int defense;

	public Armor() {} // for object mapping 
	
	public Armor(String name, String description, int quantity, int cartQuant, double price, int defense) {
		super(name, description, quantity, cartQuant, price);
		this.defense= defense;
}
	public int getDefense() {
		return this.defense;
	}
	public void setDamage(int defense) {
		this.defense = defense;
	}
	@Override
	public void displayProduct() {
		//System.out.println(name + ", " + description + ", " + quantity + ", " + price + ", " + damage);
		System.out.println(name + ", " + price + " gold");
	}
	@Override
	public String toString() {
		return (name + ", " + description + ". Provides" + defense + " defense. Currently "+ quantity + " in stock. " + "Costs " + price + " gold.");
	}
	@Override
	public void displayInCart() {
		System.out.println(name + ", " + price + " gold. " + cartQuant + " in cart.");
	}
	@Override
	public int compareTo(String a) {
		String name = this.getName();
		if (name.toLowerCase().compareTo(a.toLowerCase())==0) {
			return 0;
		}
		else
			return -1;   
	}

}
