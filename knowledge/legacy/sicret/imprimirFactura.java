/*    */ package sicret;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.awt.print.PageFormat;
/*    */ import java.awt.print.PrinterException;
/*    */ import java.awt.print.PrinterJob;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ public class imprimirFactura implements Printable {
/* 13 */   String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 14 */   JTable tablita = null;
/* 15 */   int CONTADOR = 0; public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente;
/*    */     int y, i;
/* 17 */     Graphics2D g2 = (Graphics2D)g;
/* 18 */     Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(), f.getImageableY(), f.getImageableWidth(), f.getImageableHeight());
/* 19 */     Ellipse2D circle = new Ellipse2D.Double(100.0D, 100.0D, 100.0D, 100.0D);
/* 20 */     switch (pageIndex) {
/*    */ 
/*    */ 
/*    */       
/*    */       case 0:
/* 25 */         g.setColor(Color.black);
/* 26 */         g2 = (Graphics2D)g;
/* 27 */         fuente = new Font("Dialog", 2, 10);
/* 28 */         g.setFont(fuente);
/* 29 */         g.drawString(this.DATOS[1], 425, 100);
/* 30 */         fuente = new Font("Dialog", 1, 10);
/* 31 */         g.setFont(fuente);
/* 32 */         g.drawString(this.DATOS[2], 425, 150);
/* 33 */         fuente = new Font("Dialog", 1, 10);
/* 34 */         g.setFont(fuente);
/* 35 */         if (this.DATOS[13].equals("0")) {
/* 36 */           g.drawString("WEATHERFORD S.A. DE C.V.", 25, 190);
/* 37 */           g.drawString("CARRETERA MÉXICO - TUXPAN 297,", 25, 202);
/* 38 */           g.drawString("S/N TIHUATLÁN, VERACRUZ", 25, 214);
/*    */         
/*    */         }
/* 41 */         else if (this.DATOS[13].equals("1")) {
/* 42 */           g.drawString("DOWELL SCHULUMBER DE MÉXICO S.A. DE C.V.", 25, 188);
/* 43 */           g.drawString("AV. EJERCITO NACIONAL No. 425,", 25, 200);
/* 44 */           g.drawString("PISO 5, COL. GRANADA DEL MIGUEL HIDALGO", 25, 212);
/* 45 */           g.drawString("DSM830824AY6 CP 11520 MÉXICO, MÉXICO", 25, 224);
/*    */         } 
/* 47 */         fuente = new Font("Dialog", 1, 10);
/* 48 */         g.setFont(fuente);
/* 49 */         g.drawString(this.DATOS[3], 25, 267);
/* 50 */         g.drawString(this.DATOS[4], 175, 267);
/* 51 */         g.drawString(this.DATOS[5], 330, 267);
/*    */         
/* 53 */         y = 320;
/* 54 */         for (i = 0; i < this.CONTADOR; i++) {
/* 55 */           g.drawString(String.valueOf(this.tablita.getValueAt(i, 0)), 25, y);
/* 56 */           g.drawString(String.valueOf(this.tablita.getValueAt(i, 1)), 90, y);
/* 57 */           g.drawString("$ " + String.valueOf(this.tablita.getValueAt(i, 2)), 410, y);
/* 58 */           g.drawString("$ " + String.valueOf(this.tablita.getValueAt(i, 3)), 505, y);
/* 59 */           y += 10;
/*    */         } 
/* 61 */         g.drawString("EQUIPO: " + this.DATOS[6], 90, y + 40);
/* 62 */         g.drawString("POZO: " + this.DATOS[7], 100, y + 50);
/* 63 */         fuente = new Font("Dialog", 0, 9);
/* 64 */         g.setFont(fuente);
/* 65 */         g.drawString("Impuesto Retenido de Conformidad con la Ley del", 120, 460);
/* 66 */         g.drawString("Impuesto al Valor Agregado", 120, 470);
/*    */         
/* 68 */         fuente = new Font("Dialog", 1, 9);
/* 69 */         g.setFont(fuente);
/* 70 */         g.drawString("%16 ", 485, 510);
/* 71 */         g.drawString("%4 ", 485, 523);
/*    */         
/* 73 */         fuente = new Font("Dialog", 1, 10);
/* 74 */         g.setFont(fuente);
/* 75 */         g.drawString("$ " + this.DATOS[8], 505, 497);
/* 76 */         g.drawString("$ " + this.DATOS[9], 505, 510);
/* 77 */         g.drawString("-$ " + this.DATOS[10], 505, 523);
/* 78 */         g.drawString("$ " + this.DATOS[11], 505, 536);
/*    */         
/* 80 */         g.drawString(this.DATOS[12], 25, 517);
/* 81 */         return 0;
/* 82 */     }  return 1; }
/*    */ 
/*    */   
/*    */   public void recibeDatos(String[] datos, JTable tabla, int cont) {
/* 86 */     imprimirFactura im = new imprimirFactura();
/* 87 */     im.CONTADOR = cont;
/* 88 */     im.tablita = tabla;
/* 89 */     im.DATOS = datos;
/* 90 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 91 */     job.setPrintable(im);
/* 92 */     if (job.printDialog())
/*    */       try {
/* 94 */         job.print();
/*    */       }
/* 96 */       catch (PrinterException e) {
/* 97 */         JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*    */       }  
/*    */   }
/*    */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/imprimirFactura.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */