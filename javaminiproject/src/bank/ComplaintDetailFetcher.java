package bank;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ComplaintDetailFetcher {

	USBankFileRead bankfileR = new USBankFileRead();
	Scanner sc = new Scanner(System.in);

	void loadData() {
		bankfileR.fileLoader();
	}

	void complaintsBasedOnYear(String year) {
		for (HashMap.Entry<String, ComplaintDetails> entry : bankfileR.GetMapBankobjcompdet().entrySet()) {
			if (entry.getValue().dateReceived.contains(year)) {
				System.out.println(entry.getValue().issue);
			}
		}

	}

	void complaintsBasedOnCompany(String u_company) {
		for (HashMap.Entry<String, ComplaintDetails> entry : bankfileR.GetMapBankobjcompdet().entrySet()) {
			if (entry.getValue().company.trim().equalsIgnoreCase(u_company.trim())) {
				System.out.println(entry.getValue().issue + " " + u_company);
			}
		}
	}

	void complaintsBasedOnComplaintID(String id) {
		if (bankfileR.GetMapBankobjcompdet().containsKey(id)) {
			System.out.println(bankfileR.GetMapBankobjcompdet().get(id).dateReceived + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).product + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).subProduct + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).issue + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).subIssue + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).company + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).ZIPcode + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).state + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).submittedVia + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).dateSentToCompany + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).companyResponseToConsumer + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).timelyResponse + " "
					+ bankfileR.GetMapBankobjcompdet().get(id).consumerDisputed);
		} else {
			System.out.println("Complaint ID does not exists.");
		}
	}

	void NoOfDaysTOCloseComplaint(String id) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

			if (bankfileR.GetMapBankobjcompdet().containsKey(id)) {
				Date date1 = sdf.parse(bankfileR.GetMapBankobjcompdet().get(id).dateReceived);
				Date date2 = sdf.parse(bankfileR.GetMapBankobjcompdet().get(id).dateSentToCompany);
				long timeDiff = Math.abs(date2.getTime() - date1.getTime());
				long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
				System.out.println("Days taken to close the complaint: " + daysDiff);

			} else {
				System.out.println("Complaint ID does not exists.");
			}
		} catch (ParseException error) {
			System.out.println("Something went wrong");
		}
	}

	void complaintsClosed() {
		for (HashMap.Entry<String, ComplaintDetails> entry : bankfileR.GetMapBankobjcompdet().entrySet()) {
			String compResp = entry.getValue().companyResponseToConsumer;

			if (compResp.equalsIgnoreCase("Closed") || compResp.equalsIgnoreCase("Closed with explanation")) {
				System.out.println(entry.getValue().dateReceived + " " + entry.getValue().product + " "
						+ entry.getValue().subProduct + " " + entry.getValue().issue + " " + entry.getValue().subIssue
						+ " " + entry.getValue().company + " " + entry.getValue().ZIPcode + " " + entry.getValue().state
						+ " " + entry.getValue().submittedVia + " " + entry.getValue().dateSentToCompany + " "
						+ entry.getValue().companyResponseToConsumer + " " + entry.getValue().timelyResponse + " "
						+ entry.getValue().consumerDisputed);
			}
		}

	}

	void complaintsReceivingTimelyResponse() {
		for (HashMap.Entry<String, ComplaintDetails> entry : bankfileR.GetMapBankobjcompdet().entrySet()) {
			if (entry.getValue().timelyResponse.equals("Yes")) {
				System.out.println(entry.getValue().dateReceived + " " + entry.getValue().product + " "
						+ entry.getValue().subProduct + " " + entry.getValue().issue + " " + entry.getValue().subIssue
						+ " " + entry.getValue().company + " " + entry.getValue().ZIPcode + " " + entry.getValue().state
						+ " " + entry.getValue().submittedVia + " " + entry.getValue().dateSentToCompany + " "
						+ entry.getValue().companyResponseToConsumer + " " + entry.getValue().timelyResponse + " "
						+ entry.getValue().consumerDisputed);
			}
		}
	}

	public ComplaintDetailFetcher() {
		super();
	}
}
