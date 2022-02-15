package project1;

//Hellen Munene
//CSCI 3381 9AM
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Collection {

	private static final int MAX_PRODUCTS = 2000;
	private int size;
	private static SingleEntity[] product;
	private String className;
	private String fileName;


	public Collection() {
		// TODO Auto-generated constructor stub
		size = 0;
		product = new SingleEntity[MAX_PRODUCTS];
		className = "inventory";
		fileName = null;
		readFile();

	}
	public Collection(String cn, String fn) {
		// constructor with given course name and input file
		this();
		className = cn;
		fileName = fn;
		readFile();
	}

	public void addProduct(SingleEntity s) {
		// method that adds the input products to the collection array
		if (size >= product.length)
			doubleArray();
		product[size] = s;
		size++;
	}

	public void addProductFromKeyboard (SingleEntity s4) {
		Scanner input = new Scanner(System.in);


		System.out.print("Enter product name: ");
		String name = input.nextLine();
		System.out.print("Enter product ID: ");
		String id = input.nextLine();
		System.out.print("Enter product quantity: ");
		int quantity = input.nextInt();
		System.out.print("Enter product category: ");
		String category = input.nextLine();

		addProduct (new SingleEntity(name, id, quantity, category));

		writeFile();
		input.close();  
	}
public static void suggest(SingleEntity s4) {
	for(SingleEntity s1: product) {
		if(s1.getId().equals(s4))
		{
			System.out.println(s1);
		}
	}
}

	public void removePerson (String id) {
		// method that removes the item from the array with the input id

		int index = 0;
		while(index < size && !(id.equals(product[index].getId()))) {
			index++;

		}
		if(index < size) {
			for(int i = index; i < size; i++) {
				product[i] = product[i+1];
			}
			size--;
		}
	}

	private void doubleArray() {
		// TODO Auto-generated method stub
		SingleEntity[] aProduct = new SingleEntity[product.length];
		for (int i = 0; i < size; i++) {
			aProduct[i] = product[i];
		}		
		product = aProduct;
	}

	public String toString() {
		// returns a string representation of this inventory
		String toReturn = className+"\n";
		for (int i = 0; i < size; i++) {
			toReturn += "Product:  "+product[i]+"\n";
		}
		return toReturn;
	}

	private void readFile () {
		BufferedReader lineReader = null;

		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;

			while ((line = lineReader.readLine())!=null) {
				//String name = lineReader.readLine();
				String id = lineReader.readLine();
				String quantity = lineReader.readLine();
				String category = lineReader.readLine();
				addProduct(new SingleEntity(line,id,Integer.parseInt(quantity), category));
			}
		} catch (Exception e) {
		//	System.err.println("there was a problem with the file reader, try different read type.");
			try {

				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;

				while ((line = lineReader.readLine())!=null) {
					//String name = lineReader.readLine();
					String id = lineReader.readLine();
					String quantity = lineReader.readLine();
					String category = lineReader.readLine();
					addProduct (new SingleEntity(line,id,Integer.parseInt(quantity), category));
				}
			} catch (Exception e2) {
				//System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}
		}
	}// end of readFile method	

	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method

	private void doWrite(String fn) {
		// TODO Auto-generated method stub
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			

			for (int i = 0; i < size; i++) {
				SingleEntity aProduct = product[i];

				myOutfile.write ("inventory\n");
				myOutfile.write (aProduct.getName()+"\n");
				myOutfile.write (aProduct.getId()+"\n");
				myOutfile.write (aProduct.getQuantity()+"\n");
				myOutfile.write (aProduct.getCategory()+"\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}

		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}
	
}

