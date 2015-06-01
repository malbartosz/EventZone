package pdfoperations;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.Event;
import output.EventInfoForParticipant;
import output.ParticipantForOrganizer;
import junit.framework.TestCase;

public class PdfFileOperatorTest extends TestCase {

	public void testCreatingFile() {
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.createFile();
	}

	public void testCreatingListOfParticipants() throws ParseException, MalformedURLException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.parse("2015-08-19").toString();
		Event event = new Event("Sting concert", date,
				"Nice event", "Sting management", "Wroclaw",
				"You have to be there", "C:\\picture.jpg", null, null);
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.createListOfParticipants(createListOfParticipants(), event);
	}

	
	public void testCreatingTicket() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.parse("2015-08-19").toString();
		Event event = new Event("Sting concert", date,
				"Nice event", "Sting management", "Wroclaw",
				"You have to be there", "C:\\picture.jpg", null, null);
		EventInfoForParticipant eventInfo = new EventInfoForParticipant(170, event);
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.createTicket(eventInfo, "Joanna", "Borowiak");
	}
	
	public void testModifyingFile() {
		PdfFileOperator pdfOperator = new PdfFileOperator();
		pdfOperator.modifyExistingFile();
	}
	
	// private
	private List<ParticipantForOrganizer> createListOfParticipants() {
		List<ParticipantForOrganizer> resultList = new ArrayList<ParticipantForOrganizer>();
		ParticipantForOrganizer participant = new ParticipantForOrganizer(
				"zuzanna", "zuzanna", "nowak", "zu@zu", 140);
		resultList.add(participant);
		participant = new ParticipantForOrganizer("bartek", "bartek", "nowak",
				"bartek@zu", 200);
		resultList.add(participant);
		return resultList;
	}
}
