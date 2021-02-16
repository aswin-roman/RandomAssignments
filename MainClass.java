package assignment9;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	Person P1 = new Person("DE",14011996);
		System.out.println(DO1.requestDocuments(P1, 1));
		System.out.println(DO1.requestDocuments(P1, 2));

		Person P2 = new Person("DE",14012005);
		System.out.println(DO1.requestDocuments(P2, 1));
		System.out.println(DO1.requestDocuments(P2, 2));


		Person P3 = new Person("DE",14011990);
		System.out.println(DO1.requestDocuments(P3, 2));

		Documents PD[] = DO1.find(P1);
		for(Documents D: PD)
			System.out.println( ": " + D.documentID + " - " + Integer.toString(D.expirationDate) + "\n"); 
		
		
		System.out.println(DO1.addPenalty(P1, 20));

	
		System.out.println(DO1.requestDocuments(P1, 2));*/

		DocumentOffice DO1 = new DocumentOffice("DE",25052021);

		System.out.println(DO1.updateDate(24062021));

		Person P2 = new Person("UK",25052003);
		System.out.println(DO1.requestDocuments(P2, 1));
		System.out.println(DO1.requestDocuments(P2, 2));
		System.out.println(DO1.returnDatabase());

		DocumentOffice DO2 = new DocumentOffice("UK",25112021);
		System.out.println(DO2.requestDocuments(P2, 1));

		System.out.println(DO2.requestDocuments(P2, 2));
		System.out.println(DO2.returnDatabase());
		
		System.out.println(DO2.addPenalty(P2, 20));
		System.out.println(DO2.addPenalty(P2, 20));



	}

}
