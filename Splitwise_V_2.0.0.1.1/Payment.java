package Splitwise_V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Payment 
{
	static HashMap<String, ArrayList<Double>> trans = new HashMap<>();
	static ArrayList<Double> addTrans = new ArrayList<>();
	
	
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
				
				if(trans.containsKey(personName))
				{
					addTrans = trans.get(personName);
					addTrans.add(pay);
					trans.put(personName,addTrans);
				}
				else
				{
					addTrans = new ArrayList<>();
					addTrans.add(pay);
					trans.put(personName, addTrans);
				}
			}
		}
		else
		{
			map1.put(personName, pay);
			map.put(grpName, map1);	
			addTrans = new ArrayList<>();
			addTrans.add(pay);
			trans.put(personName,addTrans);
		}
		return map;
	}
	
	public static void getTrans(String personName)
	{
		ArrayList<Double> money = new ArrayList<>();	
		money = trans.get(personName);
		System.out.print("All time "+personName+ " Transaction is ="+money);
	}	
}
