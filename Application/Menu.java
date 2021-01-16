package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CarsDao;
import entity.Cars;

public class Menu {
	private CarsDao carsDao = new CarsDao();
	Scanner input = new Scanner(System.in);
	private List<String> menuOptions = Arrays.asList("Display a Car", 
													"Display Cars", 
													"Create a Car",  
													"Delete a Car");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = input.nextLine();
			try {
				if (selection.equals("1")) {
					displayACar();
				}else if (selection.equals("2")) {
					displayCars();
				}else if(selection.equals("3")) {
					createCar();
				}else if(selection.equals("4")) {
					deleteCar();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nPlease enter to continue to the program...");
			input.nextLine();
			
		}while (!selection.equals("-1"));
	}
	
	

	//printMenu implementation
	private void printMenu() {
		System.out.println("\nSelect an option to:\n--------------------");
		for (int i = 0; i<menuOptions.size(); i++) {
			System.out.println(i+1 + ") -> " + menuOptions.get(i));
		}
	}
	
	
	//dislayACar implementation
	private void displayACar() throws SQLException {
		
		System.out.print("Enter car id: ");
		int id = Integer.parseInt(input.nextLine());
		Cars car = carsDao.getCarById(id);
		System.out.println("id:\t" + car.getId() + 
				"\nYear:\t"+ car.getYear() +
				"\nMake:\t" + car.getMake() + 
				"\nModel:\t" + car.getModel() + 
				"\nPrice:\t$" + car.getPrice());
	}


	//displayCars implementation
	private void displayCars() throws SQLException {
		List<Cars> cars = carsDao.getCars();
		for (Cars car: cars) {
			System.out.println("Car id: " + car.getId() + 
								"\tYear: "+ car.getYear() + 
								"\tMake: " + car.getMake() + 
								"\tModel: " + car.getModel() + 
								"\tPrice: " + car.getPrice());
		}
	}
	
	
	//createCar implementation
	private void createCar() throws SQLException {
		System.out.print("Enter model: ");
		String model = input.nextLine();
		
		System.out.print("Enter make: ");
		String make = input.nextLine();
		
		System.out.print("Enter year: ");
		int year = Integer.parseInt(input.nextLine());
		
		System.out.print("Enter price: ");
		double price = input.nextDouble();
		
		carsDao.createNewCar(model, make, year, price);
		
		input.nextLine(); //to avoid automatically from printing the menu
		
	}
	

	//deleteCar implementation
	private void deleteCar() throws SQLException {
		System.out.print("Enter a car id to delete: ");
		int id = Integer.parseInt(input.nextLine());
		carsDao.deleteCarsById(id);
	}
	
}
