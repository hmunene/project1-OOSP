package project1;

//Hellen Munene
//CSCI 3381 9AM

public class main {

	public static void main(String[] args) {

		// test creating inventory from scratch
		//SingleEntity s1 = new SingleEntity();
		//System.out.println(s1);
		SingleEntity s2 = new SingleEntity("book ","A322", 302, "Stationery ");
		System.out.println(s2);
		Collection myCollection = new Collection();
		System.out.println(myCollection);
		//myCollection.addProduct(s1);
		myCollection.addProduct(s2);
		
	
		System.out.println(myCollection);
		System.out.println();
		System.out.println();

		
		// test creating inventory from textfile

		SingleEntity s4 = new SingleEntity("Laptop ","A342, ", 1233232 , "Electronics ");
		System.out.println(s4);
		Collection csci3381 = new Collection("inventory","./project1/inventory.txt");
		System.out.println("\ntest reading text file");
		System.out.println(csci3381);
		csci3381.addProductFromKeyboard(s4);
		Collection.suggest(s4);
		
		System.out.println("\ntest combined data from file and data added manually");
		System.out.println(csci3381);		
		csci3381.writeFile("./project1/dataWriteTest.txt");
		
		Collection testWrite = new Collection("Test Write","./project1/dataWriteTest.txt");
		System.out.println("\ntest reading just created file");
		System.out.println(testWrite);
	}

}
