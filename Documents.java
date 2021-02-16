package assignment9;

public class Documents {
	String documentID;
	int expirationDate;
	int penaltyPoints;
	Documents(String ID,int expiry)		//Identity Card
	{
		this.documentID = ID;
		this.expirationDate = expiry;
	}
	Documents(String ID,int expiry,int points)		//Drivers License
	{
		this.documentID = ID;
		this.expirationDate = expiry;
		this.penaltyPoints = points;
	}
}
