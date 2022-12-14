package tn.esprit.projetkaddem.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projetkaddem.Entities.Departement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ExportPDFService {

    public static ByteArrayInputStream departementsPDFReport(List<Departement> departements){
        Document document = new com.itextpdf.text.Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,out);
            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER,14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Liste des Departements de notre UNIVERSITE",font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(1);
            Stream.of("Les Departements :").forEach(headerdepartements -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new  Phrase(headerdepartements,headFont));
                table.addCell(header);

            });

            for(Departement dept:departements){
                System.out.println(dept.getNomDepart());
                String testt=dept.getNomDepart();
                PdfPCell nomDepartCell = new PdfPCell(new Phrase(testt));
                System.out.println(nomDepartCell);
                nomDepartCell.setPaddingLeft(1);
                nomDepartCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nomDepartCell.setVerticalAlignment(Element.ALIGN_LEFT);
                table.addCell(String.valueOf(testt));


            }

            document.add(table);
            document.close();

        }catch (DocumentException ex) {

            ex.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
