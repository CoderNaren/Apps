package Splitwise_V2;

import java.util.HashMap;
import java.util.Set;

public class SplitBill 
{
	static HashMap<String,HashMap<String,Double>> splitBill
	(HashMap<String,HashMap<String,Double>> map ,String groupName,double total)
	
	{
		HashMap<String,Double> map1 = new HashMap<>();
		double oldBal = 0; 	double newBal = 0;	double split = 0;
		
		if(map.containsKey(groupName))
		{
			map1 = map.get(groupName);
			split = total / map1.size();
			
			Set<String> byName =  map1.keySet();
			for(Object obj : byName)
			{
				oldBal = map1.get(obj);
				newBal = oldBal - split;
				map1.put((String)obj, newBal);
			}
		}
		map.put(groupName, map1);	
		return map;
	}
	
	public static void allOwes(HashMap<String,HashMap<String,Double>> map)
	{
		HashMap<String,Double> map1 = new HashMap<>();
		double bal = 0;	
		
		Set KEY = map.keySet();
		for(Object OBJ : KEY)
		{
			map1 = map.get(OBJ);
			Set key = map1.keySet();
			System.out.println();
			for(Object obj : key)
			{
				bal = map1.get(obj);
				if(bal < 0)
					System.out.println((String)obj + " owes "+(Math.abs(bal))+" rupees on "+(String)OBJ+" group");
				if(bal ==0)
					System.out.println("All Settled for "+obj +" in "+OBJ+" group");
				if(bal > 0)
					System.out.println(OBJ + " owes "+bal+" rupees on "+obj+" group");
				System.out.println();
			}
		}
		
	}	
	
	public static void Owes(HashMap<String,HashMap<String,Double>> map ,String groupName,String personName)
	{
		HashMap<String,Double> map1 = new HashMap<>();
		double bal = 0;	
		map1 = map.get(groupName);
		bal = map1.get(personName);
		if(bal < 0)
			System.out.println(personName + " owes "+(Math.abs(bal))+" rupees on "+groupName+" group");
		if(bal ==0)
			System.out.println("All Settled for "+personName +" in "+groupName);
		if(bal > 0)
			System.out.println(groupName + " owes "+bal+" rupees on "+personName);
		
	}
}
