/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import java.util.ArrayList;

/**
 *
 * @author gerardo
 */
public class PDF {
    public static boolean guardarEnArchivo(String nombreArchivo, ArrayList<Cliente> clientes) {
        try {
            PdfWriter writer = new PdfWriter(nombreArchivo);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            Table table = new Table(UnitValue.createPercentArray(6)).useAllAvailableWidth();
                        
            //Rellena los titulos de las columnas
            table.addCell(new Cell().add(new Paragraph("Id")).setFontSize(15));
            table.addCell(new Cell().add(new Paragraph("Nombre")).setFontSize(15));
            table.addCell(new Cell().add(new Paragraph("Total prestado")).setFontSize(15));
            table.addCell(new Cell().add(new Paragraph("Tiempo restante del prestamo")).setFontSize(15));
            table.addCell(new Cell().add(new Paragraph("Monto del siguiente pago")).setFontSize(15));
            table.addCell(new Cell().add(new Paragraph("Monto restante")).setFontSize(15));
            
            //Rellena la tabla con la informacion de clientes
            for (Cliente cliente : clientes) {
                String id = String.valueOf(cliente.getId());
                String nombre = cliente.getNombre();
                String totalPrestado = String.valueOf(cliente.getTotalPrestado());
                String tiempoRestanteDePrestamo = String.valueOf(cliente.getTiempoDePrestamo() - cliente.getMesesPagados());
                String montoDelSiguientePago = String.valueOf(cliente.getTotalPrestado() / cliente.getTiempoDePrestamo());
                String montoRestante = String.valueOf(cliente.getMontoRestante());
                table.addCell(new Cell().add(new Paragraph(id)));
                table.addCell(new Cell().add(new Paragraph(nombre)));
                table.addCell(new Cell().add(new Paragraph(totalPrestado)));
                table.addCell(new Cell().add(new Paragraph(tiempoRestanteDePrestamo)));
                table.addCell(new Cell().add(new Paragraph(montoDelSiguientePago)));
                table.addCell(new Cell().add(new Paragraph(montoRestante)));
            }
                
            document.add(table);
            document.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
