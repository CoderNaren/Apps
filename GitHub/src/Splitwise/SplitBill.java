package Splitwise;

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
}
