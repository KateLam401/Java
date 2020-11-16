package _requirements.part3;

import java.io.*;
import java.util.*;

public class ReadTextFileExample {

	public static void main(String[] args) throws FileNotFoundException {
		// Reads lines of text
		// Each line has: integer, string, string, double
		// Each token is separated by a space
		Scanner textScanner = null;
		Scanner itemScanner = null;
		
		textScanner = new Scanner (new File("src/_requirements/part3/employee_info.txt"));
		while (textScanner.hasNext()){
			String item = textScanner.nextLine();
			itemScanner = new Scanner(item);
			StringBuilder itemSb = new StringBuilder();
			
			while (itemScanner.hasNext()) {
				itemSb.append("Item no: ");
				itemSb.append(itemScanner.nextInt() + ", ");
				itemSb.append("Item: ");
				itemSb.append(itemScanner.next() + ", ");
				itemSb.append("Manufacturer: ");
				itemSb.append(itemScanner.next() + ", ");
				itemSb.append("Price: ");
				itemSb.append(itemScanner.nextDouble());
			}
			System.out.println(itemSb.toString());
		}
		itemScanner.close();
		textScanner.close();	
	}

}
