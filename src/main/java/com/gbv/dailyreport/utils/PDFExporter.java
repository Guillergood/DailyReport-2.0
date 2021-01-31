package com.gbv.dailyreport.utils;

import com.gbv.dailyreport.model.Report;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class PDFExporter {
    private List<Report> listUsers;

    public PDFExporter(List<Report> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Report ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Keeper", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Animal", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Report", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Report report : listUsers) {
            table.addCell(String.valueOf(report.getId()));
            table.addCell(report.getKeeperName());
            table.addCell(report.getAnimalName());
            table.addCell(report.getReport());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Reports", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}