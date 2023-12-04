package jdbc_person;

import java.sql.SQLException;
import java.util.Scanner;

public class PersonController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		PersonCRUD crud=new PersonCRUD();
		
		System.out.println("Enter the choice \n1.Save Person");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("Enter the id:");
			int id=scanner.nextInt();
			System.out.println("Enter the name:");
			String name=scanner.next();
			System.out.println("Enter the age");
			int age=scanner.nextInt();
			System.out.println("Enter the phone:");
			long phone=scanner.nextLong();
			System.out.println("Enter the address:");
			String address=scanner.next();	
			
		    crud.savePerson(id, name, age, phone, address);
			break;
		}
		
		case 2:{
			System.out.println("Enter the id:");
			int id=scanner.nextInt();
			System.out.println("Enter the name:");
			String name=scanner.next();
			System.out.println("Enter the age");
			int age=scanner.nextInt();
			System.out.println("Enter the phone:");
			long phone=scanner.nextLong();
			System.out.println("Enter the address:");
			String address=scanner.next();	
			
			crud.updatePerson(id,name,age,phone,address);
			break;
			
		}
		case 3:{
			System.out.println("Enter the id:");
			int id=scanner.nextInt();
			
			crud.deletePerson(id);
			break;
			
		}
		case 4:{
			crud.fetchPerson();
			break;
		}
			
		}
	}

}
