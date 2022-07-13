package bank;

import java.util.Scanner;

public class USBankForum {
public static void main(String[] args) {
 
	ComplaintDetailFetcher fetch= new ComplaintDetailFetcher ();
	fetch.loadData();
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to Complaints Analyzer v1.0!");
	System.out.println("Enter your option between 1 to 7");
	System.out.println("1.Display all the complaints based on the year provided by the user ");
	System.out.println("2.Display all the complaints based on the name of the bank provided by the user");
	System.out.println("3.Display complaints based on the complaint id provided by the user ");
	System.out.println("4.Display number of days took by the Bank to close the complaint ");
	System.out.println("5.Display all the complaints closed/closed with explanation ");
	System.out.println("6.Display all the complaints which received a timely response ");
//	System.out.println("7.Display all the complaints which received a timely response ");
	
	int option=sc.nextInt();
	sc.nextLine();
	
	switch(option)
	{
	case 1: 
		System.out.println("Enter year");
		String year=sc.next();
		fetch.complaintsBasedOnYear(year);
	break;
	case 2:
		System.out.println("Enter company name");
	    String u_company=sc.nextLine();
		fetch.complaintsBasedOnCompany(u_company);
	break;
	case 3: 
		System.out.println("Enter complaint ID");
		String id=sc.next();
		fetch.complaintsBasedOnComplaintID(id);
	break;
	case 4: 
		System.out.println("Enter complaint ID");
		String compid=sc.next();
		fetch.NoOfDaysTOCloseComplaint(compid);
	break;
	case 5: 
		fetch.complaintsClosed();
	break;
	case 6: 
		fetch.complaintsReceivingTimelyResponse();
	break;
	default: System.out.println("Enter valid option");
	
	}
	sc.close();
}
}
