package Splitwise;

import java.util.HashMap;
import java.util.Scanner;

public class Split
{	
	static HashMap<String,HashMap<String,Double>> map = new HashMap<>();
	
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		char ch;	String name;	double balance;	
		
		do 
		{
			System.out.println("Enter name of the group");
			Mamber g = new Mamber(new Scanner(System.in));
			
			do 
			{
				System.out.println("Add person name for ur Group");
				name = sc.nextLine().trim().toUpperCase();
				System.out.println("Enter balance of person");
				balance = sc.nextDouble();
				
				g.setGroupData(name,balance);
				System.out.println("\nDo you want to add more members (Type y or n) \n");
		        ch = sc.next().charAt(0);
			} while (ch == 'Y'|| ch == 'y');		
			
			map.put(g.getGroupName(), g.returnGroupData());
			System.out.println("\nDo you want to make another group (Type y or n) \n");
	        ch = sc.next().charAt(0);
		} while (ch == 'Y'|| ch == 'y');	
		
		System.out.println(map);
		
		do 
		{
			System.out.println("\nDo you want to make a payment (Type y or n) \n");
			ch = sc.next().charAt(0);
			if(ch == 'Y'|| ch == 'y')
			{
				System.out.println("Enter Group name");
				String grpName = sc.next().trim().toUpperCase();
				
				System.out.println("Enter Person name");
				String personName = sc.next().trim().toUpperCase();
				
				System.out.println("Enter payment for that person");
				double bal = sc.nextDouble();
				
				map = Payment.Pay(map ,grpName, personName, bal);
			}
		} while (ch == 'Y'|| ch == 'y');
		
		System.out.println(map);
		
		do 
		{
			System.out.println("\nDo you want to make a Bill (Type y or n) \n");
			ch = sc.next().charAt(0);
			if(ch == 'Y'|| ch == 'y')
			{
				System.out.println("Enter Group name");
				String grpName = sc.next().trim().toUpperCase();
				
				System.out.println("Enter payment for that group");
				double bill = sc.nextDouble();
				
				map = SplitBill.splitBill(map, grpName, bill);
			}
		} while (ch == 'Y'|| ch == 'y');
		
		System.out.println(map);
	}
}