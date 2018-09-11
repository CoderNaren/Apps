package Splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Person 
{
	private String name;
	private double initialBalance;
	
	Person(String name, double balance)
	{
		this.name = name;
		this.initialBalance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return initialBalance;
	}

	public void setBalance(double balance) {
		this.initialBalance = balance;
	}
	
	@Override
	public String toString() {
		return name + "="+initialBalance;
	}
	
}
