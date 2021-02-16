package assignment9;

import java.util.Arrays;

public class DocumentOffice {
	String countryCode;
	Documents database[] = new Documents[0];
	int date;
	DocumentOffice(String CC,int D)
	{	
		this.date = D;
		this.countryCode = CC;
	}
	
	public boolean requestDocuments(Person Applicant,int Doc)
	{
		switch(Doc)
		{
		case 1:
			if(this.countryCode == Applicant.nationality)
			{
				Documents D1 = new 
						Documents("1" + Applicant.nationality + "-" +Integer.toString(Applicant.birthdate)
									,this.date + 10);
				int index = FindIndex(D1.documentID);
				if(index == -1)		//Identity card exist check
					AddData(D1);
				else
					database[index].expirationDate = D1.expirationDate;	//Document Updated
				return true;
			}
			return false;
		case 2:
			if(CompareDate(this.date,Applicant.birthdate+ 18))
			{
				int index = FindIndex("1" + Applicant.nationality + "-" + Integer.toString(Applicant.birthdate));
				if(index >= 0)		//Identity card exist check
				{
					Documents D2 = new 
							Documents("2" + Applicant.nationality + "-"  + Integer.toString(Applicant.birthdate)
									,this.date + 15,0);
					index = FindIndex(D2.documentID);
					if(index == -1)		//Drivers License exist check
					{
						AddData(D2);
						return true;
					}
					else
					{
						if(database[index].penaltyPoints >= 20)
							return false;
						else
						{
							database[index].expirationDate = D2.expirationDate; //Document Updated
							return true;
						}
					}
				}
			}
			return false;
		default:
			return false;
		}
	}
	
	public Documents[] find(Person P1)
	{
		Documents P_D[] = new Documents[2];
		int count = 0;
		int index = FindIndex("1" + P1.nationality + "-" + Integer.toString(P1.birthdate));
		if(index >= 0)
		{
			P_D[count] = database[index];
			count++;
		}
		index = FindIndex("2" + P1.nationality + "-"  + Integer.toString(P1.birthdate));
		if(index >= 0)
		{
			P_D[count] = database[index];
		}
		if(count == 0)
			return null;
		return P_D;	
	}
	
	public boolean updateDate(int D)
	{
		if(CompareDate(D,this.date))
		{
			this.date = D;
			return true;
		}
		else	return false;	
	}
	
	public boolean addPenalty(Person P1, int points)
	{
		int index = FindIndex("2" + P1.nationality + "-" + Integer.toString(P1.birthdate));
		if(index >= 0)
		{
			database[index].penaltyPoints += points;
			return true;
		}
		return false;
	}
	
	public String returnDatabase()
	{
		int count = 1;
		String AllData = "";
		for(Documents D:database)
		{
			AllData += "Entry Nr." + Integer.toString(count) + ": " + D.documentID + " - " 
				+ (Integer.toString(D.expirationDate)).substring(0, 2) + "."
				+ (Integer.toString(D.expirationDate)).substring(2, 4) + "."
				+ (Integer.toString(D.expirationDate)).substring(4, 8) + "\n";
			count++;
		}
		return AllData;
	}

	private void AddData(Documents D1)
	{
		database = Arrays.copyOf(database, database.length + 1);
		database[database.length - 1] = D1;
	}
	
	private int FindIndex(String ID)
	{
		if(database.length == 0)
			return -1;
		for(int i = 0;i< database.length;i++)
		{
			if(ID.equals(database[i].documentID))
				return i;	
		}
		return -1;
	}
	
	private boolean CompareDate(int D1,int D2)
	{
		if(D1%10000 > D2%10000)		return true;
		else if(D1%10000 < D2%10000)	return false;
		else 
		{
			if((D1/10000)%100 > (D2/10000)%100)		return true;
			else if((D1/10000)%100 < (D2/10000)%100)	return false;
			else 
			{
				if((D1/1000000)%100 > (D2/1000000)%100)		return true;
				else 	return false;
			}
		}
	}
}
