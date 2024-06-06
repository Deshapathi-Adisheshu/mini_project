package com.edubridge.mini_project.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.mini_project.model.moniter;
import com.edubridge.mini_project.service.moniterService;
import com.edubridge.mini_project.service.moniterServiceImpl;
public class moniterMain {
	public static void main(String[] args) {
		moniterService service = new moniterServiceImpl();
		
		moniter m = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("Welcome to Moniter App");
			System.out.println("**********************");
			System.out.println("1. Add Moniter");
			System.out.println("2. View Moniter");
			System.out.println("3. Search Moniter");
			System.out.println("4. Update Moniter");
			System.out.println("5. Delete Moniter");
			System.out.println("6. Delete All Moniter");
			System.out.println("0. Exit");
			option = in.nextInt();
			
			String searchName;
			moniter searchmoniter;
			switch (option) {
			case 1:
				System.out.println("ADD NEW Moniter");
				System.out.println("---------------");
				System.out.println("please enter brand: ");
				String brand = in.next();
				System.out.println("Please enter model: ");
				String model = in.next();
				System.out.println("Please enter price: ");
				int price = in.nextInt();
				System.out.println("Please enter color: ");
				String color = in.next();
				
				m = new moniter();
				m.setBrand(brand);
				m.setModel(model);
				m.setPrice(price);
				m.setColor(color);
				
				int status = service.addmoniter(m);
				if(status == 1) {
					System.out.println("new contact added!!!");
				}else {
					System.out.println("Something went Wrong!!!");
				}
				
				break;
			
			case 2:
				System.out.println("View All Contacts");
				List<moniter> moniter = service.findmoniters();
				System.out.println("BRAND      \t MODEL     \t     PRICE\t         COLOR ");
				System.out.println("-----------\t------------\t----------\t------------\t");
				for(moniter moniter1 : moniter) {
					System.out.println(moniter1.getBrand()+"\t"+moniter1.getModel()+"\t"+moniter1.getPrice()+"\t"+moniter1.getColor());
					
				}
				
				break;
				
			case 3:
				System.out.println("search All contact");
				System.out.println("Enter the contact Name: ");
			    searchName = in.next();
				searchmoniter = service.findmoniterByName(searchName);
				if(searchmoniter != null) {
					System.out.println("Id: "+searchmoniter.getId());
					System.out.println("Brand: "+searchmoniter.getBrand());
					System.out.println("Model: "+searchmoniter.getModel());
					System.out.println("Price: "+searchmoniter.getPrice());
					System.out.println("Color: "+searchmoniter.getColor());
				}else {
					System.out.println("No contact found!!!");
				}
				/*Contact findContactByName = service.findContactByName(name);
				System.out.println("Enter the Name: ");*/
				break;
			case 4:
				//System.out.println("Update Contacts");
				//break;
				System.out.println("Update Moniters");
				System.out.println("Please enter contact name:");
				searchName = in.next();
				searchmoniter = service.findmoniterByName(searchName);
				if(searchmoniter != null) {
					System.out.println("Id:" +searchmoniter.getId());
					System.out.println("Brand:" +searchmoniter.getBrand());
					System.out.println("Model:" +searchmoniter.getModel());
					System.out.println("Price:" +searchmoniter.getPrice());
					System.out.println("Color:" +searchmoniter.getColor());
					//Reading contact update info
					System.out.println("Please enter updated brand:");
					brand = in.next();
					System.out.println("Please enter updated model:");
					model = in.next();
					System.out.println("Please enter updated price:");
					price = in.nextInt();
					System.out.println("Please enter updated color:");
					color = in.next();
					
					moniter updatemoniter = new moniter();
					updatemoniter.setBrand(brand);
					updatemoniter.setModel(model);
					updatemoniter.setPrice(price);
					updatemoniter.setId(searchmoniter.getId());
					updatemoniter.setColor(color);
					int updateStatus = service.updatemoniter(updatemoniter);
					
					if(updateStatus == 1) {
						System.out.println("Contact updated successfully");
					}
					else{
						System.out.println("Something is wrong");
					}
				}
				else {
					System.out.println("No contact found with name");
				}
				break;
				
				
			case 5:
				System.out.println("Delete Contacts");
				System.out.println("please enter contact name");
				
				searchName = in.next();
				
				searchmoniter = service.findmoniterByName(searchName);
				if(searchmoniter != null) {
					int deleteStatus = service.deletemoniterByName(searchName);
					if(deleteStatus == 1) {
						System.out.println("contact deleted sucessfully");
				}else {
					System.out.println("something is wrong");
				} 
				}else {
					System.out.println("no contact found");
				}
				break;
				
			case 6:
				System.out.println("ARE YOU SURE Delete All Contacts?[y/n]");
				String deleteConfirmStatus = in.next();
				if(deleteConfirmStatus.equalsIgnoreCase("y")) {
					service.deleteallmoniter();
					System.out.println("All moniter Deleted!");
				}
				
				break;
				
			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option!!!");
				break;
			}
		} while(option != 0);
	}
}