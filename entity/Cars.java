package entity;

public class Cars {
	private int id;
	private String model;
	private String make;
	private int year;
	private double price;
	
	public Cars(int id, String model, String make, int year, double price) {
		this.setId(id);
		this.setModel(model);
		this.setMake(make);
		this.setYear(year);
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
