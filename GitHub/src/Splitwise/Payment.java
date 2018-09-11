package Splitwise;

import java.util.HashMap;
import java.util.Scanner;

public class Payment 
{
	public static HashMap<String,HashMap<String,Double>> Pay
	(HashMap<String,HashMap<String,Double>> map , String grpName , String personName , double pay)
	
	{	
		HashMap<String,Double> map1 = new HashMap<>();
		
		double oldBal = 0;  double newBal = 0;
		if(map.containsKey(grpName))
		{
			map1 = map.get(grpName);
			
			if(map1.containsKey(personName))
			{
				oldBal = map1.get(personName);
				newBal = oldBal + pay;
				map1.put(personName, newBal);
				map.put(grpName, map1);
			}
			else
			{
				System.out.println("Person is not in this group, do u want to add person in this group type(Y or N)");
				Scanner sc  = new Scanner(System.in);
				char ch = sc.next().charAt(0);
				if(ch == 'Y' || ch== 'y')
				{
					map1.put(personName, pay);
					map.put(grpName, map1);
				}
			}
		}
		
		return map;
	}
}
