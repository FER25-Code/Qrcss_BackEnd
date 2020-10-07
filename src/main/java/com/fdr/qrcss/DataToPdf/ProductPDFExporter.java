package com.fdr.qrcss.DataToPdf;

import com.fdr.qrcss.Models.Product;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by FERGANI DIA EL EDDINE on 05/10/2020 at 15.
 * FdR for development
 * Dia.fergani@univ-constantine2.dz
 */

public class ProductPDFExporter {
    private List<Product>productList;

    public ProductPDFExporter(List<Product> productList) {
        this.productList = productList;
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.gray);
        cell.setPadding(3);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        cell.setPhrase(new Phrase("num", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("mark", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Product product : productList) {
            table.addCell(product.getName());
            table.addCell(product.getMark());
            table.addCell(String.valueOf(product.getNum()));
        }
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("List of Products", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
