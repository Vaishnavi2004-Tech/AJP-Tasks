import java.io.File;
import java.io.FileOutputStream;
import java.awt.Desktop;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class MyPDF {

    public static void main(String[] args) {

        try {

            String fileName = "MyPDF.pdf";

            Document doc = new Document();

            PdfWriter.getInstance(
                    doc,
                    new FileOutputStream(fileName));

            doc.open();

            Font green =
                new Font(Font.FontFamily.HELVETICA,
                14, Font.NORMAL, BaseColor.GREEN);

            Font blue =
                new Font(Font.FontFamily.HELVETICA,
                14, Font.NORMAL, BaseColor.BLUE);

            Font purple =
                new Font(Font.FontFamily.HELVETICA,
                14, Font.NORMAL,
                new BaseColor(128,0,128));

	    Font red =
		new Font(Font.FontFamily.HELVETICA,
		14, Font.NORMAL, BaseColor.RED);
		
            doc.add(new Paragraph("Hi,", green));

            doc.add(new Paragraph(
                    "I am Vaishnavi", blue));

            doc.add(new Paragraph(
                    "I enjoy learning Java and exploring its features.",
                    purple));

            doc.add(new Paragraph(
                    "Java is a powerful and platform independent programming language.",
                    red));

            doc.close();

            Desktop.getDesktop().open(
                    new File(fileName));
        }

        catch(Exception e){
            System.out.println(e);
        }
    System.out.println("PDF Created");
    }
}