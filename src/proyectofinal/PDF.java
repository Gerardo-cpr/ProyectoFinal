/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.image.ImageType;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String imageFile = System.getProperty("user.dir") + "/recursos/logo.png"; 
            ImageData data = ImageDataFactory.create(imageFile);
            document.add(new Image(data).setHorizontalAlignment(HorizontalAlignment.CENTER));
                        
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
                String deudaTotal = String.valueOf(cliente.getdeudaTotal());
                String tiempoRestanteDePrestamo = String.valueOf(cliente.getTiempoDePrestamo() - cliente.getMesesPagados());
                String montoDelSiguientePago = String.valueOf(cliente.getTiempoDePrestamo() > 0 ? cliente.getdeudaTotal() / cliente.getTiempoDePrestamo() : 0 );
                String montoRestante = String.valueOf(cliente.getMontoRestante());
                table.addCell(new Cell().add(new Paragraph(id)));
                table.addCell(new Cell().add(new Paragraph(nombre)));
                table.addCell(new Cell().add(new Paragraph(deudaTotal)));
                table.addCell(new Cell().add(new Paragraph(tiempoRestanteDePrestamo)));
                table.addCell(new Cell().add(new Paragraph(montoDelSiguientePago)));
                table.addCell(new Cell().add(new Paragraph(montoRestante)));
            }
                
            document.add(table);
            document.close();
            writer.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    public static boolean guardarFormatoDeudaLiquidada(String nombreArchivo, Cliente cliente) {
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(nombreArchivo);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            String imageFile = System.getProperty("user.dir") + "/recursos/logo.png"; 
            ImageData data = ImageDataFactory.create(imageFile);
            document.add(new Image(data).setHorizontalAlignment(HorizontalAlignment.CENTER));
            document.add(new Paragraph("Nombre del cliente: " + cliente.getNombre()).setFontSize(30).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Formato de deuda liquidada").setFontSize(30).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Total prestado: " + cliente.getdeudaTotal()).setFontSize(25).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Plazo de prestamo: " + cliente.getTiempoDePrestamo()).setFontSize(25).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("El cliente " + cliente.getNombre() + " a liquidado el total de su deuda").setFontSize(25).setTextAlignment(TextAlignment.CENTER));
            document.close();
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            try {
                writer.close();
                return false;
            } catch (IOException ex1) {
                Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }
        } 
        return true;
    }
}
