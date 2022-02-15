package project1;

//Hellen Munene
//CSCI 3381 9AM

public class SingleEntity extends Collection {


	private String name;
	private String id;
	private int quantity;
	private String category;
	public SingleEntity() {
		name = "not set";
		id = "not set";
		quantity = 0;
		category = "not set";
	}

	public SingleEntity(String n, String i, int q, String c) {
		name = n;
		id = i;
		quantity = q;
		category = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// string representation of this product
	public String toString () {
		return name+"," + "\t" + id +", "  +"\t" + quantity+"," +"\t" + category ;
	}

}
