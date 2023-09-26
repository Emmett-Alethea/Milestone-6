package app;

public class Health extends Product{
	private int healthRestore;
	
	public Health() {} // empty constructor for object mapping

	public Health(String name, String description, int quantity, int cartQuant, double price, int healthRestore) {
		super(name, description, quantity, cartQuant, price);
		this.healthRestore= healthRestore;
}
	public int getHealthRestore() {
		return this.healthRestore;
	}
	public void setHealthRestore(int healthRestore) {
		this.healthRestore = healthRestore;
	}
	@Override
	public void displayProduct() {
		//System.out.println(name + ", " + description + ", " + quantity + ", " + price + ", " + damage);
		System.out.println(name + ", " + price + " gold. ");
	}
	@Override
	public String toString() {
		return (name + ", " + description + ". "+ "Heals " + healthRestore + " HP. Currently "+ quantity + " in stock. " + "Costs " + price + " gold.");
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
