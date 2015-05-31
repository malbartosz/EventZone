package pdfoperations;

import java.awt.Component.BaselineResizeBehavior;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import model.Event;
import output.EventInfoForParticipant;
import output.ParticipantForOrganizer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author ZPACHOLC
 *
 */
public class PdfFileOperator {

	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 10,
			Font.ITALIC);
	private static Font bigFont = new Font(Font.FontFamily.HELVETICA, 13,
			Font.NORMAL);
	private static Font bigBoldFont = new Font(Font.FontFamily.HELVETICA, 13,
			Font.BOLD);

	public void createFile() {
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("HelloWorld.pdf"));
			document.open();
			document.add(new Paragraph("A Hello World PDF document."));
			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String createListOfParticipants(
			List<ParticipantForOrganizer> participants, Event event)
			throws MalformedURLException, IOException {
		Document document = new Document();
		String fileName = String
				.valueOf("src\\main\\webapp\\resources\\files\\lists\\"
						+ event.getId())
				+ event.getName() + ".pdf";
		try {

			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(fileName));
			document.open();
			Image eventzoneLogo;
			eventzoneLogo = Image
					.getInstance("src\\main\\webapp\\resources\\logo.png");

			eventzoneLogo.setAbsolutePosition(40f, 710f);
			eventzoneLogo.scaleAbsolute(216, 65);
			document.add(eventzoneLogo);
			Paragraph p = new Paragraph();
			for (int i = 0; i < 5; i++) {
				p.add(new Paragraph(" "));
			}
			document.add(p);
			Paragraph title = new Paragraph();
			title.add(new Phrase("Event: ", bigFont));
			title.add(new Phrase(event.getName(), bigBoldFont));
			title.add(new Phrase("\nDate: ", bigFont));
			title.add(new Phrase(String.valueOf(event.getDateOfEvent()),
					bigBoldFont));
			title.add(new Phrase("\nPlace: ", bigFont));
			title.add(new Phrase(event.getPlace(), bigBoldFont));
			document.add(title);
			document.add(new Paragraph("Participants:"));
			try {
				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(100);
				table.setSpacingBefore(10f);
				table.setSpacingAfter(10f);

				// Set Column widths
				float[] columnWidths = { 1f, 1f, 1f, 1f };
				table.setWidths(columnWidths);
				PdfPCell nameCell = new PdfPCell();
				nameCell.addElement(new Paragraph("Name", bigBoldFont));
				nameCell.setPaddingLeft(10);
				nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				nameCell.setBorderColor(BaseColor.GRAY);

				PdfPCell mailCell = new PdfPCell();
				mailCell.addElement(new Paragraph("Email", bigBoldFont));
				mailCell.setPaddingLeft(10);
				mailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				mailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				mailCell.setBorderColor(BaseColor.GRAY);

				PdfPCell ticketPriceCell = new PdfPCell();
				ticketPriceCell.addElement(new Paragraph("Ticket cost",
						bigBoldFont));
				ticketPriceCell.setPaddingLeft(10);
				ticketPriceCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				ticketPriceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				ticketPriceCell.setBorderColor(BaseColor.GRAY);

				PdfPCell signatureCell = new PdfPCell();
				signatureCell
						.addElement(new Paragraph("Signature", bigBoldFont));
				signatureCell.setPaddingLeft(10);
				signatureCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				signatureCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				signatureCell.setBorderColor(BaseColor.GRAY);

				table.addCell(nameCell);
				table.addCell(mailCell);
				table.addCell(ticketPriceCell);
				table.addCell(signatureCell);

				for (ParticipantForOrganizer participant : participants) {
					nameCell = new PdfPCell(new Paragraph(participant.getName()
							+ " " + participant.getSurname()));

					mailCell = new PdfPCell(new Paragraph(
							participant.getEmail()));

					ticketPriceCell = new PdfPCell(new Paragraph(
							String.valueOf(participant.getTicketCost())));

					signatureCell = new PdfPCell(new Paragraph());

					nameCell.setBorderColor(BaseColor.GRAY);
					mailCell.setBorderColor(BaseColor.GRAY);
					ticketPriceCell.setBorderColor(BaseColor.GRAY);
					signatureCell.setBorderColor(BaseColor.GRAY);

					table.addCell(nameCell);
					table.addCell(mailCell);
					table.addCell(ticketPriceCell);
					table.addCell(signatureCell);
				}
				document.add(table);
			} catch (NullPointerException e) {
			}

			document.close();
			writer.close();
			return fileName;
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public String createTicket(EventInfoForParticipant eventInfo, String name,
			String surname) {
		String fileName = "src\\main\\webapp\\resources\\files\\tickets\\"
				+ eventInfo.getEvent().getName() + name + surname + ".pdf";
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(fileName));
			document.open();
			Image eventzoneLogo;
			eventzoneLogo = Image
					.getInstance("src\\main\\webapp\\resources\\logo.png");

			eventzoneLogo.setAbsolutePosition(100f, 710f);
			eventzoneLogo.scaleAbsolute(216, 65);
			document.add(eventzoneLogo);
			Paragraph p = new Paragraph();
			for (int i = 0; i < 5; i++) {
				p.add(new Paragraph(" "));
			}

			PdfPTable table = new PdfPTable(2);

			table.setWidthPercentage(80);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			float[] columnWidths = { 1f, 1f };
			table.setWidths(columnWidths);

			PdfPCell eventNameCell = new PdfPCell();
			eventNameCell.addElement(new Phrase("Event name: \n", smallFont));
			eventNameCell.addElement(new Phrase(eventInfo.getEvent().getName(),
					bigFont));
			eventNameCell.setPaddingLeft(10);
			eventNameCell.setPaddingBottom(10);
			eventNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			eventNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			eventNameCell.setBorderColor(BaseColor.GRAY);
			eventNameCell.setBorderWidthTop(3);
			eventNameCell.setBorderWidthLeft(3);
			table.addCell(eventNameCell);

			PdfPCell eventPlaceAndTime = new PdfPCell();
			eventPlaceAndTime.addElement(new Phrase("When and where: \n",
					smallFont));
			eventPlaceAndTime.addElement(new Phrase(eventInfo.getEvent()
					.getPlace()
					+ " "
					+ String.valueOf(eventInfo.getEvent().getDateOfEvent())
					+ String.valueOf(eventInfo.getEvent().getTimeOfEvent()),
					bigFont));
			eventPlaceAndTime.setPaddingLeft(10);
			eventPlaceAndTime.setPaddingBottom(10);
			eventPlaceAndTime.setHorizontalAlignment(Element.ALIGN_CENTER);
			eventPlaceAndTime.setVerticalAlignment(Element.ALIGN_MIDDLE);
			eventPlaceAndTime.setBorderColor(BaseColor.GRAY);
			eventPlaceAndTime.setBorderWidthTop(3);
			eventPlaceAndTime.setBorderWidthRight(3);
			table.addCell(eventPlaceAndTime);

			PdfPCell ticketInfo = new PdfPCell();
			ticketInfo.addElement(new Phrase("Ticket cost: \n", smallFont));
			ticketInfo.addElement(new Phrase(
					String.valueOf(eventInfo.getCost()), bigFont));
			ticketInfo.setPaddingLeft(10);
			ticketInfo.setPaddingBottom(10);
			ticketInfo.setHorizontalAlignment(Element.ALIGN_CENTER);
			ticketInfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ticketInfo.setBorderColor(BaseColor.GRAY);
			ticketInfo.setBorderWidthBottom(3);
			ticketInfo.setBorderWidthLeft(3);
			table.addCell(ticketInfo);

			PdfPCell ticketOwner = new PdfPCell();
			ticketOwner.addElement(new Phrase("Ticket owner: \n", smallFont));
			ticketOwner.addElement(new Phrase(String.valueOf(name + " "
					+ surname + "\n"), bigFont));
			ticketOwner.setPaddingLeft(10);
			ticketOwner.setPaddingBottom(10);
			ticketOwner.setHorizontalAlignment(Element.ALIGN_CENTER);
			ticketOwner.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ticketOwner.setBorderColor(BaseColor.GRAY);
			ticketOwner.setBorderWidthBottom(3);
			ticketOwner.setBorderWidthRight(3);
			table.addCell(ticketOwner);
			p.add(table);
			document.add(p);
			document.close();
			writer.close();
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public void modifyExistingFile() {
		try {
			// Read file using PdfReader
			PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

			// Modify file using PdfReader
			PdfStamper pdfStamper = new PdfStamper(pdfReader,
					new FileOutputStream("HelloWorld-modified.pdf"));

			Image image = Image
					.getInstance("src\\main\\webapp\\resources\\logo.png");
			image.scaleAbsolute(100, 50);
			image.setAbsolutePosition(100f, 700f);

			for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
				PdfContentByte content = pdfStamper.getUnderContent(i);
				content.addImage(image);
			}

			pdfStamper.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
