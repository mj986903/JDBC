package Mohit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Scanner;

public class MainClass {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("----- MENU -----");
		System.out.println("1. Insert Data");
		System.out.println("2. Update Data");
		System.out.println("3. Delete Data");
		System.out.println("4. Find Data");
		System.out.println("5. List All Data");
		System.out.println("6. Exit");
		System.out.println();
		boolean flag = true;
		while(flag){
			System.out.println();
			System.out.println();
			System.out.print("Enter Choice : " );
			int choice = sc.nextInt();
			switch(choice) {
				case 1 : 
					System.out.print("Enrollment Number : ");
					String enno = sc.next();
					sc.nextLine();
					System.out.print("Name : ");
					String name = sc.nextLine();
					System.out.print("Department : ");
					String dp = sc.next();
					System.out.print("Semester : ");
					int sem = sc.nextInt();
					System.out.print("Email : ");
					String email = sc.next();
					System.out.print("Contact : ");
					String no = sc.next();
					int result = DBHandler.insertStudent(enno, name, dp, sem, email, no);
					if(result > 0) {
						System.out.println("Record Inserted Succesfully");
					}else {
						System.out.println("Record Inserted Unsuccesfully");
					}
					break;
	
				case 2 :
					System.out.println("1. Enrollment Number");
					System.out.println("2. Name");
					System.out.println("3. Department");
					System.out.println("4. Semester");
					System.out.println("5. Email");
					System.out.println("6. Contact");
					System.out.print("Which Column You Want Update : ");
					int column = sc.nextInt();
					System.out.print("Enrollment Number : ");
					String enno1 = sc.next();
					sc.nextLine();
					System.out.print("Enter New Value : ");
					String newValue = sc.nextLine();
					int result1 = DBHandler.updateStudent(enno1, column, newValue);
					if(result1 > 0) {
						System.out.println("Record Update Successful.");
					}else {
						System.out.println("Record Not Found.");
					}
					break;
					
				case 3 :
					System.out.print("Enrollment Number : ");
					String enno2 = sc.next();
					int result2 = DBHandler.deleteStudent(enno2);
					if(result2 > 0) {
						System.out.println("Record Delete Successful.");
					}else {
						System.out.println("Record Not Found.");
					}
					break;
					
				case 4 :
					System.out.print("Enrollment Number : ");
					String enno3 = sc.next();
					ResultSet set = DBHandler.selectStudent(enno3);
					while(set.next()) {
						System.out.println("Name = " + set.getString(2));
						System.out.println("Department = " + set.getString(3));
						System.out.println("Semester = " + set.getInt(4));
						System.out.println("Email = " + set.getString(5));
						System.out.println("Contact = " + set.getString(6));
						
					}
					break;
				
				case 5 :
					ResultSet set1 = DBHandler.selectAllStudents();
					Formatter fmt = new Formatter();
					fmt.format("%15s %14s %16s %12s %11s %17s\n\n", "Enrollment Number", "Name", "Department" , "Semester" , "Email" , "Contact"); 
					while(set1.next()) {
						fmt.format("%14s %20s %12s %9s %19s %14s\n", set1.getString(1), set1.getString(2), set1.getString(3), set1.getInt(4), set1.getString(5), set1.getString(6)); 
					}
					System.out.print(fmt);
					break;
					
				case 6 :
					System.out.println("Thank You!");
					flag = false;
					break;
				
				default :
					break;
			}
		}
	}

}
