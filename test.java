package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser.Feature;

public class test {
	public static void saveToFile(String filename, Product item, boolean append) {
		PrintWriter pw;
		try {
		
			
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			//pw.println("{}".getBytes());
			//pw.flush();
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(item);
			pw.println(json);
			
			pw.close();
		}
		catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("Stock.json");
		pw.print("");
		pw.close();
		// TODO Auto-generated method stub
		ArrayList<Product> itemList = new ArrayList<Product>();
		 Product itemSword = new Weapon("Sword", "A dull sword", 12, 0, 1.5, 5);
			itemList.add(itemSword);
			Product itemBow = new Weapon("Bow", "A simple wooden short bow", 15, 0, 2.7, 6);
			itemList.add(itemBow); 
			Product itemShield = new Armor("Shield", "A wooden shield", 3, 0, 3.1, 5);
			itemList.add(itemShield);
			Product itemHelmet = new Armor("Helmet", "Protects your head", 4, 0, 5.7, 4);
			itemList.add(itemHelmet);
			Product itemPotion = new Health("Potion", "Restores 5 hp", 10, 0, 5.1, 5);
			itemList.add(itemPotion);
			
			for(int i = 0; i < itemList.size(); i++) {
				saveToFile("Stock.json", itemList.get(i), true);
			}

}
}