package Splitwise_V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Mamber
{	
	String name;
	HashMap<String,Double> map = new HashMap<>();
	
	Mamber(Scanner sc)
	{
		this.name = sc.nextLine().trim().toUpperCase();
		setGroupName(name);
	}
	
	public void setGroupName(String name)
	{
		this.name = name;
	}
	
	public String getGroupName()
	{
		return name;
	}
	
	public void setGroupData(String name , double balance)
	{
		Person p1 = new Person(name,balance);
		map.put(p1.getName(), p1.getBalance());
	}
	
	public HashMap<String,Double> returnGroupData()
	{
		return map;
	}	
	
	@Override
	public String toString() 
	{
		return returnGroupData()+"";
	}
}
